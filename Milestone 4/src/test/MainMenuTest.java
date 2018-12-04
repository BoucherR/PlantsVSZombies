package test;
import view.MainMenu;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * The Test Class for the Main menu Class (Responsible for starting the game)
 * @author Ryan Gaudreault
 * @version 4.0
 */
public class MainMenuTest {
    /**
     * The GUI MainMenu Object that is used for the TEST CASES
     */
    private MainMenu testFrame;

    /**
     * Used to initialize and establish the Main menu
     */
    @Before
    public void setUp(){
        testFrame = new MainMenu();
    }

    /**
     * The Test is used to check the Getter Method for the Save Button
     */
    @Test
    public void testGetStartButton(){
        assertTrue("The Save Menu Item is functional command",testFrame.getStartButton().isEnabled());

    }

    @After
    public void tearDown() {
        if (this.testFrame != null) {
            this.testFrame.dispose(  );
            this.testFrame = null;
        }
    }
}
