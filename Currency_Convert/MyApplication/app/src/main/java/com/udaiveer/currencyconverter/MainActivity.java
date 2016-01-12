package com.udaiveer.currencyconverter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView moneyLogoView = (ImageView) findViewById(R.id.moneyLogoView);
        loadBitmap(R.drawable.money_img, moneyLogoView);
        convertToPoundListener();
    }

    public void  convertToPoundListener() {
        Button buttonOne = (Button) findViewById(R.id.button);
        buttonOne.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                TextView myNumberView = (TextView) findViewById(R.id.dollars);
                double rate = .65;
                double dollars = (double) Double.parseDouble(myNumberView.getText().toString());
                double pounds = dollars * rate;
                Toast.makeText(getApplicationContext(), pounds + " EUR", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void loadBitmap(int resId, ImageView imageView) {
        Context context = getApplicationContext();
        Resources imageResource = context.getResources();
        BitmapWorkerTask task = new BitmapWorkerTask(context, imageView, imageResource);
        task.execute(resId, 300, 300);
    }
}
