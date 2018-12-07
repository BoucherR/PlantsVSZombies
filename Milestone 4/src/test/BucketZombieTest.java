package test;
import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for BucketZombie (Piece SubClass)
 * @author Ryan Gaudreault
 * @version 4.0
 */

public class BucketZombieTest {

    /**
     * The BucketZombie Piece Object that is analysed
     */
    private Piece bucketZombie;

    /**
     * Used to initialise and establish the BucketZombie Object that is used for the tests
     */
    @Before
    public void setUp() {
        bucketZombie = new BucketZombie();
    }

    /**
     * The Test is used to check the Name of the SubClass of Piece (BucketZombie)
     */
    @Test
    public void testGetName(){
        assertNotNull("The Game Piece is BUCKETZOMBIE", bucketZombie.getName());
        assertNotEquals("The Game Piece is BUCKETZOMBIE all Capitalised","BucketZombie", bucketZombie.getName());
        assertEquals("The Game Piece is BUCKETZOMBIE","BUCKETZOMBIE", bucketZombie.getName());
        assertNotEquals("The Game Piece is BUCKETZOMBIE","APA", bucketZombie.getName());
    }

    /**
     * The Test is used to check the DEFINED SHORT Name of the SubClass of Piece
     */
    @Test
    public void testGetShortName(){
        assertNotEquals("The Game Piece Short Name is B",' ', bucketZombie.getShortName());
        assertEquals("The Game Piece Short Name is B",'B', bucketZombie.getShortName());
        assertNotEquals("The Game Piece Short Name is B","B", bucketZombie.getShortName());
    }

    /**
     * The Test is used to check the Game Piece Health value
     */
    @Test
    public void testGetHealth(){
        assertEquals("The Game Piece Health is 25",25, bucketZombie.getHealth());
        assertNotEquals("The Game Piece Health is 25","^25", bucketZombie.getHealth());
    }

    /**
     * The Test is used to check the Given Attack Power of the Game Piece
     */
    @Test
    public void testGetAttack(){
        assertNotEquals("The Game Piece Attack Power is 10","10", bucketZombie.getAttack());
        assertNotEquals("The Game Piece Attack Power is 10","10", bucketZombie.getHealth());
        assertEquals("The Game Piece Attack Power is 10",10, bucketZombie.getAttack());
    }

    /**
     * The Test is used to check the Specified BucketZombie Piece Cost
     */
    @Test
    public void testGetCost(){
        assertNotEquals("The Game Piece BucketZombie Cost is 0","$0", bucketZombie.getCost());
        assertEquals("The Game Piece BucketZombie Cost is 0",0, bucketZombie.getCost());
        assertNotEquals("The Game Piece BucketZombie Cost is 0",'B', bucketZombie.getCost());
    }
}