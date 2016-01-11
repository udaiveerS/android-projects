package com.udaiveer.test3;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean toggleImage = true;

    public void clickFunction(View view) {

        EditText myTextField = (EditText) findViewById(R.id.text1);
        Log.i("info", myTextField.getText().toString());
        Toast.makeText(getApplicationContext(), "hi" + myTextField.getText().toString(), Toast.LENGTH_LONG).show();
        ImageView image = (ImageView) findViewById(R.id.image1);

        if(toggleImage) {
            loadBitmap(R.drawable.img1, image);
        } else {
            loadBitmap(R.drawable.img2, image);
        }

        toggleImage = !toggleImage;
    }

    public void loadBitmap(int resId, ImageView imageView) {
        Context context = getApplicationContext();
        Resources imageResource = context.getResources();
        BitmapWorkerTask task = new BitmapWorkerTask(context, imageView, imageResource);
        task.execute(resId, 100,100);
    }
}
