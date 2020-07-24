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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //This variable, "text", is the text that the user inputs into the text box in this activity
    private String text;
    private String textForRan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Standard Android code when creating an app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*These variables get the ids of the buttons for MainActivity.xml and then puts listeners on them to see when they're clicked
        When the listener sees if its button is clicked, the onCLick method is run*/
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

        //This gets the id for the textView in MainActivity
        TextView textString = findViewById(R.id.inputText1);

        //This extracts the text from textString and puts it in a temporary variable. This String will be manipulated in the if statements
        String tempText = textString.getText().toString();
        //This variable is for the random casing. It will only be used in the else
        textForRan = textString.getText().toString();

        if(view.getId() == R.id.button1) {
            /*This makes tempText all uppercase and then text gets set to it
            It does not matter if there are any special characters (ex: *$%^,\')
            because the toUpperCase methods handles it*/
            text = tempText.toUpperCase();
        }

        else if(view.getId() == R.id.button2) {
            /*This makes tempText all lowercase and then text gets set to it
            It does not matter if there are any special characters (ex: *$%^,\')
            because the toLowerCase methods handles it*/
            text = tempText.toLowerCase();
        }

        else if(view.getId() == R.id.button3) {
            //An ArrayList is created
            ArrayList<String> letList = new ArrayList<>();

            /*This for loop puts each letter of the String
            into each index of the ArrayList AND makes every
            letter lowercase because if there are any letters
            uppercase in the String, it will mess up the
            alternating upper/lower casing*/
            for(int i = 0; i<tempText.length();i++){
                letList.add(tempText.substring(i, i+1).toLowerCase());
            }

            /*This for loop makes every other letter uppercase
            and it does not matter if there are any special
            characters (ex: *$%^,\') because the toUpperCase
            methods handles it*/
            for(int i = 0; i<letList.size(); i = i+2){
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

            /*text is set to tempString.totoString() because the toString()
            method extracts the pure String from the StringBuilder.
            The toString() method is needed because you cannot directly
            convert a StringBuilder object to a */
            text = tempString.toString();

        }
        else {
            /*This calls the method openActivity3 because the text will be
            manipulated in the next activity*/
            openActivity3();
            //This is so that the openActivity2 is not reached
            return;
        }

        openActivity2();
    }

    public void openActivity2(){
        //This creates a new intent so when a button is clicked, the user can go to the next activity, MainActivity2
        Intent intent = new Intent(this, MainActivity2.class);
        //This lets the "text" variable be passed into the next activity so that it can be displayed
        intent.putExtra("text", text);
        //This starts the new activity
        startActivity(intent);
    }

    public void openActivity3(){
        //This creates a new intent so when a button is clicked, the user can go to the next activity, MainActivity3
        Intent intent = new Intent(this, MainActivity3.class);
        //This lets the "text" variable be passed into the next activity so that it can be displayed
        intent.putExtra("text", textForRan);
        //This starts the new activity
        startActivity(intent);
    }

}




