/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: N/A
*
*  A class representing the arena in which the Sudoku game takes place. Keeps track
*  of the game's rows, colums, gridboxs' and all of the tiles.
*/
public class Arena {
    
    // Creates all of the elements of an Arena
    private Squares[][] square2D;
    private Row[] rowsArr;
    private Column[] colsArr;
    private Gridbox[] gridboxsArr;
    
    /*
    * Initializes all of the elements of the Arena to their starting values,
    * checks for invalid inputs, and updates the elements.
    */
    public Arena(String filename) {
        // takes in the file name and reds it in
        In in = new In(filename);
        square2D = new Squares[9][9];
        rowsArr = new Row[9];
        colsArr = new Column[9];
        gridboxsArr = new Gridbox[9];
        
        // iterates through every square in the grid and sets its vlaue
        for (int i = 0; i < square2D.length; i++) {
            for (int j = 0; j < square2D[i].length; j++) {
                char ch = in.readChar();
                
                // When the text returns to the next line, it reads the next char
                if (ch == 10) {
                    ch = in.readChar();
                }
                
                /*
                * Creates the squares and add them to the 2D array in their
                * respective place
                */
                if (ch == ' ') {
                    square2D[i][j] = new Squares(j * 2 - 8, -(i * 2 - 8), ' ', true,
                    false, false);
                    } else if ((ch > 48 && ch < 58) || ch == 32) {
                    square2D[i][j] = new Squares(j * 2 - 8, -(i * 2 - 8), ch, false,
                    false, true);
                    } else {
                    throw new IllegalArgumentException("Invalid char passed in!");
                }
            }
            
            // Creates a new row object and stroes it
            Row newRow = new Row(square2D[i], -(i * 2 - 8));
            rowsArr[i] = newRow;
            
            // Throws error if there is a duplicate
            if (newRow.hasDuplicate()) {
                throw new IllegalArgumentException("A row starts with duplicates!");
            }
        }
        
        // Updates the columns and finds if they're valid
        for (int i = 0; i < 9; i++) {
            Squares[] columnSquares = new Squares[9];
            for (int j = 0; j < 9; j++) {
                columnSquares[j] = square2D[j][i];
            }
            
            // Creates a new column object based on the 2D array
            Column newColumn = new Column(columnSquares, (i * 2) - 8);
            colsArr[i] = newColumn;
            
            // Throws error if there is a duplicate
            if (colsArr[i].hasDuplicate()) {
                throw new IllegalArgumentException("A col starts with duplicates!");
            }
        }
        
        // creates new arrays of Squares of each gridbox to store correct values
        Squares[][] gridboxSquares0 = new Squares[3][3];
        Squares[][] gridboxSquares1 = new Squares[3][3];
        Squares[][] gridboxSquares2 = new Squares[3][3];
        Squares[][] gridboxSquares3 = new Squares[3][3];
        Squares[][] gridboxSquares4 = new Squares[3][3];
        Squares[][] gridboxSquares5 = new Squares[3][3];
        Squares[][] gridboxSquares6 = new Squares[3][3];
        Squares[][] gridboxSquares7 = new Squares[3][3];
        Squares[][] gridboxSquares8 = new Squares[3][3];
        
        // Stores all of the correct values in the 2D array to a specific gridbox
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i <= 2 && j <= 2) {
                    gridboxSquares0[i][j] = square2D[i][j];
                    } else if (i <= 2 && j >= 3 && j <= 5) {
                    gridboxSquares1[i][j - 3] = square2D[i][j];
                    } else if (i <= 2 && j >= 6) {
                    gridboxSquares2[i][j - 6] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j <= 2) {
                    gridboxSquares3[i - 3][j] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j >= 3 && j <= 5) {
                    gridboxSquares4[i - 3][j - 3] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j >= 6) {
                    gridboxSquares5[i - 3][j - 6] = square2D[i][j];
                    } else if (i >= 6 && j <= 2) {
                    gridboxSquares6[i - 6][j] = square2D[i][j];
                    } else if (i >= 6 && j >= 3 && j <= 5) {
                    gridboxSquares7[i - 6][j - 3] = square2D[i][j];
                    } else if (i >= 6 && j >= 6) {
                    gridboxSquares8[i - 6][j - 6] = square2D[i][j];
                }
            }
        }
        
        // Stores each specific gridbox into an array of gridboxs'
        Gridbox newGridbox0 = new Gridbox(gridboxSquares0, -6, 6);
        gridboxsArr[0] = newGridbox0;
        Gridbox newGridbox1 = new Gridbox(gridboxSquares1, 0, 6);
        gridboxsArr[1] = newGridbox1;
        Gridbox newGridbox2 = new Gridbox(gridboxSquares2, 6, 6);
        gridboxsArr[2] = newGridbox2;
        Gridbox newGridbox3 = new Gridbox(gridboxSquares3, -6, 0);
        gridboxsArr[3] = newGridbox3;
        Gridbox newGridbox4 = new Gridbox(gridboxSquares4, 0, 0);
        gridboxsArr[4] = newGridbox4;
        Gridbox newGridbox5 = new Gridbox(gridboxSquares5, 6, 0);
        gridboxsArr[5] = newGridbox5;
        Gridbox newGridbox6 = new Gridbox(gridboxSquares6, -6, -6);
        gridboxsArr[6] = newGridbox6;
        Gridbox newGridbox7 = new Gridbox(gridboxSquares7, 0, -6);
        gridboxsArr[7] = newGridbox7;
        Gridbox newGridbox8 = new Gridbox(gridboxSquares8, 6, -6);
        gridboxsArr[8] = newGridbox8;
        
        // Throws an error if there is a duplicate in the gridbox
        for (int i = 0; i < gridboxsArr.length; i++) {
            if (gridboxsArr[i].hasDuplicate()) {
                throw new IllegalArgumentException("A box starts with duplicates!");
            }
        }
    }
    
    /*
    * Description: Draws each row, column, gridbox, square, and the gameboard
    * Input: N/A
    * Output: N/A
    */
    public void draw() {
        // Clears the board
        PennDraw.clear(255, 255, 255);
        
        // Draws each square in the 2D array at the correct location
        for (int i = 0; i < this.square2D.length; i++) {
            for (int j = 0; j < this.square2D[i].length; j++) {
                this.square2D[i][j].draw();
            }
        }
        
        // Draws a red row if there is a dublicate
        for (int i = 0; i < rowsArr.length; i++) {
            rowsArr[i].setRowArr(square2D[i]);
            if (rowsArr[i].hasDuplicate()) {
                rowsArr[i].drawRed();
            }
        }
        
        // Draws a red column if there is a duplicate
        for (int i = 0; i < colsArr.length; i++) {
            Squares[] columnSquares = new Squares[9];
            for (int j = 0; j < colsArr.length; j++) {
                columnSquares[j] = square2D[j][i];
            }
            colsArr[i].setColArr(columnSquares);
            if (colsArr[i].hasDuplicate()) {
                colsArr[i].drawRed();
            }
        }
        
        // creates new arrays of Squares for each gridbox to store correct values
        Squares[][] gridboxSquares0 = new Squares[3][3];
        Squares[][] gridboxSquares1 = new Squares[3][3];
        Squares[][] gridboxSquares2 = new Squares[3][3];
        Squares[][] gridboxSquares3 = new Squares[3][3];
        Squares[][] gridboxSquares4 = new Squares[3][3];
        Squares[][] gridboxSquares5 = new Squares[3][3];
        Squares[][] gridboxSquares6 = new Squares[3][3];
        Squares[][] gridboxSquares7 = new Squares[3][3];
        Squares[][] gridboxSquares8 = new Squares[3][3];
        
        // Stores all of the correct values in the 2D array to a specific gridbox
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i <= 2 && j <= 2) {
                    gridboxSquares0[i][j] = square2D[i][j];
                    } else if (i <= 2 && j >= 3 && j <= 5) {
                    gridboxSquares1[i][j - 3] = square2D[i][j];
                    } else if (i <= 2 && j >= 6) {
                    gridboxSquares2[i][j - 6] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j <= 2) {
                    gridboxSquares3[i - 3][j] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j >= 3 && j <= 5) {
                    gridboxSquares4[i - 3][j - 3] = square2D[i][j];
                    } else if (i >= 3 && i <= 5 && j >= 6) {
                    gridboxSquares5[i - 3][j - 6] = square2D[i][j];
                    } else if (i >= 6 && j <= 2) {
                    gridboxSquares6[i - 6][j] = square2D[i][j];
                    } else if (i >= 6 && j >= 3 && j <= 5) {
                    gridboxSquares7[i - 6][j - 3] = square2D[i][j];
                    } else if (i >= 6 && j >= 6) {
                    gridboxSquares8[i - 6][j - 6] = square2D[i][j];
                }
            }
        }
        
        // Stores each specific gridbox into an array of gridboxs'
        Gridbox newGridbox0 = new Gridbox(gridboxSquares0, -6, 6);
        gridboxsArr[0] = newGridbox0;
        gridboxsArr[0].setGridbox(gridboxSquares0);
        Gridbox newGridbox1 = new Gridbox(gridboxSquares1, 0, 6);
        gridboxsArr[1] = newGridbox1;
        gridboxsArr[1].setGridbox(gridboxSquares1);
        Gridbox newGridbox2 = new Gridbox(gridboxSquares2, 6, 6);
        gridboxsArr[2] = newGridbox2;
        gridboxsArr[2].setGridbox(gridboxSquares2);
        Gridbox newGridbox3 = new Gridbox(gridboxSquares3, -6, 0);
        gridboxsArr[3] = newGridbox3;
        gridboxsArr[3].setGridbox(gridboxSquares3);
        Gridbox newGridbox4 = new Gridbox(gridboxSquares4, 0, 0);
        gridboxsArr[4] = newGridbox4;
        gridboxsArr[4].setGridbox(gridboxSquares4);
        Gridbox newGridbox5 = new Gridbox(gridboxSquares5, 6, 0);
        gridboxsArr[5] = newGridbox5;
        gridboxsArr[5].setGridbox(gridboxSquares5);
        Gridbox newGridbox6 = new Gridbox(gridboxSquares6, -6, -6);
        gridboxsArr[6] = newGridbox6;
        gridboxsArr[6].setGridbox(gridboxSquares6);
        Gridbox newGridbox7 = new Gridbox(gridboxSquares7, 0, -6);
        gridboxsArr[7] = newGridbox7;
        gridboxsArr[7].setGridbox(gridboxSquares7);
        Gridbox newGridbox8 = new Gridbox(gridboxSquares8, 6, -6);
        gridboxsArr[8] = newGridbox8;
        gridboxsArr[8].setGridbox(gridboxSquares8);
        
        // Draws a red gridbox if there is a duplicates
        for (int i = 0; i < this.gridboxsArr.length; i++) {
            if (gridboxsArr[i].hasDuplicate()) {
                gridboxsArr[i].drawRed();
            }
        }
        
        // Draws the horizontal thin lines of the board
        for (int i = -9; i <= 9; i += 2) {
            PennDraw.line(i, -9, i, 9);
        }
        
        // Draws the vertical thin lines of the board
        for (int i = -9; i <= 9; i += 2) {
            PennDraw.line(-9, i, 9, i);
        }
        
        // draws the thick lines of the board
        PennDraw.setPenRadius(0.005);
        PennDraw.line(-3, -9, -3, 9);
        PennDraw.line(3, -9, 3, 9);
        PennDraw.line(-9, -3, 9, -3);
        PennDraw.line(-9, 3, 9, 3);
        PennDraw.setPenRadius(0.002);
        
        // advances the frame
        PennDraw.advance();
    }
    
    /*
    * Description: returns true if the player has won the game
    * Input: n/a
    * Output: boolean
    */
    public boolean didPlayerWin() {
        if (isAnyWrong()) {
            return false;
            } else {
            return true;
        }
    }
    
    /*
    * Description: Returns true if any squares in the array are empty or incorrect
    * Input: n/a
    * Output: boolean
    */
    public boolean isAnyWrong() {
        boolean anyWrong = true;
        
        // returns true once there is an incorrect square
        for (int i = 0; i < this.square2D.length; i++) {
            for (int j = 0; j < this.square2D.length; j++) {
                if (!this.square2D[i][j].getIsCorrect()) {
                    return true;
                    } else {
                    anyWrong = false;
                }
            }
        }
        return anyWrong;
    }
    
    /*
    * Description: If the player clicks, it acesses the square at that click
    * Input: n/a
    * Output: n/a
    */
    public void checkForPlayerClick() {
        if (PennDraw.mousePressed()) {
            double mouseX = PennDraw.mouseX();
            double mouseY = PennDraw.mouseY();
            for (int i = 0; i < this.square2D.length; i++) {
                for (int j = 0; j < this.square2D[i].length; j++) {
                    this.square2D[i][j].wasSquareClicked(mouseX, mouseY);
                }
            }
        }
    }
    
    /*
    * Description: If a player has typed, it sets the value of the aceessed square
    *              to the key typed. Only works if key typed is a valid key
    * Input: n/a
    * Output: n/a
    */
    public void checkForPlayerType() {
        if (PennDraw.hasNextKeyTyped()) {
            for (int i = 0; i < this.square2D.length; i++) {
                for (int j = 0; j < this.square2D[i].length; j++) {
                    if (this.square2D[i][j].getWasClicked()) {
                        char input = PennDraw.nextKeyTyped();
                        if ((input > 48 && input < 58) || input == 32) {
                            this.square2D[i][j].setValue(input);
                        }
                    }
                }
            }
        }
    }
}

