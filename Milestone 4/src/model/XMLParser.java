package model;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The Game Level XML File Parser. This Class is used to Retrieve the date from the XML File
 * and load the most recently saved game Accordingly
 * @author Muneeb Nasir
 * @version
 */
public class XMLParser extends DefaultHandler {

    /**
     * The GameLevels XML is created during the import of the Data from the file
     */
    private GameLevels outputLoad = new GameLevels(0,0,0,0);

    /**
     * The Stack is used to keep track of the child elements values of the XML File
     */
    private Stack<String> childElements = new Stack<String>();

    /**
     * The Object stack is used to keep track of the elements stored inside the XML File
     */
    private Stack<GameLevels> gameObjects = new Stack<GameLevels>();

    /**
     * The Object stack is used to keep track of the elements stored inside the XML File
     */
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    /**
     * Booleans are used to keep track of the data influx from the XML File and output accordingly.
     * Booleans used for the proper Import of Data
     */
    private boolean level = false;
    private boolean zombieCount = false;
    private boolean sunMoney = false;
    private boolean maxLevel = false;
    private boolean zombieLimit = false;
    private boolean zombieRemaining = false;
    private boolean zombieType1 = false;
    private boolean zombieType2 = false;
    private boolean zombieType3 = false;
    private boolean gameMode = false;

    /**
     * The Getter Method for the constructed Game Level
     * @return GameLevels, The Generated GameLevel File Loaded
     */
    public GameLevels getGameFile(){
        return outputLoad;
    }

    public ArrayList<Piece> getPieces(){
        return pieces;
    }
    /**
     * The Getter Method for the current element values in the Stack
     * @return
     */
    private String currentElement() {
        return childElements.peek();
    }


    /**
     * To mark the start of the document. Receive notification of the beginning of the document.
     */
    public void startDocument(){
        System.out.println("Start of the Game Level File" + "\n");
    }

    /**
     * To mark the end of the document. Receive notification of the end of the document.
     */
    public void endDocument(){
        System.out.println("End of the Game Level File" + "\n");
    }


    /**
     * The Receive notification of the start of an element. Overrides the Default Handler Method
     * @param uri, The Namespace URI, In this case empty String
     * @param localName,  The local name (without prefix), In this case empty String
     * @param qName, The qualified name (with prefix) in the XML Element
     * @param attributes, The attributes attached to the element.
     * @throws SAXException, Basic error or warning information from the XML parser
     */
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {
        childElements.push(qName);
        System.out.println("Start Element: " + qName);
        if (qName.equalsIgnoreCase("GameLevels")) {
        } else if (qName.equalsIgnoreCase("Level")) {
            level = true;
        } else if (qName.equalsIgnoreCase("ZombieCount")) {
            zombieCount = true;
        } else if (qName.equalsIgnoreCase("ZombieLimit")) {
            zombieLimit = true;
        }else if (qName.equalsIgnoreCase("ZombiesSpawned")) {
            zombieRemaining = true;
        }else if (qName.equalsIgnoreCase("SimpleZombie")) {
            zombieType1 = true;
        }else if (qName.equalsIgnoreCase("BucketZombie")) {
            zombieType2 = true;
        }else if (qName.equalsIgnoreCase("ConeHeadZombie")) {
            zombieType3 = true;
        }  else if (qName.equalsIgnoreCase("SunMoney")) {
            sunMoney = true;
        }  else if (qName.equalsIgnoreCase("DeveloperMode")) {
            gameMode = true;
        }else if (qName.equalsIgnoreCase("MaxLevel")) {
            maxLevel = true;
        }
    }

    /**
     * Receive notification of the end of an element.
     * @param uri, The Namespace URI, In this case empty String
     * @param localName,  The local name (without prefix), In this case empty String
     * @param qName, The qualified name (with prefix) in the XML Element
     * @throws SAXException, Basic error or warning information from the XML parser
     */
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        childElements.pop();
        if (qName.equalsIgnoreCase("GameLevels")) {
            System.out.println("End Element: " + qName + "\n");
        }
    }

    /**
     * Receive notification of character data inside an element.
     * @param ch, The characters in the String
     * @param start, The start position in the character array.
     * @param length, The number of characters to use from the character array.
     * @throws SAXException, Basic error or warning information from the XML parser
     */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (value.length() == 0) {
            return;
        }
        if("Level".equals(currentElement())){
            outputLoad.setLevel(Integer.valueOf(value));
        }else if("ZombieCount".equals(currentElement())){
            outputLoad.setCurrentZombies(Integer.valueOf(value));
        }else if("ZombieLimit".equals(currentElement())) {
            outputLoad.setZombieLimit(Integer.valueOf(value));
        }else if("ZombiesSpawned".equals(currentElement())) {
            outputLoad.setZombiesSpawned(Integer.valueOf(value));
        }else if(("SimpleZombie").equals(currentElement())){
            outputLoad.setSimpleZombiePiece(Boolean.parseBoolean(value));
            if(Boolean.parseBoolean(value)){
                pieces.add(new Zombie());
            }
        }else if(("BucketZombie").equals(currentElement())){
            outputLoad.setBucketZombiePiece(Boolean.parseBoolean(value));
            if(Boolean.parseBoolean(value)){
                pieces.add(new BucketZombie());
            }
        }else if(("ConeHeadZombie").equals(currentElement())){
            outputLoad.setConeHeadPiece(Boolean.parseBoolean(value));
            if(Boolean.parseBoolean(value)){
                pieces.add(new ConeheadZombie());
            }
        } else if("SunMoney".equals(currentElement())){
            outputLoad.setSunMoney(Integer.valueOf(value));
        }else if("DeveloperMode".equals(currentElement())){
            outputLoad.setBuilderSelection(Boolean.parseBoolean(value));
        }else if("MaxLevel".equals(currentElement())){
            outputLoad.setMaxLevel(Integer.valueOf(value));
        }

        /*Used to Print the Loaded Data*/
        if (level) {
            System.out.println("Level: "
                    + new String(ch, start, length));
            level = false;
        } else if (zombieCount) {
            System.out.println("Zombie Count: " + new String(ch, start, length));
            zombieCount = false;
        }else if (zombieLimit) {
            System.out.println("Zombie Limit: " + new String(ch, start, length));
            zombieLimit = false;
        }else if (zombieRemaining) {
            System.out.println("Zombies Spawned: " + new String(ch, start, length));
            zombieRemaining = false;
        }else if(zombieType1){
            System.out.println("Simple Zombie: " + new String(ch, start, length));
            zombieType1 = false;
        }else if(zombieType2){
            System.out.println("Bucket Zombie: " + new String(ch, start, length));
            zombieType2 = false;
        }else if(zombieType3){
            System.out.println("Cone Head Zombie: " + new String(ch, start, length));
            zombieType3 = false;
        } else if (sunMoney) {
            System.out.println("SunMoney: $" + new String(ch, start, length));
            sunMoney = false;
        }else if(gameMode){
            System.out.println("Developer Mode: " + new String(ch, start, length));
            gameMode = false;
        } else if (maxLevel) {
            System.out.println("Game Max Level: " + new String(ch, start, length));
            maxLevel = false;
        }
    }

}
