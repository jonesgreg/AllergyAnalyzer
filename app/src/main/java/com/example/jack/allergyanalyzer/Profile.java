package com.example.jack.allergyanalyzer;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

// Profile object to be stored in an arraylist
public class Profile implements Externalizable,Parcelable
{
    //Instance variables
    private String name;
    private String password;
    private ArrayList<String> allergies = new ArrayList<String>();

    //Constructors
    public Profile()
    {

    }

    public Profile(String n, String e, ArrayList<String> a)
    {
        this.name = n;
        this.password = e;
        for(int i = 0; i < a.size(); i++)
            allergies.add(a.get(i));

    }
    //Parcel methods

    public static final Creator<Profile> CREATOR = new Creator<Profile>()
    {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    protected Profile(Parcel in)
    {
        this.name = in.readString();
        this.password = in.readString();
        this.allergies = in.createStringArrayList();
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    //Writing to parcel
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.password);
        dest.writeStringList(this.allergies);
    }
    //Externalizible
    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(name);
        out.writeObject(password);
        out.writeObject(allergies);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        this.name = (String) in.readObject();
        this.password = (String) in.readObject();
        this.allergies = (ArrayList<String>) in.readObject();
    }
}

