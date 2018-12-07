package view;

import controller.*;
import model.GameLevels;

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
    private JMenuBar option;
    private JMenuItem gameBuilder;


    /**
     * Creates a main menu GUI that presents a button that once pressed starts the game.
     */
    public MainMenu() {
        setTitle("Plants VS. Zombies");
        setSize(1580, 970);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startButton = new JButton( new ImageIcon(getClass().getResource("/Images/StartPage.jpg")));
        option = new JMenuBar();
        gameBuilder = new JMenuItem("Game Developer Mode");
        option.add(gameBuilder);
        setJMenuBar(option);
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
                GameLevels levels = new GameLevels(1,5,500,5);
                Controller controller = new Controller(view,levels);
                controller.actionListener();
            }
        });

         /*
        Creates the game once the button is clicked.
         */
        gameBuilder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameBuilderView developerView = new GameBuilderView();
                GameLevels levelsBuilder = new GameLevels(developerView);
            }
        });
    }

    /**
     * Getting the JButton for starting the game in MainMenu
     * @return JButton for start
     */
    public JButton getStartButton(){ return startButton; }
}
