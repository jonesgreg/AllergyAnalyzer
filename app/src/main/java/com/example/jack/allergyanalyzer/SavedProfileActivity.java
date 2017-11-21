package com.example.jack.allergyanalyzer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_profile);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String email = extras.getString("email");
        ArrayList<String> allergies = extras.getStringArrayList("allergies");


        try
        {

        }
        catch (Exception e)
        {

        }

    }

}
