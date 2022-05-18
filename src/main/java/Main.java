import java.util.Scanner;

public class Main {

    static boolean gameWon;
    static int numGuesses;

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame() {
        System.out.println("!--------------Welcome To Treasure Hunter--------------!");
        gameWon = false;

        int numRows = 0;
        int numColumns = 0;

        do {
            System.out.println("How many rows?");
            numRows = getInput();
            if (numRows < 4 || numRows > 36) {
                System.out.println("Needs to be between 4 and 36 rows.");
            }
        } while (numRows < 4 || numRows > 36);

        do {
            System.out.println("How many columns?");
            numColumns = getInput();
            if (numColumns < 4 || numColumns > 36) {
                System.out.println("Needs to be between 4 and 36 columns.");
            }
        } while (numColumns < 4 || numColumns > 36);

        Field newField = new Field(numRows, numColumns);
        numGuesses = (newField.numTreasures * 2) + 10;

        System.out.println("\nOn a " + numRows + " by " + numColumns + " grid, there will be " + (numRows * numColumns) + " cells, " +
                newField.numTreasures + " of which treasures! You have " + numGuesses + " guesses.\n");

        gameLoop(newField);
    }

    public static void gameLoop(Field newField) {

        int chosenX;
        int chosenY;

        for (int guessesLeft = numGuesses; guessesLeft > -1; guessesLeft--) {
            newField.displayField();

            if (!gameWon) {
                do {
                    System.out.println("\nChoose X coordinate: ");
                    chosenX = getInput();
                    System.out.println(chosenX);
                    if (chosenX > newField.numRows) {
                        System.out.println("\nX value not on board, try again.");
                    }
                } while (chosenX > newField.numRows);

                do {
                    System.out.println("\nChoose Y coordinate: ");
                    chosenY = getInput();
                    if (chosenY > newField.numColumns) {
                        System.out.println("\nY value not on board, try again.");
                    }
                } while (chosenY > newField.numColumns);


                if (newField.getCell(chosenX - 1, chosenY - 1).isTreasure()) {

                    newField.numTreasures--;
                    System.out.println("\nYou selected " + chosenX + "," + chosenY + ". This is a Treasure! You have " + guessesLeft + " guesses and " + newField.numTreasures + " treasures remaining!");
                    newField.getCell(chosenX - 1, chosenY - 1).setVisible(true);

                    if (newField.numTreasures == 0) {
                        winGame();
                    }
                } else {
                    System.out.println("\nYou selected " + chosenX + "," + chosenY + ". This is NOT a Treasure! You have " + guessesLeft + " guesses and " + newField.numTreasures + " treasures remaining!");
                    newField.getCell(chosenX - 1, chosenY - 1).setVisible(true);

                }
                if (guessesLeft == 0) {
                    loseGame();
                }
            }
        }


    }

    private static void winGame() {
        gameWon = true;
        System.out.println("Congrats, you gathered all the treasure!  0 = No, 1 = Yes");

        if (getInput() == 1) {
            startGame();
        } else {
            System.exit(0);
        }
    }

    public static void loseGame() {
        System.out.println("Oh no. You ran out of time! You lose. Do you want to play again? 0 = No, 1 = Yes");

        if (getInput() == 1) {
            startGame();
        } else {
            System.exit(0);
        }
    }

    public static int getInput() {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        if (input.hasNextInt()) {
            return input.nextInt();
        } else {
            return 0;
        }
    }
}



