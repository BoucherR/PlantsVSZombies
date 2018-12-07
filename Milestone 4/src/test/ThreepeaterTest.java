package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for Threepeater (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 4.0
 */

public class ThreepeaterTest {

    /**
     * The Threepeater Piece Object that is analysed
     */
    private Piece threepeater;

    /**
     * Used to initialise and establish the Threepeater Object that is used for the tests
     */
    @Before
    public void setUp() {
        threepeater = new Threepeater();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (Threepeater)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is THREEPEATER", threepeater.getName());
        assertNotEquals("The Game Piece is THREEPEATER all Capitalised","Threepeater", threepeater.getName());
        assertEquals("The Game Piece is THREEPEATER","THREEPEATER", threepeater.getName());
        assertNotEquals("The Game Piece is THREEPEATER","APA", threepeater.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is T",' ', threepeater.getShortName());
        assertEquals("The Game Piece Short Name is T",'T', threepeater.getShortName());
        assertNotEquals("The Game Piece Short Name is T","TS", threepeater.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 10",10, threepeater.getHealth());
        assertNotEquals("The Game Piece Health is 10","^10", threepeater.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 6","6", threepeater.getAttack());
        assertNotEquals("The Game Piece Attack Power is 6","661", threepeater.getHealth());
        assertEquals("The Game Piece Attack Power is 6",6, threepeater.getAttack());
    }

    /**
     * The Test is used to check the Specified Threepeater Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece Threepeater Cost is 60","$60", threepeater.getCost());
        assertEquals("The Game Piece Threepeater Cost is 60",60, threepeater.getCost());
        assertNotEquals("The Game Piece Threepeater Cost is 60",'W', threepeater.getCost());
    }
}