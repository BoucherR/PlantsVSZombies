package test;
import controller.*;
import model.*;
import view.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

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
     * The GUI Game Level Object that is used for the TEST CASES
     */
    private GameLevels controllerLevels;


    /**
     * Used to initialize and establish the GUI VIEW and CONTROLLER Object for Testing
     */
    @Before
    public void setUp(){
        guiView = new View();
        controllerLevels = new GameLevels(1,5,500,5);
        testController = new Controller(guiView,controllerLevels);
    }

    /**
     * The Tests is used to check the proper construction of the Controller
     */
    @Test
    public void testController(){
        assertNotNull("The controller is established",testController);
        testController.add(new Coordinate(2,0),new Threepeater());
        assertTrue("The Piece located is Peashooter",testController.getBoard()[2][0].isOccupied());
        assertNotNull("The Peashooter Piece correctly placed",guiView.getGameButtons()[2][0]);
        assertNotEquals("The Game Piece Location is 2,0","(0,2)",testController.getBoard()[2][0].getCoordinate());

        testController.add(new Coordinate(1,1),new Sunflower());
        testController.add(new Coordinate(2,1),new Threepeater());
        assertEquals("The Piece placed is Sunflower",getClass().getResource("/Images/sunflower.png").toString(),guiView.getGameButtons()[1][1].getIcon().toString());
        assertEquals("The Piece image is of Peashooter",getClass().getResource("/Images/threepeater.png").toString(),guiView.getGameButtons()[2][1].getIcon().toString());
        assertNotEquals("The Game Piece Location is 1,1","0,0",guiView.getGameButtons()[1][1].getLocation());

        testController.add(new Coordinate(1,2),new TwinSunflower());
        testController.add(new Coordinate(2,2),new Threepeater());
        assertEquals("The Piece placed is TwinSunflower",getClass().getResource("/Images/twinsunflower.png").toString(),guiView.getGameButtons()[1][2].getIcon().toString());
        assertNotEquals("The Piece placed is Threepeater","/Images/threepeater.png",guiView.getGameButtons()[2][2].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Threepeater",guiView.getGameButtons()[2][2]);
        assertEquals("The Game Piece Location is 1,2",new Coordinate(1,2),testController.getBoard()[1][2].getCoordinate());

        testController.add(new Coordinate(1,3),new Wallnut());
        testController.add(new Coordinate(2,3),new Repeater());
        assertEquals("The Piece placed is Wallnut",getClass().getResource("/Images/wallnut.png").toString(),guiView.getGameButtons()[1][3].getIcon().toString());
        assertEquals("The Piece placed is Repeater",getClass().getResource("/Images/repeater.png").toString(),guiView.getGameButtons()[2][3].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Wallnut",testController.getBoard()[2][3].getCoordinate());
        assertEquals("The Game Piece placed is Repeater",new Repeater(),testController.getBoard()[2][3].getPiece());

        testController.add(new Coordinate(2,4),new Threepeater());
        assertNotNull("The Game Piece Location is for a (2,4)",testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece Located is Peashooter",new Threepeater(),testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece placed is Repeater",new Coordinate(2,4),testController.getBoard()[2][4].getCoordinate());
        for(int i = 0; i < testController.getBoard()[0].length - 2;i++)
        {
            testController.movingZombie();
            testController.runTime();
        }

    }


    /**
     * The Test is used to check the MOVE functionality of the controller
     */
    @Test
    public void testMove(){
        testController.add(new Coordinate(2,1),new Peashooter());
        assertNotNull("The Game Piece Location is for a (2,1)",testController.getBoard()[2][1].getPiece());
        assertEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][1].getPiece());
        assertEquals("The Game Piece placed is Peashooter",new Coordinate(2,1),testController.getBoard()[2][1].getCoordinate());

        testController.add(new Coordinate(2,3),new Repeater());
        assertNotNull("The Game Piece Location is for a (3,1)",testController.getBoard()[2][3].getPiece());
        assertNotEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][3].getPiece());
        assertEquals("The Game Piece placed is Repeater",new Coordinate(2,3),testController.getBoard()[2][3].getCoordinate());

        testController.add(new Coordinate(4,1),new Zombie());
        assertNotNull("The Game Piece Location is for a (2,6)",testController.getBoard()[4][1].getPiece());
        assertNotEquals("The Game Piece Located is Zombie",new Sunflower(),testController.getBoard()[4][1].getPiece());
        assertTrue("The Game Piece placed is Zombie",testController.getBoard()[4][1].isOccupied());

        testController.move(new Coordinate("41"),new Coordinate("31"));
        assertNotNull("The Game Piece Location is now (3,1)",testController.getBoard()[3][1].getPiece());
        assertEquals("The Zombie Location changed",new Zombie(),testController.getBoard()[3][1].getPiece());
        assertTrue("The Game Piece placed is Zombie",testController.getBoard()[3][1].isOccupied());
        testController.hitUpdate();
        testController.getLogging();
        testController.removeUpdate();
        String[] text = guiView.getTextArea().getText().split("\\n");
        assertEquals("The Logging Correctly displays result",text[0]+"\n"+text[text.length-5]+"\n"+text[text.length-4]+"\n"+text[text.length-3]+
                "\n"+text[text.length-2]+"\n"+text[text.length-1],guiView.getTextArea().getText().trim());
    }

    /**
     * The Test is used to check the GAME LOGIC functionality of the Controller
     */
    @Test
    public void testGamePlay(){
        testController.add(new Coordinate(2,0),new Threepeater());
        assertEquals("The Piece placed is Threepeater", getClass().getResource("/Images/threepeater.png").toString(),guiView.getGameButtons()[2][0].getIcon().toString());
        assertEquals("The Plant Piece placed correctly",new Coordinate(2,0),testController.getBoard()[2][0].getCoordinate());

        testController.add(new Coordinate(2,1),new Threepeater());
        testController.add(new Coordinate(2,2),new Threepeater());
        assertNotEquals("The Piece placed is Threepeater",getClass().getResource("/Images/threepeater.png"),guiView.getGameButtons()[2][1].getIcon().toString());
        assertEquals("The Piece placed is Threepeater",getClass().getResource("/Images/threepeater.png").toString(),guiView.getGameButtons()[2][2].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Threepeater",guiView.getGameButtons()[2][2]);
        assertEquals("The Game Piece Location is 1,2",new Coordinate(2,2),testController.getBoard()[2][2].getCoordinate());

        testController.add(new Coordinate(1,3),new Sunflower());
        testController.add(new Coordinate(2,3),new Threepeater());
        assertEquals("The Piece placed is Sunflower",new Sunflower(),testController.getBoard()[1][3].getPiece());
        assertEquals("The Piece placed is Threepeater",getClass().getResource("/Images/threepeater.png").toString(),guiView.getGameButtons()[2][3].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Sunflower",testController.getBoard()[2][3].getCoordinate());
        assertEquals("The Game Piece placed is Threepeater",new Threepeater(),testController.getBoard()[2][3].getPiece());

        testController.add(new Coordinate(2,4),new Threepeater());
        assertNotNull("The Game Piece Location is for a (2,4)",testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece Located is Threepeater",new Threepeater(),testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece placed is Threepeater",new Coordinate(2,4),testController.getBoard()[2][4].getCoordinate());
        int i = 0;
        while (i < testController.getBoard().length){
            testController.runTime();
            i++;
        }
        assertNotNull("The Game Piece Location is for a Threepeater",testController.getBoard()[2][2].getPiece());
        assertNotEquals("The Game Piece Threepeater remains",new Zombie(),testController.getBoard()[2][2].getPiece());
        assertNotEquals("The Game Piece Sunflower remains",0,testController.getBoard()[1][3].getPiece().getHealth());
        assertNotEquals("The Game Piece Threepeater took little damage from zombies",2,testController.getBoard()[2][4].getPiece().getHealth());
    }

    /**
     * The Test is used to check the Logging of the Game Moves
     */
    @Test
    public void testGetLogging() {
        testController.add(new Coordinate(2, 0), new Threepeater());
        assertEquals("The Piece placed is Threepeater", getClass().getResource("/Images/threepeater.png").toString(), guiView.getGameButtons()[2][0].getIcon().toString());
        assertEquals("The Plant Piece placed correctly", new Coordinate(2, 0), testController.getBoard()[2][0].getCoordinate());

        testController.add(new Coordinate(2, 2), new Peashooter());
        assertEquals("The Plant Piece placed correctly", new Peashooter(), testController.getBoard()[2][2].getPiece());
        testController.getLogging();
        assertEquals("The Logging Displays correctly on JTextArea", "Added Piece: THREEPEATER @ Coordinates: (2,0)\n" +
                "Added Piece: PEASHOOTER @ Coordinates: (2,2)", guiView.getTextArea().getText().trim());
    }

    /**
     * The Test is used to check the Attack Logic of the controller
     */
   @Test
   public void testHitUpdate(){
       testController.add(new Coordinate(2,1),new Threepeater());
       testController.add(new Coordinate(7,1),new Zombie());
       assertNotEquals("The Zombie Placed properly on board",".src/images",testController.getBoard()[2][1].getImage().toString());
       assertEquals("The Game Piece Located is Threepeater",new Threepeater(),testController.getBoard()[2][1].getPiece());
       assertEquals("The Game Piece Located is Zombie",new Zombie(),testController.getBoard()[7][1].getPiece());

       testController.add(new Coordinate(2,2),new Threepeater());
       testController.add(new Coordinate(3,2),new BucketZombie());
       assertNotNull("The Peashooter Placed properly on board",testController.getBoard()[2][2].getImage());
       assertEquals("The Game Piece Located is Peashooter",new Threepeater(),testController.getBoard()[2][2].getPiece());
       assertEquals("The Game Piece Located is Zombie",new BucketZombie(),testController.getBoard()[3][2].getPiece());

       for(int i = 0; i < testController.getBoard().length; i++)
       {
           testController.getLogging();
           testController.hitUpdate();
           testController.removeUpdate();
       }

       assertNotEquals("The BucketZombie Health decreased, attacked by Peashooter",2,testController.getBoard()[3][2].getPiece().getHealth());
       assertNull("The Threepeater got killed by BucketZombie",testController.getBoard()[2][2].getPiece());
       assertEquals("The Threepeater kills zombie before zombie attacks",10,(testController.getBoard()[2][1].getPiece()).getHealth());
       assertNull("The Zombie Killed by Peashooter",testController.getBoard()[7][1].getPiece());
    }

    /**
     * The Test is used to check the Movement of the Zombies along the board
     */
    @Test
    public void testMovingZombie(){
        testController.add(new Coordinate(7,3),new BucketZombie());
        testController.add(new Coordinate(7,1),new Zombie());
        testController.add(new Coordinate(7,4),new ConeheadZombie());
        assertNotNull("The BucketZombie placed",testController.getBoard()[7][3].getPiece());
        assertEquals("The Zombie placed initially at (7,1)",new Coordinate(7,1),(testController.getBoard()[7][1].getCoordinate()));
        assertNotEquals("The ConeheadZombie is placed",new Zombie(),testController.getBoard()[7][4].getPiece());

        testController.movingZombie();

        assertNull("The Location of the BucketZombie is changed",testController.getBoard()[7][3].getPiece());
        assertNotEquals("The location is changed from 7,3",new BucketZombie(),testController.getBoard()[7][3].getPiece());
        assertEquals("The location is changed from 7,1 -> 6,1",new Zombie(),testController.getBoard()[6][1].getPiece());
        assertNotNull("The Piece added is ConeheadZombie",testController.getBoard()[6][4].getPiece());
        assertNull("The Location of the ConeheadZombie is changed",testController.getBoard()[7][4].getPiece());
    }

    /**
     * The Test is used to check the JButton functionality. Random Function used to retrieve random number of row and
     * column within the Game Frame.
     */
    @Test
    public void testGameActionPerformed(){
        testController.actionListener();
        Random ran = new Random();
        int row = ran.nextInt(4);
        int column = ran.nextInt(7);
        guiView.getGameButtons()[column][row].doClick();
        Coordinate temp = testController.getClickedButtonLocation();
        testController.add(temp,new Peashooter());
        testController.getLogging();
        assertTrue("The Game Piece was displayable",testController.getBoard()[column][row].isOccupied());
        assertEquals("The Game Piece is placed",new Peashooter(),testController.getBoard()[column][row].getPiece());
        assertNotNull("The Game Piece placed using Random",testController.getBoard()[column][row].getPiece());
    }

    /**
     * The Test is used to check the functionality of the UNDO Command
     */
    @Test
    public void testUndoCommand(){
        //testController.actionListener();
        testController.runTime();
        testController.add(new Coordinate(3,3),new Peashooter());
        assertTrue("The Game Piece was displayable",testController.getBoard()[3][3].isOccupied());
        assertEquals("The Game Piece is placed",new Peashooter(),testController.getBoard()[3][3].getPiece());
        testController.undo();
        assertNull("The Piece has been removed after UNDO Command",testController.getBoard()[3][3].getPiece());
        assertFalse("The Game Piece was removed after Undo",testController.getBoard()[3][3].isOccupied());
    }

    /**
     * The Test is used to check the functionality of the REDO Command
     */
    @Test
    public void testRedoCommand(){
       // testController.actionListener();
        testController.runTime();
        testController.add(new Coordinate(3,3),new Peashooter());
        assertTrue("The Game Piece was displayable",testController.getBoard()[3][3].isOccupied());
        assertEquals("The Game Piece is placed",new Peashooter(),testController.getBoard()[3][3].getPiece());


        testController.add(new Coordinate(4,2),new Threepeater());
        assertNotNull("The Game Piece is placed",testController.getBoard()[4][2].getPiece());
        assertTrue("The Game Piece was displayable",guiView.getGameButtons()[4][2].isDisplayable());
        assertEquals("The Game Piece is placed",new Threepeater(),testController.getBoard()[4][2].getPiece());

        testController.undo();

        assertNull("The Game Piece is removed after the Undo Command",testController.getBoard()[3][3].getPiece());
        assertNotEquals("The Game Piece is not removed",new Peashooter(),testController.getBoard()[3][3].getPiece());

        assertNull("The most recent game piece i.e. Threepeater addition is removed",testController.getBoard()[4][2].getPiece());
        assertFalse("The Game Piece was removed after Undo",testController.getBoard()[4][2].isOccupied());
        assertNotEquals("The most recent piece addition is UNDONE",new Threepeater(),testController.getBoard()[4][2].getPiece());
        testController.redo();

        assertNotNull("The most recent game piece i.e. Threepeater added again after REDO",testController.getBoard()[4][2].getPiece());
        assertTrue("The Game Piece was added again after Redo command",testController.getBoard()[4][2].isOccupied());
        assertEquals("The most recent piece REMOVAL is UNDONE",new Threepeater(),testController.getBoard()[4][2].getPiece());

    }

    /**
     * The Test is used to check the functionality of the RESET option
     */
    @Test
    public void testReset(){
        testController.add(new Coordinate(2,1),new Peashooter());
        assertNotNull("The Game Piece Location is for a (2,1)",testController.getBoard()[2][1].getPiece());
        testController.add(new Coordinate(3,1),new Repeater());
        assertNotNull("The Game Piece Location is for a (3,1)",testController.getBoard()[3][1].getPiece());
        testController.add(new Coordinate(4,1),new Threepeater());
        assertEquals("The Game Piece Location is for a (4,1)",new Threepeater(),testController.getBoard()[4][1].getPiece());

        testController.reset();
        assertNull("The Game is Reset, No Pieces",testController.getBoard()[2][1].getPiece());
        assertFalse("The Game Piece is not present",testController.getBoard()[4][1].isOccupied());
        assertNotEquals("The Game is RESET, no Game Piece",new Threepeater(),testController.getBoard()[3][1]);
    }

    /**
     * The Method is used to check the Save Game Functionality
     */
    @Test
    public void testGameSave(){
        testController.add(new Coordinate(3,3),new Peashooter());
        testController.add(new Coordinate(1,1),new Threepeater());
        testController.add(new Coordinate(4,4),new Repeater());
        assertEquals("The Game Piece is added properly",new Threepeater(),testController.getBoard()[1][1].getPiece());
        assertEquals("The Game Piece is added properly",new Repeater(),testController.getBoard()[4][4].getPiece());
        assertNotNull("The BucketZombie placed",testController.getBoard()[3][3].getPiece());
        testController.save("GameTestFile.txt");
    }

    /**
     * The Test is used to check the Load functionality of the Game
     */
    @Test
    public void testLoadGame(){
        testController.load("GameTestFile.txt");
        assertEquals("The Game Piece is added properly",new Threepeater(),testController.getBoard()[1][1].getPiece());
        assertEquals("The Game Piece is added properly",new Repeater(),testController.getBoard()[4][4].getPiece());
        assertNotNull("The Game is fully loaded",testController.getBoard()[4][4].getPiece());
        assertNotNull("The Game is fully loaded",testController.getBoard()[3][3].getPiece());
        assertEquals("The Game is fully loaded with correct piece Location",new Square(new Coordinate(4,4),new Repeater()),testController.getBoard()[4][4]);
        testController.add(new Coordinate(2,1),new Sunflower());
        assertEquals("The Load operation didn't affect Game Functionality",new Sunflower(),testController.getBoard()[2][1].getPiece());
    }

    /**
     * The Test is used to check the Copy Board Functionality of the Game Playground
     */
    @Test
    public void testCopyBoard(){
        testController.add(new Coordinate(3,3),new Sunflower());
        testController.add(new Coordinate(1,1),new Peashooter());
        testController.add(new Coordinate(4,4),new Threepeater());
        testController.add(new Coordinate(6,4),new Zombie());
        assertEquals("The Game Piece is added properly",new Sunflower(),testController.getBoard()[3][3].getPiece());
        assertEquals("The Game Piece is added properly",new Peashooter(),testController.getBoard()[1][1].getPiece());
        assertNotNull("The Game Board installation",testController.getBoard()[6][4].getPiece());
        Square[][] testCopy = testController.copyBoard();
        assertEquals("Copy Properly Not Done, The Game Piece is not at same location",new Sunflower(),testCopy[3][3].getPiece());
        assertEquals("Copy Properly Not Done, The Game Piece is not at same location",new Peashooter(),testCopy[1][1].getPiece());
        assertNotNull("Copy Board doesn't give same results",testCopy[6][4].getPiece());
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