package view;

import model.BucketZombie;
import model.ConeheadZombie;
import model.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBuilderView extends JFrame{

    private JPanel options;
    private JButton zombie;
    private JButton coneHeadZombie;
    private JButton bucketHeadZombie;
    private JButton submit;
    private JLabel help;


    private int modeSelection;

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


    public JButton getZombie() {
        return zombie;
    }

    public JButton getConeHeadZombie() {
        return coneHeadZombie;
    }

    public JButton getBucketHeadZombie() {
        return bucketHeadZombie;
    }

    public JButton getSubmit() {
        return submit;
    }

    public int getModeSelection() {
        return modeSelection;
    }


    public void addselectionListener(ActionListener a_Listener) {

        zombie.addActionListener(a_Listener);
        coneHeadZombie.addActionListener(a_Listener);
        bucketHeadZombie.addActionListener(a_Listener);
        submit.addActionListener(a_Listener);
    }

}
