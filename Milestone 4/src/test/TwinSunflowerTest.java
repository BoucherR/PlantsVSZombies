package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for TWINSUNFLOWER (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 4.0
 */

public class TwinSunflowerTest {

    /**
     * The TwinSunFlower Piece Object that is analysed
     */
    private Piece twinsunFlower;

    /**
     * Used to initialise and establish the TwinSunFlower Object that is used for the tests
     */
    @Before
    public void setUp() {
        twinsunFlower = new TwinSunflower();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (TwinSunFlower)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is TWINSUNFLOWER", twinsunFlower.getName());
        assertNotEquals("The Game Piece is TWINSUNFLOWER all Capitalised","TwinSunFlower", twinsunFlower.getName());
        assertEquals("The Game Piece is TWINSUNFLOWER","TWINSUNFLOWER", twinsunFlower.getName());
        assertNotEquals("The Game Piece is TWINSUNFLOWER","APA", twinsunFlower.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is 2",' ', twinsunFlower.getShortName());
        assertEquals("The Game Piece Short Name is 2",'2', twinsunFlower.getShortName());
        assertNotEquals("The Game Piece Short Name is 2","2S", twinsunFlower.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 10",10, twinsunFlower.getHealth());
        assertNotEquals("The Game Piece Health is 10","^10", twinsunFlower.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 0","0", twinsunFlower.getAttack());
        assertNotEquals("The Game Piece Attack Power is 0","001", twinsunFlower.getHealth());
        assertEquals("The Game Piece Attack Power is 0",0, twinsunFlower.getAttack());
    }

    /**
     * The Test is used to check the Specified SunFlower Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece TwinSunflower Cost is 30","$10", twinsunFlower.getCost());
        assertEquals("The Game Piece TwinSunflower Cost is 30",30, twinsunFlower.getCost());
        assertNotEquals("The Game Piece TwinSunflower Cost is 30",'2', twinsunFlower.getCost());
    }
}