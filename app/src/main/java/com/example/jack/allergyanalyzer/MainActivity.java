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
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***
         * Hide Navigation Bar & Toolbar and create a full screen resolution of the app
         */
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



        //
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run(){
                //the intent connected to this activity is the HomeActivity
                Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();

            }

        },SPLASH_TIME_OUT);
    }


}
