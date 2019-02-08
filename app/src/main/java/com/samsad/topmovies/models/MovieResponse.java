package com.samsad.topmovies.models;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieResponse {
    private String page;

    private String total_pages;

    private Movie[] results;

    private String total_results;

    public ArrayList<Movie> getMovieList() {
        ArrayList<Movie> arrayList = null;
        try {
            if(results != null) {
                arrayList = new ArrayList<Movie>(Arrays.asList(results));
            }
        } catch (Exception e){
            arrayList = null;
        }

        return arrayList;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    public Movie[] getResults ()
    {
        return results;
    }

    public void setResults (Movie[] results)
    {
        this.results = results;
    }

    public String getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return  "Movies = "+results;
    }
}
