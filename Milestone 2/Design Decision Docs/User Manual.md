# Plants VS Zombies User Manual v2
*Made by Youssef Saghbini*

Zombies have landed onto your planet and want to take over the whole world. The only way to defend yourself is to use your plants! Supplied with alien-like plants like sunflowers and peashooters, you will need to act fast and plant fast. For you and your plants are the only ones who can save this world!

## Description
In this version of plants versus zombies, it will be based of turns, but the objective is the same, where you need to eliminate the zombies. A turn-based game is where you have limited amount of actions to do within a round. Each round will consist of one action that the user will be given in the menu. The menu will be given throughout the gameplay. Zombies will be spawned at random from the farthest side of the plants. Zombies will move one square closer to the other side until reached. The user will need to improvise a strategy to defend of the zombies and win the game.


# Layout
How the game will look.
## Board 

![](https://lh3.googleusercontent.com/28-Md0Z2rfRGnoMc7RzwS7PXhLyhgzPtldgyrOs8SpT271bMlfHaMDYiyVq3i1q0hdB1Uf3puU_nMw "board")
The one-level based plants versus zombie game will consist of 5 by 8 board, where each button on the board are numbered respectively to column and row. On the bottom of the board, will indicate how much money you have to spend on your plant. In the game, you will pick where your plants will be placed by x and y coordinates. With the coordinates, it will indicate which square you are pointing at and it will place your plant of choice. Also in the bottom of the squares, there is a in-game log to show what happens in the game, more details about it later on. These are the current plants available, also will include details about zombie;

| Piece | Cost | Attack | Health | Generates Money | Symbol|
|--|--|--|--|--|--|
|Sunflower|5|0|5|5|S|
|Peashooter|10|2|5|0|P|
|Zombie (Enemy)|0|2|5|0|Z|
 
## Pop-up Menu: Choosing your plants
![Recordit GIF](http://g.recordit.co/37iDPHdQsx.gif)
As the game starts and you have seen the board filled with squares, you will be able to click on like buttons and decide which plant you would like to place on this square. You have the option to choose between the Sunflower and the Peashooter, but more plants are coming in the newer version. 

## Log 
![enter image description here](https://lh3.googleusercontent.com/XZeeQbWlGV6Qa1wpddMdzkY8WvwxR_EhAsOL5ZNK4P6yHh0aCujPXwVK7qaBw0nqSe4LCJl0zgyuRA "Logging")
During the game, any event that occurs; will be recorded and displayed, so that the user will be notified on what is happening on the battlefield. Another word, any in-game activities will be logged and shown in the next round.

# Instructions
How to play the game. Each event will be shown in short video and described for better understanding.
## Start of the game 
Once the game starts, you will see the board and the log all in one frame. 
![](https://lh3.googleusercontent.com/28-Md0Z2rfRGnoMc7RzwS7PXhLyhgzPtldgyrOs8SpT271bMlfHaMDYiyVq3i1q0hdB1Uf3puU_nMw "board")

## Adding Peashooters or Sunflowers

![Recordit GIF](http://g.recordit.co/37iDPHdQsx.gif)
During in-game, the board will always be presented to you to see the current state of the game. You will always have the ability to plants onto the game board, unless you have no more money to get more plants. In the older version of this game, you had to manually select the plant you want and then add the coordinate of where you want your selected plant to be. Now in this version, everything is automated. You can select any square, a pop-up menu will show and you can pick any plant available to you. 

 ## Attacking the frontlines

![Recordit GIF](http://g.recordit.co/H55iuElvo8.gif)
During the game, you will have zombies attack you, so you must defend yourself. The only way to defend yourself is to spawn peashooters. Peashooters are able to attack back, and have range. Once the zombie is within range of the peashooter, their health will drop dependant on the peashooter's attack. Also, whenever a plant or a zombie is attacking it will be logged. The log will help the user see which plant and or zombie is attacking and how much health is left.

## Multiple Sunflowers

![Recordit GIF](http://g.recordit.co/anYK9MCG0H.gif)
In-game, the sunflower is able to generate 5 units into the user's money pouch. The more sunflower on the board, the more units the user is receive in their money pouch.


## Exiting the game

![Recordit GIF](http://g.recordit.co/tCV8H1m5cJ.gif)
In the top right corner, the user has the ability to exit the game. Also, the user is able to exit the game at any time. Once exited, the program will end.



## Developers View
In this part of the user manual, you get to see how the developers of the game build the game from scratch. 

### Board 
![](https://lh3.googleusercontent.com/4ivQKWqFhtfpkQrl_abbGxGrbp2Og-GsgbHm5TAPuWZxFBiWe-jfEZnz4StnC9ijbsKSSpkHDVF1Zw "board")

This is the string representation of the GUI Board. The one-level based plants versus zombie game will consist of 5 by 8 board, where each row and column are numbered respectively. On the bottom of the board, will indicate how much money you have to spend on your plant.  With the coordinates, it will indicate which square you are pointing at and it will place your plant of choice. 
As the progresses, this board will follow through the whole.  It will automatically update itself, whatever is shown on the GUI, it will also be shown on the string representation. It will also keep record of how much the user has left in their money pouch.

## Winning the game 

![Recordit GIF](http://g.recordit.co/kwvJP6YNoy.gif)
In the developer's view, you are able to see the board and the money pouch. The objective of the game is preventing the zombies from reaching to your end of the board. Once all zombies have been destroyed then the user has won the game. Another words, once all the 'Z' from the board disappears the user has won the game and or level.


## Losing the game
![Recordit GIF](http://g.recordit.co/Ncjq8SB97j.gif)
The objective of the game is to prevent zombies from reaching to your home, aka column 0. The game will check itself, every round, to see if any zombie has reached to the end. If one zombie has reached to column 0, then the user looses the game.


