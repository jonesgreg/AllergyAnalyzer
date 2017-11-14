package com.example.jack.allergyanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    public static final String SAVED_PROFILE = "com.allergyanalyzer.allergyanalyzer";
    public static final String SAVED_PROFILE2 = "com.allergyanalyzer.allergyanalyzer";
    public static final String SAVED_PROFILE3 = "com.allergyanalyzer.allergyanalyzer";
    public static final String SAVED_PROFILE4 = "com.allergyanalyzer.allergyanalyzer";
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

        ListView listview= getListView();
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);
        //text filtering
        listview.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked,Allergy));

    }

    /** Called when the user taps the Save button */
    public void saveMessage(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(Profile.this, SavedProfilePage.class);
        //Takes in person's name
        EditText editText = findViewById(R.id.editText5);
        String nameMessage = editText.getText().toString();
        intent.putExtra(SAVED_PROFILE, nameMessage);
        startActivity(intent);

        Intent intent2 = new Intent(Profile.this, SavedProfilePage.class);
        //Takes in person's phone number
        EditText editText2 = findViewById(R.id.editText6);
        String phoneMessage = editText2.getText().toString();
        intent2.putExtra(SAVED_PROFILE2, phoneMessage);
        startActivity(intent2);

        Intent intent3 = new Intent(Profile.this, SavedProfilePage.class);
        //Takes in person's email
        EditText editText3 = findViewById(R.id.editText7);
        String emailMessage = editText3.getText().toString();
        intent3.putExtra(SAVED_PROFILE3, emailMessage);
        startActivity(intent3);

        Intent intent4 = new Intent(Profile.this, SavedProfilePage.class);
        //Take's in person's allergies
        //Batool will change this

    }
    public void onListItemClick(ListView parent, View v,int position,long id){
        CheckedTextView item = (CheckedTextView) v;
        Toast.makeText(this, Allergy[position] + " checked : " +
                item.isChecked(), Toast.LENGTH_SHORT).show();
    }
}

}
