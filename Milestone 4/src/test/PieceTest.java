package test;

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The TEST Class for the Piece
 * @author Muneeb Nasir
 * @version 3.0
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
     * The method is used to establish the Piece Objects that is to be used in the Test cases
     */
    @Before
    public void setUp(){
        testPiece1 = new Sunflower();
        testPiece2 = new Repeater();
        testPiece3 = new Peashooter();
        testPiece4 = new Zombie();
    }

    /**
     * The Test is used to check the Getter Method for Name of the Game Piece
     */
    @Test
    public void testGetName() {
        assertNotNull("The Game Piece is SUNFLOWER",testPiece1);
        assertNotNull("The Game Piece is REPEATER",testPiece2);
        assertNotNull("The Game Piece is PEASHOOTER",testPiece3);
        assertNotNull("The Game Piece is ZOMBIE",testPiece4);

        assertEquals("The Game Piece is SUNFLOWER","SUNFLOWER",testPiece1.getName());
        assertNotEquals("The Game Piece is SUNFLOWER Capitalised","sunflower",testPiece1.getName());

        assertEquals("The Game Piece is REPEATER","REPEATER",testPiece2.getName());
        assertNotEquals("The Game Piece is REPEATER Capitalised","repeater",testPiece2.getName());

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
        assertNotEquals("The Game Piece Short Name is R",' ',testPiece2.getShortName());
        assertNotEquals("The Game Piece Short Name is P",'\u0000',testPiece3.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",' ',testPiece4.getShortName());

        assertEquals("The Game Piece Short Name is S",'S',testPiece1.getShortName());
        assertEquals("The Game Piece Short Name is R",'R',testPiece2.getShortName());
        assertEquals("The Game Piece Short Name is P",'P',testPiece3.getShortName());
        assertEquals("The Game Piece Short Name is Z",'Z',testPiece4.getShortName());

        assertNotEquals("The Game Piece Short Name is S","SP",testPiece1.getShortName());
        assertNotEquals("The Game Piece Short Name is R",'0',testPiece2.getShortName());
        assertNotEquals("The Game Piece Short Name is P",'S',testPiece3.getShortName());
        assertNotEquals("The Game Piece Short Name is Z",'M',testPiece4.getShortName());
    }

    /**
     * The Test is used to check the Getter Method for Cost of the Game Piece
     */
    @Test
    public void testGetCost() {
        assertNotEquals("The Game Piece Cost is 10",0,testPiece1.getCost());
        assertNotEquals("The Game Piece Cost  is 50","0",testPiece2.getCost());
        assertNotEquals("The Game Piece Cost  is 20",0,testPiece3.getCost());
        assertNotEquals("The Game Piece Cost  is 0",-1,testPiece4.getCost());
        assertNotEquals("The Game Piece Cost  is 0",'$',testPiece4.getCost());

        assertEquals("The Game Piece Cost is 10",10,testPiece1.getCost());
        assertEquals("The Game Piece Cost  is 40",40,testPiece2.getCost());
        assertEquals("The Game Piece Cost  is 20",20,testPiece3.getCost());
        assertEquals("The Game Piece Cost  is 0",0,testPiece4.getCost());

        assertNotEquals("The Game Piece Cost is 10","100",testPiece1.getCost());
        assertNotEquals("The Game Piece Cost  is 50","000",testPiece2.getCost());
        assertNotEquals("The Game Piece Cost  is 20","202",testPiece3.getCost());
        assertNotEquals("The Game Piece Cost  is 0",Integer.toString(0),testPiece4.getCost());
    }

    /**
     * The Test is used to check the Getter Method for Health of the Game Piece
     */
    @Test
    public void testGetHealth() {
        assertNotEquals("The SunFlower Health is 5",-1,testPiece1.getHealth());
        assertNotEquals("The Repeater Health is 5",0,testPiece2.getHealth());
        assertNotEquals("The PeaShooter Health  is 5",-1,testPiece3.getHealth());
        assertNotEquals("The Zombie Health is 10",-1,testPiece4.getHealth());

        assertEquals("The SunFlower Health is 5",5,testPiece1.getHealth());
        assertEquals("The Repeater Health  is 5",5,testPiece2.getHealth());
        assertEquals("The PeaShooter Health is 5",5,testPiece3.getHealth());
        assertEquals("The Zombie Health is 5",5,testPiece4.getHealth());

        assertNotEquals("The SunFlower Health is 5","5",testPiece1.getHealth());
        assertNotEquals("The Repeater Health  is 5",1010,testPiece2.getHealth());
        assertNotEquals("The PeaShooter Health is 5","223",testPiece3.getHealth());
        assertNotEquals("The Zombie Health is 10",'1',testPiece4.getHealth());
    }

    /**
     * The Test is used to check the Getter Method for Attack Feature of the Game Piece
     */
    @Test
    public void testGetAttack() {
        assertNotEquals("The SunFlower Attack Power is 0",'0',testPiece1.getAttack());
        assertNotEquals("The Repeater Attack Power is 4",-2,testPiece2.getAttack());
        assertNotEquals("The PeaShooter Attack Power  is 2",-1,testPiece3.getAttack());
        assertNotEquals("The Zombie Attack Power is 2",-3,testPiece4.getAttack());

        assertEquals("The SunFlower Attack Power is 0",0,testPiece1.getAttack());
        assertEquals("The Repeater Attack Power is 4",4,testPiece2.getAttack());
        assertEquals("The PeaShooter Attack Power is 2",2,testPiece3.getAttack());
        assertEquals("The Zombie Health  Attack Power 2",2,testPiece4.getAttack());

        assertNotEquals("The SunFlower Attack Power is 0","0",testPiece1.getAttack());
        assertNotEquals("The Repeater Attack Power is 4",'4',testPiece2.getAttack());
        assertNotEquals("The PeaShooter Attack Power is 2","002",testPiece3.getAttack());
        assertNotEquals("The Zombie Health  Attack Power 10",(float) 10,testPiece4.getAttack());
    }

    /**
     * The Test is used to check the Setter Method for the Game Piece Cost
     */
    @Test
    public void testSetCost() {
        testPiece1.setCost(30);
        testPiece3.setCost(25);

        assertEquals("The SunFlower Cost is 30",30,testPiece1.getCost());
        assertEquals("The repeater Cost is 40",40,testPiece2.getCost());
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
        assertNotEquals("The Repeater Health is now 7",5,testPiece2.getHealth());
        assertEquals("The Zombie Health is now 7",7,testPiece2.getHealth());

        assertNotEquals("The Repeater Health is now 7",5,testPiece2.getHealth());
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
        assertNotEquals("The Repeater Health attack power now 3",2,testPiece2.getAttack());
        assertEquals("The Zombie Health attack power now 3",3,testPiece2.getAttack());

        assertNotEquals("The Repeater attack power is now 7",2,testPiece2.getAttack());
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
        assertEquals("Incomplete Game Piece Information","R -> Health: 5",testPiece2.toString());
        assertEquals("Incomplete Game Piece Information","P -> Health: 5",testPiece3.toString());
        assertEquals("Incomplete Game Piece Information","Z -> Health: 5",testPiece4.toString());

        assertNotEquals("Incomplete Game Piece Information","S -> lth: 5",testPiece1.toString());
        assertNotEquals("Incomplete Game Piece Information","Health: 1q",testPiece2.toString());
        assertNotEquals("Incomplete Game Piece Information","P -> 10",testPiece3.toString());
        assertNotEquals("Incomplete Game Piece Information","Z -> H:: 10",testPiece4.toString());
    }

    /**
     * The EQUALS method is used to compare two coordinate objects field by field
     */
    @Test
    public void testEquals(){
        assertEquals("Game Piece entry matches", testPiece1, new Sunflower());
        assertNotEquals("Game Piece: SUNFLOWER", testPiece1, new Zombie());
        assertNotEquals("Coordinate entry not NULL", null, testPiece1);
        assertNotEquals("The Object should not be Game Piece", testPiece1, new Square(new Coordinate(2, 3)));

        assertEquals("Game Piece entry matches", testPiece2, new Repeater());
        assertNotEquals("Game Piece entry not NULL", null, testPiece2);
        assertNotEquals("Game Piece: ZOMBIE",testPiece2.equals(new Peashooter()));
        assertNotEquals("The Object should not be Game Piece",new Zombie().equals(testPiece2));

        assertTrue("Game Piece entry matches",testPiece3.equals(new Peashooter()));
        assertNotEquals("Game Piece entry not NULL", null, testPiece3);
        assertNotEquals("Game Piece: PEASHOOTER",true, new Threepeater().equals(testPiece3));
        assertNotEquals("The Object should not be Game Piece",true,new Zombie().equals(testPiece3));

        assertTrue("Game Piece entry matches",testPiece4.equals(new Zombie()));
        assertNotEquals("Game Piece entry not NULL", null, testPiece4);
        assertNotEquals("Game Piece: ZOMBIE",true,new Wallnut().equals(testPiece4));
        assertNotEquals("The Object should not be Game Piece",true,new BucketZombie().equals(testPiece4));
    }

    /**
     * The Test Case to check the Getter method for the Image Icon of the Game Pieces
     */
    /*
    @Test
    public void testGetImage(){
        assertNotEquals("The Image Path is complete",getClass().getResource("/Images/"),testPiece1.getImage());
        assertEquals("The Image Path is complete",getClass().getResource("/Images/sunflower.png").toString(),testPiece1.getImage().toString());
        assertNotNull("The Image File Path is correct",testPiece2.getImage());
        assertEquals("The Image Path is complete",getClass().getResource("/Images/repeater.png").toString(),testPiece2.getImage().toString());
        assertEquals("The Image Path is complete",getClass().getResource("/Images/peashooter.png").toString(),testPiece3.getImage().toString());
        assertNotEquals("The Image Path is complete",getClass().getResource("/peashooter.png"),testPiece3.getImage().toString());
        assertEquals("The Image Path is complete",getClass().getResource("/Images/zombie.png").toString(),testPiece4.getImage().toString());
        assertNotEquals("The Image Path is complete",getClass().getResource("/zombie"),testPiece4.getImage().toString());
    }
    */
}