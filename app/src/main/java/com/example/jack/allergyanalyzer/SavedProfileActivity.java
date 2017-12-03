package com.example.jack.allergyanalyzer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SavedProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_profile);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String pass = extras.getString("pass");

        Profile user = new Profile();

        try
        {
            FileInputStream fileIn = new FileInputStream(getFilesDir().getAbsolutePath() + "/"+name+".ser");
            ObjectInputStream inStream = new ObjectInputStream(fileIn);

            user.readExternal(inStream);

            inStream.close();
            fileIn.close();

            if(true)
            {
                /*TODO put in code that assigns proper information to ui*/
                Toast.makeText(SavedProfileActivity.this, "IT WORKED!",
                        Toast.LENGTH_LONG).show();
                Log.e("Name ",user.getName());
                Log.e("Pass ",user.getPass());
                Log.e("Email ", user.getEmail());
                Log.e("Boolean ", "" + user.getGender());
            }
        }
        catch(Exception e)
        {
            Toast.makeText(SavedProfileActivity.this, "Error File Not Found!",
                    Toast.LENGTH_LONG).show();
            Log.e("     1       : ", e.toString());
        }





    }

}
