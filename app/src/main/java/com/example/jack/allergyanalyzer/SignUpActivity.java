package com.example.jack.allergyanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    //chesks to see if radio option was chosen
    boolean radioBtnWasPressed;
    //variable to hold gender
    boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //gets the ui aspects
        RadioGroup genderRadioGroup = (RadioGroup) findViewById(R.id.radiogroup_gender);
        genderRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        final EditText nameTxt = (EditText) findViewById(R.id.editText_userName2);
        final EditText passwordTxt = (EditText) findViewById(R.id.editText_password2);
        final EditText emailTxt = (EditText) findViewById(R.id.editText_email);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTxt.toString();
                String pass = passwordTxt.toString();
                String email = emailTxt.toString();


                Intent intent = new Intent(getApplicationContext(),Profile2Activity.class);

                if(name == null || pass == null || email == null || radioBtnWasPressed != true )
                    Toast.makeText(SignUpActivity.this, "Please fill all fields",
                            Toast.LENGTH_LONG).show();
                else
                {

                    intent.putExtra("name",name);
                    intent.putExtra("password",pass);
                    intent.putExtra("email",email);
                    intent.putExtra("gender",gender);
                    startActivity(intent);
                }
            }
        });
    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener= new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i == R.id.radiobutton_male)
            {
                radioBtnWasPressed = true;
            }
            else if(i == R.id.radiobutton_female)
            {
                radioBtnWasPressed = true;
            }
        }
    };
}