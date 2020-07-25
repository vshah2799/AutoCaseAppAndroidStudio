package com.example.autocase;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView view1 = findViewById(R.id.textViewHistory);

        Button buttonDelete = findViewById(R.id.buttonDeleteHistory);

        buttonDelete.setOnClickListener(this);

        try {
            view1.setText(readHistory());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view) {
        deleteHistory();
    }

    public void deleteHistory(){
        File[] files = this.getFilesDir().listFiles();
        if(files != null) {
            for (File file : files) {
                file.delete();
                Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "No Text To Delete", Toast.LENGTH_LONG).show();
        }
    }

    public String readHistory() throws FileNotFoundException {
        FileInputStream fis = this.openFileInput("history.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
        }

        return stringBuilder.toString();

    }


}