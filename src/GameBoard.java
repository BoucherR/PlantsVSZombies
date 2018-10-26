import java.util.Random;

/**
 * @author Youssef Saghbini
 * @version 1.0
 */

public class GameBoard {

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
     *  Logging every event happening during the game.
     */
    private String logging;

    /**
     *  Will generate a brand new board with initial values. Board will consist of
     *  a dual array of squares, and each square would contain a specific coordinate and
     *  piece when added and or removed. Logging is to keep track of every event happening.
     *  Money pouch is the amount of money the player will have. ZombieLimit is the
     *  amount of zombies allowed to be spawned into the board.
     */
    public GameBoard(){
        board = new Square[8][5];
        moneyPouch = 500;
        zombieLimit = 5;
        logging = "";
        for (int c=0; c<8; c++)
            for (int r=0; r<5; r++)
                board[c][r] = new Square(new Coordinate  (c,r));
        reset();
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
            logging += "Piece not added due to space occupied.\n";
            return false;
        }
        if(!purchasePiece(piece)){
            logging += "Piece not added due to lack to money.\n";
            return false;
        }
        srcSquare.addPiece(piece);
        logging += "Added Piece: " + piece.getName() + " @ Coordinates: " + coordinate.toString() + "\n";
        return true;
    }

    /**
     *  This method is to move a piece from one coordinate to another. It will
     *  receive the current and new coordinate; in those coordinates, the method
     *  will retrieve the piece and move them.
     *  @param src the current coordinate in the piece is currently placed
     *  @param dest the potential new coordinate where the piece will be move to
     */
    public void move(Coordinate src, Coordinate dest)
    {
        Square srcSquare = this.getSquare(src);
        Square destSquare = this.getSquare(dest);
        if (destSquare.isOccupied()){
            return;
        }
        Piece p = srcSquare.getPiece();
        destSquare.addPiece(p);
        srcSquare.deletePiece();
        logging += "Moved Zombie from " + src.toString() + " to " + dest.toString() + "\n";
        return;
    }

    /**
     *  When piece is within range of attack, it will affect the other piece's health.
     */
    public void hitUpdate(){
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[col][row].getPiece() != null) {
                    if (board[col][row].getPiece().getShortName() == 'Z') {
                        if(!(col-1 == -1))
                            if (board[col-1][row].getPiece() != null && board[col-1][row].getPiece().getShortName() != 'Z') {
                                int x = board[col - 1][row].getPiece().getHealth();
                                x -= board[col][row].getPiece().getAttack();
                                board[col - 1][row].getPiece().setHealth(x);
                                logging += board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[col - 1][row].getPiece().getName() + " Health: " + board[col - 1][row].getPiece().getHealth() + " @ " + board[col - 1][row].getCoordinate() + "\n";
                            }
                    }
                    if (board[col][row].getPiece().getShortName() == 'P') {
                        if (board[col+1][row].getPiece() != null && board[col+1][row].getPiece().getShortName() == 'Z'){
                            int x = board[col + 1][row].getPiece().getHealth();
                            x -= board[col][row].getPiece().getAttack();
                            board[col + 1][row].getPiece().setHealth(x);
                            logging += board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[col + 1][row].getPiece().getName() + " Health: " + board[col + 1][row].getPiece().getHealth() + " @ " + board[col + 1][row].getCoordinate() + "\n";
                        }
                        else if (board[col+2][row].getPiece() != null && board[col+2][row].getPiece().getShortName() == 'Z'){
                            int x = board[col + 2][row].getPiece().getHealth();
                            x -= board[col][row].getPiece().getAttack();
                            board[col + 2][row].getPiece().setHealth(x);
                            logging += board[col][row].getPiece().getName() + " Health: " + board[col][row].getPiece().getHealth() + " @ " + board[col][row].getCoordinate() + " Attacked " + board[col + 2][row].getPiece().getName() + " Health: " + board[col + 2][row].getPiece().getHealth() + " @ " + board[col + 2][row].getCoordinate() + "\n";
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
            int x = ran.nextInt(5);
            add(new Coordinate(7, x), new Piece(PlantPieces.ZOMBIES));
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
                        move(new Coordinate(col, row), new Coordinate(col-1, row));
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
                    if (board[col][row].getPiece().getHealth() <= 0)
                        board[col][row].deletePiece();
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
                        logging += "Sunflower Piece added 5 to your pouch @ Coordinates: " + board[col][row].getCoordinate() + "\n";
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
        for (int rowsBoard = 0; rowsBoard < 5; rowsBoard++)
            for (int columnsBoard = 0; columnsBoard < 8; columnsBoard++)
                board[columnsBoard][rowsBoard] = new Square( new Coordinate(columnsBoard, rowsBoard));
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
                        if (board[col][row].getPiece().getShortName() == 'Z') {
                            return;
                        }
                    }
                }
            }
            System.out.println(this.toString() + "\nYou have won the game! Thank you for playing.");
            System.exit(0);
        }
    }

    /**
     *  Will end the game, if any zombies have reached at the end of the gameboard.
     */
    public void gameOver(){
        for (int row = 0; row < 5; row++) {
            if (board[0][row].getPiece() != null) {
                if (board[0][row].getPiece().getShortName() == 'Z') {
                    System.out.println(this.toString() + "\nYou have lost. Thank you for playing.");
                    System.exit(0);
                }
            }
        }
    }

    /**
     *  Receiving the square at specific coordinate, as the square contains both the coordinate and piece.
     *  @param c Coordinate of the square needed
     *  @return The square at specific coordinate
     */
    private Square getSquare (Coordinate c){
        return board[c.getColumnNumber()][c.getRowNumber()];
    }

    /**
     *  @return String implementation of the gameboard. Also, containing logs and money pouch.
     */
    public String toString() {

        //Printing in toString() format
        String s = "\n" + logging + "\n";
        Piece shortNamePiece;
        s += "   0 1 2 3 4 5 6 7\n";
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
        logging = "";
        return s;
    }

}
