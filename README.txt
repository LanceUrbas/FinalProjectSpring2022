/**********************************************************************
 *  readme template
 *  Irate Avians
 **********************************************************************/

Name: Lance Urbas
PennKey: ulance
Recitation: 209
Hello

/**********************************************************************
* Instructions for how to run your program (which class to run, any command 
line arguments)
**********************************************************************/

run the SudokuGame class with any sudoku grid that has the same format 
as the sudokuExample.txt. The command line argument I use is:
java SudokuGame sudokuExample.txt

/**********************************************************************
Any additional features you added beyond the assignment specifications
**********************************************************************/

I didnt really add any additional feature to the games that require user
input, however, I did make all editable cell values blue so that they can be 
told apart from the starting game values(which are black).

/**********************************************************************
A brief description of each file and its purpose
**********************************************************************/

The SudokuGame file is the overarching file that controls all other aspects of 
the game. Its purpose is to set constant values and keep the game running while
it is still being played.

The Arena file is the file that controls each element of a sudoku board. Its purpose
is to control all of these elements based on their interactions with eachother as 
well as draw them.

The Row file models each row in the sudoku board. Its purpose is to determine if
there are duplicates in any given row and lets the user know if there is.

The Column file models each coulmn in the sudoku board. Its purpose is to determine 
if there are duplicates in any given column and lets the user know if there is.

The Gridbox file models each 3x3 gridbox in the sudoku board. Its purpose is to 
determine if there are duplicates in any given gridbox and lets the user know if 
there is.

The Squares file models each cell in the sudoku board. Its purpose is to assign each
cell to a square which has a value and can interact with all other elements of the 
sudoku board.