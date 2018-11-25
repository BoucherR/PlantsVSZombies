package model;

/**
 * The TwinSunFlower class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a TwinSunFlower Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A TwinSunFlower doubles the health and sun output of a sunflower while tripling its price. 
 * @author RG
 * @author Ryan Boucher
 * @version 4.0
 *
 */
public class TwinSunflower extends Piece {

	private TwinSunflower(String name, char shortName, int health, int attack, int cost)
	{
		super(name, shortName, health, attack, cost);
	}

	public TwinSunflower copy() {
		return new TwinSunflower(getName(), getShortName(), getHealth(), getAttack(), getCost());
	}

	/**
	 * Creates a TwinSunFlower with 10 health, and 30 cost value.
	 */
	public TwinSunflower() {
		super("TWINSUNFLOWER", '2', 10, 0, 30);
	}

}
