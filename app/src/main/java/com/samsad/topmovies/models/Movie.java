package com.samsad.topmovies.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

public class Movie extends BaseObservable implements Parcelable {

    private String overview;

    private String original_language;

    private String original_title;

    private String video;

    private String title;

    private String[] genre_ids;

    private String poster_path;

    private String backdrop_path;

    private String release_date;

    private String vote_average;

    private String popularity;

    private String id;

    private String adult;

    private String vote_count;

    protected Movie(Parcel in) {
        overview = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        video = in.readString();
        title = in.readString();
        genre_ids = in.createStringArray();
        poster_path = in.readString();
        backdrop_path = in.readString();
        release_date = in.readString();
        vote_average = in.readString();
        popularity = in.readString();
        id = in.readString();
        adult = in.readString();
        vote_count = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Bindable
    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getOriginal_language ()
    {
        return original_language;
    }

    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    @Bindable
    public String getOriginal_title ()
    {
        return original_title;
    }

    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }

    public String getVideo ()
    {
        return video;
    }

    public void setVideo (String video)
    {
        this.video = video;
    }


    @Bindable
    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String[] getGenre_ids ()
    {
        return genre_ids;
    }

    public void setGenre_ids (String[] genre_ids)
    {
        this.genre_ids = genre_ids;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }


    @Bindable
    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    @Bindable
    public String getVote_average ()
    {
        return vote_average;
    }

    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    public String getPopularity ()
    {
        return popularity;
    }

    public void setPopularity (String popularity)
    {
        this.popularity = popularity;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAdult ()
    {
        return adult;
    }

    public void setAdult (String adult)
    {
        this.adult = adult;
    }

    public String getVote_count ()
    {
        return vote_count;
    }

    public void setVote_count (String vote_count)
    {
        this.vote_count = vote_count;
    }

    @Override
    public String toString()
    {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(overview);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(video);
        dest.writeString(title);
        dest.writeStringArray(genre_ids);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeString(release_date);
        dest.writeString(vote_average);
        dest.writeString(popularity);
        dest.writeString(id);
        dest.writeString(adult);
        dest.writeString(vote_count);
    }
}
