package model;

/**
 * The TwinSunFlower class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a TwinSunFlower Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A TwinSunFlower doubles the health and sun output of a sunflower while tripling its price. 
 * @author RG
 * @version 3.0
 *
 */
public class TwinSunflower extends Piece {

	/**
	 * Creates a TwinSunFlower with 10 health, and 30 cost value.
	 */
	public TwinSunflower() {
		super("TWINSUNFLOWER", '2', 10, 0, 30);
	}

}
