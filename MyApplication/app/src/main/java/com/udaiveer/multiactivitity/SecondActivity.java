package com.udaiveer.multiactivitity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();

        Log.i("@@@@@@intent Hello-", i.getStringExtra("name"));

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(i.getStringExtra("name"));

    }

    public void changeActivity1(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
