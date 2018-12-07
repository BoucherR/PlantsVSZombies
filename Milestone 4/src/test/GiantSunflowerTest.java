package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for GiantSunflower (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 4.0
 */

public class GiantSunflowerTest {

    /**
     * The GiantSunflower Piece Object that is analysed
     */
    private Piece giantsunflower;

    /**
     * Used to initialise and establish the GiantSunflower Object that is used for the tests
     */
    @Before
    public void setUp() {
        giantsunflower = new GiantSunflower();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (GiantSunflower)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is GIANTSUNFLOWER", giantsunflower.getName());
        assertNotEquals("The Game Piece is GIANTSUNFLOWER all Capitalised","giantsunflower", giantsunflower.getName());
        assertEquals("The Game Piece is GIANTSUNFLOWER","GIANTSUNFLOWER", giantsunflower.getName());
        assertNotEquals("The Game Piece is GIANTSUNFLOWER","APA", giantsunflower.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is G",' ', giantsunflower.getShortName());
        assertEquals("The Game Piece Short Name is G",'G', giantsunflower.getShortName());
        assertNotEquals("The Game Piece Short Name is G","WS", giantsunflower.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 15",15, giantsunflower.getHealth());
        assertNotEquals("The Game Piece Health is 15","^15", giantsunflower.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 0","0", giantsunflower.getAttack());
        assertNotEquals("The Game Piece Attack Power is 0","001", giantsunflower.getHealth());
        assertEquals("The Game Piece Attack Power is 0",0, giantsunflower.getAttack());
    }

    /**
     * The Test is used to check the Specified Giantsunflower Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece GiantSunflower Cost is 60","$60", giantsunflower.getCost());
        assertEquals("The Game Piece GiantSunflower Cost is 60",60, giantsunflower.getCost());
        assertNotEquals("The Game Piece GiantSunflower Cost is 60",'G', giantsunflower.getCost());
    }
}