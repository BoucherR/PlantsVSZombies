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
    public void setUp(){
        guiView = new View();
        testController = new Controller(guiView);
    }


    @Test
    public void testController(){
        assertNotNull("The controller is established",testController);
        testController.add(new Coordinate(2,0),new Peashooter());
        guiView.getGameButtons()[2][0].setIcon(new ImageIcon("./src/Images/Peashooter.png"));
        assertTrue("The Piece located is Peashooter",testController.getBoard()[2][0].isOccupied());
        assertNotNull("The Peashooter Piece correctly placed",guiView.getGameButtons()[2][0]);
        assertNotEquals("The Game Piece Location is 2,0","(0,2)",testController.getBoard()[2][0].getCoordinate());

        testController.add(new Coordinate(1,1),new Sunflower());
        testController.getBoard()[2][1].addPiece(new Peashooter());
        guiView.getGameButtons()[1][1].setIcon(new ImageIcon("./src/Images/Sunflower.png"));
        guiView.getGameButtons()[2][1].setIcon(new ImageIcon("./src/Images/Peashooter.png"));
        assertEquals("The Piece placed is Sunflower","./src/Images/Sunflower.png",guiView.getGameButtons()[1][1].getIcon().toString());
        assertEquals("The Piece placed is Peashooter","./src/Images/Peashooter.png",guiView.getGameButtons()[2][1].getIcon().toString());
        assertNotEquals("The Game Piece Location is 1,1","0,0",guiView.getGameButtons()[1][1].getLocation());

        testController.add(new Coordinate(1,2),new TwinSunflower());
        testController.add(new Coordinate(2,2),new Threepeater());
        guiView.getGameButtons()[1][2].setIcon(new ImageIcon("./src/Images/TwinSunflower.png"));
        guiView.getGameButtons()[2][2].setIcon(new ImageIcon("./src/Images/Threepeater.png"));
        assertEquals("The Piece placed is TwinSunflower","./src/Images/TwinSunflower.png",guiView.getGameButtons()[1][2].getIcon().toString());
        assertEquals("The Piece placed is Threepeater","./src/Images/Threepeater.png",guiView.getGameButtons()[2][2].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Threepeater",guiView.getGameButtons()[2][2]);
        assertEquals("The Game Piece Location is 1,2",new Coordinate(1,2),testController.getBoard()[1][2].getCoordinate());

        testController.add(new Coordinate(1,3),new Wallnut());
        testController.add(new Coordinate(2,3),new Repeater());
        guiView.getGameButtons()[1][3].setIcon(new ImageIcon("./src/Images/Wallnut.png"));
        guiView.getGameButtons()[2][3].setIcon(new ImageIcon("./src/Images/Repeater.png"));
        assertEquals("The Piece placed is Wallnut","./src/Images/Wallnut.png",guiView.getGameButtons()[1][3].getIcon().toString());
        assertEquals("The Piece placed is Repeater","./src/Images/Repeater.png",guiView.getGameButtons()[2][3].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Wallnut",testController.getBoard()[2][3].getCoordinate());
        assertEquals("The Game Piece placed is Repeater",new Repeater(),testController.getBoard()[2][3].getPiece());

        testController.add(new Coordinate(2,4),new Peashooter());
        guiView.getGameButtons()[2][4].setIcon(new ImageIcon("./src/Images/Peashooter.png"));
        assertNotNull("The Game Piece Location is for a (2,4)",testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece placed is Repeater",new Coordinate(2,4),testController.getBoard()[2][4].getCoordinate());
        for(int i = 0; i < testController.getBoard()[0].length;i++)
        {
            testController.movingZombie();
            testController.runTime();
            testController.getLogging();
        }

        while (true);
    }


    @Test
    public void testMove(){
        testController.add(new Coordinate(2,1),new Peashooter());
        guiView.getGameButtons()[2][1].setIcon(new ImageIcon("./src/Images/Peashooter.png"));
        assertNotNull("The Game Piece Location is for a (2,1)",testController.getBoard()[2][1].getPiece());
        assertEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][1].getPiece());
        assertEquals("The Game Piece placed is Peashooter",new Coordinate(2,1),testController.getBoard()[2][1].getCoordinate());

        testController.add(new Coordinate(2,3),new Repeater());
        guiView.getGameButtons()[2][3].setIcon(new ImageIcon("./src/Images/Repeater.png"));
        assertNotNull("The Game Piece Location is for a (3,1)",testController.getBoard()[2][3].getPiece());
        assertNotEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][3].getPiece());
        assertEquals("The Game Piece placed is Repeater",new Coordinate(2,3),testController.getBoard()[2][3].getCoordinate());

        testController.add(new Coordinate(4,1),new Zombie());
        guiView.getGameButtons()[4][1].setIcon(new ImageIcon("./src/Images/Zombie.png"));
        assertNotNull("The Game Piece Location is for a (2,6)",testController.getBoard()[4][1].getPiece());
        assertNotEquals("The Game Piece Located is Zombie",new Sunflower(),testController.getBoard()[4][1].getPiece());
        assertTrue("The Game Piece placed is Zombie",testController.getBoard()[4][1].isOccupied());

        testController.move(new Coordinate("41"),new Coordinate("31"));
        testController.getBoard()[4][1].deletePiece();
        guiView.getGameButtons()[4][1].setIcon(new ImageIcon("./src/Images/grass.png"));  /**<-CHECK FOR THIS*/
        assertNotNull("The Game Piece Location is now (3,1)",testController.getBoard()[3][1].getPiece());
        guiView.getGameButtons()[3][1].setIcon(new ImageIcon("./src/Images/Zombie.png"));
        assertEquals("The Zombie Location changed",new Zombie(),testController.getBoard()[3][1].getPiece());
        assertTrue("The Game Piece placed is Zombie",testController.getBoard()[3][1].isOccupied());
        testController.getLogging();
        assertEquals("The Logging Correctly diplays result","Added Piece: PEASHOOTER @ Coordinates: (2,1)\n" +
                "Added Piece: REPEATER @ Coordinates: (2,3)\n" +"Added Piece: ZOMBIE @ Coordinates: (4,1)\n" +
                "Moved ZOMBIE from (4,1) to (3,1)", guiView.getTextArea().getText().trim());
    }
    /**
     * Default JUnit Test runner keeps GUI VIEW and CONTROLLER Object references for Tests. Tear Down Used to clear
     * the objects after completion of tests
     */
    @After
    public void tearDown() {
        if (this.testController != null) {
            guiView.dispose();
            this.testController = null;
        }
    }
}