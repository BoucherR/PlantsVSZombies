package model;

/**
 * The Zombie class provides the PlantsVSZombie game with a single Piece type that
 * once called can create a Zombie Piece in of itself. This class only contains a
 * constructor and simplifies the Piece class code. It uses its super class Piece to 
 * create a new object and passes it's designated parameters. 
 * 
 * @author Ryan Gaudreault
 * @author Ryan Boucher
 * @version 4.0
 */
public class Zombie extends Piece {

	/**
	 * Creates a Zombie with 5 health, 2 attack damage and 0 cost value.
	 */
    public Zombie() {
        super("ZOMBIE",'Z',5,2,0);
    }

    private Zombie(String name, char shortName, int health, int attack, int cost)
    {
        super(name, shortName, health, attack, cost);
    }

    public Zombie copy() {
        return new Zombie(getName(), getShortName(), getHealth(), getAttack(), getCost());
    }

}
