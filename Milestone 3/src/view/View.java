package view;

/**
 * @author Youssef Saghbini
 * @version 1.0
 */


import model.*;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    /**
     *  A JPanel for the buttons to be presented on the GUI
     */
    private JPanel topPanel;

    /**
     *  A JPanel for the JTextArea to be presented on the GUI
     */
    private JPanel bottomPanel;

    /**
     *  A dual-array JButtons to keep record on where the pieces are being placed on the board
     */
    private JButton[][] gameButtons;

    /**
     *  A pop-up menu to allow the user select which plant to place on the board
     */
    private JPopupMenu popupMenu;

    /**
     *  A JTextArea for in-game logs
     */
    private JTextArea textArea;

    /**
     *  A JScrollPane for any excess logs on the JTextArea, allowing the scroll feature
     */
    private JScrollPane jScrollPane;

    /**
     *  A Sunflower option on the pop-up menu
     */
    private JMenuItem sunflower;

    /**
     *  A Peashooter option on the pop-up menu
     */
    private JMenuItem peashooter;

    JLabel sunLabel;
    JLabel sunMoney;
    JMenu redoButton;
    JMenu undoButton;
    JMenuBar menuBar;

    /**
     *  Setting up the GUI using the fields that were chosen
     */
    public View(){

        /*
            Initializing JScroll, JPanel and JTextArea
         */
        textArea = new JTextArea(15,50);
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        jScrollPane = new JScrollPane(textArea);
        sunLabel = new JLabel(new ImageIcon("./src/Images/Sun.png"));
        sunMoney = new JLabel();
        redoButton = new JMenu("Redo");
        undoButton = new JMenu("Undo");
        menuBar = new JMenuBar();

        /*
            Setting up the size of the game board and where the JTextArea,
            JScrollPane and JPanels will be placed on the JFrame
         */
        setSize(1366,768);
        topPanel.setLayout(new GridLayout(5,8));
        bottomPanel.setLayout(new FlowLayout());
        add(topPanel, BorderLayout.CENTER);
        sunLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(sunLabel);
        sunLabel.add(sunMoney);
        bottomPanel.add(jScrollPane);
        add(bottomPanel, BorderLayout.SOUTH);

        menuBar.add(undoButton);
        menuBar.add(redoButton);
        setJMenuBar(menuBar);

        /*
            Initializing all JButtons and organizing them with coordinates.
            The coordinates will be able to aid the program to identify each JButton
            with placement of plants and zombies. Also, adding each button
            to the JPanel and enabling them.
         */
        gameButtons = new JButton[8][5];
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 8;j++){
                gameButtons[j][i] = new JButton(new Coordinate(j,i).name(), new ImageIcon("./src/Images/Grass.png"));
                gameButtons[j][i].setBorderPainted(false);
                topPanel.add(gameButtons[j][i]);

            }
        }

        /*
            Disabling the JTextArea, so user may not be able to edit any logs.
            Adding options to the pop-up menu, also setting up the size of the
            pop-up menu.
         */
        textArea.setEditable(false);
        popupMenu = new JPopupMenu("Select Plant");
        popupMenu.setPopupSize(120,100);
        sunflower = new JMenuItem("Sunflower", new ImageIcon("./src/Images/SunflowerSmall.png"));
        peashooter = new JMenuItem("Peashooter", new ImageIcon("./src/Images/PeashooterSmall.png"));
        popupMenu.add(sunflower);
        popupMenu.add(peashooter);

        /*
            The user will not be able to resize the window the game and allowing the
            JFrame to be visible for the user.
         */
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     *  Getter for the JPanel filled with JButtons
     *  @return JPanel filled with JButtons
     */
    public JPanel getTopPanel() {
        return topPanel;
    }

    /**
     *  Dual-array JButtons that is used to place or remove plants and zombies on the game board
     *  @return Dual-array JButtons of the game board
     */
    public JButton[][] getGameButtons() {
        return gameButtons;
    }

    /**
     *  JPopupMenu shown in every JButton
     *  @return Popup Menu for each JButton
     */
    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    /**
     *  Getting or Creating a Sunflower at the specific point of the game board
     *  @return JMenuItem dedicated for Sunflower
     */
    public JMenuItem getSunflower() {
        return sunflower;
    }

    /**
     *  Getting or Creating a Peashooter at the specific point of the game board
     *  @return JMenuItem dedicated for Peashooter
     */
    public JMenuItem getPeashooter() {
        return peashooter;
    }

    /**
     *  Getting the JTextArea for in-game logging
     *  @return JTextArea for Logging
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    public JLabel getSunMoney(){
        return sunMoney;
    }

    public JMenu getRedoButton() {
        return redoButton;
    }

    public JMenu getUndoButton() {
        return undoButton;
    }
}
