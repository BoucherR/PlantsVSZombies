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

    private int zombieLimit;
    private int currentZombies;
    private int currentlevel;
    private int maxlevel;
    private int sunMoney;


    public GameLevels(){
        currentlevel = 1;
        maxlevel = 5;
        zombieLimit = 5;
        currentZombies = 5;
    }

    public void restartLevels(){
        currentlevel = 1;
        maxlevel = 5;
        zombieLimit = 5;
    }

    public void setSunMoney(int money) {
        this.sunMoney = money;
    }

    public void nextLevel(){
        currentlevel++;
        zombieLimit +=5;
        sunMoney+=100;
        currentZombies = zombieLimit;
    }

    public void checkZombieLimit(){
        zombieLimit--;
    }

    public void zombieKilled(){
        currentZombies--;
    }

    public boolean checkAllZombiesDead(){
        if(this.currentZombies==0)
        {
            nextLevel();
            System.out.println(currentlevel + "Next Level reached" + sunMoney);
            return true;
        }
        System.out.println(currentZombies+"Next Level not reached" + sunMoney);
        return false;
    }

    public int getCurrentZombies() {
        return currentZombies;
    }

    public boolean checkLimit(int count){
        return (zombieLimit == count);
    }

    public void setZombieLimit(int zombieLimit) {
        this.zombieLimit = zombieLimit;
    }

    public int getLevel() {
        return currentlevel;
    }

    public boolean maxLevel(){return (this.currentlevel == this.maxlevel);}

    public void setLevel(int level) {
        this.currentlevel = level;
    }

    public void setMaxLevel(int level) {
        this.currentlevel = level;
    }

    public void setMoney(int money){this.sunMoney = money; }

    public String toXML() {
        String output = "";
        output += "<GameLevels>" + "\n";
        output += "\t" + "<Level>" + currentlevel + "</Level>" + "\n";
        output += "\t" + "<ZombieCount>" + currentZombies + "</ZombieCount>" + "\n";
        output += "\t" + "<SunMoney>" + sunMoney + "</SunMoney>" + "\n";
        output += "\t" + "<MaxLevel>" + maxlevel + "</MaxLevel>" + "\n";
        output += "</GameLevels>";
        return output;
    }


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



    public static void main(String[] args) {
        GameLevels test = new GameLevels();
        System.out.println(test.toXML());
        test.saveLevels();
        GameLevels input = test.loadLevels();
    }
}
