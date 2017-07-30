Extended 8 queen problem without backtracking
===================

About the project
-------------
This project is an attempt to solve the 8 queen problem without backtracking. You also have the ability to define the size of the chess board, choose which type of piece you want to use (queen, rook or bishop) and how many of them you want the program to put on board (the goal). 

Board notations
-------------
There are 3 different symbol I use when I draw the chess board.
> - **-** Means the given square is under attack.
> - **0** Means it is free and not being attacked.
> - **1** It has a piece in it.

Side notes
-------------
> - It is a heuristic algorithm thus it's not guaranted to find the solution for first take but it keeps trying. A random factor is being introduced, the number of takes and thus the time it takes to solve the problem can vary. 
> - You can define problems without any solution. Thats why I maximized the takes to 5000 (you can change that if you want) to avoid infinite loops.



