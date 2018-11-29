package test;

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The Test Class for the Game Levels
 * @author Muneeb Nasir
 * @version
 */
public class GameLevelsTest {

    private GameLevels testLevel1;
    private GameLevels testLevel2;

    @Before
    public void setUp() throws Exception {
        testLevel1 = new GameLevels();
        testLevel2 = new GameLevels();
    }

    @Test
    public void testGameLevel(){
        assertNotNull(testLevel1);

    }

    @Test
    public void testRestartLevels(){

    }

    @Test
    public void testSetSunMoney(){

    }

    @Test
    public void testGetMoney(){

    }

    @Test
    public void testGetCurrentZombies(){

    }

    @Test
    public void testGetLevel(){

    }

    @Test
    public void testEarnedMoney(){

    }

    @Test
    public void testNextLevel(){

    }

    @Test
    public void testBuyPiece(){

    }

    @Test
    public void testZombieKilled(){

    }

    @Test
    public void testCheckAllZombiesDead(){

    }

    @Test
    public void testCheckLimit(){

    }

    @Test
    public void testSetCurrentZombies(){

    }

    @Test
    public void testMaxLevel(){

    }

    @Test
    public void testSetLevel(){

    }

    @Test
    public void testSetMaxLevel(){

    }

    @Test
    public void testToXML(){

    }

    @Test
    public void testSaveLevels(){

    }

    @Test
    public void testLoadLevels(){

    }
}