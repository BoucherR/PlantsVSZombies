

# ReadMe
###### Made by Youssef Saghbini

Zombies have landed onto your planet and want to take over the whole world. The only way to defend yourself is to use your plants! Supplied with alien-like plants like sunflowers and peashooters, you will need to act fast and plant fast. For you and your plants are the only ones who can save this world!

## Milestone 4
### Contributions
|Contributors |Effort |
|----------------|-------------------------------|
|Ryan Boucher  | Design Decision Document, Real-Time Add-on & Refined Redo/Undo           |
|Ryan Gaudreault | Sequence Diagram, Refactored code, Added comments & Added Menu page|
|Muneeb Nasir|UML Diagram, Refined Unit Testing & Added Level Builder|
|Youssef Saghbini|User Manual, ReadMe & Added Save/Load Functionality|

## Files
- Main.java - Start up file for the game to run 
- MainMenu.java - Title page of the game
- View.java - The display of the game
- Controller.java - Manipulation of the game with zombieMoves, hitUpdates, etc.
- Square.java - Square Class stores information of the Pieces and Coordinates
- Coordinate.java - The Coordinate class is used to identify the rows and columns of the game
- GameLevels.java - The game level builder that implements different levels of the game
- XMLParser.java - Used to convert a XML file from a saved file onto the game
- Piece.java - Super class for each plant and zombie in the game
	- Plants
		- PEASHOOTER Piece is an offensive plant 
		-  REPEATER Piece is an offensive plant, stronger than the PEASHOOTER
		- THREEPEATER Piece is an offensive plant, stronger than the REPEATER
		- SUNFLOWER Piece is a non-offensive plant piece that can aide the player by granting money to the play per turn
		- TWINSUNFLOWER Piece is a non-offensive plant and can aide the player by granting money to the play per turn, more money than the SUNFLOWER
		- GIANTSUNFLOWER Piece is a friendly non-offensive entity and can aide the player by granting money to the play per turn, more money than the TWINSUNFLOWER
	- Zombies
		- ZOMBIE Piece is an offensive enemy that can move and will attack plants pieces in its way until it reaches the end of the board, defeating the player
		- The CONEHEADZOMBIE is an offensive enemy, stronger than the ZOMBIE
		- The BUCKETZOMBIE Piece is an offensive enemy, stronger than the CONEHEADZOMBIE  
- Testing Package - Contains all JUnit Testing for Model, View and Controller

## User Changes
- Added Save/Load functionality using Serialize
- Refined Undo/Redo functionality
- Added Game Level save using XML
- Added Menu page
- Refactored code
- Added more comments


### Know Issues

### Future Plans 
- Enjoy the game
