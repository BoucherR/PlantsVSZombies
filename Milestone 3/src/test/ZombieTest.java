package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for ZOMBIE (Piece SubClass)
 * @author Muneeb Nasir
 * @version 3.0
 */

public class ZombieTest {

    /**
     * The Zombie Object that is analysed
     */
    private Piece zombie;

    /**
     * Used to initialise and establish the Zombie Object that is used for the tests
     */
    @Before
    public void setUp() {
        zombie = new Zombie();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (Zombie)
     */
    @Test
    public void testGetName(){
        assertNotNull(zombie.getName());
        assertNotEquals("The Game Piece is ZOMBIE all Capitalised","Zombie",zombie.getName());
        assertEquals("The Game Piece is ZOMBIE","ZOMBIE",zombie.getName());
        assertNotEquals("The Game Piece is ZOMBIE","ZBI",zombie.getName());
        assertNotEquals("The Game Piece is ZOMBIE",'I',zombie.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is Z",' ',zombie.getShortName());
        assertEquals("The Game Piece Short Name is Z",'Z',zombie.getShortName());
        assertNotEquals("The Game Piece is Short Name is Z",'I',zombie.getShortName());
        assertNotEquals("The Game Piece is Short Name is Z",123,zombie.getShortName());
    }

    /**
     * The Test is used to check the Specified Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 5",5,zombie.getHealth());
        assertNotEquals("The Game Piece Health is 5","%5",zombie.getHealth());
        assertNotEquals("The Game Piece Health is 5","05",zombie.getHealth());
    }

    /**
     * The Test is used to check the Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 2",-1,zombie.getAttack());
        assertEquals("The Game Piece Attack Power is 2",2,zombie.getAttack());
    }

    /**
     * The Test is used to check the Specified Zombie Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece Zombie Cost is 0",-3,zombie.getCost());
        assertNotEquals("The Game Piece Zombie Cost is 0","$0",zombie.getCost());
        assertEquals("The Game Piece Zombie Cost is 0",0,zombie.getCost());
    }
}