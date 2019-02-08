package com.samsad.topmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ResponseMovieDetails implements Parcelable {
    private String original_language;

    private String imdb_id;

    private String video;

    private String title;

    private String backdrop_path;

    private String revenue;

    private Genres[] genres;

    private String popularity;

    private ProductionCountries[] production_countries;

    private String id;

    private String vote_count;

    private String budget;

    private String overview;

    private String original_title;

    private String runtime;

    private String poster_path;

    private SpokenLanguages[] spoken_languages;

    private ProductionCompanies[] production_companies;

    private String release_date;

    private String vote_average;

    private String belongs_to_collection;

    private String tagline;

    private String adult;

    private String homepage;

    private String status;

    protected ResponseMovieDetails(Parcel in) {
        original_language = in.readString();
        imdb_id = in.readString();
        video = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        revenue = in.readString();
        genres = in.createTypedArray(Genres.CREATOR);
        popularity = in.readString();
        production_countries = in.createTypedArray(ProductionCountries.CREATOR);
        id = in.readString();
        vote_count = in.readString();
        budget = in.readString();
        overview = in.readString();
        original_title = in.readString();
        runtime = in.readString();
        poster_path = in.readString();
        spoken_languages = in.createTypedArray(SpokenLanguages.CREATOR);
        production_companies = in.createTypedArray(ProductionCompanies.CREATOR);
        release_date = in.readString();
        vote_average = in.readString();
        belongs_to_collection = in.readString();
        tagline = in.readString();
        adult = in.readString();
        homepage = in.readString();
        status = in.readString();
    }

    public static final Creator<ResponseMovieDetails> CREATOR = new Creator<ResponseMovieDetails>() {
        @Override
        public ResponseMovieDetails createFromParcel(Parcel in) {
            return new ResponseMovieDetails(in);
        }

        @Override
        public ResponseMovieDetails[] newArray(int size) {
            return new ResponseMovieDetails[size];
        }
    };

    public String getOriginal_language ()
    {
        return original_language;
    }

    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    public String getImdb_id ()
    {
        return imdb_id;
    }

    public void setImdb_id (String imdb_id)
    {
        this.imdb_id = imdb_id;
    }

    public String getVideo ()
    {
        return video;
    }

    public void setVideo (String video)
    {
        this.video = video;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }

    public String getRevenue ()
    {
        return revenue;
    }

    public void setRevenue (String revenue)
    {
        this.revenue = revenue;
    }

    public Genres[] getGenres ()
    {
        return genres;
    }

    public void setGenres (Genres[] genres)
    {
        this.genres = genres;
    }

    public String getPopularity ()
    {
        return popularity;
    }

    public void setPopularity (String popularity)
    {
        this.popularity = popularity;
    }

    public ProductionCountries[] getProduction_countries ()
    {
        return production_countries;
    }

    public void setProduction_countries (ProductionCountries[] production_countries)
    {
        this.production_countries = production_countries;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getVote_count ()
    {
        return vote_count;
    }

    public void setVote_count (String vote_count)
    {
        this.vote_count = vote_count;
    }

    public String getBudget ()
    {
        return budget;
    }

    public void setBudget (String budget)
    {
        this.budget = budget;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getOriginal_title ()
    {
        return original_title;
    }

    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }

    public String getRuntime ()
    {
        return runtime;
    }

    public void setRuntime (String runtime)
    {
        this.runtime = runtime;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    public SpokenLanguages[] getSpoken_languages ()
    {
        return spoken_languages;
    }

    public void setSpoken_languages (SpokenLanguages[] spoken_languages)
    {
        this.spoken_languages = spoken_languages;
    }

    public ProductionCompanies[] getProduction_companies ()
    {
        return production_companies;
    }

    public void setProduction_companies (ProductionCompanies[] production_companies)
    {
        this.production_companies = production_companies;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String getVote_average ()
    {
        return vote_average;
    }

    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    public String getBelongs_to_collection ()
    {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection (String belongs_to_collection)
    {
        this.belongs_to_collection = belongs_to_collection;
    }

    public String getTagline ()
    {
        return tagline;
    }

    public void setTagline (String tagline)
    {
        this.tagline = tagline;
    }

    public String getAdult ()
    {
        return adult;
    }

    public void setAdult (String adult)
    {
        this.adult = adult;
    }

    public String getHomepage ()
    {
        return homepage;
    }

    public void setHomepage (String homepage)
    {
        this.homepage = homepage;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [original_language = "+original_language+", imdb_id = "+imdb_id+", video = "+video+", title = "+title+", backdrop_path = "+backdrop_path+", revenue = "+revenue+", genres = "+genres+", popularity = "+popularity+", production_countries = "+production_countries+", id = "+id+", vote_count = "+vote_count+", budget = "+budget+", overview = "+overview+", original_title = "+original_title+", runtime = "+runtime+", poster_path = "+poster_path+", spoken_languages = "+spoken_languages+", production_companies = "+production_companies+", release_date = "+release_date+", vote_average = "+vote_average+", belongs_to_collection = "+belongs_to_collection+", tagline = "+tagline+", adult = "+adult+", homepage = "+homepage+", status = "+status+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(original_language);
        dest.writeString(imdb_id);
        dest.writeString(video);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeString(revenue);
        dest.writeTypedArray(genres, flags);
        dest.writeString(popularity);
        dest.writeTypedArray(production_countries, flags);
        dest.writeString(id);
        dest.writeString(vote_count);
        dest.writeString(budget);
        dest.writeString(overview);
        dest.writeString(original_title);
        dest.writeString(runtime);
        dest.writeString(poster_path);
        dest.writeTypedArray(spoken_languages, flags);
        dest.writeTypedArray(production_companies, flags);
        dest.writeString(release_date);
        dest.writeString(vote_average);
        dest.writeString(belongs_to_collection);
        dest.writeString(tagline);
        dest.writeString(adult);
        dest.writeString(homepage);
        dest.writeString(status);
    }
}
