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

    private View view;

    private Coordinate clickedButtonLocation;

    private List<String> loggingList;

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
        this.view = view;
        this.moneyPouch = 500;
        this.zombieLimit = 10;
        for (int c=0; c<8; c++)
            for (int r=0; r<5; r++)
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

        view.getRedoButton().addMenuListener(new MenuListener() {

            public void menuSelected(MenuEvent e) {
                loggingList.add("Redo Clicked! \n");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        view.getUndoButton().addMenuListener(new MenuListener() {

            public void menuSelected(MenuEvent e) {
                loggingList.add("Undo Clicked! \n");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        /**
         * Placing Action listeners on each square of the board
         */
        for(int i = 0; i < 5;i++) {
            for (int j = 0; j < 8; j++) {
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
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setIcon(new ImageIcon("./src/Images/Sunflower.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });

        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a peashooter.
         */
        view.getPeashooter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Peashooter())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setDisabledIcon(new ImageIcon("./src/Images/Peashooter.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a repeater.
         */
        view.getRepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Repeater())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setDisabledIcon(new ImageIcon("./src/Images/Repeater.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getThreepeater().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Threepeater())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setDisabledIcon(new ImageIcon("./src/Images/Threepeater.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of a threepeater.
         */
        view.getWallnut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new Wallnut())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setDisabledIcon(new ImageIcon("./src/Images/Wallnut.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
        
        /**
         * Using pop-ups on the board, generated on the click-location, to handle the placing of sunflowers.
         */
        view.getTwinSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new TwinSunflower())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setIcon(new ImageIcon("./src/Images/TwinSunflower.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
        
        view.getGiantSunflower().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(add(clickedButtonLocation, new GiantSunflower())) {
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setIcon(new ImageIcon("./src/Images/GiantSunflower.png"));
                    view.getGameButtons()[clickedButtonLocation.getColumnNumber()][clickedButtonLocation.getRowNumber()].setRolloverEnabled(false);
                    runTime(); // effectively ends turn
                    getLogging(); // keep track of game
                }
                view.getPopupMenu().setVisible(false);
            }
        });
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
            loggingList.add("Piece not added due to lack to money.\n");
            return false;
        }
        srcSquare.addPiece(piece);

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
        srcSquare.deletePiece();
        loggingList.add("Moved " + p.getName() + " from " + src.toString() + " to " + dest.toString() + "\n");
        return true;
    }

    /**
     *  When piece is within range of attack, it will affect the other piece's health.
     */
    public void hitUpdate(){
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getHealth() > 0){
                        if (board[col][row].getPiece().getShortName() == 'P' || board[col][row].getPiece().getShortName() == 'T' || board[col][row].getPiece().getShortName() == 'R' ) {
                            for(int i = 0; i < 8; i++){
                                if (board[i][row].getPiece() != null)
                                    if( board[i][row].getPiece().getShortName() == 'Z' || board[i][row].getPiece().getShortName() == 'B' || board[i][row].getPiece().getShortName() == 'C') {
                                    board[i][row].getPiece().setHealth(board[i][row].getPiece().getHealth() - board[i][row].getPiece().getAttack());
                                    if (board[i][row].getPiece().getHealth() <= 0) {
                                        loggingList.add(board[i][row].getPiece().getName() + " Health: " + board[i][row].getPiece().getHealth() + " @ " + board[i][row].getCoordinate() + " Attacked " + board[i][row].getPiece().getName() + " Health: Dead @ " + board[i][row].getCoordinate() + "\n");
                                    } else {
                                        loggingList.add(board[i][row].getPiece().getName() + " Health: " + board[i][row].getPiece().getHealth() + " @ " + board[i][row].getCoordinate() + " Attacked " + board[i][row].getPiece().getName() + " Health: " + board[i][row].getPiece().getHealth() + " @ " + board[i][row].getCoordinate() + "\n");
                                    }
                                }
                            }
                        }
                        if (board[col][row].getPiece().getShortName() == 'Z' 
                        		|| board[col][row].getPiece().getShortName() == 'B' || board[col][row].getPiece().getShortName() == 'C') {
                            if (!(col - 1 == -1)){
                                if (board[col - 1][row].getPiece() != null && board[col - 1][row].getPiece().getShortName() != 'Z'
                                        && board[col - 1][row].getPiece().getShortName() != 'B'
                                        && board[col - 1][row].getPiece().getShortName() != 'C') {
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
	            view.getGameButtons()[7][y].setDisabledIcon(new ImageIcon("./src/Images/Zombie.png"));
	        } else if (t == 2) {
	        	add(new Coordinate(7, y), new ConeheadZombie());
	            view.getGameButtons()[7][y].setDisabledIcon(new ImageIcon("./src/Images/ConeHeadZombie.png"));
	        } else if (t == 3) {
	        	add(new Coordinate(7, y), new BucketZombie());
	            view.getGameButtons()[7][y].setDisabledIcon(new ImageIcon("./src/Images/BucketZombie.png"));
	        }
            view.getGameButtons()[7][y].setEnabled(false);
            zombieLimit--;
        }
    }

    /**
     *  Used for the zombies to move one square forward after every round.
     */
    public void movingZombie(){
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getShortName() == 'Z') {
                        view.getGameButtons()[col][row].setIcon(new ImageIcon("./src/Images/Grass.png"));
                        view.getGameButtons()[col][row].setEnabled(true);
                        if(move(new Coordinate(col, row), new Coordinate(col-1, row))) {
                            view.getGameButtons()[col - 1][row].setDisabledIcon(new ImageIcon("./src/Images/Zombie.png"));
                            view.getGameButtons()[col - 1][row].setEnabled(false);
                        }
                        else {
                            view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon("./src/Images/Zombie.png"));
                            view.getGameButtons()[col][row].setEnabled(false);
                        }
                    } else if (board[col][row].getPiece().getShortName() == 'B') {
                    	view.getGameButtons()[col][row].setIcon(new ImageIcon("./src/Images/Grass.png"));
                        view.getGameButtons()[col][row].setEnabled(true);
                        if(move(new Coordinate(col, row), new Coordinate(col-1, row))) {
                            view.getGameButtons()[col - 1][row].setDisabledIcon(new ImageIcon("./src/Images/BucketZombie.png"));
                            view.getGameButtons()[col - 1][row].setEnabled(false);
                        }
                        else {
                            view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon("./src/Images/BucketZombie.png"));
                            view.getGameButtons()[col][row].setEnabled(false);
                        }
                    } else if (board[col][row].getPiece().getShortName() == 'C' ) {
                    	view.getGameButtons()[col][row].setIcon(new ImageIcon("./src/Images/Grass.png"));
                        view.getGameButtons()[col][row].setEnabled(true);
                        if(move(new Coordinate(col, row), new Coordinate(col-1, row))) {
                            view.getGameButtons()[col - 1][row].setDisabledIcon(new ImageIcon("./src/Images/ConeHeadZombie.png"));
                            view.getGameButtons()[col - 1][row].setEnabled(false);
                        }
                        else {
                            view.getGameButtons()[col][row].setDisabledIcon(new ImageIcon("./src/Images/ConeHeadZombie.png"));
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
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getHealth() <= 0) {
                        view.getGameButtons()[col][row].setEnabled(true);
                        view.getGameButtons()[col][row].setIcon(new ImageIcon("./src/Images/Grass.png"));
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
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
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
        for (int rowsBoard = 0; rowsBoard < 5; rowsBoard++) {
            for (int columnsBoard = 0; columnsBoard < 8; columnsBoard++) {
                board[columnsBoard][rowsBoard] = new Square(new Coordinate(columnsBoard, rowsBoard));
                view.getGameButtons()[columnsBoard][rowsBoard].setIcon(new ImageIcon("./src/Images/Grass.png"));
                view.getGameButtons()[columnsBoard][rowsBoard].setContentAreaFilled(false);
                view.getGameButtons()[columnsBoard][rowsBoard].setRolloverEnabled(true);
                view.getGameButtons()[columnsBoard][rowsBoard].setRolloverIcon(new ImageIcon("./src/Images/GrassHighlighted.png"));
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
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 8; col++) {
                    if (board[col][row].getPiece() != null) {
                        if (board[col][row].getPiece().getShortName() == 'Z' || board[col][row].getPiece().getShortName() == 'C' || board[col][row].getPiece().getShortName() == 'B') {
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
        for (int row = 0; row < 5; row++) {
            if (board[0][row].getPiece() != null) {
                if (board[0][row].getPiece().getShortName() == 'Z' || board[0][row].getPiece().getShortName() == 'C' || board[0][row].getPiece().getShortName() == 'B') {
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
        for (int row = 0; row < 5; row++) {
            s += row +" |";
            for (int col = 0; col < 8; col++) {
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

}
