/**
 * This activity is to Create Welcome Screen (Splash Screen)
 * author: Batool Aljedani
 * Date: Nov 12,2017
 */


package com.example.jack.allergyanalyzer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run(){
                //the intent connected to this activity is the HomeActivity
                Intent homeIntent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(homeIntent);
                finish();

            }

        },SPLASH_TIME_OUT);
    }


}
