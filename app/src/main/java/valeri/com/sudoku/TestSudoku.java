package valeri.com.sudoku;

/**
 * Created by aleksander on 2/27/15.
 */
public class TestSudoku {

    // Model Sudoku game cells as continuous range
    static int[] sudokuCells;

    public static void create() {


        sudokuCells = new int[81];

        //Top-left Sudoku region has 9 cells.
        //These are starting positions for populating sudoku with digits
        int[] cellIndexesInTopLeftRegion = {0, 20, 9, 2, 19, 11, 1, 18, 10};

        //We fill every position with number one greater than previous
        //We must be sure there is sufficient array elements available
        //Worst case is when starting position must be populated with number 9
        //We have 9,1,2,3,4,5,6,7,8
        int[] startingDigitsForTopLeftRegion = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8};


        int currentStartingDigit = 0;
        // Visit all cells in top-left sudoku region in order defined by cellIndexesInTopLeftRegion Array
        for (int i = 0; i < cellIndexesInTopLeftRegion.length; i++) {

            //Index from startingDigitsForTopLeftRegion Array that will place actual number in sudoku cell
            currentStartingDigit = i;

            // Visit vertically Top-left , Middle-left, Bottom-left Sudoku regions
            for (int j = cellIndexesInTopLeftRegion[i]; j < sudokuCells.length; j += 27) {

                //Visit horizontally every corresponding Left Middle and Right Regions
                for (int k = j; k < j + 9; k += 3) {
                    sudokuCells[k] = startingDigitsForTopLeftRegion[currentStartingDigit];
                    currentStartingDigit++;

                }

            }

        }


        logSudoku();

    }

    private static void logSudoku() {

        for (int i = 0; i < sudokuCells.length; i++) {
            System.out.print(sudokuCells[i]);

            //separate  each element
            System.out.print(" ");

            //end region
            if (i % 3 == 2) {
                System.out.print(" ");
            }

            //last element in row
            if (i % 9 == 8) {
                System.out.println("");

            }

            //end of right region
            if (i % 27 == 26) {
                System.out.println("");

            }


        }
    }

}
