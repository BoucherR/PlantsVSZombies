package model;

/**
 * The GiantSunflower class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a GiantSunflower Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * The GiantSunflower triples the amount of a signle sunflower piece and triples the health. 
 * 
 * @author RG
 * @version 3.0
 *
 */
public class GiantSunflower extends Piece {

	/**
	 * Creates a Giantsunflower with 15 health with 60 cost value.
	 */
	public GiantSunflower() {
		super("GIANTSUNFLOWER", 'G', 15, 0, 60);
	}

}
