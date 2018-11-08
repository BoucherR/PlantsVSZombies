package Model;

/**
 * The Model.PlantPieces enumerated class provides the PlantsVSZombie game with a designated (char) shortName for each Model.PlantPieces type.
 * This enum class includes a Model.PlantPieces(char) constructor that creates the Model.PlantPieces and then designates it's shortName character and includes a getShortName() method.
 * 
 * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Model.Peashooter, Model.Zombie and Model.Sunflower respectively.
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
     * A constructor for the class Model.PlantPieces that takes the parameter shortName (char) and then creates the PlantPiece.
     * @param shortName A char associated with the respective Model.PlantPieces.
     */
    PlantPieces (char shortName){
        this.shortName = shortName;
    }
    
    /**
     * When getShortName() method is called, it returns the character (char) that is associated with the Model.PlantPieces object.
     * In version 1.0, this char includes 'P', 'Z', 'S' which represents the Model.Peashooter, Model.Zombie and Model.Sunflower respectively.
     * 
     * @return shortName A char associated with the Model.PlantPieces object. This char is represented on the board as the piece.
     */
    public char getShortName(){
        return this.shortName;
    }

}
