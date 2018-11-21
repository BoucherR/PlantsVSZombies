package test;
import View.*;
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
        assertFalse("The TextArea is Fixed",testFrame.getjTextArea().isEditable());
        assertTrue("The Frame is Valid ROOT Element",testFrame.isValidateRoot());
        assertNotEquals("The Buttons on the View are 40",10,testFrame.getGameButtons().length);
        assertEquals("The Size of the Game View is 1366 x 768",new Dimension(1366,768),testFrame.getSize());
        assertNotEquals("The Size of the Game View is 1366 x 768",new Dimension(800,900),testFrame.getSize());
        assertTrue("The Button Panels are Visible",testFrame.getjButtonPanel().isDisplayable());
        assertTrue("The Text Area is established",testFrame.getjTextArea().isDisplayable());
        for(int i = 0; i < testFrame.getGameButtons().length;i++){
            for(int j = 0; j < testFrame.getGameButtons()[0].length;j++){
                assertNotNull("The Button is placed properly in horizontal & vertical position",testFrame.getGameButtons()[i][j]);
                assertEquals("The Button Icon properly placed","./src/Images/Grass.png",testFrame.getGameButtons()[i][j].getIcon().toString());
                assertNotNull("The Button Icon is established",testFrame.getGameButtons()[i][j].getIcon());
                assertNotEquals("The Button Icon properly imported","./src/Images/Grass",testFrame.getGameButtons()[i][j].getIcon().toString());
            }
        }
    }

    @Test
    public void testGetJButtonPanel(){
        JPanel testPanel = new JPanel();
        assertNotNull("The Button Panel contains JButtons for the Game",testFrame.getjButtonPanel());
        assertTrue("The Panel and its placement is valid",testFrame.getjButtonPanel().isValid());
        assertNotEquals("The Panel contains JButtons",testPanel,testFrame.getjButtonPanel());
    }

    @Test
    public void testGetGameButtons(){
        JButton[] testButtonArray = new JButton[5];
        assertNotNull("The Buttons Array contains complete Buttons",testFrame.getGameButtons());
        assertNotEquals("The Buttons dimensions is 8 x 5 in total","40",testFrame.getGameButtons().length);
        assertEquals("The Buttons row are 8",8,testFrame.getGameButtons().length);
        assertEquals("The Buttons columns are 5",5,testFrame.getGameButtons()[0].length);
        assertNotEquals("The 2D Button array is [8][5]",testButtonArray,testFrame.getGameButtons());
    }

    @Test
    public void testGetPopupMenu(){
        assertNotNull("The Popup Menu are functional",testFrame.getPopupMenu());
        assertEquals("The Popup Menu option is Select Plant","Select Plant",testFrame.getPopupMenu().getLabel());
        assertEquals("The Popup Menu contains Sunflower and PeaShooter Option",2,testFrame.getPopupMenu().getComponentCount());
        assertNotEquals("The Popup Menu shows selection option","Plant",testFrame.getPopupMenu().getName());
    }

    @Test
    public void testGetSunflower(){
        assertNotNull("The Popup Menu Option are functional",testFrame.getSunflower());
        assertNotNull("The Sunflower Image Label Icon is set",testFrame.getSunflower().getIcon());
        assertEquals("The Image Icon properly placed","./src/Images/SunflowerSmall.png",testFrame.getSunflower().getIcon().toString());
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
        assertEquals("The Image Icon properly placed","./src/Images/PeashooterSmall.png",testFrame.getPeashooter().getIcon().toString());
        assertNotEquals("The Image properly extracted from correct file path","./Images/Pea",testFrame.getPeashooter().getIcon().toString());
        assertEquals("The Popup Menu option: Peashooter","Peashooter",testFrame.getPeashooter().getText());
        assertEquals("PeaShooter has no SUB-MENU Items",0,testFrame.getPeashooter().getComponentCount());
        assertNotEquals("PeaShooter has no SUB-MENU Items",2,testFrame.getPeashooter().getComponentCount());
        assertNotEquals("The option is Peashooter","Shooter",testFrame.getPeashooter().getName());
    }

    /*   @Test
    public void testSetGameButtons(){
        testFrame.setGameButtons((new JButton[10][8]));//To check the Setter Method
        assertNotNull("The Buttons Array contains complete Buttons",testFrame.getGameButtons());
        assertNotEquals("The Array size is changed",8,testFrame.getGameButtons().length);
        assertEquals("The Buttons row are 10",10,testFrame.getGameButtons().length);
        assertNotEquals("The Buttons columns are 8",5,testFrame.getGameButtons()[0].length);
        assertEquals("The Buttons columns are 8",8,testFrame.getGameButtons()[0].length);
        assertNotEquals("The 2D Button array is [10][8]",(new JButton[10][8]),testFrame.getGameButtons());
    }
*/
  /*  @Test
    public void testGetJTextPanel(){
        assertNotNull("The Text Panel is functional",testFrame.getjTextPanel());
        assertEquals("Text Panel contains sub-elements",1,testFrame.getjTextPanel().getComponentCount());
        assertNotEquals("Text Panel contains sub-elements",0,testFrame.getjTextPanel().getComponentCount());
        assertFalse("Text Panel not ROOT of the GUI",testFrame.getjTextPanel().isValidateRoot());
        assertTrue("Text Panel is functional",testFrame.getjTextPanel().isEnabled());
    }

    @Test
    public void testGetJTextArea(){
        assertNotNull("The Text Area is functional",testFrame.getjTextArea());
        assertEquals("Text Area contains sub-elements",0,testFrame.getjTextArea().getComponentCount());
        assertNotEquals("Text Area is component of JScrollPane",1,testFrame.getjTextArea().getComponentCount());
        assertFalse("Text Area not ROOT of the GUI",testFrame.getjTextArea().isValidateRoot());
        assertTrue("Text Area is functional",testFrame.getjTextArea().isEnabled());
        assertFalse("Text Area is Not Editable",testFrame.getjTextArea().isEditable());
    }

*//*
    @Test
    public void testSetPopupMenu(){
        JPopupMenu temp = testFrame.getPopupMenu();
        JPopupMenu testPopup = new JPopupMenu("Option Change");
        testFrame.setPopupMenu(testPopup);
        assertNotEquals("The Popup Menu is changed",temp,testFrame.getPopupMenu());
        assertEquals("The Popup Menu is Option change","Option Change",testFrame.getPopupMenu().getLabel());
        assertNotEquals("The Popup Menu is changed",(new JMenuItem("Hello")),testFrame.getPopupMenu());
    }
*/


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