package model;


/**
 * The Peashooter class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Peashooter Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * @author Ryan Gaudreault
 * @author Ryan Boucher
 * @version 4.0
 */
public class Peashooter extends Piece {

    private Peashooter(String name, char shortName, int health, int attack, int cost)
    {
        super(name, shortName, health, attack, cost);
    }

    public Peashooter copy() {
        return new Peashooter(getName(), getShortName(), getHealth(), getAttack(), getCost());
    }

	/**
	 * Creates a Peashooter with 5 health, 2 attack damage and 20 cost value.
	 */
   public Peashooter() {
        super("PEASHOOTER",'P',5,2,20);
   }


}
