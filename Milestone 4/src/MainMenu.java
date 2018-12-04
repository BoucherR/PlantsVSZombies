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
     *
     */
    private JFrame mainMenu;

    /**
     *
     */
    private JButton startButton;

    /**
     *
     */
    public MainMenu() {
        mainMenu = new JFrame("Plants VS. Zombies");
        mainMenu.setSize(1600, 1000);

        startButton = new JButton( new ImageIcon(getClass().getResource("/Images/StartPage.jpg")));
        mainMenu.add(startButton);
        mainMenu.setVisible(true);

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
