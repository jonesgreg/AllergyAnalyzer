package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {
    //Storage variables
    String nameMessage;
    String emailMessage;


    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        final EditText editText = (EditText) findViewById(R.id.editText5);
        final EditText editText3 = (EditText) findViewById(R.id.editText7);

        Button btn = (Button) findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(),SavedProfileActivity.class);
                nameMessage = editText.getText().toString();
                emailMessage = editText3.getText().toString();

                if(nameMessage == null || emailMessage == null)
                    Toast.makeText(ProfileActivity.this, "Please fill all feilds",
                            Toast.LENGTH_LONG).show();
                else
                {
                    intent.putExtra("name",nameMessage);
                    intent.putExtra("email",emailMessage);
                    startActivity(intent);
                }
            }
        });

    }

}

