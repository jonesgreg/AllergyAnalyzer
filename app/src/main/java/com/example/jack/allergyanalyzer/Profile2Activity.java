package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Profile2Activity extends ListActivity {

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
        setContentView(R.layout.activity_profile2);

        Button btn = (Button) findViewById(R.id.button_signUp);
        Button btn2 = (Button) findViewById(R.id.button_login);
        ListView listview= getListView();
        //Sign up button


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If inputs are invalid tell the user else create profile

                intent = new Intent(getApplicationContext(),SavedProfileActivity.class);

                if(Allergies.size() == 0)
                    Toast.makeText(Profile2Activity.this, "Choose at least one Allergy",
                            Toast.LENGTH_LONG).show();
                else
                {
                    Bundle extras = getIntent().getExtras();
                    String name = extras.getString("name");
                    String password = extras.getString("password");

                    intent.putExtra("name",name);
                    intent.putExtra("password",password);
                    intent.putExtra("allergies",Allergies);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);
        //text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked,Allergy));


    }

    public void onListItemClick(ListView parent, View v, int position, long id){
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
