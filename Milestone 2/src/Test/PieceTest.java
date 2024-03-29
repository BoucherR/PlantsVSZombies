package Test;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The TEST Class for the Piece
 * @author Muneeb Nasir
 * @version 2.0
 */

public class PieceTest {

    /**
     * The Piece Objects used for the Test Cases
     */
    private Piece testPiece1;
    private Piece testPiece2;
    private Piece testPiece3;
    private Piece testPiece4;

    /**
     * The method is used to establish the Piece Objects that is to be used in the test cases
     */
    @Before
    public void setUp(){
        testPiece1 = new Sunflower();
        testPiece2 = new Zombie();
        testPiece3 = new Peashooter();
        testPiece4 = new Piece("ZOMBIE",'Z',10,10,0);
    }

    /**
     * The Test is used to check the Getter Method for Name of the Game Piece
     */
    @Test
    public void testGetName() {
        assertNotNull("The Game Piece Short Name is SUNFLOWER",testPiece1.getName());
        assertNotNull("The Game Piece is ZOMBIE",testPiece2.getName());
        assertNotNull("The Game Piece is PEASHOOTER",testPiece3.getName());
        assertNotNull("The Game Piece is ZOMBIE",testPiece4.getName());

        assertEquals("The Game Piece is SUNFLOWER","SUNFLOWER",testPiece1.getName());
        assertNotEquals("The Game Piece is SUNFLOWER Capitalised","sunflower",testPiece1.getName());

        assertEquals("The Game Piece is ZOMBIE","ZOMBIE",testPiece2.getName());
        assertNotEquals("The Game Piece is ZOMBIE Capitalised","zombie",testPiece2.getName());

        assertEquals("The Game Piece is PEASHOOTER","PEASHOOTER",testPiece3.getName());
        assertNotEquals("The Game Piece is PEASHOOTER Capitalised","peashooter",testPiece2.getName());

        assertEquals("The Game Piece is ZOMBIE","ZOMBIE",testPiece4.getName());

    }

    /**
     * The Test is used to check the Getter Method for SHORT Name of the Game Piece
     */
    @Test
    public void testGetShortName() {
        assertNotEquals("The Game Piece Short Name is S",' ',testPiece1.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",' ',testPiece2.getShortName());
        assertNotEquals("The Game Piece Short Name is P",'\u0000',testPiece3.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",' ',testPiece4.getShortName());

        assertEquals("The Game Piece Short Name is S",'S',testPiece1.getShortName());
        assertEquals("The Game Piece Short Name is Z",'Z',testPiece2.getShortName());
        assertEquals("The Game Piece Short Name is P",'P',testPiece3.getShortName());
        assertEquals("The Game Piece Short Name is Z",'Z',testPiece4.getShortName());

        assertNotEquals("The Game Piece Short Name is S","SP",testPiece1.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",'0',testPiece2.getShortName());
        assertNotEquals("The Game Piece Short Name is P",'S',testPiece3.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",'M',testPiece4.getShortName());
    }

    /**
     * The Test is used to check the Getter Method for Cost of the Game Piece
     */
    @Test
    public void testGetCost() {
        assertNotEquals("The Game Piece Cost is 10",0,testPiece1.getCost());
        assertNotEquals("The Game Piece Cost  is 0","0",testPiece2.getCost());
        assertNotEquals("The Game Piece Cost  is 20",0,testPiece3.getCost());
        assertNotEquals("The Game Piece Cost  is 0",-1,testPiece4.getCost());
        assertNotEquals("The Game Piece Cost  is 0",'$',testPiece4.getCost());

        assertEquals("The Game Piece Cost is 10",10,testPiece1.getCost());
        assertEquals("The Game Piece Cost  is 0",0,testPiece2.getCost());
        assertEquals("The Game Piece Cost  is 20",20,testPiece3.getCost());
        assertEquals("The Game Piece Cost  is 0",0,testPiece4.getCost());

        assertNotEquals("The Game Piece Cost is 10","100",testPiece1.getCost());
        assertNotEquals("The Game Piece Cost  is 0","000",testPiece2.getCost());
        assertNotEquals("The Game Piece Cost  is 20","202",testPiece3.getCost());
        assertNotEquals("The Game Piece Cost  is 0",Integer.toString(0),testPiece4.getCost());
    }

    /**
     * The Test is used to check the Getter Method for Health of the Game Piece
     */
    @Test
    public void testGetHealth() {
        assertNotEquals("The SunFlower Health is 5",-1,testPiece1.getHealth());
        assertNotEquals("The Zombie Health is 5",0,testPiece2.getHealth());
        assertNotEquals("The PeaShooter Health  is 5",-5,testPiece3.getHealth());
        assertNotEquals("The Zombie Health is 10",-10,testPiece4.getHealth());

        assertEquals("The SunFlower Health is 5",5,testPiece1.getHealth());
        assertEquals("The Zombie Health  is 5",5,testPiece2.getHealth());
        assertEquals("The PeaShooter Health is 5",5,testPiece3.getHealth());
        assertEquals("The Zombie Health is 10",10,testPiece4.getHealth());

        assertNotEquals("The SunFlower Health is 5","5",testPiece1.getHealth());
        assertNotEquals("The Zombie Health  is 5",1010,testPiece2.getHealth());
        assertNotEquals("The PeaShooter Health is 5","223",testPiece3.getHealth());
        assertNotEquals("The Zombie Health is 10",'1',testPiece4.getHealth());
    }

    /**
     * The Test is used to check the Getter Method for Attack Feature of the Game Piece
     */
    @Test
    public void testGetAttack() {
        assertNotEquals("The SunFlower Attack Power is 0",'0',testPiece1.getAttack());
        assertNotEquals("The Zombie Attack Power is 2",-2,testPiece2.getAttack());
        assertNotEquals("The PeaShooter Attack Power  is 2",-1,testPiece3.getAttack());
        assertNotEquals("The Zombie Attack Power is 2",-3,testPiece4.getAttack());

        assertEquals("The SunFlower Attack Power is 0",0,testPiece1.getAttack());
        assertEquals("The Zombie Attack Power is 2",2,testPiece2.getAttack());
        assertEquals("The PeaShooter Attack Power is 2",2,testPiece3.getAttack());
        assertEquals("The Zombie Health  Attack Power 10",10,testPiece4.getAttack());

        assertNotEquals("The SunFlower Attack Power is 0","0",testPiece1.getAttack());
        assertNotEquals("The Zombie Attack Power is 2",'2',testPiece2.getAttack());
        assertNotEquals("The PeaShooter Attack Power is 2","002",testPiece3.getAttack());
        assertNotEquals("The Zombie Health  Attack Power 10", "1",testPiece4.getAttack());
    }

    /**
     * The Test is used to check the Setter Method for the Game Piece Cost
     */
    @Test
    public void testSetCost() {
        testPiece1.setCost(30);
        testPiece3.setCost(25);

        assertEquals("The SunFlower Cost is 30",30,testPiece1.getCost());
        assertEquals("The Zombie Cost is 0",0,testPiece2.getCost());
        assertEquals("The PeaShooter Cost is 25",25,testPiece3.getCost());
        assertEquals("The Zombie Cost is 0",0,testPiece4.getCost());

        assertNotEquals("The SunFlower Cost is 30","030",testPiece1.getCost());
        assertNotEquals("The Zombie Cost is 0",'0',testPiece2.getCost());
        assertNotEquals("The PeaShooter Cost is 25","02502",testPiece3.getCost());
        assertNotEquals("The Zombie Cost is 0","00100",testPiece4.getCost());
    }

    /**
     * The Test is used to check the Setter Method for the Health of the Game Piece
     */
    @Test
    public void testSetHealth() {
        testPiece1.setHealth(10);
        testPiece2.setHealth(7);
        testPiece3.setHealth(7);
        testPiece4.setHealth(10);

        assertEquals("The SunFlower Health is now 10",10,testPiece1.getHealth());
        assertNotEquals("The Zombie Health is now 7",5,testPiece2.getHealth());
        assertEquals("The Zombie Health is now 7",7,testPiece2.getHealth());

        assertNotEquals("The PeaShooter Health is now 7",5,testPiece2.getHealth());
        assertEquals("The PeaShooter Health is now 7",7,testPiece3.getHealth());
        assertEquals("The Zombie Health is now 10",10,testPiece4.getHealth());

        assertNotEquals("The PeaShooter Health is now 7",70,testPiece2.getHealth());
        assertNotEquals("The Zombie Health is now 10","(10)",testPiece4.getHealth());
    }

    /**
     * The Test is used to check the Setter Method for the Attack Feature of the Game Piece
     */
    @Test
    public void testSetAttack() {
        testPiece2.setAttack(3);
        testPiece3.setAttack(7);
        testPiece4.setAttack(12);

        assertEquals("The SunFlower has no attack Power",0,testPiece1.getAttack());
        assertNotEquals("The Zombie Health attack power now 3",2,testPiece2.getAttack());
        assertEquals("The Zombie Health attack power now 3",3,testPiece2.getAttack());

        assertNotEquals("The PeaShooter attack power is now 7",2,testPiece2.getAttack());
        assertEquals("The PeaShooter attack power is now 7",7,testPiece3.getAttack());

        assertNotEquals("The Zombie Bomber attack power now 12",10,testPiece2.getAttack());
        assertEquals("The Zombie Bomber Health is now 12",12,testPiece4.getAttack());
    }

    /**
     * The Test is used to check the toString() Method and the String Output showing the information of the
     * Game Piece
     */
    @Test
    public void testToString() {
        assertNotNull("Incomplete Game Piece Information",testPiece1.toString());
        assertNotNull("Incomplete Game Piece Information",testPiece2.toString());
        assertNotNull("Incomplete Game Piece Information",testPiece3.toString());
        assertNotNull("Incomplete Game Piece Information",testPiece4.toString());

        assertEquals("Incomplete Game Piece Information","S -> Health: 5",testPiece1.toString());
        assertEquals("Incomplete Game Piece Information","Z -> Health: 5",testPiece2.toString());
        assertEquals("Incomplete Game Piece Information","P -> Health: 5",testPiece3.toString());
        assertEquals("Incomplete Game Piece Information","Z -> Health: 10",testPiece4.toString());

        assertNotEquals("Incomplete Game Piece Information","S ->  5",testPiece1.toString());
        assertNotEquals("Incomplete Game Piece Information","Health: 1",testPiece2.toString());
        assertNotEquals("Incomplete Game Piece Information","P -> 10",testPiece3.toString());
        assertNotEquals("Incomplete Game Piece Information","Z -> H:: 10",testPiece4.toString());
    }

    /**
     * The EQUALS method is used to compare two coordinate objects field by field
     */
    @Test
    public void testEquals(){
        assertEquals("Game Piece entry doesn't match", testPiece1, new Sunflower());
        assertNotEquals("Game Piece: SUNFLOWER", testPiece1, new Piece("SUNFLOWER", 'S', 0, 2, 0));
        assertNotEquals("Coordinate entry not NULL", null, testPiece1);
        assertNotEquals("The Object should not be Game Piece", testPiece1, new Square(new Coordinate(2, 3)));

        assertEquals("Game Piece entry doesn't match", testPiece2, new Piece("ZOMBIE", 'Z', 5, 2, 0));
        assertNotEquals("Game Piece entry not NULL", null, testPiece2);
        assertNotEquals("Game Piece: ZOMBIE",testPiece2.equals(new Piece("Bomber",'B',5,5,0)));
        assertNotEquals("The Object should not be Game Piece",new Piece("NBomber",'T',5,5,0).equals(testPiece2));

        assertTrue("Game Piece entry doesn't match",testPiece3.equals(new Peashooter()));
        assertNotEquals("Game Piece entry not NULL", null, testPiece3);
        assertNotEquals("Game Piece: PEASHOOTER",true, new Piece("PS",'S',10,0,0).equals(testPiece3));
        assertNotEquals("The Object should not be Game Piece",true,new Zombie().equals(testPiece3));

        assertTrue("Game Piece entry doesn't match",testPiece4.equals(new Piece("ZOMBIE",'Z',10,10,0)));
        assertNotEquals("Game Piece entry not NULL", null, testPiece4);
        assertNotEquals("Game Piece: ZOMBIE",true,new Piece("Zombie Killer",'E',0,10,5).equals(testPiece4));
        assertNotEquals("The Object should not be Game Piece",true,new Piece("ZOM",'K',10,10,0).equals(testPiece4));
    }
}