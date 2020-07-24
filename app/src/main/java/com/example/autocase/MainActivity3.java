//Vishal Shah
//These are all the packages and dependencies for this class
package com.example.autocase;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Standard Android code when creating an app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //This is used to get the intent from the previous activity
        Intent intent = getIntent();

        //This gets the id for the TextView box
        TextView text4 = findViewById(R.id.textView10);

        /*This sets the TextView to the final text and
        the intent.getStringExtra() gets the "text" key's data,
        which is the text that was passed from MainActivity*/
        text4.setText(randomCase(intent.getStringExtra("text")));
        Button buttonGoBackActivity3 = findViewById(R.id.buttonBackFromActivity3);
        buttonGoBackActivity3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //This method is used for making the alternating case text
    public String randomCase(String tempText){
        //An ArrayList is created
        ArrayList<String> letList = new ArrayList<>();

        //A Random object is created
        Random tempRan = new Random();

        /*This for loop puts each letter of the String
        into each index of the ArrayList AND makes every
        letter lowercase because if there are any letters
        uppercase in the String, it will mess up the
        alternating upper/lower casing*/
        for(int i = 0; i<tempText.length();i++){
            letList.add(tempText.substring(i, i+1).toLowerCase());
        }

         /*This for loop makes random letters uppercase by using
         tempRan.nextInt(3) as the random number generator and it
         does not matter if there are any special characters
         (ex: *$%^,\') because the toUpperCase methods handles it*/
        for(int i = 0; i<letList.size(); i += tempRan.nextInt(3)){
            letList.set(i, letList.get(i).toUpperCase());
        }

        /*The ArrayList has the be rebuilt into a String
        so the first thing that has to happen is this for each loop.
        A StringBuilder object (tempString) is created and then the
        for each puts every index of the ArrayList into the StringBuilder*/

        StringBuilder tempString = new StringBuilder();
        for(String x : letList){
            tempString.append(x);
        }

        return tempString.toString();
    }


}