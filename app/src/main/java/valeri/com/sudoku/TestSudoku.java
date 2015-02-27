package valeri.com.sudoku;

import java.util.Arrays;

/**
 * Created by aleksander on 2/27/15.
 */
public class TestSudoku {

    public static void create() {
        int[] fillRules = { 0, 20, 9, 2, 19, 11, 1, 18, 10 };
        int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8 };
        // create new array for cells
        int[] sudokuCells = new int[81];

        int startingDigit = 0;
        // perform fill based on selected position in region of 9 cells
        for (int i = 0; i < fillRules.length; i++) {
            startingDigit = i;
            // we fill all cells at beginning position
            // we have 3 row - go until end
            for (int j = fillRules[i]; j < sudokuCells.length; j += 27) {

                // each row has 3 sells at offset of 3
                // 3 times iteration
                for (int k = j; k < j + 9; k += 3) {
                    sudokuCells[k] = digits[startingDigit];
                    startingDigit++;

                }

            }

        }

        System.out.println(Arrays.toString(sudokuCells));

    }

}
