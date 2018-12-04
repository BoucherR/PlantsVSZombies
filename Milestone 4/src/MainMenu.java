import controller.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ryan Gaudreault
 * @version 4.0
 */
public class MainMenu {

    /**
     * A JFrame for the main menu screen to be presented.
     */
    private JFrame mainMenu;

    /**
     * A JButton that makes up the main menu, starts game when pressed.
     */
    private JButton startButton;

    /**
     * Creates a main menu GUI that presents a button that once pressed starts the game.
     */
    public MainMenu() {
        mainMenu = new JFrame("Plants VS. Zombies");
        mainMenu.setSize(1600, 1000);

        startButton = new JButton( new ImageIcon(getClass().getResource("/Images/StartPage.jpg")));
        mainMenu.add(startButton);
        mainMenu.setVisible(true);

        /*
        Creates the game once the button is clicked.
         */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.dispose();
                View view = new View();
                Controller controller = new Controller(view);
                controller.actionListener();
            }
        });
    }
}
