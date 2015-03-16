package valeri.com.sudoku;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by valeri on 15-3-5.
 */
public class RandomGenerator {

    Random r = new Random();
    ArrayList<Integer> random;




    public ArrayList<Integer> takeIndex(){

        ArrayList<Integer> repo = new ArrayList<>();

                for(int j = 0; j < 81; j++){
                    repo.add(j);
                }




        random = new ArrayList<>();

        for (int i = 0; i < 58; i++){

            int all = r.nextInt(repo.size());
            int f= all;

            random.add(repo.get(f));
            Log.d("Random number", String.valueOf(repo.get(f)));

            repo.remove(f);
        }
        Log.d("Sice of repo", String.valueOf(repo.size()));


        for (Integer element:random){
            Log.d("gggggggggggggggggggggggggggggg", String.valueOf(element));
        }

        return random;

    }




}
