package com.udaiveer.ticktack;

import android.animation.Animator;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isPlayer1 = true;
    private static String P1_MESSAGE = "Player 1's Move";
    private static String P2_MESSAGE = "Player 2's Move";

    int [][] state = new int [3][3];
    private boolean gameActive = true;
    int numberOfMoves =0;

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
        if(state[i][j] != 1 && state[i][j] != 2 && gameActive) {
            setMove(i, j);
            ImageView token = (ImageView) view;
            token.setImageResource(rId);
            token.setTranslationY(-1000f);
            token.animate().translationYBy(1000f).rotation(360f).setDuration(500l);

            isPlayer1 = !isPlayer1;
            updateLabel();
            numberOfMoves++;
        }
        checkWinState();

        if(!gameActive || numberOfMoves == 9) {
            // show come message
            System.out.println(numberOfMoves);
            gameActive = false;
            TextView text = (TextView) findViewById(R.id.winnerMessage);
            if (checkWinState() == 1) {
                text.setText("Player 1 Wins");
            } else if (checkWinState() == 2) {
                text.setText("Player 2 Wins");
            } else {
                text.setText("Draw Game");
            }

            LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
            layout.setVisibility(View.VISIBLE);
            isPlayer1 = true;
            updateLabel();
        }

    }

    public void playAgain(View view) {
        numberOfMoves = 0;
        gameActive = true;
        isPlayer1 = true;
        state = new int [3][3];
        //hide the message
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        for(int i =0; i < grid.getChildCount(); i++) {
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        layout.setVisibility(View.INVISIBLE);

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

    public int checkWinState() {
        int a,b,c,d;
        a = StateTester.checkColumns(state);
        b = StateTester.checkRows(state);
        c = StateTester.checkDiagonalForward(state);
        d = StateTester.checkDiagonalBackward(state);

        if(a == 1 | b == 1 || c == 1 || d == 1) {
            gameActive = false;
            return 1;
        }

        if(a == 2 | b == 2 || c == 2 || d == 2) {
            gameActive = false;
            return 2;
        }

        return 0;
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
