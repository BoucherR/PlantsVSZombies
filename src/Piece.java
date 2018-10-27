/**
 * 
 * The Piece class provides the PlantsVSZombie game with the appropriate pieces that populate squares on the game board and perform certain actions that help or hinder the player
 * in their pursuit to win the game. This class includes two constructors, one constructor that will build a Piece given a PlantPiece parameter and another constructor that will build
 * a Piece given a char shortName of a PlantPiece. Additionally, this class includes getter and setters such as a getName(), getShortName(), getCost(), getHealth(), setHealth(),
 * and getAttack(). Piece also includes a toString() method. 
 * 
 * In version 1.0, Pieces include the "PEASHOOTER", "ZOMBIE" and "SUNFLOWER" PlantPieces name.
 * Each piece includes a (int) cost, (int) health, (int) attack, (char) shortName and (PlantPieces) name.
 * 
 * The PEASHOOTER Piece is a friendly offensive entity and can aide the player by damaging ZOMBIE entities that appear on the board. 
 * The SUNFLOWER Piece is a friendly non-offensive entity and can aide the player by granting money to the play per turn, which the play can use to buy more friendly entities. 
 * The ZOMBIE Piece is an an offensive enemy entity that can move and will attack friendly pieces in its way until it reaches the end of the board, defeating the player. 
 * 
 * @author Ryan Gaudreault : 100968218
 * @version 1.0
 */

public class Piece {

    private PlantPieces name;
    private char shortName;
    private int health;
    private int attack;
    private int cost;

    /**
     * A constructor for the class Piece that takes the parameter name (PlantPieces) and then creates the Piece. 
     * This constructor also sets the default cost, health, attack and shortName of the Piece. 
     * 
     * In version 1.0, this name only includes "PEASHOOTER", "ZOMBIE" and "SUNFLOWER".
     * 
     * @param name PlantPieces object which is an enumerated class type.
     */
    public Piece(PlantPieces name){
        switch(name){
        	//This is the PEASHOOTER Piece, it is a friendly offensive entity represented on the board by a 'P'.
            case PEASHOOTER: 
                this.name = name.PEASHOOTER;
                this.shortName = 'P';
                this.cost = 20;
                this.health = 5;
                this.attack = 2;
                break;
            //This is the SUNFLOWER Piece, it is a friendly non-offensive entity represented on the board by a 'S'.
            case SUNFLOWER: 
                this.name = name.SUNFLOWER;
                this.shortName = 'S';
                this.cost = 10;
                this.health = 5;
                this.attack = 0;
                break;
            //This is the ZOMBIE Piece, it is an offensive enemy entity represented on the board by a 'Z'.
            case ZOMBIES:
                this.name = name.ZOMBIES;
                this.shortName = 'Z';
                this.cost = 0;
                this.health = 5;
                this.attack = 2;
                break;
        }
    }

    /**
     * A constructor for the class Piece that takes the parameter shortName (char) and then creates the Piece.
     * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Peashooter, Zombie and Sunflower respectively. 
     * 
     * @param shortName A char short form representing the PlantPiece type. 
     */
    public Piece(char shortName){
        switch (shortName){
            case 'S':
                this.name = name.PEASHOOTER;
                break;
            case 'F':
                this.name = name.SUNFLOWER;
                break;
            case 'Z':
                this.name = name.ZOMBIES;
                break;
        }
    }

    /**
     * When getName() method is called, it returns the PlantPieces object called name, which is an enumerated type.
     * In version 1.0, this name only includes "PEASHOOTER", "ZOMBIE" and "SUNFLOWER".
     * 
     * @return name PlantPieces object to return which is an enumerated class type.
     */
    public PlantPieces getName(){
        return this.name;
    }

    /**
     * When getShortName() method is called, it returns the character (char) that is associated with the PlantPieces object. 
     * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Peashooter, Zombie and Sunflower respectively. 
     * 
     * @return shortName A char associated with the PlantPieces object. This char is represented on the board as the piece.  					
     */
    public char getShortName(){
        return this.shortName;
    }

    /**
     * When getCost() method is called, it returns an integer (int) of how much the PlantPiece costs to place on the board. 
     * This cost is then deducted from the players moneyPouch in the GameBoard class. 
     * This method only pertains to the friendly entities on the board that the player can manipulate such as the "PEASHOOTER" 
     * and the "SUNFLOWER". The PlantPiece "ZOMBIE" doesn't include a cost due to the fact that it is not a friendly entity and 
     * therefore is not bought or placed by the player. 
     * 
     * @return cost An int of the price of each friendly PlantPiece that can be placed on the board. 
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * When getHealth() method is called, it returns an integer (int) of how much health the PlantPiece currently has on the board. 
     * Every piece starts off on the board with full health, regardless of it being friendly or an enemy. 
     * As a piece takes damage, the health of the piece will fall, as it reaches zero the PlantPiece is removed from the board,
     * aka killed. This method is useful for the GameBoard class to know whether a PlantPiece on the board is still alive and what pieces have taken damage. 
     * 
     * Depending on the PlantPiece type, they will start off with a different starting health. 
     * 
     * @return health An int of the current health of each PlantPiece has on the board. 
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * When setHealth() method is called, it changes the value of the PlantPiece health (int) to a new value, one that has taken damage.
     * This method is useful for the GameBoard class to change a PlantPiece health if they take damage, if health is set to zero or below,
     * the PlantPiece is removed from the board aka 'killed'. 
     * 
     * @param health An int of the current health after damage has been taken to the PlantPiece. 
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * When getAttack() method is called, it returns the attack damage (int) that the PlantPiece can execute. 
     * When an offensive PlantPiece object, like a "ZOMBIE" or a "PERSHOOTER" executes an attack on its quarry,
     * the victim will have its health reduced by that of the amount of the attack damage.
     * 
     * @return attack An int of the attack damage that an offensive PlantPiece can execute on its target. 
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * When toString() method is called, it returns the string form of the this PlantPieces health to be displayed on the console.
     * This is useful for the player to know what PlantPieces have currently taken damage and how a player should respond. 
     * 
     * @return String A string representation of the current PlantPiece object health. 
     */
    public String toString(){
        switch(name){
            case PEASHOOTER:
                return "P -> Health: " + this.getHealth();
            case SUNFLOWER:
                return "S -> Health: " + this.getHealth();
            case ZOMBIES:
                return "Z -> Health: " + this.getHealth();
                default: throw new IllegalArgumentException("Error: Wrong Piece");
        }
    }

}
