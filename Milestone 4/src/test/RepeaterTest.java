package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for the REPEATER (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 4.0
 */

public class RepeaterTest {

    /**
     * The Repeater Piece Object that is analysed
     */
    private Piece repeater;

    /**
     * Used to initialise and establish the Repeater Object that is used for the tests
     */
    @Before
    public void setUp() {
        repeater = new Repeater();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (Repeater)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is REPEATER", repeater.getName());
        assertNotEquals("The Game Piece is REPEATER all Capitalised","Repeater", repeater.getName());
        assertEquals("The Game Piece is REPEATER","REPEATER", repeater.getName());
        assertNotEquals("The Game Piece is REPEATER","APA", repeater.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is R",' ', repeater.getShortName());
        assertEquals("The Game Piece Short Name is R",'R', repeater.getShortName());
        assertNotEquals("The Game Piece Short Name is R","TS", repeater.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 5",5, repeater.getHealth());
        assertNotEquals("The Game Piece Health is 5","^5", repeater.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 4","4", repeater.getAttack());
        assertNotEquals("The Game Piece Attack Power is 4","661", repeater.getHealth());
        assertEquals("The Game Piece Attack Power is 4",4, repeater.getAttack());
    }

    /**
     * The Test is used to check the Specified Repeater Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece Repeater Cost is 40","$40", repeater.getCost());
        assertEquals("The Game Piece Repeater Cost is 40",40, repeater.getCost());
        assertNotEquals("The Game Piece Repeater Cost is 40",'W', repeater.getCost());
    }
}
