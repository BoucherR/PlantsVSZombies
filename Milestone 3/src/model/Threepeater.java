package model;

/**
 * The Threepeater class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Threepeater Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A Threepeater triples the attack damage and cost of a typical peashooter while doubling health. 
 * @author RG
 * @version 3.0
 */
public class Threepeater extends Piece {

	/**
	 * Creates a Threepeater with 10 health, 6 attack damage, and 60 cost value.
	 */
	public Threepeater() {
		super("THREEPEATER", 'T', 10, 6, 60);
	}

}
