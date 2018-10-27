
/**
 * The PlantPieces enumerated class provides the PlantsVSZombie game with a designated (char) shortName for each PlantPieces type.
 * This enum class includes a PlantPieces(char) constructor that creates the PlantPieces and then designates it's shortName character and includes a getShortName() method. 
 * 
 * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Peashooter, Zombie and Sunflower respectively. 
 * 
 * @author Ryan Gaudreault
 * @version 1.0
 */
public enum PlantPieces {

    SUNFLOWER('S'),
    PEASHOOTER('P'),
    ZOMBIES('Z');

    final char shortName;

    /**
     * A constructor for the class PlantPieces that takes the parameter shortName (char) and then creates the PlantPiece.
     * @param shortName A char associated with the respective PlantPieces. 
     */
    PlantPieces (char shortName){
        this.shortName = shortName;
    }
    
    /**
     * When getShortName() method is called, it returns the character (char) that is associated with the PlantPieces object. 
     * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Peashooter, Zombie and Sunflower respectively. 
     * 
     * @return shortName A char associated with the PlantPieces object. This char is represented on the board as the piece.  					
     */
    public char getShortName(){
        return this.shortName;
    }

}
