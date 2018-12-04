import controller.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    public MainMenu() {
        JFrame mainMenu = new JFrame("Plants VS. Zombies");
        mainMenu.setSize(1600, 1000);

        JButton startButton = new JButton( new ImageIcon(getClass().getResource("/Images/StartPage.jpg")));
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
