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
    String passwordMessage;
    private Button signUpButton;
    private Button loginButton;


    Intent signUpIntent;
    Intent loginIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText editText2 = (EditText) findViewById(R.id.editText_userName);
        final EditText editText3 = (EditText) findViewById(R.id.editText_password);

        signUpButton = (Button) findViewById(R.id.button_signUp);
        loginButton  = (Button) findViewById(R.id.button_login);


        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(),SavedProfileActivity.class);
                nameMessage = editText2.getText().toString();
                passwordMessage = editText3.getText().toString();

                if(nameMessage == null || passwordMessage == null)
                    Toast.makeText(ProfileActivity.this, "Please fill all fields",
                            Toast.LENGTH_LONG).show();
                else
                {
                    intent.putExtra("name",nameMessage);
                    intent.putExtra("password",passwordMessage);
                    startActivity(intent);
                }
            }
        });
        */

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpIntent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                nameMessage = editText2.getText().toString();
                passwordMessage = editText3.getText().toString();

                if(nameMessage == null || passwordMessage == null)
                {
                    Toast.makeText(ProfileActivity.this, "Please fill all fields",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    loginIntent.putExtra("name",nameMessage);
                    loginIntent.putExtra("password",passwordMessage);
                    startActivity(loginIntent);
                }
            }
        });
    }
}

