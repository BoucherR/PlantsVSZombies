package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for Square
 * @author Muneeb Nasir
 * @version 3.0
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
     * The method is used to establish the Square Object that is to be used in the Test cases
     */
    @Before
    public void setUp() {
        testSquare1 = new Square(new Coordinate(1,2));
        testSquare2 = new Square(new Coordinate(4,3));
        testSquare3 = new Square((new Coordinate(1,1)), new Sunflower());
        testSquare4 = new Square((new Coordinate(5,2)), new Zombie());
    }

    /**
     * The method is used to Test the constructor for the class whose parameter is the coordinate of the
     * square on the Game Board
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(testSquare1);
        assertNotNull(testSquare2);

        assertEquals("The Column Number is 1",1,testSquare1.getColumnNumber());
        assertEquals("The Row Number is 2",2,testSquare1.getRowNumber());
        assertNotEquals("The Column Number is 1",'0',testSquare1.getColumnNumber());
        assertNotEquals("The Row Number is 2","3",testSquare1.getRowNumber());
        assertEquals(testSquare1, new Square(new Coordinate(1, 2)));
        assertNotEquals(testSquare1, new Square(new Coordinate("34"), new Zombie()));

        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());
        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());
        assertEquals(testSquare2, new Square(new Coordinate(4, 3)));
        assertNotEquals(testSquare2, new Square(new Coordinate("44"), new Sunflower()));
    }

    /**
     * The method is used to Test the constructor for the class with the user defined Coordinate and Game Piece
     * of the square
     */
    @Test
    public void testConstructor(){
        assertNotNull("The Square has given coordinates",testSquare3);
        assertNotNull("The Square has given coordinates",testSquare4);

        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());
        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());
        assertEquals(testSquare3, new Square((new Coordinate(1, 1)), new Sunflower()));

        assertEquals("The Column Number is 5",5,testSquare4.getColumnNumber());
        assertEquals("The Row Number is 2",2,testSquare4.getRowNumber());
        assertEquals(testSquare4, new Square((new Coordinate(5, 2)), new Zombie()));

        assertNotEquals("The Column Number is 1",'9',testSquare3.getColumnNumber());
        assertNotEquals("The Row Number is 2","02",testSquare4.getRowNumber());

    }

    /**
     * The Test is used to check the Setter method for the position of the square on the Game Board
     */
    @Test
    public void testSetPosition(){
        testSquare1.setPosition(new Coordinate(3,3));
        assertNotNull("The Square has given coordinates",testSquare1.getCoordinate());
        assertEquals("The Square has given coordinates set to 3,3",testSquare1.getCoordinate(),new Coordinate(3,3));
        assertNotEquals("The Coordinates are 3,3",new Coordinate("44"),testSquare1.getCoordinate());
        assertNotEquals("The Coordinates are 3,3","1,2",testSquare1.getCoordinate());


        testSquare2.setPosition(new Coordinate(1,2));
        assertNotNull("The Square has given coordinates",testSquare2.getCoordinate());
        assertEquals("The Coordinates are 1,2",testSquare2.getCoordinate(),new Coordinate(1,2));
        assertNotEquals("The Coordinates are 1,2",new Coordinate("21"),testSquare2.getCoordinate());
        assertNotEquals("The Coordinates are 1,2","4,3",testSquare2.getCoordinate());

        testSquare3.setPosition(new Coordinate(2,2));
        assertNotNull("The Square has given coordinates",testSquare3.getCoordinate());
        assertEquals("The Coordinates are 2,2",testSquare3.getCoordinate(),new Coordinate(2,2));
        assertNotEquals("The Coordinates are 2,2",new Coordinate("12"),testSquare3.getCoordinate());
        assertNotEquals("The Coordinates are 2,2",'2',testSquare3.getCoordinate());
    }

    /**
     * The Test is used to check the Setter method for the piece object located at the square
     */
    @Test
    public void testSetPiece(){
        testSquare1.setPiece(new Zombie());
        testSquare2.setPiece(new Peashooter());

        assertNotNull("The Piece is Zombie",testSquare1.getPiece());
        assertNotNull("The Piece is Peashooter",testSquare2.getPiece());

        assertEquals("Game Piece => ZOMBIE ","ZOMBIE",testSquare1.getPiece().getName());
        assertNotEquals("Game Piece=> Zombie",1234,testSquare1.getPiece().getName());

        assertEquals("Game Piece => PEASHOOTER","PEASHOOTER",testSquare2.getPiece().getName());
        assertNotEquals("Game Piece=> PEASHOOTER","XOSHOOT",testSquare1.getPiece().getName());
    }

    /**
     * The Test is used to check the Getter Method for Column Number of the square
     */
    @Test
    public void testGetColumnNumber(){
        assertNotEquals("The Column Number is 1",0,testSquare1.getColumnNumber());
        assertNotEquals("The Column Number is 4",-1,testSquare2.getColumnNumber());
        assertNotEquals("The Column Number is 1",-1,testSquare3.getColumnNumber());
        assertNotEquals("The Column Number is 5",0,testSquare4.getColumnNumber());

        assertNotEquals("The Column Number is 1",3,testSquare1.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 1",1,testSquare1.getColumnNumber());

        assertNotEquals("The Column Number is 4","55",testSquare2.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());

        assertNotEquals("The Column Number is 1",'2',testSquare3.getColumnNumber());//As the Set Position Test changes the Original Position
        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());

        assertEquals("The Column Number is 5",5,testSquare4.getColumnNumber());
        assertNotEquals("The Column Number is 5","05",testSquare4.getColumnNumber());
    }

    /**
     * The Test is used to check the Getter method for the Row Number of the Square
     */
    @Test
    public void testGetRowNumber(){
        assertNotEquals("The Row Number is 2",0,testSquare1.getRowNumber());
        assertNotEquals("The Row Number is 3",-1,testSquare2.getRowNumber());
        assertNotEquals("The Row Number is 1",0,testSquare3.getRowNumber());
        assertNotEquals("The Row Number is 2",-1,testSquare4.getRowNumber());

        assertNotEquals("The Row Number is 2",'5'-48,testSquare1.getRowNumber());
        assertEquals("The Row Number is 2",2,testSquare1.getRowNumber());

        assertNotEquals("The Row Number is 3","03",testSquare2.getRowNumber());
        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());

        assertNotEquals("The Row Number is 1",'1',testSquare3.getRowNumber());
        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());

        assertEquals("The Row Number is 2",2,testSquare4.getRowNumber());
        assertNotEquals("The Row Number is 2","20",testSquare4.getRowNumber());
    }

    /**
     * The Test is used to check the Coordinate Getter method for the square object
     */
    @Test
    public void testGetCoordinate(){
        assertNotNull("The Square Position is Set",testSquare1.getCoordinate());
        assertNotNull("The Square Position is Set to 3,4",testSquare2.getCoordinate());
        assertNotNull("The Square Position is Set",testSquare3.getCoordinate());
        assertNotNull("The Square Position is Set",testSquare4.getCoordinate());

        assertEquals("The Square Position is Set to 1,2",testSquare1.getCoordinate(),new Coordinate(1,2));

        assertEquals("The Row Number is 3",3,testSquare2.getRowNumber());
        assertEquals("The Column Number is 4",4,testSquare2.getColumnNumber());
        assertNotEquals("The Row Number is 3",'3',testSquare2.getRowNumber());
        assertNotEquals("The Row Number is 4","4",testSquare2.getColumnNumber());

        assertEquals("The Row Number is 1",1,testSquare3.getRowNumber());
        assertEquals("The Column Number is 1",1,testSquare3.getColumnNumber());
        assertNotEquals("The Row Number is 3","01",testSquare3.getRowNumber());
        assertNotEquals("The Row Number is 4","04",testSquare3.getColumnNumber());

        Square temp = new Square ((new Coordinate(5,2)),new Zombie());
        assertEquals("The Coordinates are 5,2",testSquare4,temp);
        temp.setPosition(new Coordinate("55"));
        assertNotEquals("The Coordinates are 5,2",testSquare4,temp);
    }

    /**
     * The Test is used to check the Game Piece Getter method for the square object
     */
    @Test
    public void testGetPiece(){
        assertNull("The Square should be empty",testSquare1.getPiece());
        assertNull("The Square should be empty",testSquare2.getPiece());
        assertNotEquals("The Square not occupied",new Square(new Coordinate("22"), new Zombie()),testSquare2);

        assertNotNull("The Square should NOT be empty",testSquare3.getPiece());
        assertNotNull("The Square should NOT be empty",testSquare4.getPiece());

        assertEquals("Actual Value is SUNFLOWER","SUNFLOWER",testSquare3.getPiece().getName());
        assertEquals("Actual Value is ZOMBIE","ZOMBIE",testSquare4.getPiece().getName());

        assertNotEquals("Actual Value is SUNFLOWER","FLOW",testSquare3.getPiece().getName());
        assertNotEquals("Actual Value is ZOMBIE","ZZZ",testSquare4.getPiece().getName());
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

        assertNotEquals("The Game Piece is PEASHOOTER","PSHOOTER",testSquare1.getPiece().getName());
        assertNotEquals("The Game Piece is ZOMBIE","BIE",testSquare2.getPiece().getName());

        testSquare3.addPiece(new Zombie());
        assertNotEquals("The Game Piece is Sunflower","ZOMBIE",testSquare3.getPiece().getName());
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

        testSquare1.addPiece(new Zombie());
        assertTrue(testSquare1.isOccupied());
        testSquare1.deletePiece();
        assertFalse(testSquare1.isOccupied());
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
        assertEquals("Square entry doesn't match", testSquare1, new Square(new Coordinate(1, 2)));
        assertNotEquals("Square entry not NULL", null, testSquare1);
        assertNotEquals("Square: R-1,C-2,P-None",true,testSquare1.equals(new Square(new Coordinate(4,2),new Peashooter())));
        assertNotEquals("Square: R-1,C-2,P-None", testSquare1, new Square(new Coordinate(2, 3), new Peashooter()));


        assertEquals("Square entry doesn't match", testSquare2, new Square(new Coordinate(4, 3)));
        assertNotEquals("Square entry not NULL", null, testSquare2);
        assertNotEquals("Square: R-4,C-3,P-PeaShooter",true,testSquare2.equals(new Square(new Coordinate(4,4),new Sunflower())));
        assertNotEquals("Square: R-4,C-3,P-PeaShooter",true,testSquare2.equals(new Square(new Coordinate(2,1),new Sunflower())));

        assertTrue("Square entry doesn't match",testSquare3.equals(new Square((new Coordinate(1,1)), new Sunflower())));
        assertNotEquals("Square entry not NULL", null, testSquare3);
        assertNotEquals("Square: R-1,C-1,P-SunFlower",true,testSquare3.equals(new Square((new Coordinate(1,4)), new Zombie())));
        assertNotEquals("Square: R-1,C-1,P-SunFlower",true,testSquare3.equals(new Square(new Coordinate(4,4),new Sunflower())));

        assertTrue("Square entry doesn't match",testSquare4.equals(new Square((new Coordinate(5,2)), new Zombie())));
        assertNotEquals("Square entry not NULL", null, testSquare4);
        assertNotEquals("Square: R-5,C-2,P-Zombie",true,testSquare4.equals(new Square((new Coordinate(3,2)), new Peashooter())));
        assertNotEquals("Square: R-1,C-1,P-Zombie",true,testSquare4.equals(new Square(new Coordinate(1,4),new Sunflower())));
    }

    /**
     * The Test is used to check a functionality of the method to check the Type of the Game Piece (Plant OR Zombie)
     */
    @Test
    public void testIsZombie(){
        assertFalse("The Piece located is not a Zombie",testSquare1.isZombie());
        testSquare1.addPiece(new ConeheadZombie());
        assertTrue("The Piece Located is Zombie",testSquare1.isZombie());
        testSquare1.deletePiece();
        assertFalse("The Zombie Located was removed",testSquare1.isZombie());

        testSquare2.addPiece(new Threepeater());
        assertFalse("The Piece is not Zombie",testSquare2.isZombie());

        assertFalse("The Game Piece is not a Zombie",testSquare3.isZombie());
        assertTrue("The Game Piece located a Zombie",testSquare4.isZombie());
    }

    /**
     * The Test is used to check a functionality of the method to check the Type of the Game Piece (Plant OR Zombie)
     */
    @Test
    public void testIsPlant(){
        assertFalse("There is no piece located",testSquare1.isPlant());
        testSquare2.addPiece(new Repeater());
        assertTrue("The Piece instance is Repeater Plant",testSquare2.isPlant());
        assertTrue("The Piece instance is Sunflower Plant",testSquare3.isPlant());
        assertFalse("The Piece instance is Repeater",testSquare4.isPlant());
    }

    /**
     * The Test is used to check a functionality of the method to check the Shooter Type of the Plant Piece (Sunflower OR Shooter)
     */
    @Test
    public void testIsShooter(){
        testSquare1.addPiece(new Sunflower());
        assertFalse("The Plant Piece is a shooter",testSquare1.isShooter());
        testSquare1.deletePiece();
        testSquare1.addPiece(new BucketZombie());
        assertFalse("The Piece object is Zombie",testSquare1.isShooter());

        testSquare2.addPiece(new Repeater());
        assertTrue("The Plant Piece is a shooter",testSquare2.isShooter());
        assertFalse("The Plant Piece is not a Shooter",testSquare3.isShooter());
        assertFalse("The Piece object is a Zombie",testSquare4.isShooter());
    }

    /**
     * The Test is used to check a functionality of the method to check the Sunflower Type of the Plant Piece (Sunflower OR Shooter)
     */
    @Test
    public void testIsSunflower(){
        testSquare1.addPiece(new GiantSunflower());
        assertTrue("The Plant Piece is a Sunflower",testSquare1.isSunflower());
        testSquare1.deletePiece();
        testSquare1.addPiece(new BucketZombie());
        assertFalse("The Piece object is not a Sunflower",testSquare1.isSunflower());

        testSquare2.addPiece(new Sunflower());
        assertTrue("The Plant Piece is a Sunflower",testSquare3.isSunflower());

        testSquare3.deletePiece();
        assertFalse("The Sunflower piece has been removed",testSquare3.isSunflower());
    }
}