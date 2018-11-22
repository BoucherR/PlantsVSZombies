package model;

/**
 * The Sunflower class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Sunflower Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 *  
 * @author RG
 * @version 2.0
 */
public class Sunflower extends Piece {

	/**
	 * Creates a Sunflower with 5 health, 0 attack damage and 10 cost value.
	 */
    public Sunflower() {
        super("SUNFLOWER",'S',5,0,10);
    }


}
