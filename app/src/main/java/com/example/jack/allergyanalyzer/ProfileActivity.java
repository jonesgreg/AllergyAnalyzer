package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.content.Intent;
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

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Submit button
        Button btn = (Button) findViewById(R.id.button);

        final EditText editText = (EditText) findViewById(R.id.editText5);
        final EditText editText3 = (EditText) findViewById(R.id.editText7);

        ListView listview= getListView();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If inputs are invalid tell the user else create profile

                intent = new Intent(getApplicationContext(),SavedProfileActivity.class);

                if(Allergies.size() == 0)
                    Toast.makeText(ProfileActivity.this, "Choose at least one Allergy",
                            Toast.LENGTH_LONG).show();
                else
                {

                    nameMessage = editText.getText().toString();
                    emailMessage = editText3.getText().toString();

                    intent.putExtra("name",nameMessage);
                    intent.putExtra("email",emailMessage);
                    intent.putExtra("allergies",Allergies);
                    startActivity(intent);
                }
            }
        });


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

