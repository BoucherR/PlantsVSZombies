package model;
import org.xml.sax.InputSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * The Game Level class. Used to keep track of game levels, Save and Load the Game Levels when the Game is SAVED/LOADED
 * @author Muneeb Nasir
 * @version
 */
public class GameLevels {

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
    private int maxlevel;

    /**
     * The Money that the player holds
     */
    private int sunMoney;

    public GameLevels(int level,int max,int zlimit,int money){ }

    /**
     * The Game Level Default Constructor
     */
    public GameLevels(){
        currentlevel = 1;
        maxlevel = 5;
        zombieLimit = 5;
        currentZombies = 5;
        sunMoney = 500;
    }

    /**
     * The method is used to restart the levels during the game reset
     */
    public void restartLevels(){
        currentlevel = 1;
        maxlevel = 5;
        zombieLimit = 5;
        sunMoney = 500;
    }

    /**
     * The Setter Method for the player money
     * @param money, The Initial money of the player
     */
    public void setSunMoney(int money) {
        this.sunMoney = money;
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
     * The Getter method for the current level number
     * @return Current Level, The current level number
     */
    public int getLevel() {
        return currentlevel;
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
        zombieLimit +=5;
        sunMoney+=100;
        currentZombies = zombieLimit;
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
            nextLevel();
            System.out.println( "Level No: " +currentlevel + " Next Level reached " + sunMoney);
            return true;
        }
        System.out.println("Zombies: "+currentZombies+" Next Level not reached " + sunMoney);
        return false;
    }

    /**
     * The Method is used check the zombies added with respect to zombies limit for a given level
     * @param count, The current count of the zombies added on the Board
     * @return True, if the count equals the limit for the zombies
     */
    public boolean checkLimit(int count){
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
        return (this.currentlevel >= this.maxlevel);
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
        this.maxlevel = max;
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
        output += "\t" + "<SunMoney>" + sunMoney + "</SunMoney>" + "\n";
        output += "\t" + "<MaxLevel>" + maxlevel + "</MaxLevel>" + "\n";
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
        GameLevels loadGame = new GameLevels();
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

    @Override
    public String toString(){
        return ("Level: "+this.getLevel() + "\n"
                    + "zombies: "+ this.currentZombies+ "\n"+
                        "SunMoney: "+ this.sunMoney);
    }



    public static void main(String[] args) {
        GameLevels test = new GameLevels();
        System.out.println(test.toXML());
        test.setSunMoney(10);
        test.setLevel(4);
        test.saveLevels();
        GameLevels input = test.loadLevels();
        input.toString();

    }
}
