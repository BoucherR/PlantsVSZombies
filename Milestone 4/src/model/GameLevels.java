package model;
import controller.Controller;
import org.xml.sax.InputSource;
import model.Coordinate;
import view.GameBuilderView;
import view.View;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * The Game Level class. Used to keep track of game levels, Save and Load the Game Levels when the Game is SAVED/LOADED
 * @author Muneeb Nasir
 * @version 4.0
 */
public class GameLevels implements Serializable{

    /**
     * The Maximum numbers of the zombies for a given level
     */
    private int zombieLimit;

    /**
     * The Current numbers of the zombies for a given level
     */
    private int currentZombies;

    /**
     * The Current Level of the Game
     */
    private int currentlevel;

    /**
     * The Maximum Level for the entire game
     */
    private int maxLevelWave;

    /**
     * The is used to keep track of the zombies that had been spawned prior to save command (For Load/Save Functionality)
     */
    private int zombiesSpawned;

    private GameBuilderView builderView;

    /**
     * The Game Level Builder option selection
     */
     private boolean builderSelection;

     private ArrayList<Piece> data;

    private boolean simpleZombiePiece;

     private boolean coneHeadPiece;

     private boolean bucketZombiePiece;

     private boolean userSelection;

    private String gameMode;


    /**
     * The Money that the player holds
     */
    private int sunMoney;


    /**
     * The Game Level Default Constructor
     */
    public GameLevels(GameBuilderView selection){
        builderView = selection;

        builderSelection = false;


        if(selection.getModeSelection() == JOptionPane.YES_OPTION){
            currentlevel = 1;
            maxLevelWave = 1;
            data = new ArrayList<Piece>();
            sunMoney = 500;
            builderSelection = true;
            simpleZombiePiece = false;
            coneHeadPiece = false;
            bucketZombiePiece = false;
            gameMode = "Developer Mode";
            addListener();
            GameLevelBuilder();
            //MaximumLevelBuild();
        }
        else if(selection.getModeSelection() == JOptionPane.NO_OPTION) {
            currentlevel = 1;
            maxLevelWave = 5;
            zombieLimit = 5;
            zombiesSpawned = 0;
            currentZombies = zombieLimit;
            gameMode = "Campaign Mode";
            sunMoney = 500;
            JOptionPane.showMessageDialog(null,"Developer Mode not selected, Default Game Level Settings installed");
            //System.out.println(builderSelection);
        }

    }


    public GameLevels(int level, int maxWave, int initialBank, int limit){
        currentlevel = level;
        maxLevelWave = maxWave;
        zombieLimit = limit;
        zombiesSpawned = 0;
        currentZombies = zombieLimit;
        sunMoney = initialBank;
        builderSelection = false;
    }


    private void GameLevelBuilder(){
        boolean correct = false;
        String optionLevelZombie = JOptionPane.showInputDialog("Enter Zombie Limit for the Wave");
        if(!(optionLevelZombie == null)) {
            while (!correct) {
                if (optionLevelZombie.length() == 1 && Character.getNumericValue(optionLevelZombie.charAt(0)) > 0) {
                    zombiesSpawned = 0;
                    correct = true;
                    zombieLimit = Character.getNumericValue(optionLevelZombie.charAt(0));
                    currentZombies = zombieLimit;
                    System.out.println(currentZombies);

                } else if (optionLevelZombie.length() == 2 &&
                        Character.getNumericValue(optionLevelZombie.charAt(0)) > 0 &&
                        (Integer.valueOf(String.valueOf(optionLevelZombie.charAt(0)) + String.valueOf(optionLevelZombie.charAt(1)))) < 50) {
                    zombiesSpawned = 0;
                    correct = true;
                    zombieLimit = Integer.valueOf(optionLevelZombie);
                    currentZombies = zombieLimit;
                    System.out.println(currentZombies);

                } else {
                    String optionZombiesCorrect = JOptionPane.showInputDialog("Invalid Entry, Zombie Limit must be between 1-50: ");
                    correct = false;
                    optionLevelZombie = optionZombiesCorrect;
                }
            }
        }

    }

    private void MaximumLevelBuild() {
        boolean inputCorrect = false;
        String optionMaxLevel = JOptionPane.showInputDialog("Enter Maximum Level Limit for the Game");
        if (!(optionMaxLevel == null)) {
            while (!inputCorrect) {
                if (optionMaxLevel.length() == 1 && Character.getNumericValue(optionMaxLevel.charAt(0)) > 0
                        && Character.getNumericValue(optionMaxLevel.charAt(0)) < 5) {
                    inputCorrect = true;
                    maxLevelWave = Character.getNumericValue(optionMaxLevel.charAt(0));
                } else {
                    String optionZombiesCorrect = JOptionPane.showInputDialog("Invalid Entry, Level Limit must be between 1-5: ");
                    inputCorrect = false;
                    optionMaxLevel = optionZombiesCorrect;
                }
            }
        }else {
            JOptionPane.showMessageDialog(null,"No Selection Made, Developer Mode Turned Off");
            builderView.dispose();
        }
    }

    private void addListener(){
        builderView.addselectionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Object action_M;
                action_M = event.getSource();
                if (action_M instanceof JButton) {
                    if (action_M == builderView.getZombie()) {
                        data.add(new Zombie());
                    } else if (action_M == builderView.getBucketHeadZombie()) {
                        data.add(new BucketZombie());
                    } else if (action_M == builderView.getConeHeadZombie()) {
                        data.add((new ConeheadZombie()));
                    } else if(action_M == builderView.getSubmit()){
                        if(data.isEmpty())
                        {
                            JOptionPane.showMessageDialog(null,"No Selection Made. Please Select Zombies");
                        }
                        else{
                            builderView.dispose();
                            callGame();
                        }
                    }
                }
            }
        });

    }

    public void callGame(){
        View view = new View();
        Controller controller = new Controller(view,this);
        controller.actionListener();
    }


    public ArrayList<Piece> placeSelectedZombies() {
            return data;
    }


    /**
     * The method is used to restart the levels during the game reset
     */
    public void restartLevels(){
        if(!builderSelection)
        {
            currentlevel = 1;
            maxLevelWave = 5;
            zombieLimit = 5;
            sunMoney = 500;
            currentZombies = zombieLimit;
            zombiesSpawned = 0;
        }
        System.out.println(builderSelection);
        System.out.println(currentZombies+"\n");
        System.out.println(zombieLimit+"\n");
    }

    /**
     * The Setter Method for the player money
     * @param money, The Initial money of the player
     */
    public void setSunMoney(int money) {
        this.sunMoney = money;
    }

    /**
     * The Method is used for loading the most recent value of zombies spawned
     * @param num, The zombies spawn count
     */
    public void setZombiesSpawned(int num){
        zombiesSpawned =num;
    }

    /**
     * The Number of zombies that were spawned before the save operation
     * @return zombiesSpawned,  The Zombies Spawn count
     */
    public int getZombiesSpawned(){
        return zombiesSpawned;
    }

    /**
     * The Getter method for the SunMoney
     * @return Money, The Money account of the Player
     */
    public int getMoney(){
        return this.sunMoney;
    }

    /**
     * The Getter method for the current number of zombies
     * @return currentZombies, The current number of zombies in the level
     */
    public int getCurrentZombies() {
        return currentZombies;
    }

    /**
     * The Setter method for getting the current level zombie Limit
     */
    public void setZombieLimit(int number){
        zombieLimit = number;
    }

    /**
     * The Getter method for the current level number
     * @return Current Level, The current level number
     */
    public int getLevel() {
        return currentlevel;
    }

    public boolean getMode(){
        return builderSelection;
    }

    /**
     * The Method is used to add the money earned by the player
     * @param grant, The amount of money the player has earned
     */
    public void earnedMoney(int grant){
        sunMoney+=grant;
    }

    /**
     * The Method is used to take the player to the next level and it is also used to
     * grant the money to the user
     */
    private void nextLevel(){
        currentlevel++;
        if(!builderSelection){
            if(currentlevel <= maxLevelWave){
                zombieLimit +=5;
                sunMoney+=100;
                currentZombies = zombieLimit;
                JOptionPane.showMessageDialog(null, "Next Level Reached");
            }
            else
            {
                currentZombies = 0;
                zombieLimit = 0;
            }
        }
    }

    /**
     * The Method is used to Buy a Game Piece
     * @param price, The cost of the Game Piece
     */
    public void buyPiece(int price){
        sunMoney-=price;
    }

    /**
     * The Method is used to subtract the current number of zombies when a zombie is killed
     */
    public void zombieKilled(){
        currentZombies--;
    }

    /**
     * The Method is used to check if next level is reached and check if current number of zombies are ZERO
     * @return True, if next level is reached, else false
     */
    public boolean checkAllZombiesDead(){
        if(this.currentZombies==0)
        {
            if(maxLevel()){
                JOptionPane.showMessageDialog(null, "All Zombies Defeated");
                return true;
            }
            currentZombies = 0;
            nextLevel();
            System.out.println( "Level No: " +currentlevel + " Next Level reached. User Money: " + sunMoney);
            return true;
        }
        return false;
    }

    public boolean getUserSelection(){
        return userSelection;
    }

    /**
     * The Method is used check the zombies added with respect to zombies limit for a given level
     * @param count, The current count of the zombies added on the Board
     * @return True, if the count equals the limit for the zombies
     */
    public boolean checkLimit(int count){
        System.out.println(zombieLimit);
        return (zombieLimit == count);
    }

    /**
     * The Setter Method for the current number of zombies
     * @param zombiesAlive, The current number of zombies alive in the level
     */
    public void setCurrentZombies(int zombiesAlive) {
        this.currentZombies = zombiesAlive;
    }

    /**
     * The method is used to check if the user has finished the maximum level
     * @return True, if the user has played all the levels
     */
    public boolean maxLevel(){
        return (this.currentlevel > this.maxLevelWave);
    }

    /**
     * The Setter method for the current level
     * @param level, The level number to be specified
     */
    public void setLevel(int level) {
        this.currentlevel = level;
    }

    /**
     * The Setter method for the Maximum Game level
     * @param max, The Maximum Level
     */
    public void setMaxLevel(int max) {
        this.maxLevelWave = max;
    }


    public void setSimpleZombiePiece(boolean simpleZombiePiece) {
        this.simpleZombiePiece = simpleZombiePiece;
    }

    public void setConeHeadPiece(boolean coneHeadPiece) {
        this.coneHeadPiece = coneHeadPiece;
    }

    public void setBucketZombiePiece(boolean bucketZombiePiece) {
        this.bucketZombiePiece = bucketZombiePiece;
    }

    /**
     * The Method is used to convert the Game Level Data to XML Format
     * @return XML Format of the Game Levels
     */
    private String toXML() {
        String output = "";
        output += "<GameLevels>" + "\n";
        output += "\t" + "<Level>" + currentlevel + "</Level>" + "\n";
        output += "\t" + "<ZombieCount>" + currentZombies + "</ZombieCount>" + "\n";
        output += "\t" + "<ZombieLimit>" + zombieLimit  + "</ZombieLimit>" + "\n";
        output += "\t" + "<ZombiesSpawned>" + zombiesSpawned + "</ZombiesSpawned>" + "\n";
        output += "\t" + "<SimpleZombie>" + simpleZombiePiece + "</SimpleZombie>" + "\n";
        output += "\t" + "<BucketZombie>" + bucketZombiePiece + "</BucketZombie>" + "\n";
        output += "\t" + "<ConeHeadZombie>" + coneHeadPiece + "</ConeHeadZombie>" + "\n";
        output += "\t" + "<SunMoney>" + sunMoney + "</SunMoney>" + "\n";
        output += "\t" + "<Mode>" + gameMode + "</Mode>" + "\n";
        output += "\t" + "<MaxLevel>" + maxLevelWave + "</MaxLevel>" + "\n";
        output += "</GameLevels>";
        return output;
    }

    /**
     * The Method used to save the current Game Level Data
     */
    public void saveLevels(){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("GameLevelFile.xml"));
        }catch (IOException ERR){ }
        try {
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
            out.write(toXML());
        } catch (IOException t) {
            t.printStackTrace();
        }
        try {
            out.close();
        }catch (IOException ERR){}

    }

    /**
     * The Method is used to Load the Game Level Data
     * @return The Game Level that is to be loaded back
     */
    public GameLevels loadLevels(){
        GameLevels loadGame = new GameLevels(0,0,0,0);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLParser userhandler = new XMLParser();
            File inputFile = new File("GameLevelFile.xml");
            InputStream inputStream = new FileInputStream(inputFile);
            Reader readerData = new InputStreamReader(inputStream,"UTF-8");
            InputSource inSource = new InputSource(readerData);
            inSource.setEncoding("UTF-8");
            saxParser.parse(inSource, userhandler);
            loadGame = userhandler.getGameFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadGame;
    }

    /**
     * To String Method for the Game Level Class
     * @return String, The Game Level Data in a String Format
     */
    @Override
    public String toString(){
        return ("Level: "+this.getLevel() + "\n"
                    + "zombies: "+ this.currentZombies+ "\n"+
                        "SunMoney: "+ this.sunMoney);
    }





    public static void main(String[] args) {
        //GameLevels test = new GameLevels();
        //System.out.println(test.toXML());

    }


}
