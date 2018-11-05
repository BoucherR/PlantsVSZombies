/**
 * @author Ryan Boucher
 * @version 1.1
 */

import java.util.Scanner;

public class Main {

    //Fields
    private GameBoard gb;

    //Methods

    /**
     * To be run at the start of Main. Starts the game with a ascii splashcreen, and allows for the user to start a
     * new game
     */
    public void initialize() {

        System.out.println("Welcome to ...");

        System.out.println(
                ".______   __          ___     .__   __..___________.   _______. ____    ____  _______.  ________   ______  .___  ___..______   __  _______ \n" +
                        "|   _  \\ |  |        /   \\    |  \\ |  ||           |  /       | \\   \\  /   / /       | |       /  /  __  \\ |   \\/   ||   _  \\ |  ||   ____|\n" +
                        "|  |_)  ||  |       /  ^  \\   |   \\|  |`---|  |----` |   (----`  \\   \\/   / |   (----` `---/  /  |  |  |  ||  \\  /  ||  |_)  ||  ||  |__   \n" +
                        "|   ___/ |  |      /  /_\\  \\  |  . `  |    |  |       \\   \\       \\      /   \\   \\        /  /   |  |  |  ||  |\\/|  ||   _  < |  ||   __|  \n" +
                        "|  |     |  `----./  _____  \\ |  |\\   |    |  |   .----)   |       \\    /.----)   |      /  /----|  `--'  ||  |  |  ||  |_)  ||  ||  |____ \n" +
                        "| _|     |_______/__/     \\__\\|__| \\__|    |__|   |_______/         \\__/ |_______/      /________|\\______/ |__|  |__||______/ |__||_______|\n");

        System.out.println("Please select the following: ");
        System.out.println("    Press 1 to start a new game.");
        System.out.println("    Press any other key to exit.");
        System.out.print("Your selection: ");

        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        switch (entry) {
            case 1:
                Main main = new Main();
                main.startGame();
                break;
            default:
                System.exit(0);
        }
    }

    /**
     * Logic of the game turns. Allows for the user to input commands for a turn, and will run continuously until
     * case 4 is reached, ending the game.
     */
    public void startGame(){
        gb = new GameBoard();
        System.out.println("New game generated: \n" + gb.toString());
        while(true){
            System.out.println("Please select the following: ");
            System.out.println("    1. Add Peashooter.");
            System.out.println("    2. Add Sunflower.");
            System.out.println("    3. Skip the Round.");
            System.out.println("    4. Exit the Game.");
            System.out.print("Your selection: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch (choice){
                case "1":
                    System.out.println("Where would you like to add a Peashooter? \n Format: [Column][Row] e.g 13 ");
                    System.out.print("Your selection: ");
                    String choice2 = scanner.next();
                    if(choice2.length() == 2) {
                        if (((choice2.charAt(0) - 48 >= 0) && (choice2.charAt(0) - 48 < 8)) && ((choice2.charAt(1) - 48 >= 0) && (choice2.charAt(1) - 48 < 5))) {
                            if(gb.add(new Coordinate(choice2.charAt(0) - 48, choice2.charAt(1) - 48), new Piece(PlantPieces.PEASHOOTER)))
                                runGame(gb);
                        }
                    }
                    else System.out.println("Error: Wrong input. Please try again.");
                    break;
                case "2":
                    System.out.println("Where would you like to add a Sunflower? \n Format: [Column][Row] -> 13 ");
                    System.out.print("Your selection: ");
                    String choice3 = scanner.next();
                    if(choice3.length() == 2) {
                        if (((choice3.charAt(0) - 48 >= 0) && (choice3.charAt(0) - 48 < 8)) && ((choice3.charAt(1) - 48 >= 0) && (choice3.charAt(1) - 48 < 5))) {
                            if (gb.add(new Coordinate(choice3.charAt(0) - 48, choice3.charAt(1) - 48), new Piece(PlantPieces.SUNFLOWER)))
                                runGame(gb);
                        }
                    }
                    else System.out.println("Error: Wrong input. Please try again.");
                    break;
                case "3":
                    System.out.println("Round Skipped.\n");
                    runGame(gb);
                    break;
                case "4":
                    System.out.println("You have ended the game, thank you for playing!");
                    System.exit(0);
                    break;
                default:System.out.println("Error: Wrong input. Please try again.");
            }
            System.out.println(gb.toString());
        }
    }

    /**
     * Game logic for adding resources, moving enemies, and applying damage to pieces
     * @param gb Gameboard that is being used in the current game
     */
    public void runGame(GameBoard gb){
        gb.sunflowerMoney();
        gb.movingZombie();
        gb.addingZombie();
        gb.hitUpdate();
        gb.removeUpdate();
        gb.gameWon();
        gb.gameOver();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initialize();
    }
}
