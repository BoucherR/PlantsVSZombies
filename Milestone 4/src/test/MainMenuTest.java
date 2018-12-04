package test;
import org.junit.After;
import view.MainMenu;
import org.junit.Before;


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

    @After
    public void tearDown() {
        if (this.testFrame != null) {
            this.testFrame.dispose(  );
            this.testFrame = null;
        }
    }
}
