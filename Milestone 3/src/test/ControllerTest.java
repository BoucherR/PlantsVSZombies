package test;
import controller.*;
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
        assertNotNull(testController);
        guiView.getGameButtons()[1][1].setIcon(new ImageIcon(getClass().getResource("/Images/Peashooter.png")));
        while (true);
        //assertNotNull(guiView.getGameButtons()[0][1].getIcon());
    }


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