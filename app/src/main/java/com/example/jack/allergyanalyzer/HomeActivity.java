/**
 * This activity is For Home Page
 * author: Batool Aljedani
 * Date: Nov 11,2017
 */

package com.example.jack.allergyanalyzer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    private ImageButton b1; //search button
    private ImageButton b2; //profile button
    private ImageButton b3; //Home button
    private ImageButton b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b1=(ImageButton)findViewById(R.id.imageButton2);
        b2=(ImageButton)findViewById(R.id.imageButton3);
        b3=(ImageButton)findViewById(R.id.imageButton4);
        b4=(ImageButton)findViewById(R.id.imageButton5);

        //-------------------------------------------------
        b1.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on search button and move to searchActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
            }
        });
        //-------------------------------------------------
        b2.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on profile button and move to MainActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),searchActivity.class);
                startActivity(i);
            }
        });
        //-------------------------------------------------
        b3.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on profile button and move to MainActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),SavedProfileActivity.class);
                startActivity(i);
            }
        });
        //-------------------------------------------------
        b4.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on profile button and move to MainActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
