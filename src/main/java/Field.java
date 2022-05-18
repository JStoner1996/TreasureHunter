public class Field {

    int minRows = 4;
    int minColumns = 4;

    int numRows;
    int numColumns;

    int numMines;

    public Cells[][] field;

    public Field(int numRows, int numColumns){
        this.numRows = Math.max(numRows, minRows);
        this.numColumns = Math.max(numColumns, minColumns);
        this.numMines= (this.numRows * this.numColumns)/5;

        CellsGenerator generator = new CellsGenerator(numRows, numColumns);
        field = generator.buildField();
    }

    public Cells getCell(int row, int column){
        return field[row][column];
    }

    public void displayField (){
        printHeader();

        for (int row = 0; row < numRows; row++) {
            String index = String.format("%1$2s", row + 1);
            System.out.print(index + " |");
            for (int column = 0; column < numColumns; column++) {
                System.out.print( " ? ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private void printHeader() {
        String headerCols = "   |";
        String headerLine = "---|";
        for (int i = 0; i < numColumns; i++) {
            String index = String.format("%1$2s", i + 1);
            headerCols = headerCols.concat(index + " ");
            headerLine = headerLine.concat("---");
        }
        System.out.println(headerCols);
        System.out.println(headerLine);
    }

//    public void initGrid (){
//
//        for (int i = 0; i < field.length; i++){
//            for (int j = 0; j <field.length; j++){
//                Cells newCell = new Cells(i, j);
//                if((rand.nextInt(99) < 20)) {
//                    newCell.isMine = true;
//                } else {
//                    newCell.isMine = false;
//                    newCell.isVisible = true;
//                }
//                    field[i][j] = newCell.setCharacter();
//
//            }
//        }
//    }

//    public void displayGrid() {
//
//        for (int i = 0; i< field.length; i++ ) {
//            for (int j = 0; j < field.length; j++){
//                System.out.print(field[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.print("  ");
//        for (int row = 0; row < size; row++) {
//            System.out.print("\t " + (row + 1));
//
//        }
//        System.out.println("");
//        for (int row = 0; row < size; row++) {
//            System.out.print((row + 1) + " ");
//            for (int column = 0; column < size; column++) {
//                System.out.print("\t ? ");
//            }
//            System.out.println("");
//        }
//      }
}

