package model;

import Model.Piece;

/**
 * The Wallnut class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Wallnut Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters.
 * 
 * The Wallnut class doesn't attack but has alot of health. Essentially to slow down hostiles.
 * @author RG
 * @version 3.0
 * 
 */
public class Wallnut extends Piece{

	/**
	 * Creates a Wallnut with 30 health and 50 cost value.
	 */
	public Wallnut() {
		super("WALLNUT", 'W', 30, 0, 50);
	}

}
