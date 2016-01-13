package com.udaiveer.ticktack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isPlayer1 = true;
    private static String P1_MESSAGE = "Player 1's Move";
    private static String P2_MESSAGE = "Player 2's Move";
    int [][] state = new int [3][3];


    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView label = (TextView) findViewById(R.id.moveLabel);
        this.label = label;
        label.setText(P1_MESSAGE);
        isPlayer1 = true;

    }

    public void dropIn(View view) {


        int rId  = getTokenId();

        int index = Integer.parseInt(view.getTag().toString());
        int[] arr = get_ij(index);
        int i = arr[0];
        int j = arr[1];
        System.out.println(i + "," + j);
        if(state[i][j] != 1 && state[i][j] != 2) {
            setMove(i, j);
            ImageView token = (ImageView) view;
            token.setImageResource(rId);
            token.setTranslationY(-1000f);
            token.animate().translationYBy(1000f).rotation(360f).setDuration(1000l);

            isPlayer1 = !isPlayer1;
            updateLabel();
        }
        for(int[] arr1: state) {
            System.out.print("[");
            for(int g : arr1) {
                System.out.print(g + " ");

            }
            System.out.println("]");

        }
    }


    public int getTokenId() {
        if(isPlayer1) {
            return R.drawable.red;
        } else {
            return R.drawable.yellow;
        }
    }

    public void updateLabel() {
        if(isPlayer1) {
            label.setText(P1_MESSAGE);
        } else {
            label.setText(P2_MESSAGE);
        }

    }

    public void checkWinState() {
        int a,b,c,d;
        a = StateTester.checkColumns(state);
        b = StateTester.checkRows(state);
        c = StateTester.checkDiagonalForward(state);
        d = StateTester.checkDiagonalBackward(state);

        if(a == 1 | b == 1 || c == 1 || d == 1) {

        }

        if(a == 2 | b == 2 || c == 2 || d == 2) {

        }
    }

    public int[] get_ij(int x) {
        return new int[] {(x-1)/3, (x-1)%3};
    }

    public void setMove(int i, int j) {
        if(isPlayer1) {
            state[i][j] = 1;
        } else {
            state[i][j] = 2;
        }
    }


}
