package Test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for the Coordinate
 * @author Muneeb Nasir
 * @version 2.0
 */
public class CoordinateTest {

    /**
     * The Coordinate Objects used for the Test Cases
     */
    private Coordinate testcoodinate1;
    private Coordinate testcoodinate2;
    private Coordinate stringCoordinate1;
    private Coordinate stringCoordinate2;
    /**
     * The method is used to establish the Square Object that is to be used in the Test cases
     */
    @Before
    public void setUp(){
        testcoodinate1 = new Coordinate(2,3);
        testcoodinate2 = new Coordinate(7,2);
        stringCoordinate1 = new Coordinate("11");
        stringCoordinate2 = new Coordinate("44");
    }

    /**
     * The Test is used to check the default constructor for the coordinate class that accepts the
     * row and column values as int.
     */
    @Test
    public void testDefaultConstructor(){
        assertNotNull(testcoodinate1);
        assertNotNull(testcoodinate2);
        assertEquals(2,testcoodinate1.getColumnNumber());
        assertEquals(7,testcoodinate2.getColumnNumber());

        assertEquals(3,testcoodinate1.getRowNumber());
        assertEquals(2,testcoodinate2.getRowNumber());
    }
    /**
     * The Test is used to check the constructor that accepts the row ans column values as a string
     */
    @Test
    public void testConstructor(){
        assertEquals(1,stringCoordinate1.getColumnNumber());
        assertEquals(4,stringCoordinate2.getColumnNumber());

        assertEquals(1,stringCoordinate1.getRowNumber());
        assertEquals(4,stringCoordinate2.getRowNumber());

        assertNotNull(stringCoordinate1);
        assertNotNull(stringCoordinate2);
    }

    /**
     * The Test is used to check the Getter method for the Column Number of the coordinate
     */
    @Test
    public void testGetColumnNumber() {
        assertNotNull(testcoodinate1.getColumnNumber());
        assertNotNull(testcoodinate2.getColumnNumber());
        assertNotNull(stringCoordinate1.getColumnNumber());
        assertNotNull(stringCoordinate1.getColumnNumber());

        assertEquals(2,testcoodinate1.getColumnNumber());
        assertEquals(7,testcoodinate2.getColumnNumber());
        assertEquals(1,stringCoordinate1.getColumnNumber());
        assertEquals(4,stringCoordinate2.getColumnNumber());
    }

    /**
     * The Test is used to check the Getter method for the Row Number of the coordinate
     */
    @Test
    public void testGetRowNumber() {
        assertNotNull(testcoodinate1.getRowNumber());
        assertNotNull(testcoodinate2.getRowNumber());
        assertNotNull(stringCoordinate1.getRowNumber());
        assertNotNull(stringCoordinate1.getRowNumber());

        assertEquals(3,testcoodinate1.getRowNumber());
        assertEquals(2,testcoodinate2.getRowNumber());
        assertEquals(1,stringCoordinate1.getRowNumber());
        assertEquals(4,stringCoordinate2.getRowNumber());
    }

    /**
     * The method is used to compare two coordinate objects field by field
     */
    @Test
    public void testEquals(){
        assertTrue("Coordinate entry doesn't match",testcoodinate1.equals(new Coordinate(2,3)));
        assertFalse("Coordinate: C-2,R-3",testcoodinate1.equals(new Coordinate(3,3)));
        assertFalse("Coordinate entry not NULL",testcoodinate1.equals(null));
        assertFalse("The Object should not be Coordinate",testcoodinate1.equals(new Square(new Coordinate(2,3))));

        assertTrue("Coordinate entry doesn't match",testcoodinate2.equals(new Coordinate(7,2)));
        assertFalse("Coordinate entry not NULL",testcoodinate2.equals(null));
        assertFalse("Coordinate: C-7,R-2",testcoodinate2.equals(new Coordinate(3,3)));
        assertFalse("The Object should not be Coordinate",testcoodinate2.equals(new Square(new Coordinate(2,3))));

        assertTrue("Coordinate entry doesn't match",stringCoordinate1.equals(new Coordinate(1,1)));
        assertFalse("Coordinate entry not NULL",stringCoordinate1.equals(null));
        assertFalse("Coordinate: C-1,R-1",stringCoordinate1.equals(new Coordinate(2,3)));
        assertFalse("The Object should not be Coordinate",stringCoordinate1.equals(new Square(new Coordinate(2,3))));

        assertTrue("Coordinate entry doesn't match",stringCoordinate2.equals(new Coordinate(4,4)));
        assertFalse("Coordinate entry not NULL",stringCoordinate2.equals(null));
        assertFalse("Coordinate: C-4,R-4",stringCoordinate2.equals(new Coordinate(3,1)));
        assertFalse("The Object should not be Coordinate",stringCoordinate2.equals(new Square(new Coordinate(2,3))));
    }

    /**
     * The Test is used to check the String output of the coordinte
     */
    @Test
    public void testToString() {
        assertNotNull(testcoodinate1.toString());
        assertNotNull(testcoodinate2.toString());
        assertNotNull(stringCoordinate1.toString());
        assertNotNull(stringCoordinate1.toString());

        assertEquals("Coordinate String Format not Correct","(2,3)",testcoodinate1.toString());
        assertNotEquals("Output: (2,3)","2,3",testcoodinate1.toString());

        assertEquals("Coordinate String Format not Correct","(7,2)",testcoodinate2.toString());
        assertNotEquals("Output: (7,2)","2,0",testcoodinate2.toString());

        assertEquals("Coordinate String Format not Correct","(1,1)", stringCoordinate1.toString());
        assertNotEquals("Output: (1,1)","1,1",stringCoordinate1.toString());

        assertEquals("Coordinate String Format not Correct","(4,4)",stringCoordinate2.toString());

    }

}