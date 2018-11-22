package test;
import controller.*;
import model.*;
import view.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * The Test Class for the Controller
 * @author Muneeb Nasir
 * @version 3.0
 */
public class ControllerTest {

    /**
     * The GUI VIEW Object that is used for the TEST CASES
     */
    private View guiView;

    /**
     * The GUI CONTROLLER Object that is used for the TEST CASES
     */
    private Controller testController;


    /**
     * Used to initialize and establish the GUI VIEW and CONTROLLER Object for Testing
     */
    @Before
    public void setUp() throws Exception {
        guiView = new View();
        testController = new Controller(guiView);
    }


    @Test
    public void testController(){
        testController.actionListener();
        assertNotNull("The controller is established",testController);
        testController.add(new Coordinate(1,1),new Sunflower());
        testController.add(new Coordinate(2,1),new Peashooter());
        guiView.getGameButtons()[1][1].setIcon(new ImageIcon("./src/Images/Sunflower.png"));
        guiView.getGameButtons()[2][1].setIcon(new ImageIcon("./src/Images/Peashooter.png"));
        assertEquals("The Piece placed is Sunflower","./src/Images/Sunflower.png",guiView.getGameButtons()[1][1].getIcon().toString());
        assertEquals("The Piece placed is Peashooter","./src/Images/Peashooter.png",guiView.getGameButtons()[2][1].getIcon().toString());
        assertNotEquals("The Game Piece Location is","0,0",guiView.getGameButtons()[1][1].getLocation());
        testController.add(new Coordinate(1,2),new TwinSunflower());
        testController.add(new Coordinate(2,2),new Threepeater());
        guiView.getGameButtons()[1][2].setIcon(new ImageIcon("./src/Images/TwinSunflower.png"));
        guiView.getGameButtons()[2][2].setIcon(new ImageIcon("./src/Images/Threepeater.png"));
        assertEquals("The Piece placed is TwinSunflower","./src/Images/TwinSunflower.png",guiView.getGameButtons()[1][2].getIcon().toString());
        assertEquals("The Piece placed is Threepeater","./src/Images/Threepeater.png",guiView.getGameButtons()[2][2].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Threepeater",guiView.getGameButtons()[2][2]);
        testController.add(new Coordinate(1,3),new Wallnut());
        testController.add(new Coordinate(2,3),new Repeater());
        guiView.getGameButtons()[1][3].setIcon(new ImageIcon("./src/Images/Wallnut.png"));
        guiView.getGameButtons()[2][3].setIcon(new ImageIcon("./src/Images/Repeater.png"));
        assertEquals("The Piece placed is Wallnut","./src/Images/Wallnut.png",guiView.getGameButtons()[1][3].getIcon().toString());
        assertEquals("The Piece placed is Repeater","./src/Images/Repeater.png",guiView.getGameButtons()[2][3].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Wallnut",guiView.getGameButtons()[2][3]);
        guiView.getGameButtons()[3][3].setIcon(new ImageIcon("./src/Images/Zombie.png"));
    }


    /*
    guiView.getGameButtons()[1][1].setIcon(new ImageIcon(getClass().getResource("/Images/Peashooter.png")));
        while (true);
        //assertNotNull(guiView.getGameButtons()[0][1].getIcon());
     */
    /**
     * Default JUnit Test runner keeps GUI VIEW and CONTROLLER Object references for Tests. Tear Down Used to clear
     * the objects after completion of tests
     */
    /*@After
    public void tearDown() {
        if (this.testController != null) {
            guiView.dispose();
            this.testController = null;
        }
    }*/
}