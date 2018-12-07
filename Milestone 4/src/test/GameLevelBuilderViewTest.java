package test;

import controller.*;
import model.*;
import view.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;


/**
 * The Test Class for the Game Levels Builder View
 * @author Muneeb Nasir
 * @version 4.0
 */
public class GameLevelBuilderViewTest {

    /**
     * The Class Objects used for testing
     */
    private GameBuilderView testLevelView1;



    /**
     * Used to initialize and establish the GUI
     */
    @Before
    public void setUp(){
        testLevelView1 = new GameBuilderView();
    }


    @Test
    public void testGameLevelBuilderView(){
        assertNotNull("The Game Builder Frame is properly established",testLevelView1);
        assertEquals("The Frame is Game Builder","Zombie Selection: Please select desired zombies and click complete build",testLevelView1.getTitle());
        assertEquals("The Size of the Game Level Builder View is 760 x 138",new Dimension(760,138),testLevelView1.getSize());
        assertNotEquals("The Size of the Game Level Builder 760 x 138",new Dimension(800,183),testLevelView1.getSize());
        assertNotEquals("The Frame is Game Builder","Plant Vs Zombies",testLevelView1.getTitle());
    }


    @Test
    public void testGetZombie(){
        assertNotNull("The Zombie Selection Button is functional",testLevelView1.getZombie());
        assertNotNull("The Zombie Label Icon is set",testLevelView1.getZombie().getIcon());
        assertEquals("The Image Icon properly placed",new ImageIcon(getClass().getResource("/Images/zombie.png")).toString(),testLevelView1.getZombie().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./Images/zombie",testLevelView1.getZombie().getIcon().toString());
        assertNotEquals("The Zombie Buttons is enabled","Zombie",testLevelView1.getZombie().getText());
        assertEquals("Zombie Buttons has no sub-components",0,testLevelView1.getZombie().getComponentCount());
    }


    @Test
    public void testGetConeHeadZombie(){
        assertNotNull("The Cone Head Zombie Selection Button is functional",testLevelView1.getConeHeadZombie());
        assertNotNull("The Cone Head Zombie Label Icon is set",testLevelView1.getConeHeadZombie().getIcon());
        assertEquals("The Image Icon properly placed",new ImageIcon(getClass().getResource("/Images/coneheadzombie.png")).toString(),testLevelView1.getConeHeadZombie().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./Icon/zombie",testLevelView1.getConeHeadZombie().getIcon().toString());
        assertNotEquals("The  Zombie Buttons is enabled","Zombie",testLevelView1.getZombie().getText());
        assertEquals("Zombie Buttons has no sub-components",0,testLevelView1.getConeHeadZombie().getComponentCount());
    }

    @Test
    public void testGetSubmit(){
        assertEquals("The Command is placed correctly","Complete Build",testLevelView1.getSubmit().getText());
        assertNotNull("The Submit Button is functional",testLevelView1.getSubmit());
        assertNotNull("The Submit Label Icon is set",testLevelView1.getSubmit());
        assertNotEquals("The Zombie Buttons is enabled","Zombie",testLevelView1.getZombie().getText());
        assertEquals("Submit Buttons has no sub-components",0,testLevelView1.getZombie().getComponentCount());

    }

    @Test
    public void testGetBucketHeadZombie(){
        assertNotNull("The Bucket Head Zombie Selection Button is functional",testLevelView1.getBucketHeadZombie());
        assertNotNull("The Bucket Head Zombie Label Icon is set",testLevelView1.getBucketHeadZombie().getIcon());
        assertEquals("The Image Icon properly placed",new ImageIcon(getClass().getResource("/Images/bucketzombie.png")).toString(),testLevelView1.getBucketHeadZombie().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","src",testLevelView1.getConeHeadZombie().getIcon().toString());
        assertNotEquals("The  Bucket Zombie Buttons is enabled","Zombie",testLevelView1.getConeHeadZombie().getText());
        assertEquals("Bucket Zombie Buttons has no sub-components",0,testLevelView1.getConeHeadZombie().getComponentCount());
    }








    /**
     * Default JUnit Test runner keeps GUI VIEW and associated Object references for Tests. Tear Down Used to clear
     * the objects after completion of tests
     */
    @After
    public void tearDown() {
        if (this.testLevelView1 != null) {
            testLevelView1.dispose();
        }
    }

}

