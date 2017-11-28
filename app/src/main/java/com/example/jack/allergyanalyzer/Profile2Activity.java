package com.example.jack.allergyanalyzer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Profile2Activity extends ListActivity {

    ArrayList<String> allergies = new ArrayList<String>();

    //String array holding the list of allergies
    String[] Allergy= {
            "Corn",
            "Egg",
            "Fish",
            "Meat",
            "Milk",
            "Peanut",
            "Shellfish",
            "Soy",
            "Tree-Nut",
            "Gluten",
            "Onions",};

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        Bundle extra = getIntent().getExtras();
        final String name = extra.getString("name");
        final String pass = extra.getString("pass");
        final String email = extra.getString("email");
        final boolean gender = extra.getBoolean("gender");
        intent = new Intent(getApplicationContext(),SavedProfileActivity.class);

        final String filePath = getFilesDir() + "/" + name + ".ser";

        Button btn = (Button) findViewById(R.id.button);
        ListView listview= getListView();
        //Submit button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                    try
                    {
                        File file = new File(getFilesDir(), name + ".ser");

                        Profile user = new Profile(name,pass,email,gender,allergies);

                        FileOutputStream fileOut = new FileOutputStream(file);
                        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
                        outStream.writeObject(user);
                        outStream.close();
                        fileOut.close();

                        intent.putExtra("name",name);
                        intent.putExtra("pass", pass);
                        startActivity(intent);
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(Profile2Activity.this, "Profile Can not be Created! ",
                                Toast.LENGTH_LONG).show();
                        Log.e("File Not Found? ",e.toString());
                        e.printStackTrace();
                    }

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
            allergies.add(Allergy[position]);
        }
        else
        {
            Toast.makeText(this, Allergy[position] + " unchecked : " +
                    item.isChecked(), Toast.LENGTH_SHORT).show();
            allergies.remove(Allergy[position]);
        }
    }
}
