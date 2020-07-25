//Vishal Shah
//These are all the packages and dependencies for this class
package com.example.autocase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Standard Android code when creating an app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //This is used to get the intent from the previous activity
        Intent intent = getIntent();

        //This gets the id for the TextView box
        TextView text3 = findViewById(R.id.textView2);

        /*This sets the TextView to the final text and
        the intent.getStringExtra() gets the "text" key's data,
        which is the text that was passed from MainActivity*/
        text3.setText(intent.getStringExtra("text"));


        writeHistory(intent.getStringExtra("text"));

        //This is for going back to MainActivity
        Button buttonGoBackActivity2 = findViewById(R.id.buttonBackFromActivity2);
        buttonGoBackActivity2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //This is for going back to MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void writeHistory(String fileContents) {
        String filename = "history.txt";
        String fileContents2 = fileContents + "\n\n";
        try (FileOutputStream fos = this.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(fileContents2.getBytes());
            Toast.makeText(this, "Saved",
                    Toast.LENGTH_LONG).show();
        }
        catch(IOException e){
            //Error, file not found
            e.printStackTrace();
        }
    }
}