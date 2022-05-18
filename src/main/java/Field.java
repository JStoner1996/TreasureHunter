public class Field {

    private final Cells[][] gameField;
    int minRows = 4;
    int minColumns = 4;
    int maxRows = 36;
    int maxColumns = 36;
    int numRows;
    int numColumns;
    int numTreasures;

    public Field(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numTreasures = (this.numRows * this.numColumns) / 4;

        CellsGenerator generator = new CellsGenerator(numRows, numColumns);
        gameField = generator.buildField();
    }

    public Cells getCell(int row, int column) {
        return gameField[row][column];
    }

    public void displayField() {
        printHeader();


        for (int row = 0; row < numRows; row++) {
            String index = String.format("%1$2s", row + 1);
            System.out.print(index + " |");
            for (int column = 0; column < numColumns; column++) {
                System.out.print(getCell(row, column).getDisplayCharacter());
            }

            System.out.println();
        }
        System.out.println();

    }

    private void printHeader() {
        String headColumns = "   |";
        String headerLine = "---|";
        for (int i = 0; i < numColumns; i++) {
            String index = String.format("%1$2s", i + 1);
            headColumns = headColumns.concat(index + " ");
            headerLine = headerLine.concat("---");
        }
        System.out.println(headColumns);
        System.out.println(headerLine);
    }

}

