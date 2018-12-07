package test;

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for the Game Levels
 * @author Muneeb Nasir
 * @version 4.0
 */
public class GameLevelsTest {

    /**
     * The Class Objects used for testing
     */
    private GameLevels testLevel1;
    private GameLevels testLevel2;

    /**
     * The Method used to establish the class objects for testing
     */
    @Before
    public void setUp(){
        testLevel1 = new GameLevels(1,5,500,5);
        testLevel2 = new GameLevels(1,5,500,5);
    }

    /**
     * Test for the Default class constructor
     */
    @Test
    public void testGameLevel(){
        assertNotNull("The Game Levels established",testLevel1);
        assertNotNull("The Game Levels established",testLevel2);

        assertEquals("The SunMoney is initiaised at 500",500,testLevel2.getMoney());
        assertNotEquals("The SunMoney is initiaised at 500",200,testLevel1.getMoney());

        assertNotEquals("There is max Level of 5",0,testLevel1.getLevel());
        assertNotEquals("The current zombies are 5",0,testLevel1.getCurrentZombies());
    }

    /**
     * Test for the restart method for the Game Levels
     */
    @Test
    public void testRestartLevels(){
        testLevel2.setLevel(4);
        testLevel1.setLevel(8);

        testLevel1.restartLevels();
        assertNotEquals("The current Level of 5",8,testLevel1.getLevel());
        assertEquals("There is are total of 5 zombies",5,testLevel1.getCurrentZombies());
        assertEquals("The SunMoney 500",500,testLevel1.getMoney());

        testLevel2.restartLevels();
        assertNotEquals("The current Level is 5",4,testLevel2.getLevel());
        assertEquals("There is are total of 5 zombies",5,testLevel2.getCurrentZombies());
        assertEquals("The SunMoney 500",500,testLevel2.getMoney());
    }

    /**
     * Test for the Setter Method for the players money
     */
    @Test
    public void testSetSunMoney(){
        testLevel1.setSunMoney(900);
        testLevel2.setSunMoney(300);

        assertEquals("The Money is set at 900",900,testLevel1.getMoney());
        assertNotEquals("The Money is set at 900",500,testLevel1.getMoney());

        assertEquals("The Money is set at 300",300,testLevel2.getMoney());
        assertNotEquals("The Money is changed to 300",500,testLevel2.getMoney());
    }

    /**
     * Test for the Getter Method for the players money
     */
    @Test
    public void testGetMoney(){
        assertEquals("The Money account is set at 500",500,testLevel1.getMoney());
        assertNotEquals("The Money account is set at 500",0,testLevel1.getMoney());

        assertEquals("The Money is set at 500",500,testLevel2.getMoney());
        assertNotEquals("The Default Money is changed to 500",100,testLevel2.getMoney());
    }

    /**
     * Test for the Getter Method for the current number of zombies in the level
     */
    @Test
    public void testGetCurrentZombies(){
        assertEquals("The current zombie count is 5",5,testLevel1.getCurrentZombies());
        assertNotEquals("The current zombie count is 5",0,testLevel1.getCurrentZombies());

        assertEquals("The current zombie count is 5",5,testLevel2.getCurrentZombies());
        assertNotEquals("The current zombie count is 5",-1,testLevel2.getCurrentZombies());
    }

    /**
     * Test for the Getter Method for Game Levels
     */
    @Test
    public void testGetLevel(){
        assertEquals("The current Level is 1",1,testLevel1.getLevel());
        assertNotEquals("The current level is 1",5,testLevel1.getLevel());

        assertNotEquals("The current level is 1",'1',testLevel2.getLevel());
        assertNotEquals("The game level not played",0,testLevel2.getLevel());
    }

    /**
     * Test for the accounting the money earned by the user
     */
    @Test
    public void testEarnedMoney(){
        testLevel1.earnedMoney(100);
        testLevel2.earnedMoney(20);

        assertEquals("The player has earned money is 100",600,testLevel1.getMoney());
        assertNotEquals("The player has earned money is 100","100",testLevel1.getMoney());

        assertEquals("The player has earned money is 20",520,testLevel2.getMoney());
        assertNotEquals("The player has earned money is 100",400,testLevel2.getMoney());
    }

    /**
     * Test for the method to control the purchase of game pieces
     */
    @Test
    public void testBuyPiece(){
        Piece testPiece = new Peashooter();
        testLevel1.buyPiece(testPiece.getCost());
        assertNotEquals("A Piece is bought by the player",500,testLevel1.getMoney());
        assertEquals("The Piece cost is adjusted with the Total Player Account",480,testLevel1.getMoney());

        assertEquals("Nothing is bought by the user",500,testLevel2.getMoney());
    }

    /**
     * Test for the checking the method that decrements the current zombie count
     */
    @Test
    public void testZombieKilled(){
        testLevel1.zombieKilled();
        assertEquals("The current zombies count decreased",4,testLevel1.getCurrentZombies());
        assertNotEquals("The current zombies count decreased only by 1",2,testLevel1.getCurrentZombies());
        testLevel2.zombieKilled();
        testLevel2.zombieKilled();
        assertEquals("The current zombies count decreased",3,testLevel2.getCurrentZombies());
        assertNotEquals("The current zombies count decreased only by 2",'4',testLevel2.getCurrentZombies());
    }

    /**
     * Test for the compare method that checks the number of zombies with the max. Game Level Limit
     */
    @Test
    public void testCheckLimit(){
        assertFalse("The Limit doesn't match",testLevel1.checkLimit(Integer.valueOf("10")));
        assertTrue("The Limit doesn't match",testLevel1.checkLimit(5));
        assertFalse("The Limit doesn't match",testLevel2.checkLimit(Integer.valueOf("-5")));
        assertFalse("The Limit doesn't match",testLevel2.checkLimit("5".charAt(0)));
    }

    /**
     * Test for the checker method for the Maximum Level
     */
    @Test
    public void testMaxLevel(){
        assertFalse("Current Level is not Maximum Level",testLevel1.maxLevel());
        testLevel1.setLevel(5);
        assertFalse("The current Level has been changed but not exceed Maximum Level",testLevel1.maxLevel());
        assertFalse("The current Level has not been changed",testLevel2.maxLevel());
        testLevel2.setLevel(6);
        assertTrue("The current Level has been changed to exceed Maximum Level",testLevel2.maxLevel());
    }

    /**
     * Test for the Setter Method for the current Game Level
     */
    @Test
    public void testSetLevel(){
        testLevel1.setLevel(2);
        assertNotEquals("The Current Level is not 5",5,testLevel1.getLevel());
        assertEquals("The Current Level is 2",2,testLevel1.getLevel());
        testLevel2.setLevel(8);
        assertNotEquals("The Current Level is not default of 5",5,testLevel2.getLevel());
        assertEquals("The Current Level is 8",8,testLevel2.getLevel());
    }

    /**
     * Test for the Setter Method for the Maximum Game Level
     */
    @Test
    public void testSetMaxLevel(){
        testLevel1.setMaxLevel(10);
        testLevel1.setLevel(10);
        assertEquals("The Current Level is changed to Maximum Level",10,testLevel1.getLevel());
        assertNotEquals("The Current Level is changed to Maximum Level",'0',testLevel1.getLevel());
        assertNotEquals("The Current Level is changed to Maximum Level","10",testLevel1.getLevel());
    }

    /**
     * Test for the Method is used to check the Save and Load Functionality of the Game Levels
     */
    @Test
    public void testLoadLevels(){
        testLevel1.saveLevels();
        GameLevels testLoad = testLevel1.loadLevels();
        assertNotNull(testLoad);
        assertEquals("The Data is loaded successfully",testLevel1.loadLevels().toString(),testLoad.toString());
        assertEquals("The Game Money Loaded as saved",500,testLoad.getMoney());
        assertNotEquals("The Current Zombies are 5",0,testLoad.getCurrentZombies());
    }

    /**
     * Test for the Method is check the Setter Method for the Current Number Zombies
     */
    @Test
    public void testSetCurrentZombies(){
        testLevel1.setCurrentZombies(10);
        testLevel2.setCurrentZombies(8);
        assertNotEquals("The current zombie count was changed",5,testLevel1.getCurrentZombies());
        assertEquals("The current zombie count was changed",10,testLevel1.getCurrentZombies());

        assertEquals("The current zombie count was changed",8,testLevel2.getCurrentZombies());
        assertNotEquals("The current zombie count was changed",'8',testLevel2.getCurrentZombies());
    }

    /**
     * Test for the Method is check the current number of the zombies that are alive
     */
    @Test
    public void testCheckAllZombiesDead(){
        testLevel1.setCurrentZombies(0);
        assertTrue("The Zombies have been killed",testLevel1.checkAllZombiesDead());
        testLevel1.setCurrentZombies(1);
        assertFalse("Not all Zombies have been killed",testLevel1.checkAllZombiesDead());
        testLevel2.setCurrentZombies(0);
        assertTrue("The Zombies have been killed",testLevel2.checkAllZombiesDead());
    }

    /**
     * Test for the Getter Method for the number of zombies that were spawned
     */
    @Test
    public void testGetZombiesSpawned(){
        assertNotEquals("The current zombie spawn count is default","0",testLevel1.getCurrentZombies());
        assertEquals("The current zombie count not changed",0,testLevel1.getZombiesSpawned());

        assertEquals("The current zombie spawn not changed for level 2",0,testLevel2.getZombiesSpawned());
        testLevel2.setZombiesSpawned(10);
        assertEquals("The current zombie count was changed",10,testLevel2.getZombiesSpawned());

    }

    /**
     * Test for the Setter Method for the number of zombies that were spawned
     */
    @Test
    public void testSetZombiesSpawned(){
        testLevel1.setZombiesSpawned(10);
        testLevel2.setZombiesSpawned(5);
        assertNotEquals("The current zombie spawn count was changed","0",testLevel1.getZombiesSpawned());
        assertEquals("The current zombie count was changed",10,testLevel1.getZombiesSpawned());

        assertEquals("The current zombie spawn count was changed",5,testLevel2.getZombiesSpawned());
        assertNotEquals("The current zombie count was changed",0,testLevel2.getZombiesSpawned());

    }

}