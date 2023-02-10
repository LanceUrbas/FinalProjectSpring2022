/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: java SudokuGame sudokuExample.txt
*
*  Represents the Sudoku game. Takes a level description text file and
*  initializes a game arena with that data, then runs the game until the player
*  wins.
*/
public class SudokuGame {
    public static void main(String[] args) {
        // Sets the constant attributes of the game;
        PennDraw.setXscale(-9, 9);
        PennDraw.setYscale(-9, 9);
        PennDraw.setFontSize(32);
        PennDraw.enableAnimation(30);
        
        // Creates a new arena object with passed in file argument
        Arena arena = new Arena(args[0]);
        
        // While the player has not won, the game keeps running
        while (!arena.didPlayerWin()) {
            // Checks for player action
            arena.checkForPlayerClick();
            arena.checkForPlayerType();
            
            // Draws the updated arena and its components.
            arena.draw();
        }
        
        // Draws the win message once the player has won.
        PennDraw.setPenColor(255, 255, 255, 150);
        PennDraw.filledRectangle(0, 0, 9, 9);
        PennDraw.setFontSize(50);
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.text(0, 0, "Level Complete!");
        PennDraw.advance();
        
    }
}
