package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Class is used to provide Game Builder Options
 * @author Muneeb Nasir
 * @version 4.0
 */
public class GameBuilderView extends JFrame{

    /**
     * The Panel that holds the Game Buttons
     */
    private JPanel options;

    /**
     * The Game Buttons that is used for the selection of the zombies
     */
    private JButton zombie;
    private JButton coneHeadZombie;
    private JButton bucketHeadZombie;
    private JButton submit;

    /**
     * The Command Selections
     */
    private int modeSelection;

    /**
     * The Constructor of the Game Level Builder GUI
     */
    public GameBuilderView() {
        setTitle("Zombie Selection: Please select desired zombies and click complete build");
        options = new JPanel();

        zombie = new JButton();
        zombie.setIcon(new ImageIcon(getClass().getResource("/Images/zombie.png")));
        zombie.setContentAreaFilled(false);
        bucketHeadZombie = new JButton(new ImageIcon(getClass().getResource("/Images/bucketzombie.png")));
        bucketHeadZombie.setContentAreaFilled(false);
        coneHeadZombie = new JButton(new ImageIcon(getClass().getResource("/Images/coneheadzombie.png")));
        coneHeadZombie.setContentAreaFilled(false);
        submit = new JButton("Complete Build");


        options.add(zombie);
        options.add(bucketHeadZombie);
        options.add(coneHeadZombie);
        options.add(submit);
        options.setLayout(new GridLayout(1,4));

        setSize(760, 138);
        setResizable(false);
        add(options);
        setVisible(true);
    }


    /**
     * The Getter Method for the
     * @return
     */
    public JButton getZombie() {
        return zombie;
    }

    /**
     * The Getter Method for the Cone Head Zombie
     * @return JButton, The JButton provided for the selection
     */
    public JButton getConeHeadZombie() {
        return coneHeadZombie;
    }

    /**
     * The Getter Method for the Bucket Head Zombie
     * @return JButton, The JButton provided for the selection
     */
    public JButton getBucketHeadZombie() {
        return bucketHeadZombie;
    }

    /**
     * The Getter Method for the Submit Button
     * @return JButton, The JButton provided for the completing submission
     */
    public JButton getSubmit() {
        return submit;
    }

    /**
     * The Getter Method for the Command Selection
     * @return command, the selection of the Mode
     */
    public int getModeSelection() {
        return modeSelection;
    }

    /**
     * The method to add Action Listener
     * @param a_Listener, The Action Listener
     */
    public void addselectionListener(ActionListener a_Listener) {

        zombie.addActionListener(a_Listener);
        coneHeadZombie.addActionListener(a_Listener);
        bucketHeadZombie.addActionListener(a_Listener);
        submit.addActionListener(a_Listener);
    }

}
