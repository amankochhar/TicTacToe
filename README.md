# TicTacToe
Tic Tac Toe game implementation using minimax algortihm

In a Tic Tac Toe game two players, X and O, take turns to mark the spaces in a 3X3
grid. The winner will be the player who first succeeds in placing three of his/her marks in a
horizontal, vertical, or diagonal row.
This is a program for a computer (X player) to play with a human (O player) on Tic Tac Toe
game given an initial status of the game. The initial status of the game is represented
by a string of 9 characters. 
For example, the game status can be expressed using string “OOO_OX_XX". The program always 
plays the winning strategies and try to defeat the human player if possible. The program
tries to play a maxmin strategy first. If the maxmin strategy is not 
beneficial it will play a minmax strategy to minimize the payoff of the other player.

The sample input and output are shown below:
Example 1:
"XXO_O_XO_"
The computer chooses to fill the cell #4
1
X X O
X O
X O
The Computer Won!
Example 2: 
"XXOOO_X__"
The computer chooses to fill the cell #6
X X O
O O X
X
Human player please select a cell number to fill: 1
Not a valid move, please try again. Please select a cell to fill: 8
Thanks. Now the board looks like:
X X O
O O X
X O
The computer chooses to fill the cell #9
X X O
O O X
X O X
The game is finished. No one won the game.

