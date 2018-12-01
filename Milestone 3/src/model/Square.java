package model;


import java.io.Serializable;

/**
 * Square Class stores information of the Pieces and Coordinates
 * @author Muneeb Nasir
 * @version  1.0
 */

public class Square implements Serializable {

    /**
     * The Coordinates of the square object
     */
    private Coordinate position;

    /**
     * The Piece that is occupying  the square object
     */
    private Piece gamePiece;

    /**
     * Square Constructor with specific coordinate
     * @param newCoordinates, user specified position
     */
    public Square(Coordinate newCoordinates){
        this.position = newCoordinates;
    }

    /**
     * Square Constructor with specific coordinate and game piece
     * @param newCoordinates, user specified position
     * @param newPiece, user specified game object
     */
    public Square(Coordinate newCoordinates, Piece newPiece){
        this.gamePiece = newPiece;
        this.position = newCoordinates;
    }

    /**
     * Getter method for the column number of the coordinate position
     * @return Column Number of the position
     */
    public int getColumnNumber(){
        return position.getColumnNumber();
    }

    /**
     * Getter method for the row number of the coordinate position
     * @return Row Number of the coordinate position
     */
    public int getRowNumber(){
        return position.getRowNumber();
    }

    /**
     * Setter method for the position of the square with user specified coordinate value
     * @param newCoordinate, The user specified coordinate of the square
     */
    public void setPosition(Coordinate newCoordinate){this.position = newCoordinate;}
    /**
     * Getter method for the coordinate position
     * @return Position, The position coordinate of the square
     */
    public Coordinate getCoordinate(){
        return this.position;
    }

    /**
     * Getter method for the game piece on the square
     * @return Piece, the piece located on the square position
     */
    public Piece getPiece(){
        return this.gamePiece;
    }

    /**
     * Setter method for the game piece
     * @param piece, user specified game piece object
     */
    public void setPiece(Piece piece) {
        this.gamePiece = piece;
    }

    /**
     *  Adds a new piece to the specific square object when necessary, and if the square
     *  is not empty/occupied it will replace the existing game piece.
     * @param newPiece, user specified game piece object that is to be added
     */
    public void addPiece(Piece newPiece){
        if(!isOccupied()){
            this.gamePiece = newPiece;
        }
    }

    /**
     * Removes a piece from the square position.
     */
    public void deletePiece(){
        if(isOccupied()){
            Piece temp = this.gamePiece;
            this.gamePiece = null;
        }
    }

    /**
     * Method checks if the square is empty or being occupied by an existing game piece
     * @return True, only if the square is occupied. False, if there is no game piece located
     */
    public boolean isOccupied(){
        if(this.position != null && this.gamePiece != null){
            return true;
        }
        return false;
    }

    /**
     *   Method used to print the information of the square object in STRING format
     *   @return String, a String which contains the coordinates of the specific square along with the
     *   piece that occupies that current square location
     */
    public String toString(){
        if(isOccupied()){
            return "Square(" + Integer.toString(getColumnNumber()) + "," + Integer.toString(getRowNumber()) + "):" + gamePiece.toString();
        }
        return "Square(" + Integer.toString(getColumnNumber()) + "," + Integer.toString(getRowNumber()) + ")";

    }

    /**
     * The Equality of two objects is checked by comparing the object by the field values
     * @return True, If the two objects are same
     */
    @Override
    public boolean equals(Object input) {
        if (input != null && input instanceof Square)
        {
            if (this.gamePiece == null && ((Square)input).gamePiece == null)
            {
                if (this.getCoordinate().equals(((Square)input).getCoordinate()))
                {
                    return true;
                }
            }
            else
            {
                if(this.gamePiece == null)
                {
                    return false;
                }
                if (this.getCoordinate().equals(((Square)input).getCoordinate()) && this.gamePiece.equals(((Square)input).getPiece())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The Method is used to check the current piece type Game piece: ZOMBIE
     * @return True, if the current piece located is a Zombie else false
     */
    public boolean isZombie(){
        if(gamePiece==null) { return false; }
        return gamePiece.getShortName() == 'Z' || gamePiece.getShortName() == 'C' || gamePiece.getShortName() == 'B';
    }

    /**
     * The Method is used to check the current piece type of Game piece: PLANT
     * @return True, if the current piece located is a PLANT else false
     */
    public boolean isPlant(){
        if(gamePiece==null) { return false; }
        return gamePiece.getShortName() == 'S' || gamePiece.getShortName() == '2' || gamePiece.getShortName() == 'G'
                || gamePiece.getShortName() == 'W' || gamePiece.getShortName() == 'P' || gamePiece.getShortName() == 'T'
                || gamePiece.getShortName() == 'R';
    }

    /**
     * The Method is used to check the current piece type of Game piece: PLANT SHOOTER
     * @return True, if the current piece located is a PLANT SHOOTER else false
     */
    public boolean isShooter(){
        if(gamePiece==null) { return false; }
        return gamePiece.getShortName() == 'P' || gamePiece.getShortName() == 'T' || gamePiece.getShortName() == 'R';
    }

    /**
     * The Method is used to check the current piece type of Game piece: PLANT SUNFLOWER
     * @return True, if the current piece located is a PLANT SUNFLOWER else false
     */
    public boolean isSunflower(){
        if(gamePiece==null) { return false; }
        return gamePiece.getShortName() == 'S' || gamePiece.getShortName() == '2' || gamePiece.getShortName() == 'G';
    }

    /**
     * Used for a deep-copy in order to allow for proper undo/redo
     * @return Deep copy of the square
     */
    public Square copy() {
        return new Square (position, gamePiece == null ? null : gamePiece.copy());
    }


}
