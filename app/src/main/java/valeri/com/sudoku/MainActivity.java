package valeri.com.sudoku;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends Activity implements View.OnClickListener {

    public int[] NumberInSudoku = new int[81];
    public ArrayList<String> forCheck;

    int numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix,
            numberSeven, numberEight, numberNine;

    int i, k;
    static int changeArray = 0;
    int sum = 0;
    ArrayList<int[]> ints;
    int[] NumberInCellOne = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] NumberInCellTwo = {2, 3, 4, 5, 6, 7, 8, 9, 1};
    int[] NumberInCellThree = {3, 4, 5, 6, 7, 8, 9, 1, 2};
    int[] NumberInCellFour = {4, 5, 6, 7, 8, 9, 1, 2, 3};
    int[] NumberInCellFive = {5, 6, 7, 8, 9, 1, 2, 3, 4};
    int[] NumberInCellSix = {6, 7, 8, 9, 1, 2, 3, 4, 5};
    int[] NumberInCellSeven = {7, 8, 9, 1, 2, 3, 4, 5, 6};
    int[] NumberInCellEight = {8, 9, 1, 2, 3, 4, 5, 6, 7};
    int[] NumberInCellNine = {9, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] number;
    int index;

    String one = "1";
    String two = "2";
    String three = "3";
    String four = "4";
    String five = "5";
    String six = "6";
    String seven = "7";
    String eight = "8";
    String nine = "9";

    GridLayout gridLayout;
    ArrayList<TextView> digit;
    RandomGenerator randomGenerator;
    Button one_button, two_button, three_button, four_button, five_button,
            six_button, seven_button, eight_button, nine_button, check_button, create_new_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniTializationElement();
        makeIndexAndPutInSudokuNumber();
        putAllTViewInArray();
        putNumberInTextView();
        hideNumber();

    }

    /**
     * put all array numberInCell in one array list "arrt"
     *
     * @return
     */

    public ArrayList<int[]> arrt() {

        ArrayList<int[]> ints = new ArrayList<>();

        ints.add(NumberInCellOne);
        ints.add(NumberInCellTwo);
        ints.add(NumberInCellThree);
        ints.add(NumberInCellFour);
        ints.add(NumberInCellFive);
        ints.add(NumberInCellSix);
        ints.add(NumberInCellSeven);
        ints.add(NumberInCellEight);
        ints.add(NumberInCellNine);
        Collections.rotate(ints, changeArray);
        return ints;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one_button:
                digit.get(index).setText(one);
                break;
            case R.id.two_button:
                digit.get(index).setText(two);
                break;
            case R.id.three_button:
                digit.get(index).setText(three);
                break;
            case R.id.four_button:
                digit.get(index).setText(four);
                break;
            case R.id.five_button:
                digit.get(index).setText(five);
                break;
            case R.id.six_button:
                digit.get(index).setText(six);
                break;
            case R.id.seven_button:
                digit.get(index).setText(seven);
                break;
            case R.id.eight_button:
                digit.get(index).setText(eight);
                break;
            case R.id.nine_button:
                digit.get(index).setText(nine);
                break;
            case R.id.check_button:{
                forCheck = new ArrayList<>();
                for (int d = 0; d < 81; d++) {
                    //we get text view from grid layout
                    TextView my = digit.get(d);
                    //make String from text layout
                    String mmm = my.getText().toString();
                    Log.d("String",mmm);
                    if(mmm!="") {
                        forCheck.add(mmm);
                        Log.d("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", String.valueOf(forCheck.size()));

                    }
                }

                if (forCheck.size()!= NumberInSudoku.length) {
                    Log.d("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", String.valueOf(forCheck.size()));
                    Toast.makeText(this, "You are not fill all boxes.", Toast.LENGTH_SHORT).show();
                }
                else {
                    // With this we check is number in grid layout are equal to NumberInSudoku
                    int oneNumberFromSudoku = 0;
                    int oneNumerFromGridLayout = 0;
                    for (int l = 0; l < 81; l++) {
                        oneNumberFromSudoku = NumberInSudoku[l];
                        try {
                            oneNumerFromGridLayout = Integer.parseInt(forCheck.get(l));
                        }
                        catch (Exception e){

                        }
                        if (oneNumberFromSudoku != oneNumerFromGridLayout) {
                            Toast.makeText(this, "Yore solution is not correct!", Toast.LENGTH_SHORT).show();
                            break;
                        }

                    }
                    if (oneNumberFromSudoku == oneNumerFromGridLayout) {
                        Toast.makeText(this, "Congratulation you solve this Sudoku!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
            case R.id.create_new_button:
                sum = 0;
                changeArray--;
                makeIndexAndPutInSudokuNumber();
                putAllTViewInArray();
                putNumberInTextView();
                hideNumber();


                break;
        }
    }

    /**
     * Initialization All element
     */

    public void iniTializationElement() {
        one_button = (Button) findViewById(R.id.one_button);
        one_button.setOnClickListener(this);
        two_button = (Button) findViewById(R.id.two_button);
        two_button.setOnClickListener(this);
        three_button = (Button) findViewById(R.id.three_button);
        three_button.setOnClickListener(this);
        four_button = (Button) findViewById(R.id.four_button);
        four_button.setOnClickListener(this);
        five_button = (Button) findViewById(R.id.five_button);
        five_button.setOnClickListener(this);
        six_button = (Button) findViewById(R.id.six_button);
        six_button.setOnClickListener(this);
        seven_button = (Button) findViewById(R.id.seven_button);
        seven_button.setOnClickListener(this);
        eight_button = (Button) findViewById(R.id.eight_button);
        eight_button.setOnClickListener(this);
        nine_button = (Button) findViewById(R.id.nine_button);
        nine_button.setOnClickListener(this);
        check_button = (Button) findViewById(R.id.check_button);
        check_button.setOnClickListener(this);
        gridLayout = (GridLayout) findViewById(R.id.grid_layout);
        create_new_button = (Button) findViewById(R.id.create_new_button);
        create_new_button.setOnClickListener(this);
    }

    /**
     * Take position in grid where wi put numbers,
     * and put numbers in Number in sudoku Array from Array number
     */
    public void makeIndexAndPutInSudokuNumber() {
        ints = arrt();
        for (i = 0; i < 60; i++) {
            if (i == 1) {
                i = 20;
            } else if (i == 21) {
                i = 9;
            } else if (i == 10) {
                i = 2;
            } else if (i == 3) {
                i = 19;
            } else if (i == 20) {
                i = 11;
            } else if (i == 12) {
                i = 1;
            } else if (i == 2) {
                i = 18;
            } else if (i == 19) {
                i = 10;
            }
            numberOne = i;
            numberTwo = numberOne + 3;
            numberThree = numberTwo + 3;
            numberFour = 27 + numberOne;
            numberFive = numberFour + 3;
            numberSix = numberFive + 3;
            numberSeven = 27 + numberFour;
            numberEight = numberSeven + 3;
            numberNine = numberEight + 3;

            for (k = 0; k < 9; k++) {
                number = new int[]{numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix,
                        numberSeven, numberEight, numberNine};

                NumberInSudoku[number[k]] = ints.get(sum)[k];
            }
            sum++;
            Log.d("sum", String.valueOf(sum));
            if (i == 10) {
                break;
            }
        }
    }


    /**
     * put all textview in one Array list "digit"
     */
    Drawable my ;
    TextView myText;
    public void putAllTViewInArray() {
        // put all text view in one arrayList
        digit = new ArrayList<>();
        for (int t = 0; t < gridLayout.getChildCount(); t++) {

            View child = gridLayout.getChildAt(t);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (my!=null && myText != null) {
                        myText.setBackground(my);
                    }
                   myText = (TextView) v;
                           index = digit.indexOf(v);

                    my =   digit.get(index).getBackground();
                      digit.get(index).setBackgroundColor(Color.BLUE);


                }
            });
            digit.add((TextView) child);

        }
    }

    /**
     * With this method we hide numbers from grid view
     */

    public void hideNumber() {

        randomGenerator = new RandomGenerator();
        ArrayList<Integer> randomNumber = randomGenerator.takeIndex();
        for (int j = 0; j < randomNumber.size(); j++) {
            int forRandom = randomNumber.get(j);
            digit.get(forRandom).setText("");
        }
    }

    /**
     * With this we put fron numberInSudoku to Array list <TextView> digit
     */

    public void putNumberInTextView() {
        //With this we put Text view wit number from number in sudoku
        for (int d = 0; d < 81; d++) {
            digit.get(d).setText(String.valueOf(NumberInSudoku[d]));
        }
    }
}
