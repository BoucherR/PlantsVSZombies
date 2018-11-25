package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for ConeheadZombie (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 3.0
 */

public class ConeheadZombieTest {

    /**
     * The ConeheadZombie Piece Object that is analysed
     */
    private Piece coneheadZombie;

    /**
     * Used to initialise and establish the ConeheadZombie Object that is used for the tests
     */
    @Before
    public void setUp() {
        coneheadZombie = new ConeheadZombie();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (ConeheadZombie)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is CONEHEADZOMBIE", coneheadZombie.getName());
        assertNotEquals("The Game Piece is CONEHEADZOMBIE all Capitalised","coneheadZombie", coneheadZombie.getName());
        assertEquals("The Game Piece is CONEHEADZOMBIE","CONEHEADZOMBIE", coneheadZombie.getName());
        assertNotEquals("The Game Piece is CONEHEADZOMBIE","APA", coneheadZombie.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is C",' ', coneheadZombie.getShortName());
        assertEquals("The Game Piece Short Name is C",'C', coneheadZombie.getShortName());
        assertNotEquals("The Game Piece Short Name is C","WS", coneheadZombie.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 15",15, coneheadZombie.getHealth());
        assertNotEquals("The Game Piece Health is 10","^10", coneheadZombie.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 4","4", coneheadZombie.getAttack());
        assertNotEquals("The Game Piece Attack Power is 4","001", coneheadZombie.getAttack());
        assertEquals("The Game Piece Attack Power is 4",4, coneheadZombie.getAttack());
    }

    /**
     * The Test is used to check the Specified ConeheadZombie Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece ConeheadZombie Cost is 0","$0", coneheadZombie.getCost());
        assertEquals("The Game Piece ConeHeadZombie Cost is 0",0, coneheadZombie.getCost());
        assertNotEquals("The Game Piece ConeHeadZombie Cost is 0",'C', coneheadZombie.getCost());
    }
}