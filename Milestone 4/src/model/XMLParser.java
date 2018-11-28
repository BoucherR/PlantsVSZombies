package model;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
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
    private GameLevels outputLoad = new GameLevels();

    /**
     * The Stack is used to keep track of the child elements values of the XML File
     */
    private Stack<String> childElements = new Stack<String>();

    /**
     * The Object stack is used to keep track of the elements stored inside the XML File
     */
    private Stack<GameLevels> gameObjects = new Stack<GameLevels>();

    /**
     * Booleans are used to keep track of the data influx from the XML File and output accordingly
     */
    private boolean level = false;
    private boolean zombieCount = false;
    private boolean sunMoney = false;
    private boolean maxLevel = false;

    /**
     * The Getter Method for the constructed Game Level
     * @return GameLevels, The Generated GameLevel File Loaded
     */
    public GameLevels getGameFile(){
        return outputLoad;
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
            GameLevels budTemp = new GameLevels();
            gameObjects.push(budTemp);
        } else if (qName.equalsIgnoreCase("Level")) {
            level = true;
        } else if (qName.equalsIgnoreCase("ZombieCount")) {
            zombieCount = true;
        } else if (qName.equalsIgnoreCase("SunMoney")) {
            sunMoney = true;
        }
        else if (qName.equalsIgnoreCase("MaxLevel")) {
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
            GameLevels level = gameObjects.peek();
            level.setLevel(Integer.valueOf(value));
        }else if("ZombieCount".equals(currentElement())){
            GameLevels level = gameObjects.peek();
            level.setZombieLimit(Integer.valueOf(value));
        }else if("SunMoney".equals(currentElement())){
            GameLevels level = gameObjects.peek();
            level.setSunMoney(Integer.valueOf(value));
        }else if("MaxLevel".equals(currentElement())){
            GameLevels level = gameObjects.peek();
            level.setMaxLevel(Integer.valueOf(value));
        }
        if (level) {
            System.out.println("Level: "
                    + new String(ch, start, length));
            level = false;
        } else if (zombieCount) {
            System.out.println("Zombie Count: " + new String(ch, start, length));
            zombieCount = false;
        } else if (sunMoney) {
            System.out.println("SunMoney: $" + new String(ch, start, length));
            sunMoney = false;
        } else if (maxLevel) {
            System.out.println("Game Max Level: " + new String(ch, start, length));
            maxLevel = false;
        }
    }

}
