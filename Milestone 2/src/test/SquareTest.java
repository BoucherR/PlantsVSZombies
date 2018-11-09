package test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for Square
 * @author Muneeb Nasir
 * @version 2.0
 */

public class SquareTest {

    /**
     * The Square Objects used for the Test Cases
     */
    private Square testSquare1;
    private Square testSquare2;
    private Square testSquare3;
    private Square testSquare4;

    /**
     * The method is used to establish the Square Object that is to be used in the test cases
     */
    @Before
    public void setUp() {
        testSquare1 = new Square(new Coordinate(1,2));
        testSquare2 = new Square(new Coordinate(4,3));
        testSquare3 = new Square((new Coordinate(1,1)), new Sunflower());
        testSquare4 = new Square((new Coordinate(5,2)), new Zombie());
    }

    /**
     * The method is used to test the constructor for the class whose parameter is the coordinate of the
     * square on the Game Board
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(testSquare1);
        assertNotNull(testSquare2);

        assertEquals("The Column Number is 1",1,testSquare1.getColumnNumber());
        assertEquals("The Row Number is 2",2,testSquare1.getRowNumber());
        assertTrue(testSquare1.equals(new Square(new Coordinate(1,2))));

        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());
        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());
        assertTrue(testSquare2.equals(new Square(new Coordinate(4,3))));
    }

    /**
     * The method is used to test the constructor for the class with the user defined Coordinate and Game Piece
     * of the square
     */
    @Test
    public void testConstructor(){
        assertNotNull(testSquare3);
        assertNotNull(testSquare4);

        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());
        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());
        assertTrue(testSquare3.equals(new Square((new Coordinate(1,1)),new Sunflower())));

        assertEquals("The Column Number is 5",5,testSquare4.getColumnNumber());
        assertEquals("The Row Number is 2",2,testSquare4.getRowNumber());
        assertTrue(testSquare4.equals(new Square((new Coordinate(5,2)),new Zombie())));

    }

    /**
     * The Test is used to check the Setter method for the position of the square on the Game Board
     */
    @Test
    public void testSetPosition(){
        testSquare1.setPosition(new Coordinate(3,3));
        assertNotNull(testSquare1.getCoordinate());
        assertTrue(testSquare1.getCoordinate().equals(new Coordinate(3,3)));


        testSquare2.setPosition(new Coordinate(1,2));
        assertNotNull(testSquare2.getCoordinate());
        assertTrue(testSquare2.getCoordinate().equals(new Coordinate(1,2)));

        testSquare3.setPosition(new Coordinate(2,2));
        assertNotNull(testSquare3.getCoordinate());
        assertTrue(testSquare3.getCoordinate().equals(new Coordinate(2,2)));
    }

    /**
     * The Test is used to check the Setter method for the piece object located at the square
     */
    @Test
    public void testSetPiece(){
        testSquare1.setPiece(new Zombie());
        testSquare2.setPiece(new Peashooter());

        assertNotNull(testSquare1.getPiece());
        assertNotNull(testSquare2.getPiece());

        assertEquals("Game Piece => ZOMBIE ","ZOMBIE",testSquare1.getPiece().getName());
        assertEquals("Game Piece => PEASHOOTER","PEASHOOTER",testSquare2.getPiece().getName());
    }

    /**
     * The Test is used to check the Getter Method for Column Number of the square
     */
    @Test
    public void testGetColumnNumber(){
        assertNotNull(testSquare1.getColumnNumber());
        assertNotNull(testSquare2.getColumnNumber());
        assertNotNull(testSquare3.getColumnNumber());
        assertNotNull(testSquare4.getColumnNumber());

        assertNotEquals(3,testSquare1.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 1",1,testSquare1.getColumnNumber());

        assertNotEquals("The Column Number is 4",2,testSquare2.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());

        assertNotEquals("The Column Number is 1",2,testSquare3.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());

        assertEquals("The Column Number is 5",5,testSquare4.getColumnNumber());
    }

    /**
     * The Test is used to check the Getter method for the Row Number of the Square
     */
    @Test
    public void testGetRowNumber(){
        assertNotNull(testSquare1.getRowNumber());
        assertNotNull(testSquare2.getRowNumber());
        assertNotNull(testSquare3.getRowNumber());
        assertNotNull(testSquare4.getRowNumber());

        assertNotEquals("The ",3,testSquare1.getRowNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Row Number is 2",2,testSquare1.getRowNumber());

        assertNotEquals(1,testSquare2.getRowNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());

        assertNotEquals(2,testSquare3.getRowNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());

        assertEquals("The Row Number is 2",2,testSquare4.getRowNumber());
    }

    /**
     * The Test is used to check the Coordinate Getter method for the square object
     */
    @Test
    public void testGetCoordinate(){
        assertNotNull(testSquare1.getCoordinate());
        assertNotNull(testSquare2.getCoordinate());
        assertNotNull(testSquare3.getCoordinate());
        assertNotNull(testSquare4.getCoordinate());

        assertTrue(testSquare1.getCoordinate().equals(new Coordinate(1,2)));

        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());
        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());

        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());
        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());

        Square temp = new Square ((new Coordinate(5,2)),new Zombie());
        assertTrue("The Coordinates are 5,2",testSquare4.equals(temp));
    }

    /**
     * The Test is used to check the Game Piece Getter method for the square object
     */
    @Test
    public void testGetPiece(){
        assertNull("The Square should be empty",testSquare1.getPiece());
        assertNull("The Square should be empty",testSquare2.getPiece());

        assertNotNull("The Square should NOT be empty",testSquare3.getPiece());
        assertNotNull("The Square should NOT be empty",testSquare4.getPiece());

        assertEquals("Actual Value is SUNFLOWER","SUNFLOWER",testSquare3.getPiece().getName());
        assertEquals("Actual Value is ZOMBIE","ZOMBIE",testSquare4.getPiece().getName());
    }

    /**
     * The Test is used to check for the Piece Addition onto the Game Board
     */
    @Test
    public void testAddPiece(){
        testSquare1.addPiece(new Peashooter());
        testSquare2.addPiece(new Zombie());

        assertNotNull("The Square should NOT be empty",testSquare1.getPiece());
        assertNotNull("The Square should NOT be empty",testSquare2.getPiece());

        assertEquals("The Game Piece is PEASHOOTER","PEASHOOTER",testSquare1.getPiece().getName());
        assertEquals("The Game Piece is ZOMBIE","ZOMBIE",testSquare2.getPiece().getName());
    }

    /**
     * The Test is used to check the Removal of the Game Piece from the current Square.
     */
    @Test
    public void testDeletePiece(){
        testSquare1.addPiece(new Peashooter()); //Added to check the deletion of game piece
        testSquare2.addPiece(new Zombie());
        assertNotNull(testSquare1.getPiece());
        assertNotNull(testSquare2.getPiece());

        testSquare1.deletePiece();
        testSquare2.deletePiece();
        testSquare3.deletePiece();
        testSquare4.deletePiece();

        assertNotSame("The Square should be empty",(new Peashooter()),testSquare1.getPiece());
        assertNotSame("The Square should be empty",(new Zombie()),testSquare2.getPiece());
        assertNotSame("The Square should be empty",(new Sunflower()),testSquare3.getPiece());
        assertNotSame("The Square should be empty",(new Zombie()),testSquare4.getPiece());

    }

    /**
     * The Test is used to check the IsOccupied() method which checks the existence of Game Piece object
     * at the specific square coordinates
     */
    @Test
    public void testIsOccupied(){
        assertFalse(testSquare1.isOccupied()); //As there is no piece at the square
        assertFalse(testSquare2.isOccupied());
        assertTrue(testSquare3.isOccupied());
        assertTrue(testSquare4.isOccupied());
    }

    /**
     * The Test is used to check the String output that contains the information of the square object
     */
    @Test
    public void testToString(){
        assertEquals("Square(1,2)",testSquare1.toString());
        assertNotEquals("Square(1,2)","Square(1,2):P -> Health: 5",testSquare1.toString());

        assertEquals("Square(4,3)",testSquare2.toString());
        assertNotEquals("Square with no game piece","Square(4,3):P -> Health: 5",testSquare2.toString());
        assertNotEquals("Square(1,1)",testSquare3.toString());
        assertEquals("Complete Square Information Missing","Square(1,1):S -> Health: 5",testSquare3.toString());

        assertNotEquals("Square(5,2)",testSquare4.toString());
        assertNotEquals("Square(5,2):Z -> Health: 5","Square(5,2)",testSquare4.toString());
        assertEquals("Complete Square Information Missing","Square(5,2):Z -> Health: 5",testSquare4.toString());
    }

    /**
     * The Test is used to check the equals() method
     */
    @Test
    public void testEqual(){
        assertTrue("Square entry doesn't match",testSquare1.equals(new Square(new Coordinate(1,2))));
        assertFalse("Square entry not NULL",testSquare1.equals(null));
        assertFalse("Square: R-1,C-2,P-None",testSquare1.equals(new Square(new Coordinate(4,2),new Peashooter())));
        assertFalse("Square: R-1,C-2,P-None",testSquare1.equals(new Square(new Coordinate(2,3),new Peashooter())));


        assertTrue("Square entry doesn't match",testSquare2.equals(new Square(new Coordinate(4,3))));
        assertFalse("Square entry not NULL",testSquare2.equals(null));
        assertFalse("Square: R-4,C-3,P-PeaShooter",testSquare2.equals(new Square(new Coordinate(4,4),new Sunflower())));
        assertFalse("Square: R-4,C-3,P-PeaShooter",testSquare2.equals(new Square(new Coordinate(2,1),new Sunflower())));

        assertTrue("Square entry doesn't match",testSquare3.equals(new Square((new Coordinate(1,1)), new Sunflower())));
        assertFalse("Square entry not NULL",testSquare3.equals(null));
        assertFalse("Square: R-1,C-1,P-SunFlower",testSquare3.equals(new Square((new Coordinate(1,4)), new Zombie())));
        assertFalse("Square: R-1,C-1,P-SunFlower",testSquare3.equals(new Square(new Coordinate(4,4),new Sunflower())));

        assertTrue("Square entry doesn't match",testSquare4.equals(new Square((new Coordinate(5,2)), new Zombie())));
        assertFalse("Square entry not NULL",testSquare4.equals(null));
        assertFalse("Square: R-5,C-2,P-Zombie",testSquare4.equals(new Square((new Coordinate(3,2)), new Peashooter())));
        assertFalse("Square: R-1,C-1,P-Zombie",testSquare4.equals(new Square(new Coordinate(1,4),new Sunflower())));
    }
}