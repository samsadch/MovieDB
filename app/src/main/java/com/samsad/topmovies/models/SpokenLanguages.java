package com.samsad.topmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

public class SpokenLanguages implements Parcelable {

    private String name;

    private String iso_639_1;

    protected SpokenLanguages(Parcel in) {
        name = in.readString();
        iso_639_1 = in.readString();
    }

    public static final Creator<SpokenLanguages> CREATOR = new Creator<SpokenLanguages>() {
        @Override
        public SpokenLanguages createFromParcel(Parcel in) {
            return new SpokenLanguages(in);
        }

        @Override
        public SpokenLanguages[] newArray(int size) {
            return new SpokenLanguages[size];
        }
    };

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIso_639_1 ()
    {
        return iso_639_1;
    }

    public void setIso_639_1 (String iso_639_1)
    {
        this.iso_639_1 = iso_639_1;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", iso_639_1 = "+iso_639_1+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(iso_639_1);
    }
}
