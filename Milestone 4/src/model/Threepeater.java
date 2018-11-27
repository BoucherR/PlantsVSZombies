package model;

/**
 * The Threepeater class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Threepeater Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A Threepeater triples the attack damage and cost of a typical peashooter while doubling health. 
 * @author RG
 * @author Ryan Boucher
 * @version 4.0
 */
public class Threepeater extends Piece {

	private Threepeater(String name, char shortName, int health, int attack, int cost)
	{
		super(name, shortName, health, attack, cost);
	}

	public Threepeater copy() {
		return new Threepeater(getName(), getShortName(), getHealth(), getAttack(), getCost());
	}

	/**
	 * Creates a Threepeater with 10 health, 6 attack damage, and 60 cost value.
	 */
	public Threepeater() {
		super("THREEPEATER", 'T', 10, 6, 60);
	}

}
