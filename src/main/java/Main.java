import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        System.out.println("How many rows?");
        int numRows = getInput();
        System.out.println("How many columns?");
        int numColumns = getInput();

        startGame(numRows, numColumns);


    }

    public static int getInput(){
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        return input.nextInt();
    }

    public static void startGame (int numRows, int numColumns){
        Field newField = new Field(numRows, numColumns);
        System.out.println("On a "+ numRows + " by " + numColumns + " grid, there will be " +
                        newField.numMines + " mines!");



        for (int guesses = 9; guesses > -1; guesses--) {
            newField.displayField();
            System.out.println("Choose a X coordinate: ");
            int chosenX = getInput();
            System.out.println("Choose a Y coordinate: ");
            int chosenY = getInput();
            System.out.println("You selected " + chosenX + "," + chosenY + ". This is a " +
                    newField.getCell(chosenX - 1, chosenY - 1).isMine +
                    ". You have " + guesses + " guesses remaining!");
            newField.getCell(chosenX - 1, chosenY - 1).setVisible(true);



        }

    }
}

