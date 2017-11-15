package com.example.jack.allergyanalyzer;

/**
 * This activity is For seching about exact recipe ,if it cause allergy or not
 * author: Batool Aljedani
 * Date: Nov 13,2017
 */



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RecSearchActivity extends AppCompatActivity {

    private ImageButton b; //search button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_search);

        b=(ImageButton)findViewById(R.id.imageButton4);
        // b2=(ImageButton)findViewById(R.id.imageButton9);

        //ToDO 
       //Creating my API in this area

        //-------------------------------------------------
        b.setOnClickListener(new View.OnClickListener() {
            /**
             * This method enable us to click on search button and move to searchActivity
             */
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
        //-------------------------------------------------

    }
}
