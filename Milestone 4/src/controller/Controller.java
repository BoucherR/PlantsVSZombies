package controller;

import view.*;
import model.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 * @author Youssef Saghbini
 * @author Ryan Boucher
 * @version 1.5
 */

public class Controller implements Serializable{

    private int seconds;
    private static Timer timer;


    /**
     *  Dual-array gameboard to be played on.
     */
    private Square board[][];

    /**
     *  User's money pouch during the game.
     */
    private int moneyPouch;

    /**
     *  The amount of zombies to be spawned within the board.
     */
    private int zombies;

    /**
     * The Game Levels of the game
     */
    private GameLevels levels;

    /**
     *  Displaying the game, and is able to manipulate
     */
    private View view;

    /**
     *  Used for detecting on where the mouse has been clicked
     */
    private Coordinate clickedButtonLocation;

    /**
     *  Keeping recording on what is happening in-game
     */
    private List<String> loggingList;

    private Stack<Square[][]> undoBoard;
    private Stack<Square[][]> redoBoard;
    private static final int BOARD_LENGTH = 8;
    private static final int BOARD_HEIGHT = 5;

    /**
     *  Will generate a brand new board with initial values. Board will consist of
     *  a dual array of squares, and each square would contain a specific coordinate and
     *  piece when added and or removed. Logging is to keep track of every event happening.
     *  Money pouch is the amount of money the player will have. ZombieLimit is the
     *  amount of zombies allowed to be spawned into the board.
     */
    public Controller(View view){
        timer = new Timer();
        seconds = 0;
        this.loggingList = new ArrayList<>();
        undoBoard = new Stack<>();
        redoBoard = new Stack<>();
        this.board = new Square[BOARD_LENGTH][BOARD_HEIGHT];
        this.view = view;
        this.levels = new GameLevels();
        //this.moneyPouch = 500;
        //this.levels.setSunMoney(500);
        this.zombies = 0;
        for (int c = 0; c < board.length; c++)
            for (int r = 0; r < board[0].length; r++)
                board[c][r] = new Square(new Coordinate (c,r));
        reset();
        undoBoard.push(board);
    }

    /**
     * Main code for the "Controller" aspect of the MVC Model that is required for this milestone.
     * Adds action listeners to all buttons on the game board, and handles user-input on the
     * pop-up menus that allow for the placing of plants in the game, through the use of action events
     * on the popups.
     * After plant is placed, runtime() is called to finish the turn, perform zombie logic, and award sun-points.
     * Currently supports the placing of peashooters and sunflowers.
     */
    public void actionListener(){

        /**
         * Placing Action listeners on each square of the board
         */
        for(int i = 0; i < board[0].length;i++) {
            for (int j = 0; j < board.length - 1; j++) {
                view.getGameButtons()[j][i].addActionListener((ActionEvent event) -> {
                    clickedButtonLocation = new Coordinate(((JButton) event.getSource()).getLabel());
                    view.getPopupMenu().show(view.getTopPanel(), ((JButton) event.getSource()).getX(), ((JButton) event.getSource()).getY());
                });
                view.getGameButtons()[j][i].setRolloverEnabled(true);
                view.getGameButtons()[j][i].setRolloverIcon(new ImageIcon(getClass().getResource("/Images/grasshighlighted.png")));
            }
        }

        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of sunflowers.
         */
        view.getSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new Sunflower());
            }
        });

        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a peashooter.
         */
        view.getPeashooter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new Peashooter());
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a repeater.
         */
        view.getRepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new Repeater());
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getThreepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new Threepeater());
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getWallnut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new Wallnut());
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of sunflowers.
         */
        view.getTwinSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new TwinSunflower());
            }
        });
        
        view.getGiantSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(clickedButtonLocation, new GiantSunflower());
            }
        });


        view.getSaveButton().addActionListener((e) -> {
            save("GameSave.txt");
        });

        view.getLoadButton().addActionListener((e) -> {
            load("GameSave.txt");
        });

        /**
         * When a plant is removed from the board, the user will be able to add it with this function
         */
        view.getRedoButton().addActionListener((e) -> {
            redo();
            loggingList.add("Redo Clicked! \n");
        });

        /**
         * When a plant is placed on the board, the user will be able to remove it with this function
         */
        view.getUndoButton().addActionListener((e) -> {
            undo();
            loggingList.add("Undo Clicked! \n");
        });

        TimerTask task;
        task = new TimerTask() {
            private final int MAX_SECONDS = 10;

            @Override
            public void run() {
                if (!(levels.maxLevel() && levels.checkLimit(zombies))) {
                    runTime();
                    System.out.println("Seconds = " + seconds);
                    seconds ++;
                }
                else {
                    cancel();
                }
            }

        };
        timer.schedule(task, 0, 5000);
    }

    /**
     * This method is used to call the other methods required to finish a turn, after the player has placed his/her
     * plants.
     */
    public void runTime(){
        undoBoard.push(copyBoard());
        movingZombie();
        removeUpdate();
        if(levels.checkAllZombiesDead()){
            System.out.println("All Dead");
            zombies =0;
        }
        addingZombie();
        hitUpdate();
        sunflowerMoney();
        gameOver();
        gameWon();
        getLogging();
        view.getSunMoney().setText(Integer.toString(levels.getMoney()));
        System.out.println(toString());
    }

    /** Adding pieces around the generated gameBoard. Will use the addPiece()
     *  and removePiece() methods, when necessary.
     *  @param coordinate receiving the coordinate at which the piece will be placed
     *  @param piece receiving the type of piece to be added at specific coordinate
     *  @return Whether if it is possible to add the piece within conditions
     */
    public boolean add(Coordinate coordinate, Piece piece)
    {
        Square srcSquare = this.getSquare(coordinate);
        if(srcSquare.isOccupied()){
            loggingList.add("Piece not added due to space occupied.\n");
            return false;
        }
        if(!purchasePiece(piece)){
            JOptionPane.showMessageDialog(null,"Not enough Money");
            return false;
        }
        srcSquare.addPiece(piece);
        board2GUI(board);
        loggingList.add("Added Piece: " + piece.getName() + " @ Coordinates: " + coordinate.toString() + "\n");
        return true;
    }

    /**
     *  This method is to move a piece from one coordinate to another. It will
     *  receive the current and new coordinate; in those coordinates, the method
     *  will retrieve the piece and move them.
     *  @param src the current coordinate in the piece is currently placed
     *  @param dest the potential new coordinate where the piece will be move to
     */
    public boolean move(Coordinate src, Coordinate dest) {
        Square srcSquare = this.getSquare(src);
        Square destSquare = this.getSquare(dest);
        if (destSquare.isOccupied()) {
            return false;
        }
        Piece p = srcSquare.getPiece();
        destSquare.addPiece(p);
        srcSquare.deletePiece();
        board2GUI(board);
        loggingList.add("Moved " + p.getName() + " from " + src.toString() + " to " + dest.toString() + "\n");
        return true;
    }

    /**
     *  When piece is within range of attack, it will affect the other piece's health.
     */
    public void hitUpdate(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null && board[col][row].getPiece().getHealth() > 0) {
                    if (board[col][row].isShooter()) {
                        for(int i = col + 1; i < board.length; i++){
                            if( board[i][row].isZombie()) {
                                board[i][row].getPiece().setHealth(board[i][row].getPiece().getHealth() - board[col][row].getPiece().getAttack());
                                if (board[i][row].getPiece().getHealth() <= 0) {
                                    loggingList.add(board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[i][row].getPiece().getName() + " Health: Dead @ " + board[i][row].getCoordinate() + "\n");
                                } else {
                                    loggingList.add(board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[i][row].getPiece().getName() + " Health: " + board[i][row].getPiece().getHealth() + " @ " + board[i][row].getCoordinate() + "\n");
                                }
                            }
                        }
                    }
                    else if (board[col][row].isZombie()){
                        if( !(col - 1 == -1)) {
                            if (board[col - 1][row].isPlant()) {
                                board[col - 1][row].getPiece().setHealth(board[col - 1][row].getPiece().getHealth() - board[col][row].getPiece().getAttack());
                                if (board[col - 1][row].getPiece().getHealth() <= 0) {
                                    loggingList.add(board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[col - 1][row].getPiece().getName() + " Health: Dead @ " + board[col - 1][row].getCoordinate() + "\n");
                                } else {
                                    loggingList.add(board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[col - 1][row].getPiece().getName() + " Health: " + board[col - 1][row].getPiece().getHealth() + " @ " + board[col - 1][row].getCoordinate() + "\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *  Adding zombies randomly at the end of the board.
     */
    public void addingZombie(){
        if(!levels.maxLevel()){
            if (!levels.checkLimit(zombies)) {
                Random ran = new Random();
                int y = ran.nextInt(5);
                int t = ran.nextInt(7);
                if (t == 0 || t == 1 || t == 2 || t == 3) {
                    add(new Coordinate(7, y), new Zombie());
                } else if (t == 4 || t == 5) {
                    add(new Coordinate(7, y), new ConeheadZombie());
                } else if (t == 6) {
                    add(new Coordinate(7, y), new BucketZombie());
                }
                zombies++;
                System.out.println(zombies);
            }
        }
    }

    /**
     *  Used for the zombies to move one square forward after every round.
     */
    public void movingZombie(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].isZombie()) {
                    if(board[col][row].getPiece().getHealth() <= 0)
                    {
                        levels.zombieKilled();
                    }
                    if(move(new Coordinate(col, row), new Coordinate(col-1, row)))
                        board2GUI(board);
                }
            }
        }
    }

    /**
     *  It will remove pieces when health is equal to zero and below.
     */
    public void removeUpdate(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getHealth() <= 0) {
                        board[col][row].deletePiece();
                        board2GUI(board);
                    }
                }
            }
        }
    }

    /**
     *  Whenever there is a sunflower spawned in the game, it will
     *  add money into the user's money pouch.
     */
    public void sunflowerMoney(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getShortName() == 'S') {
                        levels.earnedMoney(5);//moneyPouch += 5;
                        loggingList.add( "Model.Sunflower Model.Piece added 5 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n");
                    }
                    if (board[col][row].getPiece().getShortName() == '2') {
                        levels.earnedMoney(10);
                        //moneyPouch += 10;
                        loggingList.add( "Model.TwinSunflower Model.Piece added 10 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n");
                    }
                    if (board[col][row].getPiece().getShortName() == 'G') {
                        levels.earnedMoney(15);
                        //moneyPouch += 15;
                        loggingList.add( "Model.GiantSunflower Model.Piece added 15 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n");
                    }
                }
            }
        }
    }

    /**
     *  To see if the user is able to purchase a new piece.
     *  @param piece The piece wanting to purchase.
     *  @return The ability to purchase a piece.
     */
    public boolean purchasePiece(Piece piece){
        if(levels.getMoney() < piece.getCost())
            return false;
        levels.buyPiece(piece.getCost()); //-= piece.getCost();
        return true;
    }


    /**
     * Copies the current state of the gameboard
     * @return Square[][] object representing the board and all it's pieces
     */
    public Square[][] copyBoard() {
        Square boardCopy[][] = new Square[BOARD_LENGTH][BOARD_HEIGHT];
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                boardCopy[col][row] = board[col][row].copy();
            }
        }
        return boardCopy;
    }

    /**
     * Import Serial file to receive AddressBook
     * @param file
     */
    public void load(String file){
        GameLevels temp;
        try{
            ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(file));
            Square[][] tempBoard = (Square[][]) oStream.readObject();
            oStream.close();
            for (int row = 0; row < board[0].length; row++) {
                for (int col = 0; col < board.length; col++) {
                    board[col][row] = tempBoard[col][row];
                }
            }
            board2GUI(board);
            JOptionPane.showMessageDialog(null, "Game successfully loaded.");
            temp = levels.loadLevels();
            levels = temp;
            zombies = levels.getZombiesLeft();
            view.getSunMoney().setText(Integer.toString(levels.getMoney()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Game save was not found");
        }
    }

    /**
     * Export AddressBook into Serialize Format
     * @param file
     */
    public void save(String file){
        try{
            ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(file));
            oStream.writeObject(copyBoard());
            oStream.close();
            JOptionPane.showMessageDialog(null, "Game successfully saved.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Game save unsuccessful.");
        }
        levels.saveLevels();
    }

    public void undo() {
        if (undoBoard.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No possible undos.");
            return;
        }
        redoBoard.push(board);
        board = undoBoard.pop();
        board2GUI(board);
    }

    public void redo() {
        if (redoBoard.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No possible redos.");
            return;
        }
        undoBoard.push(board);
        board = redoBoard.pop();
        board2GUI(board);
    }

    public void board2GUI(Square[][] board){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if(board[col][row].getPiece() != null) {
                    view.getGameButtons()[col][row].setDisabledIcon(board[col][row].getImage());
                    view.getGameButtons()[col][row].setIcon(board[col][row].getImage());
                    view.getGameButtons()[col][row].setEnabled(false);
                } else {
                    if(col == 7){
                        view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon(getClass().getResource("/Images/sidewalk.png")));
                        view.getGameButtons()[col][row].setIcon(new ImageIcon(getClass().getResource("/Images/sidewalk.png")));
                        view.getGameButtons()[col][row].setEnabled(false);
                    } else {
                        view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
                        view.getGameButtons()[col][row].setIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
                        view.getGameButtons()[col][row].setEnabled(true);
                    }
                }
            }
        }
    }

    /**
     *  Will re-initialize the gameboard, where no piece has spawned.
     */
    public void reset(){
        //Creating two arrays to align with a 2 dimension array
        board = new Square[8][5];
        levels.restartLevels();
        for (int rowsBoard = 0; rowsBoard < board[0].length; rowsBoard++) {
            for (int columnsBoard = 0; columnsBoard < board.length; columnsBoard++) {
                board[columnsBoard][rowsBoard] = new Square(new Coordinate(columnsBoard, rowsBoard));
                view.getGameButtons()[columnsBoard][rowsBoard].setContentAreaFilled(false);
            }
        }
        board2GUI(board);
    }

    /**
     *  Once all the zombies have been spawned, it will go through all the squares
     *  in the board; To see if any zombies are "alive". If there are zombies still
     *  alive then the game keeps going. If all are killed, then the game ends.
     */
    private void gameWon(){
        if (levels.maxLevel()){
            JOptionPane.showMessageDialog(null, "You have won the game! Thank you for playing.");
            System.exit(0);
        }
    }

    /**
     *  Will end the game, if any zombies have reached at the end of the gameboard.
     */
    private void gameOver(){
        for (int row = 0; row < board[0].length; row++) {
            if (board[0][row].isZombie()) {
                JOptionPane.showMessageDialog(null,"You have lost. Thank you for playing.");
                System.exit(0);
            }
        }
    }

    /**
     *  Receiving the square at specific coordinate, as the square contains both the coordinate and piece.
     *  @param c Model.Coordinate of the square needed
     *  @return The square at specific coordinate
     */
    private Square getSquare (Coordinate c){
        return board[c.getColumnNumber()][c.getRowNumber()];
    }

    public void getLogging(){
        view.getTextArea().setText("");
        for(String log : loggingList){
            view.getTextArea().append(log);
        }
    }

    /**
     *  @return String implementation of the gameboard. Also, containing logs and money pouch.
     */
    @Override
    public String toString() {
        //Printing in toString() format of the gameBoard
        Piece shortNamePiece;
        String s = "";
        s += "\n   0 1 2 3 4 5 6 7\n";
        for (int row = 0; row < board[0].length; row++) {
            s += row +" |";
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null) {
                    shortNamePiece = board[col][row].getPiece();
                    s += shortNamePiece.getShortName() + "|";
                } else {
                    s += " |";
                }
            }
            s += "\n";
        }
        s += "Money Pouch: " + levels.getMoney() + "\n";
        // s += logging;
        return s;
    }

    /**
     * The Getter method for the Square Board
     * @return board, The Game Board
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * The Getter method for the clicked button coordinate values
     * @return Coordinate, The Coordinate Values of the clicked buttons
     */
    public Coordinate getClickedButtonLocation() {
        return clickedButtonLocation;
    }


}
