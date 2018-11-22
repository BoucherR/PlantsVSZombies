package model;

import Model.Piece;

/**
 * The BucketZombie class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a BucketZombie Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A BucketZombie has 5x the health of a typical zombie and 5x its attack damage. 
 * @author Ryan Gaudreault
 * @version 3.0
 *
 */
public class BucketZombie extends Piece{

	/**
	 * Creates a BucketZombie with 25 health with 10 attack damage.
	 */
	public BucketZombie() {
		super("BUCKETZOMBIE", 'B', 25, 10, 0);
	}

}
