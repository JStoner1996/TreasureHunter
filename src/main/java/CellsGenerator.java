import java.util.Random;

public class CellsGenerator {

    // Attributes
    int numRows;
    int numColumns;
    int numMines;

    // Constructor
    public CellsGenerator(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numMines = (this.numRows * this.numColumns)/5;
    }

    // Methods
    public Cells[][] buildField(){
        Cells[][] field = new Cells[this.numRows][this.numColumns];
        addCells(field);
        addMines(field);

        System.out.println("There are "+ numMines + " mines.");
        return field;
    }

    // Add empty cells to the field
    public void addCells(Cells[][] field){
        for (int row = 0; row < this.numRows; row++){
            for (int column=0; column < this.numColumns; column++){
                field[row][column] = new Cells();

            }
        }
    }

    public void addMines(Cells[][] field){
        int mines = 0;
        for (int row = 0; row < this.numRows; row++){
            for (int column=0; column < this.numColumns; column++){
                if (mines < numMines) {
                    field[row][column].setMine();
                    mines++;
                }
            }
        }
        randomizeField(field);
    }

    public void randomizeField(final Cells[][] field){
        Random rand = new Random();

        for (int row = field.length - 1; row > 0; row--) {
            for (int column = field[row].length - 1; column > 0; column--) {
                int randomRow = rand.nextInt(row + 1);
                int randomColumn = rand.nextInt(column + 1);

                Cells tempField = field[row][column];
                field[row][column] = field[randomRow][randomColumn];
                field[randomRow][randomColumn] = tempField;

            }
        }


    }


}
