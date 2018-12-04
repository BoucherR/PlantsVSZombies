package model;


/**
 * The BucketZombie class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a BucketZombie Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A BucketZombie has 5x the health of a typical zombie and 5x its attack damage. 
 * @author Ryan Gaudreault
 * @author Ryan Boucher
 * @version 4.0
 *
 */
public class BucketZombie extends Piece{

	public BucketZombie(String name, char shortName, int health, int attack, int cost)
	{
		super(name, shortName, health, attack, cost);
	}

	public BucketZombie copy() {
		return new BucketZombie(getName(), getShortName(), getHealth(), getAttack(), getCost());
	}

	/**
	 * Creates a BucketZombie with 25 health with 10 attack damage.
	 */
	public BucketZombie() {
		super("BUCKETZOMBIE", 'B', 25, 10, 0);
	}

}
