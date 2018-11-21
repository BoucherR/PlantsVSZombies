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
     * The method is used to establish the Square Object that is to be used in the test cases
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
        assertEquals("The column number is 2",2,testcoodinate1.getColumnNumber());
        assertEquals("The column number is 7",7,testcoodinate2.getColumnNumber());
        assertNotEquals("The column number is 2 INTEGER","2",testcoodinate1.getColumnNumber());
        assertNotEquals("The column number is 7 INTEGER",'7',testcoodinate2.getColumnNumber());

        assertEquals("The ROW number is 3",3,testcoodinate1.getRowNumber());
        assertEquals("The ROW number is 2",2,testcoodinate2.getRowNumber());
        assertNotEquals("The ROW number is 3 INTEGER","3",testcoodinate1.getRowNumber());
        assertNotEquals("The ROW number is 2 INTEGER",'2',testcoodinate2.getRowNumber());
    }
    /**
     * The Test is used to check the constructor that accepts the row ans column values as a string
     */
    @Test
    public void testConstructor(){
        assertEquals("The column number is 1",1,stringCoordinate1.getColumnNumber());
        assertEquals("The column number is 4",4,stringCoordinate2.getColumnNumber());
        assertNotEquals("The column number is 1 INTEGER","1",stringCoordinate1.getColumnNumber());
        assertNotEquals("The column number is 4 INTEGER",'4',stringCoordinate2.getColumnNumber());

        assertEquals("The column number is 1",1,stringCoordinate1.getRowNumber());
        assertEquals("The column number is 4",4,stringCoordinate2.getRowNumber());
        assertNotEquals("The column number is 2 INTEGER","2",stringCoordinate1.getRowNumber());
        assertNotEquals("The column number is 7 INTEGER",'7',stringCoordinate2.getRowNumber());

        assertNotNull("The column number is 2 INTEGER",stringCoordinate1);
        assertNotNull("The column number is 7 INTEGER",stringCoordinate2);
    }

    /**
     * The Test is used to check the Getter method for the Column Number of the coordinate
     */
    @Test
    public void testGetColumnNumber() {
        assertNotEquals("The Column No: 2",-1,testcoodinate1.getColumnNumber());
        assertNotEquals("The Column No: 7",-1,testcoodinate2.getColumnNumber());
        assertNotEquals("The Column No: 1",-1,stringCoordinate1.getColumnNumber());
        assertNotEquals("The Column No: 4",-1,stringCoordinate1.getColumnNumber());

        assertEquals("The Column No: 2",2,testcoodinate1.getColumnNumber());
        assertEquals("The Column No: 7",7,testcoodinate2.getColumnNumber());
        assertEquals("The Column No: 1",1,stringCoordinate1.getColumnNumber());
        assertEquals("The Column No: 4",4,stringCoordinate2.getColumnNumber());

        //Testing with Bogus Values
        assertNotEquals("Column Entry should not match",Character.getNumericValue('5'),testcoodinate1.getColumnNumber());
        assertNotEquals("Column Entry should not match",String.valueOf("7"),testcoodinate2.getColumnNumber());
        assertNotEquals("Column Entry should not match",String.valueOf("1"),stringCoordinate1.getColumnNumber());
        assertNotEquals("Column Entry should not match",Character.getNumericValue('7'),stringCoordinate2.getColumnNumber());
    }

    /**
     * The Test is used to check the Getter method for the Row Number of the coordinate
     */
    @Test
    public void testGetRowNumber() {
        assertNotEquals("The Row No: 3",-1,testcoodinate1.getRowNumber());
        assertNotEquals("The Row No: 2",-1,testcoodinate2.getRowNumber());
        assertNotEquals("The Row No: 1",-2,stringCoordinate1.getRowNumber());
        assertNotEquals("The Row No: 4",-2,stringCoordinate1.getRowNumber());

        assertEquals("The Row No: 3",3,testcoodinate1.getRowNumber());
        assertEquals("The Row No: 2",2,testcoodinate2.getRowNumber());
        assertEquals("The Row No: 1",1,stringCoordinate1.getRowNumber());
        assertEquals("The Row No: 4",4,stringCoordinate2.getRowNumber());

        assertNotEquals("Column Entry should not match Type",3.0001, testcoodinate1.getRowNumber());
        assertNotEquals("Column Entry should not match",Integer.toString(2), testcoodinate2.getRowNumber());
        assertNotEquals("Column Entry should not match",'1', stringCoordinate1.getRowNumber());
        assertNotEquals("Column Entry should not match",4.00, stringCoordinate2.getRowNumber());
    }

    /**
     * The method is used to compare two coordinate objects field by field
     */
    @Test
    public void testEquals(){
        assertTrue("Coordinate entry doesn't match",testcoodinate1.equals(new Coordinate(2,3)));
        assertNotEquals("Coordinate: C-2,R-3",true,testcoodinate1.equals(new Coordinate(3,3)));
        assertNotEquals("Coordinate entry not NULL", null, testcoodinate1);
        assertNotEquals("The Object should not be Coordinate",true, new Coordinate(0, 3).equals(testcoodinate1));

        assertTrue("Coordinate entry doesn't match",testcoodinate2.equals(new Coordinate(7,2)));
        assertNotEquals("Coordinate entry not NULL", null, testcoodinate2);
        assertNotEquals("Coordinate: C-7,R-2",true,testcoodinate2.equals(new Coordinate(3,3)));
        assertNotEquals("The Object should not be Coordinate",true,new Coordinate(2,3).equals(testcoodinate2));

        assertTrue("Coordinate entry doesn't match",stringCoordinate1.equals(new Coordinate(1,1)));
        assertNotEquals("Coordinate entry not NULL", null, stringCoordinate1);
        assertNotEquals("Coordinate: C-1,R-1",true,stringCoordinate1.equals(new Coordinate(2,3)));
        assertNotEquals("The Object should not be Coordinate",true,new Coordinate(2,3).equals(stringCoordinate1));

        assertTrue("Coordinate entry doesn't match",stringCoordinate2.equals(new Coordinate(4,4)));
        assertNotEquals("Coordinate entry not NULL", null, stringCoordinate2);
        assertNotEquals("Coordinate: C-4,R-4",true,stringCoordinate2.equals(new Coordinate(3,1)));
        assertNotEquals("The Object should not be Coordinate",true,new Coordinate(2,3).equals(stringCoordinate2));
    }

    /**
     * The Test is used to check the String output of the coordinte
     */
    @Test
    public void testToString() {
        assertNotNull("Output: (2,3)",testcoodinate1.toString());
        assertNotNull("Output: (7,2)",testcoodinate2.toString());
        assertNotNull("Output: (1,1)",stringCoordinate1.toString());
        assertNotNull("Output: (4,4)",stringCoordinate1.toString());

        assertEquals("Coordinate String Format not Correct","(2,3)",testcoodinate1.toString());
        assertNotEquals("Output: (2,3)","2,3",testcoodinate1.toString());

        assertEquals("Coordinate String Format not Correct","(7,2)",testcoodinate2.toString());
        assertNotEquals("Output: (7,2)","2,0",testcoodinate2.toString());
        assertNotEquals("Output: (7,2)","0",testcoodinate2.toString());

        assertEquals("Coordinate String Format not Correct","(1,1)", stringCoordinate1.toString());
        assertNotEquals("Output: (1,1)","1,1",stringCoordinate1.toString());
        assertNotEquals("Output: (1,1)",'1',stringCoordinate1.toString());

        assertEquals("Coordinate String Format not Correct","(4,4)",stringCoordinate2.toString());

    }
}