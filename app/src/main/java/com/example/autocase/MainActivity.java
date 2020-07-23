package com.example.autocase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        TextView textString = findViewById(R.id.inputText1);
        String tempText = textString.getText().toString();

        if(view.getId() == R.id.button1) {
            text = tempText.toUpperCase();
        }

        else if(view.getId() == R.id.button2) {
            text = tempText.toLowerCase();
        }

        else if(view.getId() == R.id.button3) {

            ArrayList<String> letList = new ArrayList<>();
            for(int i = 0; i<tempText.length();i++){
                letList.add(tempText.substring(i, i+1));
            }
            for(int i = 0; i<letList.size(); i = i+2){
                letList.set(i, letList.get(i).toUpperCase());
            }
            StringBuilder tempString = new StringBuilder();
            for(String x : letList){
                tempString.append(x);
            }
            text = tempString.toString();

        }
        else {


        }

        openActivity2();
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("text", text);
        startActivity(intent);
    }

}




