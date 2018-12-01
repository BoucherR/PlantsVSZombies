

# ReadMe
###### Made by Youssef Saghbini

Zombies have landed onto your planet and want to take over the whole world. The only way to defend yourself is to use your plants! Supplied with alien-like plants like sunflowers and peashooters, you will need to act fast and plant fast. For you and your plants are the only ones who can save this world!

## Milestone 3
### Contributions
|Contributors |Effort |
|----------------|-------------------------------|
|Ryan Boucher  | Design Decision Document & Redo/Undo Functionality          |
|Ryan Gaudreault | Sequence Diagram, Added more Plants/Zombies with Unit Testing|
|Muneeb Nasir|UML Diagram, Unit Testing for View, Controller and Models|
|Youssef Saghbini|User Manual, ReadMe, Updated View and  Refactored Classes|

## Files
- Main.java - Start up file for the game to run 
- View.java - The display of the game
- Controller.java - Manipulation of the game with zombieMoves, hitUpdates, etc.
- Square.java - Square Class stores information of the Pieces and Coordinates
- Coordinate.java - The Coordinate class is used to identify the rows and columns of the game
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
- Added more game pieces 
- Changed layout of the gameplay
- Added JMenuBar for Redo/Undo
- Refactored Controller and Model


### Know Issues
- Nothing happens when all squares are filled
- If no more sun points then game can not be continued
- When plant is added on the last column on the right, zombie can't be spawned
- Undos is up to n-1
- Undo/Redos does not affect money

### Future Plans 
- Implement Save/Load Functionality
- Apply Real-Time
- Fix bugs and known issues 
- Add title page to the game
- Update documents








## Milestone 2 - Completed
### Contributions
| Contributors | Ryan Boucher | Ryan Gaudreault | Muneeb Nasir | Youssef Saghbini |
|-|----|----|----|---|
|| Controller | Model | Unit Testing | View |
|| Updated Design Decision Document | Added Plants/Zombie Classes | Generated JUnit Testing | Generated View.java |
|| Modified Gameboard.java into Controller.java | Update Sequence Diagram | Updated UML | Update ReadMe |
|||||Updated User Manual|

### Future Plans and Known Issues
1. Optimize/Refactor Code -> DONE
2. Capture any "Smelly" code -> DONE
3. Add Title Page in the beginning of the game
4. Add Win/Lose Pop-Up when necessary -> DONE
5. Add Redo/Undo Functionality -> DONE
6. Add more Plants/Zombie units -> DONE
7. Up date any documents



## Milestone 1 - Completed
### Contributions
|Contributors |Effort |
|----------------|-------------------------------|
|Ryan Boucher  | Design Decision Document & Main.java          |
|Ryan Gaudreault | Sequence Diagram, Model.PlantPieces.java & Pieces.java|
|Muneeb Nasir|UML, Model.Coordinate.java and Model.Square.java|
|Youssef Saghbini|User Manual & GameBoard.java|

### Future Plans
1. Optimize Code 
2. ~~Up date any documents, if necessary~~
3. ~~GUI-Based Version of this Version~~
4. ~~Tests will be used with JUnit~~
5. ~~Add more to more ReadMe~~






