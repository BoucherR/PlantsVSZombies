package test;
import controller.*;
import model.*;
import view.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
     * Used to initialize and establish the GUI VIEW and CONTROLLER Object for Testing
     */
    @Before
    public void setUp(){
        guiView = new View();
        testController = new Controller(guiView);
    }

    /**
     * The Tests is used to check the proper construction of the Controller
     */
    @Test
    public void testController(){
        assertNotNull("The controller is established",testController);
        testController.add(new Coordinate(2,0),new Peashooter());
        assertTrue("The Piece located is Peashooter",testController.getBoard()[2][0].isOccupied());
        assertNotNull("The Peashooter Piece correctly placed",guiView.getGameButtons()[2][0]);
        assertNotEquals("The Game Piece Location is 2,0","(0,2)",testController.getBoard()[2][0].getCoordinate());

        testController.add(new Coordinate(1,1),new Sunflower());
        testController.add(new Coordinate(2,1),new Peashooter());
        assertEquals("The Piece placed is Sunflower",getClass().getResource("/Images/sunflower.png").toString(),guiView.getGameButtons()[1][1].getIcon().toString());
        assertEquals("The Piece image is of Peashooter",getClass().getResource("/Images/peashooter.png").toString(),guiView.getGameButtons()[2][1].getIcon().toString());
        assertNotEquals("The Game Piece Location is 1,1","0,0",guiView.getGameButtons()[1][1].getLocation());

        testController.add(new Coordinate(1,2),new TwinSunflower());
        testController.add(new Coordinate(2,2),new Threepeater());
        assertEquals("The Piece placed is TwinSunflower",getClass().getResource("/Images/twinsunflower.png").toString(),guiView.getGameButtons()[1][2].getIcon().toString());
        assertNotEquals("The Piece placed is Threepeater","/Images/threepeater.png",guiView.getGameButtons()[2][2].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Threepeater",guiView.getGameButtons()[2][2]);
        assertEquals("The Game Piece Location is 1,2",new Coordinate(1,2),testController.getBoard()[1][2].getCoordinate());

        testController.add(new Coordinate(1,3),new Walnut());
        testController.add(new Coordinate(2,3),new Repeater());
        assertEquals("The Piece placed is Walnut",getClass().getResource("/Images/wallnut.png").toString(),guiView.getGameButtons()[1][3].getIcon().toString());
        assertEquals("The Piece placed is Repeater",getClass().getResource("/Images/repeater.png").toString(),guiView.getGameButtons()[2][3].getIcon().toString());
        assertNotNull("The Game Piece Location is for a Walnut",testController.getBoard()[2][3].getCoordinate());
        assertEquals("The Game Piece placed is Repeater",new Repeater(),testController.getBoard()[2][3].getPiece());

        testController.add(new Coordinate(2,4),new Peashooter());
        assertNotNull("The Game Piece Location is for a (2,4)",testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][4].getPiece());
        assertEquals("The Game Piece placed is Repeater",new Coordinate(2,4),testController.getBoard()[2][4].getCoordinate());
        for(int i = 0; i < testController.getBoard()[0].length;i++)
        {
            testController.movingZombie();
            testController.updateView();
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
        assertEquals("The Logging Correctly displays result","Added Piece: PEASHOOTER @ Coordinates: (2,1)\n" +
                "Added Piece: REPEATER @ Coordinates: (2,3)\n" +"Added Piece: ZOMBIE @ Coordinates: (4,1)\n" +
                "Moved ZOMBIE from (4,1) to (3,1)\n" + "PEASHOOTER Health: 5 @ (2,1) Attacked ZOMBIE Health: 3 @ (3,1)\n"
        + "ZOMBIE Health: 3 @ (3,1) Attacked PEASHOOTER Health: 3 @ (2,1)", guiView.getTextArea().getText().trim());
        //while (true);
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
            testController.updateView();
            i++;
        }
        assertNotNull("The Game Piece Location is for a Threepeater",testController.getBoard()[2][2].getPiece());
        assertNotEquals("The Game Piece Threepeater remains",new Zombie(),testController.getBoard()[2][2].getPiece());
        assertEquals("The Game Piece Sunflower remains",5,testController.getBoard()[1][3].getPiece().getHealth());
        assertNotEquals("The Game Piece Threepeater took little damage from zombies",5,testController.getBoard()[2][4].getPiece().getHealth());
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
       assertNotEquals("The Zombie Placed properly on board",".src/images",testController.getBoard()[2][1].getPiece().getImage().toString());
       assertEquals("The Game Piece Located is Threepeater",new Threepeater(),testController.getBoard()[2][1].getPiece());
       assertEquals("The Game Piece Located is Zombie",new Zombie(),testController.getBoard()[7][1].getPiece());

       testController.add(new Coordinate(2,2),new Peashooter());
       testController.add(new Coordinate(3,2),new BucketZombie());
       assertNotNull("The Peashooter Placed properly on board",testController.getBoard()[2][2].getPiece().getImage());
       assertEquals("The Game Piece Located is Peashooter",new Peashooter(),testController.getBoard()[2][2].getPiece());
       assertEquals("The Game Piece Located is Zombie",new BucketZombie(),testController.getBoard()[3][2].getPiece());

       for(int i = 0; i < testController.getBoard().length; i++)
       {
           testController.getLogging();
           testController.hitUpdate();
           testController.removeUpdate();
       }

       assertNotEquals("The BucketZombie Health decreased, attacked by Peashooter",5,testController.getBoard()[3][2].getPiece().getHealth());
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
        Random ran = new Random();
        for(int i = 0; i < 2;i++)
        {
            int row = ran.nextInt(4);
            int column = ran.nextInt(7);
            guiView.getGameButtons()[column][row].doClick();
            testController.add(new Coordinate(column,row),new Peashooter());
            assertTrue("The Game Piece was displayable",testController.getBoard()[column][row].isOccupied());
            assertEquals("The Game Piece is placed",new Peashooter(),testController.getBoard()[column][row].getPiece());
            assertNotNull("The Game Piece placed using Random",testController.getBoard()[column][row].getPiece());
        }
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