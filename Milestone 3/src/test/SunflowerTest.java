package Test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for SUNFLOWER (Piece SubClass)
 * @author Muneeb Nasir
 * @version 3.0
 */

public class SunflowerTest {

    /**
     * The SunFlower Piece Object that is analysed
     */
    private Piece sunFlower;

    /**
     * Used to initialise and establish the SunFlower Object that is used for the tests
     */
    @Before
    public void setUp() {
        sunFlower = new Sunflower();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (SunFlower)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is SUNFLOWER",sunFlower.getName());
        assertNotEquals("The Game Piece is SUNFLOWER all Capitalised","SunFlower",sunFlower.getName());
        assertEquals("The Game Piece is SUNFLOWER","SUNFLOWER",sunFlower.getName());
        assertNotEquals("The Game Piece is SUNFLOWER","SFA",sunFlower.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is S",' ',sunFlower.getShortName());
        assertEquals("The Game Piece Short Name is S",'S',sunFlower.getShortName());
        assertNotEquals("The Game Piece Short Name is S","SSS",sunFlower.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 5",5,sunFlower.getHealth());
        assertNotEquals("The Game Piece Health is 5","^5",sunFlower.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 0","0",sunFlower.getAttack());
        assertNotEquals("The Game Piece Attack Power is 0","001",sunFlower.getHealth());
        assertEquals("The Game Piece Attack Power is 0",0,sunFlower.getAttack());
    }

    /**
     * The Test is used to check the Specified SunFlower Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece Zombie Cost is 10","$10",sunFlower.getCost());
        assertEquals("The Game Piece Zombie Cost is 10",10,sunFlower.getCost());
        assertNotEquals("The Game Piece Zombie Cost is 10",'2',sunFlower.getCost());
    }
}