package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for Walnut (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 3.0
 */

public class WalnutTest {

    /**
     * The Walnut Piece Object that is analysed
     */
    private Piece wallNut;

    /**
     * Used to initialise and establish the Walnut Object that is used for the tests
     */
    @Before
    public void setUp() {
        wallNut = new Walnut();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (Walnut)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is WALNUT", wallNut.getName());
        assertNotEquals("The Game Piece is WALNUT all Capitalised","Walnut", wallNut.getName());
        assertEquals("The Game Piece is WALNUT","WALNUT", wallNut.getName());
        assertNotEquals("The Game Piece is WALNUT","APA", wallNut.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is W",' ', wallNut.getShortName());
        assertEquals("The Game Piece Short Name is W",'W', wallNut.getShortName());
        assertNotEquals("The Game Piece Short Name is W","WS", wallNut.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 30",30, wallNut.getHealth());
        assertNotEquals("The Game Piece Health is 30","^30", wallNut.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 0","0", wallNut.getAttack());
        assertNotEquals("The Game Piece Attack Power is 0","001", wallNut.getHealth());
        assertEquals("The Game Piece Attack Power is 0",0, wallNut.getAttack());
    }

    /**
     * The Test is used to check the Specified Walnut Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece Walnut Cost is 50","$50", wallNut.getCost());
        assertEquals("The Game Piece Walnut Cost is 50",50, wallNut.getCost());
        assertNotEquals("The Game Piece Walnut Cost is 50",'W', wallNut.getCost());
    }
}