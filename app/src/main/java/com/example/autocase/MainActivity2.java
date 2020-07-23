package com.example.autocase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private String finalText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String testName = intent.getStringExtra("text");
        TextView text3 = findViewById(R.id.textView2);
        text3.setText(testName);
    }

    @Override
    public void onClick(View view) {

    }
}