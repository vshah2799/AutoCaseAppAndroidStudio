package com.example.autocase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String text;
    public String test = "Hello world";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        TextView textString = findViewById(R.id.inputText1);
        text = textString.getText().toString();
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button1) {
            openActivity2();
        }
        else if(view.getId() == R.id.button2) {
            openActivity2();
        }
        else if(view.getId() == R.id.button3) {
            openActivity2();
        }
        else {
            openActivity2();
        }
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("text", test);
        startActivity(intent);
    }

}




