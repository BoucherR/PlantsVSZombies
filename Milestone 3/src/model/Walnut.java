package model;

/**
 * The Walnut class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Walnut Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters.
 * 
 * The Walnut class doesn't attack but has alot of health. Essentially to slow down hostiles.
 * @author RG
 * @author Ryan Boucher
 * @version 4.0
 * 
 */
public class Walnut extends Piece{

	private Walnut(String name, char shortName, int health, int attack, int cost)
	{
		super(name, shortName, health, attack, cost);
	}

	public Walnut copy() {
		return new Walnut(getName(), getShortName(), getHealth(), getAttack(), getCost());
	}

	/**
	 * Creates a Walnut with 30 health and 50 cost value.
	 */
	public Walnut() {
		super("WALNUT", 'W', 30, 0, 50);
	}

}
