/**
 * This activity is For Home Page
 * author: Batool Aljedani
 * Date: Nov 13,2017
 */

package com.example.jack.allergyanalyzer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class searchActivity extends AppCompatActivity {

    private ImageView im1;
    //private ImageView im2;
    private ImageView im3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        im1 = (ImageView) findViewById(R.id.imageView5);

        im3 = (ImageView) findViewById(R.id.imageView8);
        //-------------------------------------------------

        //------------------------------------------------
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RecSearchActivity.class);
                startActivity(i);
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on search button and move to searchActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), RecIntolSearchAcivity.class);
                startActivity(i);
            }
        });
        //------------------------------------------------
        im3.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on search button and move to searchActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });

    }


}