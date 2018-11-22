package model;

/**
 *
 * The Piece class provides the PlantsVSZombie game with the appropriate pieces that populate squares on the game board and perform certain actions that help or hinder the player
 * in their pursuit to win the game. This class includes two constructors, one constructor that will build a Piece given a PlantPiece parameter and another constructor that will build
 * a Piece given a char shortName of a PlantPiece. Additionally, this class includes getter and setters such as a getName(), getShortName(), getCost(), getHealth(), setHealth(),
 * and getAttack(). Piece also includes a toString() method.
 *
 * In version 2.0, Pieces include the "PEASHOOTER", "ZOMBIE" and "SUNFLOWER" PlantPieces name.
 * Each piece includes a (int) cost, (int) health, (int) attack, (char) shortName and (PlantPieces) name.
 *
 * The PEASHOOTER Piece is a friendly offensive entity and can aide the player by damaging ZOMBIE entities that appear on the board.
 * The SUNFLOWER Piece is a friendly non-offensive entity and can aide the player by granting money to the play per turn, which the play can use to buy more friendly entities.
 * The ZOMBIE Piece is an an offensive enemy entity that can move and will attack friendly pieces in its way until it reaches the end of the board, defeating the player.
 *
 * @author Ryan Gaudreault : 100968218
 * @version 2.0
 */

public class Piece {

    private String name;
    private char shortName;
    private int health;
    private int attack;
    private int cost;

    /**
     * A constructor for the class Piece that takes the String name, character shortName, integer health, 
     * integer attack, integer cost of a Piece object and creates it.
     *
     * In version 2.0, this name only includes "PEASHOOTER", "ZOMBIE" and "SUNFLOWER".
     *
     * @param name The name of the Piece in all caps, a string.
     * @param shortName The character of the Piece to be represented on the game board, a char.
     * @param health The health points of the Piece, an int.
     * @param attack The attack points of the Piece that it can afflict on other Pieces, an int.
     * @param cost The cost of purchasing the Piece, an int.
     */
    public Piece(String name, char shortName, int health, int attack, int cost){
        this.name = name;
        this.shortName = shortName;
        this.cost = cost;
        this.health = health;
        this.attack = attack;
    }

    /**
     * When getName() method is called, it returns the PlantPieces object called name, which is a String.
     * In version 2.0, this name only includes "PEASHOOTER", "ZOMBIE" and "SUNFLOWER".
     *
     * @return name Plant string to return which is an enumerated class type.
     */
    public String getName(){
        return this.name;
    }

    /**
     * When getShortName() method is called, it returns the character (char) that is associated with the PlantPieces object.
     * In version 2.0, this char includes 'P', 'Z', 'S' which represents the Peashooter, Zombie and Sunflower respectively.
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
     *
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
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
     * When setAttack() method is called, it changes the value of the PlantPiece attack (int) to a new value.
     * This method is useful for the GameBoard class to change a PlantPiece attack if they are upgraded.
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * When toString() method is called, it returns the string form of the this PlantPieces health to be displayed on the console.
     * This is useful for the player to know what PlantPieces have currently taken damage and how a player should respond.
     *
     * @return String A string representation of the current PlantPiece object health.
     */
    public String toString(){
        switch(name){
            case "PEASHOOTER":
                return "P -> Health: " + this.getHealth();
            case "REPEATER":
            	return "R -> Health: " + this.getHealth();
            case "THREEPEATER":
            	return "T -> Health: " + this.getHealth();
            case "SUNFLOWER":
                return "S -> Health: " + this.getHealth();
            case "TWINSUNFLOWER":
                return "2S -> Health: " + this.getHealth();
            case "GIANTSUNFLOWER":
                return "G -> Health: " + this.getHealth();
            case "WALLNUT":
            	return "W -> Health: " + this.getHealth();
            case "ZOMBIE":
                return "Z -> Health: " + this.getHealth();
            case "CONEHEADZOMBIE":
                return "CZ -> Health: " + this.getHealth();
            case "BUCKETZOMBIE":
                return "BZ -> Health: " + this.getHealth();
            default: throw new IllegalArgumentException("Error: Wrong Piece");
        }
    }

    /**
     * When equals() method is called, it returns a true boolean condition if Object o and this Object are the same piece or have the same values. 
     * This method returns false if Object o is a null value or if it is not a Piece at all.
     * @param o The object to be analyzed.
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null) return false;
        if (!(o instanceof Piece) )
            return false;
        return this.shortName == ((Piece) o).shortName && this.name.equals(((Piece) o).name) && this.health == ((Piece) o).health && this.cost == ((Piece) o).cost && this.attack == ((Piece) o).attack;
    }

}
