/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: N/A
*
* A class representing a column in which the there are 9 of in the game. Keeps
* track of each columns' squares and x position
*/
public class Column {
    
    //Creates all of the elements of a column
    private Squares[] colArr;
    private int xPos;
    
    // Initializes each element of the column
    public Column(Squares[] colArr, int xPos) {
        this.colArr = colArr;
        this.xPos = xPos;
    }
    
    /*
    * Description: Draws a column red if there is a duplicate
    * Input: n/a
    * Output: n/a
    */
    public void drawRed() {
        PennDraw.setPenColor(255, 0, 0, 50);
        PennDraw.filledRectangle(this.xPos, 0, 1, 9);
        PennDraw.setPenColor(PennDraw.BLACK);
    }
    
    /*
    * Description: Returns true if there is a duplicate in the column
    * Input: n/a
    * Output: boolean
    */
    public boolean hasDuplicate() {
        for (int i = 0; i < this.colArr.length; i++) {
            for (int j = 0; j < this.colArr.length; j++) {
                // if there is a duplicate calls draw red at their position
                if (colArr[i].getValue() == colArr[j].getValue() &&
                colArr[j].getValue() != ' ' && j != i) {
                    colArr[i].drawRed();
                    colArr[j].drawRed();
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    * Description: Setter method to set the Squares Array of the column
    * Input: Squares array
    * Output: n/a
    */
    public void setColArr(Squares[] squareArr) {
        this.colArr = squareArr;
    }
}
