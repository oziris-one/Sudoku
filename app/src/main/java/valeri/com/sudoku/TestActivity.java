package valeri.com.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        createAndPlaceCells();


    }

    private void createAndPlaceCells() {
        GridLayout grid = (GridLayout) findViewById(R.id.grid);

        for(int i=0;i<9;i++){

            for (int j=0;j<9;j++){

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width=45;
                params.height=45;
                params.setMargins(0,0,0,0);


                Button text = new Button(this);
                text.setPadding(0,0,0,0);
                text.setLayoutParams(params);
                grid.addView(text);
            }


        }
    }


}
