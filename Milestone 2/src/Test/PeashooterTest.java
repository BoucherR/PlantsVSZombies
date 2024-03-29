package Test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for the PEASHOOTER (Piece SubClass)
 * @author Muneeb Nasir
 * @version 2.0
 */

public class PeashooterTest {

    /**
     * The PeaShooter Piece Object that is analysed
     */
    private Piece peaShooter;

    /**
     * Used to initialise and establish the PeaShooter Object that is used for the tests
     */
    @Before
    public void setUp() {
        peaShooter = new Peashooter();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (PeaShooter)
     */
    @Test
    public void testGetName(){
        assertNotNull(peaShooter.getName());
        assertNotEquals("The Game Piece is PEASHOOTER all Capitalised","PeaShooter",peaShooter.getName());
        assertEquals("The Game Piece is PEASHOOTER","PEASHOOTER",peaShooter.getName());
        assertNotEquals("The Game Piece is PEASHOOTER","PS",peaShooter.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is P",' ',peaShooter.getShortName());
        assertNotEquals("The Game Piece Short Name is P","P1",peaShooter.getShortName());
        assertEquals("The Game Piece Short Name is P",'P',peaShooter.getShortName());

    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertNotEquals("The Game Piece Health is 5",'5',peaShooter.getHealth());
        assertEquals("The Game Piece Health is 5",5,peaShooter.getHealth());
        assertNotEquals("The Game Piece Health is 5","55",peaShooter.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 2",0,peaShooter.getAttack());
        assertNotEquals("The Game Piece Attack Power is 2",-2,peaShooter.getAttack());
        assertEquals("The Game Piece Attack Power is 2",2,peaShooter.getAttack());
    }

    /**
     * The Test is used to check the Specified PeaShooter Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece PeaShooter Cost is 20","20",peaShooter.getCost());
        assertNotEquals("The Game Piece PeaShooter Cost is 20","$$",peaShooter.getCost());
        assertNotEquals("The Game Piece PeaShooter Cost is 20",10,peaShooter.getCost());
        assertEquals("The Game Piece PeaShooter Cost is 20",20,peaShooter.getCost());
    }
}