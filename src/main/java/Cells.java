public class Cells {

    // Attributes
    int visibleNumber;
    char character;
    boolean isFlag;
    boolean isTreasure;
    boolean isVisible;

    public Cells() {
        this.visibleNumber = 0;
        //this.character = '?';
        this.isFlag = false;
        this.isTreasure = false;
        this.isVisible = false;
    }

    // Methods
    public String getDisplayCharacter() {


        if (!this.isVisible) {
            return " ? ";
        } else if (this.isTreasure) {
            return " * ";
        } else if (this.isFlag) {
            return " ! ";
        } else {
            return "   ";
        }
    }

    public void revealCell() {
        if (isVisible) {
            System.out.println("A Cell can only be selected once");
        }
    }

    public void changeToFlag() {
        isFlag = true;
    }

    // Getters & Setters


    public int getVisibleNumber() {
        return visibleNumber;
    }

    public void setVisibleNumber(int visibleNumber) {
        this.visibleNumber = visibleNumber;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public boolean isTreasure() {
        return isTreasure;
    }

    public void setTreasure() {
        this.isTreasure = true;

    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

}
