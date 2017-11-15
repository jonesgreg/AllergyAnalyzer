package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class ProfileActivity extends ListActivity {
    //Storage variables
    String nameMessage;
    String emailMessage;
    ArrayList<String> Allergies = new ArrayList<String>();

    //String array holding the list of allergies
    String[] Allergy= {
            "Corn Allergy",
            "Egg Allergy",
            "Fish Allergy",
            "Meat Allergy",
            "Milk Allergy",
            "Peanut Allergy",
            "Shellfish Allergy",
            "Soy Allergy",
            "Tree Nut Allergy",
            "Wheat Allergy",
            "FPIES Allergy",};

    //JUSTINS CODE STARTS HERE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Submit button
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If inputs are invalid tell the user else create profile
                if(Allergies.size() == 0)
                    Toast.makeText(ProfileActivity.this, "Choose at least one Allergy",
                            Toast.LENGTH_LONG).show();
                else
                {
                    Profile user = new Profile(nameMessage,emailMessage,Allergies);
                    Toast.makeText(ProfileActivity.this, "User profile created",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        setProfile();


    }

    /** Called when the user taps the Save button deals with fields and drop down list*/
    public void setProfile()
    {

        // Do something in response to button

        //Takes in person's name
        EditText editText = (EditText) findViewById(R.id.editText5);
        nameMessage = editText.getText().toString();

        //Takes in person's email
        EditText editText3 = (EditText) findViewById(R.id.editText7);
        emailMessage = editText3.getText().toString();

        //Take's in person's allergies

        ListView listview= getListView();
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);
        //text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked,Allergy));



    }
    public void onListItemClick(ListView parent, View v,int position,long id){
        CheckedTextView item = (CheckedTextView) v;
        //if item is unchecked and add to Allergies, else uncheck and take it out of Allergies
        if(item.isChecked())
        {
            Toast.makeText(this, Allergy[position] + " checked : " +
                    item.isChecked(), Toast.LENGTH_SHORT).show();
            Allergies.add(Allergy[position]);
        }
        else
        {
            Toast.makeText(this, Allergy[position] + " unchecked : " +
                    item.isChecked(), Toast.LENGTH_SHORT).show();
            Allergies.remove(Allergy[position]);
        }
    }
}

