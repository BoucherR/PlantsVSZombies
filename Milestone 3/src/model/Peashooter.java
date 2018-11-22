package model;


/**
 * The Peashooter class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Peashooter Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * @author RG
 * @version 3.0
 */
public class Peashooter extends Piece {

	/**
	 * Creates a Peashooter with 5 health, 2 attack damage and 20 cost value.
	 */
   public Peashooter() {
        super("PEASHOOTER",'P',5,2,20);
   }


}
