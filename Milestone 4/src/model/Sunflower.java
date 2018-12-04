package model;

/**
 * The Sunflower class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Sunflower Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 *  
 * @author Ryan Gaudreault
 * @version 4.0
 */
public class Sunflower extends Piece {

    private Sunflower(String name, char shortName, int health, int attack, int cost)
    {
        super(name, shortName, health, attack, cost);
    }

    public Sunflower copy() {
        return new Sunflower(getName(), getShortName(), getHealth(), getAttack(), getCost());
    }
	/**
	 * Creates a Sunflower with 5 health, 0 attack damage and 10 cost value.
	 */
    public Sunflower() {
        super("SUNFLOWER",'S',5,0,10);
    }


}
