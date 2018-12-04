package view;

import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ryan Gaudreault
 * @version 4.0
 */
public class MainMenu extends JFrame{


    /**
     * A JButton that makes up the main menu, starts game when pressed.
     */
    private JButton startButton;

    /**
     * Creates a main menu GUI that presents a button that once pressed starts the game.
     */
    public MainMenu() {
        setTitle("Plants VS. Zombies");
        setSize(1600, 970);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startButton = new JButton( new ImageIcon(getClass().getResource("/Images/StartPage.jpg")));
        add(startButton);
        setVisible(true);

        /*
        Creates the game once the button is clicked.
         */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                View view = new View();
                Controller controller = new Controller(view);
                controller.actionListener();
            }
        });
    }

    /**
     * Getting the JButton for starting the game in MainMenu
     * @return JButton for start
     */
    public JButton getStartButton(){ return startButton; }
}
