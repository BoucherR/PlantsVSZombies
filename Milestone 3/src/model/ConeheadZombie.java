package model;

/**
 * The ConeheadZombie class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a ConeheadZombie Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A ConeheadZombie doubles the health and attack damage of a typical zombie. 
 * @author RG
 * @author Ryan Boucher
 * @version 4.0
 *
 */
public class ConeheadZombie extends Piece{

	private ConeheadZombie(String name, char shortName, int health, int attack, int cost)
	{
		super(name, shortName, health, attack, cost);
	}

	public ConeheadZombie copy() {
		return new ConeheadZombie(getName(), getShortName(), getHealth(), getAttack(), getCost());
	}

	/**
	 * Creates a ConeheadZombie with 10 health and 4 attack damage.
	 */
	public ConeheadZombie() {
		super("CONEHEADZOMBIE", 'C', 10, 4, 0);
	}

}
