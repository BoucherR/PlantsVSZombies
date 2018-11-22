package test;
import view.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * The Test Class for the View Class (Responsible for GUI)
 * @author Muneeb Nasir
 * @version 3.0
 */
public class ViewTest {

    /**
     * The GUI VIEW Object that is used for the TEST CASES
     */
    private View testFrame;

    /**
     * Used to initialize and establish the GUI
     */
    @Before
    public void setUp(){
        testFrame = new View();
    }


    @Test
    public void testView(){
        assertNotNull(testFrame);
        assertEquals("The Buttons indexes are established",8,testFrame.getGameButtons().length);
        assertTrue("The View is established",testFrame.isVisible());
        assertFalse("The TextArea is Fixed",testFrame.getTextArea().isEditable());
        assertTrue("The Frame is Valid ROOT Element",testFrame.isValidateRoot());
        assertNotEquals("The Buttons on the View are 40",10,testFrame.getGameButtons().length);
        assertEquals("The Size of the Game View is 1366 x 768",new Dimension(1366,768),testFrame.getSize());
        assertNotEquals("The Size of the Game View is 1366 x 768",new Dimension(800,900),testFrame.getSize());
        assertTrue("The Text Area is established",testFrame.getTextArea().isDisplayable());
        assertTrue("The Top Panel contains sub-options: redo/undo",testFrame.getTopPanel().isDisplayable());
        assertNotNull("The Redo Menu Button is properly places",testFrame.getRedoButton());
        assertNotNull("The Undo Menu Button is properly placed",testFrame.getUndoButton());
        for(int i = 0; i < testFrame.getGameButtons()[0].length;i++){
            for(int j = 0; j < testFrame.getGameButtons().length;j++){
                assertNotNull("The Button is placed properly in horizontal & vertical position",testFrame.getGameButtons()[j][i]);
                assertEquals("The Button Icon properly placed","./src/Images/grass.png",testFrame.getGameButtons()[j][i].getIcon().toString());
                assertNotNull("The Button Icon is established",testFrame.getGameButtons()[j][i].getIcon());
                assertNotEquals("The Button Icon properly imported","./Images/grass",testFrame.getGameButtons()[j][i].getIcon().toString());
            }
        }
    }

    @Test
    public void testGetGameButtons(){
        JButton[] testButtonArray = new JButton[5];
        assertNotNull("The Buttons Array contains complete Buttons",testFrame.getGameButtons());
        assertNotEquals("The Buttons dimensions is 8 x 5 in total","40",testFrame.getGameButtons().length);
        assertEquals("The Buttons row are 5",5,testFrame.getGameButtons()[0].length);
        assertEquals("The Buttons columns are 8",8,testFrame.getGameButtons().length);
        assertNotEquals("The 2D Button array is [8][5]",testButtonArray,testFrame.getGameButtons());
    }

    @Test
    public void testGetPopupMenu(){
        assertNotNull("The Popup Menu are functional",testFrame.getPopupMenu());
        assertEquals("The Popup Menu option is Select Plant","Select Plant",testFrame.getPopupMenu().getLabel());
        assertEquals("The Popup Menu contains Numerous Piece Options",7,testFrame.getPopupMenu().getComponentCount());
        assertNotEquals("The Popup Menu shows selection option","Plant",testFrame.getPopupMenu().getName());
    }

    @Test
    public void testGetSunflower(){
        assertNotNull("The Popup Menu Option are functional",testFrame.getSunflower());
        assertNotNull("The Sunflower Image Label Icon is set",testFrame.getSunflower().getIcon());
        assertEquals("The Image Icon properly placed","./src/Icons/SunflowerSmall.png",testFrame.getSunflower().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./src/Images/Sunflower",testFrame.getSunflower().getIcon().toString());
        assertEquals("The Popup Menu option: Sunflower","Sunflower",testFrame.getSunflower().getText());
        assertEquals("Sunflower has no SUB-MENU Items",0,testFrame.getSunflower().getComponentCount());
        assertNotEquals("Sunflower has no SUB-MENU Items",2,testFrame.getSunflower().getComponentCount());
        assertNotEquals("The option is Sunflower","Flower",testFrame.getSunflower().getName());
    }

    @Test
    public void testGetPeashooter(){
        assertNotNull("The Popup Menu Option are functional",testFrame.getPeashooter());
        assertNotNull("The Peashooter Image Label Icon is set",testFrame.getPeashooter().getIcon());
        assertEquals("The Image Icon properly placed","./src/Icons/PeashooterSmall.png",testFrame.getPeashooter().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./Images/Pea",testFrame.getPeashooter().getIcon().toString());
        assertEquals("The Popup Menu option: Peashooter","Peashooter",testFrame.getPeashooter().getText());
        assertEquals("PeaShooter has no SUB-MENU Items",0,testFrame.getPeashooter().getComponentCount());
        assertNotEquals("PeaShooter has no SUB-MENU Items",2,testFrame.getPeashooter().getComponentCount());
        assertNotEquals("The option is Peashooter","Shooter",testFrame.getPeashooter().getName());
    }

    @Test
    public void testGetTopPanel(){
        assertNotEquals("The Top Menu Panel is placed properly",testFrame.getTopPanel());
        assertTrue("The Top Panel contains sub-options: redo/undo",testFrame.getTopPanel().isValid());
        assertTrue("The option is undo",testFrame.getTopPanel().isEnabled());
    }

    @Test
    public void testGetSunMoney(){
        assertTrue("The Sun is visible",testFrame.getSunMoney().isDisplayable());
        assertNotEquals("The Sun money is not established prior to player's entrance","100",testFrame.getSunMoney().getText());
    }

    @Test
    public void testGetRedoButton(){
        assertTrue("The Redo Menu Item is visible",testFrame.getRedoButton().isDisplayable());
        assertNotEquals("The game option is Redo","Replay",testFrame.getRedoButton().getText());
    }

    @Test
    public void testGetUndoButton(){
        assertTrue("The Undo Menu Item is visible",testFrame.getUndoButton().isDisplayable());
        assertNotEquals("The game option is Undo","Exit",testFrame.getUndoButton().getText());
    }

    @Test
    public void testGetRepeater(){
        assertNotNull("The Repeater Piece Popup Menu Option are functional",testFrame.getRepeater());
        assertNotNull("The Repeater Image Label Icon is set",testFrame.getRepeater().getIcon());
        assertEquals("The Image Icon properly placed","./src/Icons/RepeaterSmall.png",testFrame.getRepeater().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./Images",testFrame.getRepeater().getIcon().toString());
    }

    @Test
    public void testGetThreepeater(){
        assertNotNull("The Threepeater Piece Valid Game Piece",testFrame.getThreepeater());
        assertEquals("The Popup Menu option: Threepeater","Threepeater",testFrame.getThreepeater().getText());
        assertEquals("PeaShooter has no SUB-MENU Items",0,testFrame.getThreepeater().getComponentCount());
        assertNotEquals("The option is Threepeater","peater",testFrame.getThreepeater().getName());
    }

    @Test
    public void testGetWallnut(){
        assertNotNull("The Wallnut Piece Valid Game Piece",testFrame.getWallnut());
        assertEquals("The Popup Menu option: Walnut","Walnut",testFrame.getWallnut().getText());
        assertEquals("Wallnut has no SUB-MENU Items",0,testFrame.getWallnut().getComponentCount());
        assertNotEquals("The option is Wallnut","W",testFrame.getWallnut().getName());
        assertNotEquals("The Image properly extracted from correct file path","./src/Images/.png",testFrame.getRepeater().getIcon().toString());
    }

    @Test
    public void testGetTwinSunflower(){
        assertNotNull("The Twin Sunflower Piece Valid Game Piece",testFrame.getTwinSunflower());
        assertEquals("The Popup Menu option: Twin Sunflower","Twin Sunflower",testFrame.getTwinSunflower().getText());
        assertEquals("Twin Sunflower has no SUB-MENU Items",0,testFrame.getTwinSunflower().getComponentCount());
        assertNotNull("The Twin Sunflower Image Label Icon is set",testFrame.getTwinSunflower().getIcon());
        assertEquals("The Image Icon properly placed","./src/Icons/TwinSunflowerSmall.png",testFrame.getTwinSunflower().getIcon().toString());
    }

    @Test
    public void testGetGiantSunflower(){
        assertNotNull("The Giant Sunflower Piece Valid Game Piece",testFrame.getGiantSunflower());
        assertEquals("The Popup Menu option: Giant Sunflower","Giant Sunflower",testFrame.getGiantSunflower().getText());
        assertEquals("Giant Sunflower has no SUB-MENU Items",0,testFrame.getGiantSunflower().getComponentCount());
        assertNotNull("The Giant Sunflower Image Label Icon is set",testFrame.getGiantSunflower().getIcon());
        assertEquals("The Image Icon properly placed","./src/Icons/GiantSunflowerSmall.png",testFrame.getGiantSunflower().getIcon().toString());
    }

    /**
     * Default JUnit Test runner keeps GUI VIEW Object references for Tests. Tear Down Used to clear
     * the objects after completion of tests
     */
    @After
    public void tearDown() {
        if (this.testFrame != null) {
            this.testFrame.dispose(  );
            this.testFrame = null;
        }
    }
}