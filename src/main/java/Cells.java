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

    // Getters & Setters
    public boolean isTreasure() {
        return isTreasure;
    }

    public void setTreasure(boolean isTreasure) {
        this.isTreasure = isTreasure;

    }
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

}
