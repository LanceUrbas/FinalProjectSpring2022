/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: N/A
*
* A class representing a row in which the there are 9 of in the game. Keeps track
* of each rows' squares and y position
*/
public class Row {
    
    //Creates all of the elements of a row
    private Squares[] rowArr;
    private int yPos;
    
    // Initializes each element of the row
    public Row(Squares[] rowArr, int yPos) {
        this.rowArr = rowArr;
        this.yPos = yPos;
    }
    
    /*
    * Description: Draws a row red if there is a duplicate
    * Input: n/a
    * Output: n/a
    */
    public void drawRed() {
        PennDraw.setPenColor(255, 0, 0, 50);
        PennDraw.filledRectangle(0, this.yPos, 9, 1);
        PennDraw.setPenColor(PennDraw.BLACK);
    }
    
    /*
    * Description: returns true if there is a duplicate in the row
    * Input: n/a
    * Output: boolean
    */
    public boolean hasDuplicate() {
        for (int i = 0; i < this.rowArr.length; i++) {
            for (int j = 0; j < this.rowArr.length; j++) {
                // if there is a duplicate calls draw red at their position
                if (rowArr[i].getValue() == rowArr[j].getValue() &&
                rowArr[j].getValue() != ' ' && j != i) {
                    rowArr[i].drawRed();
                    rowArr[j].drawRed();
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    * Description: Setter method to set the Squares Array of the row
    * Input: Squares array
    * Output: n/a
    */
    public void setRowArr(Squares[] squareArr) {
        this.rowArr = squareArr;
    }
}
