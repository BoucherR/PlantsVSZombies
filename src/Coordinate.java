/**
 * The Coordinate class is used to identify the rows and columns of the game.
 * @author Muneeb Nasir
 * @version 1.0
 */
public class Coordinate {

    /**
     * The Column value of the coordinate
     */
    private int column;

    /**
     * The Row value of the coordinate
     */
    private int row;

    /**
     * Constructor that takes in the int values of the rows and columns of the coordinates
     * The constructor checks if the values of column and row are within bounds, if
     * the values are not within bounds, exception displayed when the row and column values not within
     * the specific constraints
     * @param column, user specified column number for the coordinate
     * @param row, user specified row number for the coordinate
     * @throws IndexOutOfBoundsException when the row and column values not within the specific board constraints
     */
    public Coordinate(int column, int row) throws IndexOutOfBoundsException
    {
        if ((column<0) || (column>8)) throw new IndexOutOfBoundsException("column must be between 0 and 7,inclusive");
        if ((row<0) || (row>5)) throw new IndexOutOfBoundsException("row must be between 0 and 4,inclusive");

        this.column = column;
        this.row = row;
    }

    /**
     * Constructor that takes in the row and column values in a STRING FORMAT of the coordinate.
     * The constructors checks if the values of column and row in String are within bounds.
     * It also checks if it is a valid entry for the rows and column.
     * Exception displayed when invalid entry i.e. not the right String format or correct input format
     * Exception displayed when the row and column values not within the specific constraints
     * @param coordinate, The String form of the row and column
     * @throws IllegalArgumentException when the row and column values not in correct String format
     * @throws IndexOutOfBoundsException when the row and column values not within the specific constraints
     */
    public Coordinate(String coordinate) throws IllegalArgumentException
    {
        if (coordinate.length() != 2) throw new IllegalArgumentException ("getCoordinate is a 2-character string");
        if ((coordinate.charAt(1)<'1')|| (coordinate.charAt(1)>'5')) throw new IndexOutOfBoundsException("row must be between 1 and 8,inclusive");

        this.column = coordinate.charAt(0);
        this.row = coordinate.charAt(1);
    }

    /**
     * Getter method to retrieve the row number of the coordinate
     * @return Row, The row number of the coordinate
     */
    public int getColumnNumber(){
        return this.column;
    }

    /**
     * Getter method to retrieve the column number of the coordinate
     * @return Column, The column number of the coordinate
     */
    public int getRowNumber(){
        return this.row;
    }

    /**
     * Method used to displayed the coordinate row and column information in STRING format
     * @return String, a String which contains the row and column information of the coordinates.
     */
    public String toString(){
        return "(" + Integer.toString(getColumnNumber()) + "," + Integer.toString(getRowNumber()) + ")";
    }

}
