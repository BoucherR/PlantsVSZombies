package controller;

import view.*;
import model.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Youssef Saghbini
 * @author Ryan Boucher
 * @version 1.5
 */

public class Controller {

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
    private int zombieLimit;

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

    /**
     *  Undo move
     */
    private List<Square> undoList;

    /**
     * Redo move
     */
    private List<Square> redoList;

    /**
     *  Will generate a brand new board with initial values. Board will consist of
     *  a dual array of squares, and each square would contain a specific coordinate and
     *  piece when added and or removed. Logging is to keep track of every event happening.
     *  Money pouch is the amount of money the player will have. ZombieLimit is the
     *  amount of zombies allowed to be spawned into the board.
     */
    public Controller(View view){
        this.board = new Square[8][5];
        this.loggingList = new ArrayList<>();
        undoList = new ArrayList<>();
        redoList = new ArrayList<>();
        this.view = view;
        this.moneyPouch = 500;
        this.zombieLimit = 10;
        for (int c = 0; c < board.length; c++)
            for (int r = 0; r < board[0].length; r++)
                board[c][r] = new Square(new Coordinate (c,r));
        reset();
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
         * When a plant is removed from the board, the user will be able to add it with this function
         */
        view.getRedoButton().addActionListener((ActionEvent event) -> {
            validateList(redoList);
            if(redoList.size() > 0) {
                Square tempSquare = redoList.get(redoList.size() - 1);
                undoList.add(tempSquare);
                if(add(tempSquare.getCoordinate(),tempSquare.getPiece())) {
                    view.getGameButtons()[tempSquare.getColumnNumber()][tempSquare.getRowNumber()].setDisabledIcon(tempSquare.getPiece().getImage());
                    view.getGameButtons()[tempSquare.getColumnNumber()][tempSquare.getRowNumber()].setIcon(tempSquare.getPiece().getImage());
                    redoList.remove(redoList.size() - 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Can't undo since space is occupied.");
                }
                loggingList.add("Re-added Plant \n");
            } else {
                JOptionPane.showMessageDialog(null, "No more possible Redos.");
            }
        });

        /**
         * When a plant is placed on the board, the user will be able to remove it with this function
         */
        view.getUndoButton().addActionListener((ActionEvent event) -> {
            validateList(undoList);
            if(undoList.size() > 0) {
                Square tempSquare = undoList.get(undoList.size() - 1);
                redoList.add(new Square(tempSquare.getCoordinate(),tempSquare.getPiece()));
                board[tempSquare.getColumnNumber()][tempSquare.getRowNumber()].deletePiece();
                view.getGameButtons()[tempSquare.getColumnNumber()][tempSquare.getRowNumber()].setDisabledIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
                view.getGameButtons()[tempSquare.getColumnNumber()][tempSquare.getRowNumber()].setIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
                undoList.remove(undoList.size() - 1);
                loggingList.add("Removed Plant \n");
            } else {
                JOptionPane.showMessageDialog(null, "No more possible Undos.");
            }
        });

        /**
         * Placing Action listeners on each square of the board
         */
        for(int i = 0; i < board[0].length;i++) {
            for (int j = 0; j < board.length; j++) {
                view.getGameButtons()[j][i].addActionListener((ActionEvent event) -> {
                    clickedButtonLocation = new Coordinate(((JButton) event.getSource()).getLabel());
                    view.getPopupMenu().show(view.getTopPanel(), ((JButton) event.getSource()).getX(), ((JButton) event.getSource()).getY());
                });
            }
        }

        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of sunflowers.
         */
        view.getSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Sunflower())) {
                    updateView();
                }
            }
        });

        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a peashooter.
         */
        view.getPeashooter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Peashooter())) {
                    updateView();
                }
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a repeater.
         */
        view.getRepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Repeater())) {
                    updateView();
                }
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getThreepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Threepeater())) {
                    updateView();
                }
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getWallnut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Wallnut())) {
                    updateView();
                }
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of sunflowers.
         */
        view.getTwinSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new TwinSunflower())) {
                    updateView();

                }
            }
        });
        
        view.getGiantSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new GiantSunflower())) {
                    updateView();
                }
            }
        });
    }

    /**
     *
     */
    public void updateView(){
        runTime(); // effectively ends turn
        getLogging(); // keep track of game
    }

    /**
     * This method is used to call the other methods required to finish a turn, after the player has placed his/her
     * plants.
     */
    public void runTime(){
        movingZombie();
        addingZombie();
        removeUpdate();
        hitUpdate();
        sunflowerMoney();
        gameOver();
        gameWon();
        view.getSunMoney().setText(Integer.toString(moneyPouch));
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
        if (board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'P'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'T'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'R'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'S'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == '2'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'G'
                || board[srcSquare.getColumnNumber()][srcSquare.getRowNumber()].getPiece().getShortName() == 'W') {
            undoList.add(srcSquare);
        }
        view.getGameButtons()[coordinate.getColumnNumber()][coordinate.getRowNumber()].setDisabledIcon(piece.getImage());
        view.getGameButtons()[coordinate.getColumnNumber()][coordinate.getRowNumber()].setIcon(piece.getImage());
        view.getGameButtons()[coordinate.getColumnNumber()][coordinate.getRowNumber()].setRolloverEnabled(false);
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
    public boolean move(Coordinate src, Coordinate dest)
    {
        Square srcSquare = this.getSquare(src);
        Square destSquare = this.getSquare(dest);
        if (destSquare.isOccupied()){
            return false;
        }
        Piece p = srcSquare.getPiece();
        destSquare.addPiece(p);
        view.getGameButtons()[dest.getColumnNumber()][dest.getRowNumber()].setDisabledIcon(p.getImage());
        view.getGameButtons()[dest.getColumnNumber()][dest.getRowNumber()].setIcon(p.getImage());
        srcSquare.deletePiece();
        view.getGameButtons()[src.getColumnNumber()][src.getRowNumber()].setDisabledIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
        view.getGameButtons()[src.getColumnNumber()][src.getRowNumber()].setIcon(new ImageIcon(getClass().getResource("/Images/grass.png")));
        loggingList.add("Moved " + p.getName() + " from " + src.toString() + " to " + dest.toString() + "\n");
        return true;
    }

    /**
     * Checking in the Redo/Undo List for any plants that are dead to make sure only plants who have health are stored
     */
    public void validateList(List<Square> list){
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).getPiece().getHealth() <= 0)
                list.remove(i);
        }
    }

    /**
     *  When piece is within range of attack, it will affect the other piece's health.
     */
    public void hitUpdate(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getHealth() > 0){
                        if (board[col][row].isShooter()) {
                            for(int i = col + 1; i < board.length; i++){
                                if (board[i][row].getPiece() != null){
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
                        }
                        else if (board[col][row].isZombie()) {
                            if (!(col - 1 == -1)){
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
    }

    /**
     *  Adding zombies randomly at the end of the board.
     */
    public void addingZombie(){
        if (zombieLimit != 0) {
            Random ran = new Random();
            int y = ran.nextInt(5);
            int t = ran.nextInt(4);
            if (t == 0 || t == 1) {
	            add(new Coordinate(7, y), new Zombie());
	        } else if (t == 2) {
	        	add(new Coordinate(7, y), new ConeheadZombie());
	        } else if (t == 3) {
	        	add(new Coordinate(7, y), new BucketZombie());
	        }
            view.getGameButtons()[7][y].setEnabled(false);
            zombieLimit--;
        }
    }

    /**
     *  Used for the zombies to move one square forward after every round.
     */
    public void movingZombie(){
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].isZombie()) {
                        view.getGameButtons()[col][row].setIcon(new ImageIcon(getClass().getResource("/Images/Grass.png")));
                        view.getGameButtons()[col][row].setEnabled(true);
                        if(move(new Coordinate(col, row), new Coordinate(col-1, row))) {
                            view.getGameButtons()[col - 1][row].setEnabled(false);
                        }
                        else {
                            view.getGameButtons()[col][row].setEnabled(false);
                        }
                    }
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
                        view.getGameButtons()[col][row].setEnabled(true);
                        view.getGameButtons()[col][row].setIcon(new ImageIcon(getClass().getResource("/Images/Grass.png")));
                        view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon(getClass().getResource("/Images/Grass.png")));
                        board[col][row].deletePiece();
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
                        moneyPouch += 5;
                        loggingList.add( "Model.Sunflower Model.Piece added 5 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n");
                    }
                    if (board[col][row].getPiece().getShortName() == '2') {
                        moneyPouch += 10;
                        loggingList.add( "Model.TwinSunflower Model.Piece added 10 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n");
                    }
                    if (board[col][row].getPiece().getShortName() == 'G') {
                        moneyPouch += 15;
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
        if(moneyPouch < piece.getCost())
            return false;
        moneyPouch -= piece.getCost();
        return true;
    }

    /**
     *  Will re-initialize the gameboard, where no piece has spawned.
     */
    public void reset(){
        //Creating two arrays to align with a 2 dimension array
        board = new Square[8][5];
        for (int rowsBoard = 0; rowsBoard < board[0].length; rowsBoard++) {
            for (int columnsBoard = 0; columnsBoard < board.length; columnsBoard++) {
                board[columnsBoard][rowsBoard] = new Square(new Coordinate(columnsBoard, rowsBoard));
                view.getGameButtons()[columnsBoard][rowsBoard].setIcon(new ImageIcon(getClass().getResource("/Images/Grass.png")));
                view.getGameButtons()[columnsBoard][rowsBoard].setContentAreaFilled(false);
                view.getGameButtons()[columnsBoard][rowsBoard].setRolloverEnabled(true);
                view.getGameButtons()[columnsBoard][rowsBoard].setRolloverIcon(new ImageIcon(getClass().getResource("/Images/GrassHighlighted.png")));
            }
        }
    }

    /**
     *  Once all the zombies have been spawned, it will go through all the squares
     *  in the board; To see if any zombies are "alive". If there are zombies still
     *  alive then the game keeps going. If all are killed, then the game ends.
     */
    public void gameWon(){
        if(zombieLimit == 0){
            for (int row = 0; row < board[0].length; row++) {
                for (int col = 0; col < board.length; col++) {
                    if (board[col][row].getPiece() != null) {
                        if (board[col][row].isZombie()) {
                            return;
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "You have won the game! Thank you for playing.");
            System.exit(0);
        }
    }

    /**
     *  Will end the game, if any zombies have reached at the end of the gameboard.
     */
    public void gameOver(){
        for (int row = 0; row < board[0].length; row++) {
            if (board[0][row].getPiece() != null) {
                if (board[0][row].isZombie()) {
                    JOptionPane.showMessageDialog(null,"You have lost. Thank you for playing.");
                    System.exit(0);
                }
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
        s += "Money Pouch: " + moneyPouch + "\n";
        // s += logging;
        return s;
    }

    public Square[][] getBoard() {
        return board;
    }

    public Coordinate getClickedButtonLocation() {
        return clickedButtonLocation;
    }


}
