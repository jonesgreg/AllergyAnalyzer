package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {
    //Storage variables
    String nameMessage;
    String passwordMessage;
    String defaultValue;
    private Button signUpButton;
    private Button loginButton;


    Intent signUpIntent;
    Intent loginIntent;
    Intent serviceIntent;
    Intent activityIntent;
    Intent savedProfileIntent;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText editText2 = (EditText) findViewById(R.id.editText_userName);
        final EditText editText3 = (EditText) findViewById(R.id.editText_password);

        defaultValue = editText2.getText().toString();

        signUpButton = (Button) findViewById(R.id.button_signUp);
        loginButton  = (Button) findViewById(R.id.button_login);


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
                    String name = editText2.getText().toString();
                    String pass = editText3.getText().toString();

                    Profile user = new Profile();
                    try
                    {
                        FileInputStream fileIn = new FileInputStream(getFilesDir().getAbsolutePath() + "/"+name+".ser");
                        ObjectInputStream inStream = new ObjectInputStream(fileIn);

                        user.readExternal(inStream);

                        inStream.close();
                        fileIn.close();

                        if(pass.equals(user.getPass()))
                        {
                /*TODO put in code that assigns proper information to ui*/
                            Toast.makeText(ProfileActivity.this, "Login Successful",
                                    Toast.LENGTH_LONG).show();

                            serviceIntent = new Intent(getApplicationContext(),PersistentDataService.class);
                            activityIntent = new Intent(getApplicationContext(),HomeActivity.class);
                            //savedProfileIntent = new Intent(getApplicationContext(), SavedProfileActivity.class);

                           /* savedProfileIntent.putExtra("userName", user.getName());
                            savedProfileIntent.putExtra("email", user.getEmail());
                            savedProfileIntent.putExtra("gender", user.getGender());
                            savedProfileIntent.putExtra("allergies", user.getAllergies());*/

                            serviceIntent.putExtra("name",user.getName());
                            serviceIntent.putExtra("email",user.getEmail());
                            serviceIntent.putExtra("gend",user.getGender());
                            serviceIntent.putExtra("allergies", user.getAllergies());

                            startService(serviceIntent);
                            startActivity(activityIntent);
                            //startActivity(savedProfileIntent);

                            Log.e("Name ",user.getName());
                            Log.e("Pass ",user.getPass());
                            Log.e("Email ", user.getEmail());
                            Log.e("Boolean ", "" + user.getGender());
                        }
                        else
                        {
                            Toast.makeText(ProfileActivity.this, "Incorrect Login!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(ProfileActivity.this, "Error File Not Found!",
                                Toast.LENGTH_LONG).show();
                        Log.e("     1       : ", e.toString());
                    }
                }
            }
        });
    }
}

