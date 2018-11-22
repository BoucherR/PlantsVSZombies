package model;

/**
 * The ConeheadZombie class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a ConeheadZombie Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A ConeheadZombie doubles the health and attack damage of a typical zombie. 
 * @author RG
 * @version 3.0
 *
 */
public class ConeheadZombie extends Piece{

	/**
	 * Creates a ConeheadZombie with 10 health and 4 attack damage.
	 */
	public ConeheadZombie() {
		super("CONEHEADZOMBIE", 'C', 10, 4, 0);
	}

}
