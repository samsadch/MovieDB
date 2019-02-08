package com.samsad.topmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductionCompanies implements Parcelable {

    private String logo_path;

    private String name;

    private String id;

    private String origin_country;

    protected ProductionCompanies(Parcel in) {
        logo_path = in.readString();
        name = in.readString();
        id = in.readString();
        origin_country = in.readString();
    }

    public static final Creator<ProductionCompanies> CREATOR = new Creator<ProductionCompanies>() {
        @Override
        public ProductionCompanies createFromParcel(Parcel in) {
            return new ProductionCompanies(in);
        }

        @Override
        public ProductionCompanies[] newArray(int size) {
            return new ProductionCompanies[size];
        }
    };

    public String getLogo_path ()
    {
        return logo_path;
    }

    public void setLogo_path (String logo_path)
    {
        this.logo_path = logo_path;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getOrigin_country ()
    {
        return origin_country;
    }

    public void setOrigin_country (String origin_country)
    {
        this.origin_country = origin_country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [logo_path = "+logo_path+", name = "+name+", id = "+id+", origin_country = "+origin_country+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(logo_path);
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(origin_country);
    }
}
