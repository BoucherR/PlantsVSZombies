package model;

/**
 * The Repeater class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Repeater Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * A Repeater plant doubles the attack damage and cost of a normal peashooter. 
 * @author RG
 * @version 3.0
 */
public class Repeater extends Piece{

	/**
	 * Creates a Repeater with 5 health, 4 attack damage with 40 cost value. 
	 */
	public Repeater() {
		super("REPEATER", 'R', 5, 4, 40);
	}

}
