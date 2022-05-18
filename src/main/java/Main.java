import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many rows?");
        int numRows = input.nextInt();
        System.out.println("How many columns?");
        int numColumns = input.nextInt();

        startGame(numRows, numColumns);


    }


    public static void startGame (int numRows, int numColumns){
        Field newField = new Field(numRows, numColumns);
        System.out.println("On a "+ numRows + " by " + numColumns + " grid, there will be " +
                        newField.numMines + " mines! (num of rows * num of columns / 5)");

        newField.displayField();
//        newBoard.initGrid();
//        newBoard.displayGrid();

    }
}

