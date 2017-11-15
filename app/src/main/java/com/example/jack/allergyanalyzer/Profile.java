package com.example.jack.allergyanalyzer;
import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

// Profile object to be stored in an arraylist
public class Profile implements Parcelable
{
    private String name;
    private String email;
    private ArrayList<String> allergies = new ArrayList<String>();

    //Constructors
    public Profile()
    {

    }

    public Profile(String n, String e, ArrayList<String> a)
    {
        name = n;
        email = e;
        for(int i = 0; i < a.size(); i++)
            allergies.add(a.get(i));

    }
    //Parcel methods
    protected Profile(Parcel in)
    {
        name = in.readString();
        email = in.readString();
        allergies = in.createStringArrayList();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    //Writing to parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeStringList(allergies);
    }
}

