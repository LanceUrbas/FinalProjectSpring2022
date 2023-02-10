/*  Name: Lance Urbas
*  PennKey: ulance
*  Recitation: 209
*
*  Execution: N/A
*
* A class representing a Square in which the there are 81 of at each cell. Keeps
* track of each Squares' position, value, ability to be edited and determines if a
* square was clicked and is correct.
*/
public class Squares {
    
    //Creates all of the elements of a square
    private int xPos;
    private int yPos;
    private char value;
    private boolean editable;
    private boolean wasClicked;
    private boolean isCorrect;
    
    // Initializes each element of the square
    public Squares(int xPos, int yPos, char value, boolean editable,
    boolean wasClicked, boolean isCorrect) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.value = value;
        this.editable = editable;
        this.wasClicked = wasClicked;
        this.isCorrect = isCorrect;
    }
    
    /*
    * Description: Draws a square in the correct position based on it value.
    * Input: n/a
    * Output: n/a
    */
    public void draw() {
        /*
        * Draws each Square. If the square is editable, it will be drawn blue,
        * if not, it will be drawn red.
        */
        if (this.editable) {
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.filledRectangle(this.xPos, this.yPos, 1, 1);
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.text(this.xPos, this.yPos, "" + this.value);
            
            // If the square is drawn blue and in not a space, it is correct
            if (this.value != ' ') {
                this.isCorrect = true;
            }
            } else {
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.filledRectangle(this.xPos, this.yPos, 1, 1);
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.text(this.xPos, this.yPos, "" + this.value);
            this.isCorrect = true;
        }
    }
    
    /*
    * Description: Draws a square red and sets its correctness to false
    * Input: n/a
    * Output: n/a
    */
    public void drawRed() {
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledRectangle(this.xPos, this.yPos, 1, 1);
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.text(this.xPos, this.yPos, "" + this.value);
        this.isCorrect = false;
    }
    
    /*
    * Description: Sets the squares was clicked value to true if the mouse was in
    * its range when the mouse was clicked.
    * Input: A double called mouseX, and a double called mouseY
    * Output: n/a
    */
    public void wasSquareClicked(double mouseX, double mouseY) {
        if (mouseX > this.xPos - 1 && mouseX < this.xPos + 1 && 
        mouseY > this.yPos - 1 && mouseY < this.yPos + 1 && this.editable) {
            this.wasClicked = true;
            } else {
            this.wasClicked = false;
        }
    }
    
    /*
    * Description: Returns the value of a square
    * Input: n/a
    * Output: integer
    */
    public int getValue() {
        return this.value;
    }
    
    /*
    * Description: Sets the value of a square
    * Input: a char called value
    * Output: n/a
    */
    public void setValue(char value) {
        this.value = value;
    }
    
    /*
    * Description: Returns the was clicked boolean of a square
    * Input: n/a
    * Output: boolean
    */
    public boolean getWasClicked() {
        return this.wasClicked;
    }
    
    /*
    * Description: Sets the was clicked boolean of a square
    * Input: a boolean called wasClicked
    * Output: n/a
    */
    public void setWasClicked(boolean wasClicked) {
        this.wasClicked = wasClicked;
    }
    
    /*
    * Description: Returns the editable boolean of a square
    * Input: n/a
    * Output: boolean
    */
    public boolean getEditable() {
        return this.editable;
    }
    
    /*
    * Description: Returns the xPos of a square
    * Input: n/a
    * Output: int
    */
    public int getXPos() {
        return this.xPos;
    }
    
    /*
    * Description: Returns the yPos of a square
    * Input: n/a
    * Output: int
    */
    public int getYPos() {
        return this.yPos;
    }
    
    /*
    * Description: Returns the isCorrect boolean of a square
    * Input: n/a
    * Output: int
    */
    public boolean getIsCorrect() {
        return this.isCorrect;
    }
}
