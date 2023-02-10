/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: N/A
*
* A class representing a gridbox in which the there are 9 of in the game. Keeps
* track of each gridboxs' squares and position
*/
public class Gridbox {
    
    //Creates all of the elements of a gridbox
    private Squares[][] gridbox;
    private int xPos;
    private int yPos;
    
    // Initializes each element of the gridbox
    public Gridbox(Squares[][] gridbox, int xPos, int yPos) {
        this.gridbox = gridbox;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /*
    * Description: Draws a gridbox red if there is a duplicate
    * Input: n/a
    * Output: n/a
    */
    public void drawRed() {
        PennDraw.setPenColor(255, 0, 0, 50);
        PennDraw.filledRectangle(this.xPos, this.yPos, 3, 3);
        PennDraw.setPenColor(PennDraw.BLACK);
    }
    
    /*
    * Description: Returns true if a gridbox has a duplicate
    * Input: n/a
    * Output: boolean
    */
    public boolean hasDuplicate() {
        // Creates a new array to store the gridbox values
        Squares[] gridboxArray = new Squares[9];
        int count = 0;
        
        // converts the 2D array to a regular array
        for (int i = 0; i < this.gridbox.length; i++) {
            for (int j = 0; j < this.gridbox.length; j++) {
                gridboxArray[count] = this.gridbox[i][j];
                count++;
            }
        }
        
        /*
        * Checks if a value is equal to another value in the array other than
        * space or itself
        */
        for (int i = 0; i < gridboxArray.length; i++) {
            for (int j = 0; j < gridboxArray.length; j++) {
                // if there is a duplicate calls draw red at their position
                if (gridboxArray[i].getValue() == gridboxArray[j].getValue() &&
                gridboxArray[j].getValue() != ' ' && i != j) {
                    gridboxArray[i].drawRed();
                    gridboxArray[j].drawRed();
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    * Description: Setter method to set the Squares 2D Array of the row
    * Input: 2D array of squares
    * Output: n/a
    */
    public void setGridbox(Squares[][] square2DArr) {
        this.gridbox = square2DArr;
    }
}
