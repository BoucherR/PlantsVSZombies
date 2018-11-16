package Test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for ZOMBIE (Piece SubClass)
 * @author Muneeb Nasir
 * @version 2.0
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
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotNull(zombie.getShortName());
        assertEquals("The Game Piece Short Name is Z",'Z',zombie.getShortName());

    }

    /**
     * The Test is used to check the Specified Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertNotNull(zombie.getHealth());
        assertEquals("The Game Piece Health is 5",5,zombie.getHealth());
    }

    /**
     * The Test is used to check the Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotNull(zombie.getAttack());
        assertEquals("The Game Piece Attack Power is 2",2,zombie.getAttack());
    }

    /**
     * The Test is used to check the Specified Zombie Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotNull(zombie.getCost());
        assertEquals("The Game Piece Zombie Cost is 0",0,zombie.getCost());
    }
}