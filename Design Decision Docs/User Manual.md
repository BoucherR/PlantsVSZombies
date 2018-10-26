# Plants VS Zombies User Manual
*Made by Youssef Saghbini*

Zombies have landed onto your planet and want to take over the whole world. The only way to defend yourself is to use your plants! Supplied with alien-like plants like sunflowers and peashooters, you will need to act fast and plant fast. For you and your plants are the only ones who can save this world!

## Description
In this version of plants versus zombies, it will be based of turns, but the objective is the same, where you need to eliminate the zombies. A turn-based game is where you have limited amount of actions to do within a round. Each round will consist of one action that the user will be given in the menu. The menu will be given throughout the gameplay. Zombies will be spawned at random from the farthest side of the plants. Zombies will move one square closer to the other side until reached. The user will need to improvise a strategy to defend of the zombies and win the game.


# Layout
How the game will look.
## Board 
![](https://lh3.googleusercontent.com/4ivQKWqFhtfpkQrl_abbGxGrbp2Og-GsgbHm5TAPuWZxFBiWe-jfEZnz4StnC9ijbsKSSpkHDVF1Zw "board")

The one-level based plants versus zombie game will consist of 5 by 8 board, where each row and column are numbered respectively. On the bottom of the board, will indicate how much money you have to spend on your plant. In the game, you will pick where your plants will be placed by x and y coordinates. With the coordinates, it will indicate which square you are pointing at and it will place your plant of choice. These are the current plants available, also will include details about zombie;

| Piece | Cost | Attack | Health | Generates Money | Symbol|
|--|--|--|--|--|--|
|Sunflower|5|0|5|5|S|
|Peashooter|10|2|5|0|P|
|Zombie (Enemy)|0|2|5|0|Z|
 
## Menu
![](https://lh3.googleusercontent.com/ybxdhRCZsANoTCLalVR8Lzy1Kjape9nTLqkrO8vrzL7Z22QeDUOBZfz_-EY4ziiX0kweVGXVpMhrxw "menu")

As the game starts, you will be greeted with this menu. This menu will be with you until you lose, win or end the game. This menu will help you add plants, skip the round and exit the game at anytime. 

## Log 
![](https://lh3.googleusercontent.com/reP2awdH4ZiWgFqDRReI7Wknv0e4sOpM9U5Jz7iSJ7LRSwYG0BBIfarsogGpnQCehavHP96byvEIiQ "log")

During the game, any event that occurs; will be recorded and displayed, so that the user will be notified on what is happening on the battlefield. Another word, any in-game activities will be logged and shown in the next round.

# Instructions

How to play the game. Each event will be shown in gif and described for better understanding.
## Start of the game 

Once the game, you will be asked whether to start the game or press any key to exit out.

![Recordit GIF](http://g.recordit.co/oRQpxfTTVH.gif)

If pressed 1, then it will generate a new game.

![Recordit GIF](http://g.recordit.co/cKFGiO4bXo.gif)

If pressed anything else then the program will be exited and close.


## Adding Peashooters or Sunflowers

![Recordit GIF](http://g.recordit.co/pU0pKRBDR2.gif)

During in-game, the board and menu will always be presented to you to see the current state. As the menu is shown, you will be given the option to add a plant, whether its peashooter or sunflower, it is up to the user. Once chosen, it will prompt asking you where you would like to place your new plant. It is asking the user for a two digit value, where the first digit will be the column section and the second digit will be the row section. Another words, the two digits are coordinates pointing to a square where the plant will be added. Also, when adding a new plant is must follow three conditions;

 1. Must be two characters and two characters only
 2. Must be within the range of the board
 3. Must have enough money to purchase a new plant

## Skipping the round

![Recordit GIF](http://g.recordit.co/4eYLfOh0yI.gif)

In some cases, the user will have little amount of money to with start or during in-game. When the user is at that state, they are limited to skipping the round or exiting the game. If the user contains sunflowers in the game, then each round skipped money will be generated and the user will be able to add plants onto the board. If no sunflowers were added onto the board, then the user can see then end result of the game when skipping the round or they can exit the game. 

## Attacking the frontlines

![Recordit GIF](http://g.recordit.co/Gpt8YmeQpB.gif)

During the game, you will have zombies attack you, so you must defend yourself. The only way to defend yourself is to spawn peashooters. Peashooters are able to attack back, and have range. Once the zombie is within range of the peashooter, their health will drop dependant on the peashooter's attack. Also, whenever a plant or a zombie is attacking it will be logged. The log will help the user see which plant and or zombie is attacking and how much health is left.

## Multiple Sunflowers

![Recordit GIF](http://g.recordit.co/6E79V5x6Fo.gif)

In-game, the sunflower is able to generate 5 units into the user's money pouch. The more sunflower on the board, the more units the user is receive in their money pouch.


## Exiting the game

![Recordit GIF](http://g.recordit.co/PwpD6DxilF.gif)
In the menu, the last option the user is given is the exit option. Where the user is able to exit the game at each round. Once exited, the program will end.


## Winning the game 

![Recordit GIF](http://g.recordit.co/iWyRksqoIY.gif)

Since the objective of the game is preventing the zombies from reaching to your end of the board. Once all zombies have been destroyed then the user has won the game.


## Losing the game
![Recordit GIF](http://g.recordit.co/Lom3A6DoWy.gif)

The objective of the game is to prevent zombies from reaching to your home, column 0. The game will check itself, every round, to see if any zombie has reached to the end. If one zombie has reached to column 0, then the user looses the game.
