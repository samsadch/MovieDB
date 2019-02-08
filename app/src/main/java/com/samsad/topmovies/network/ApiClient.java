package com.samsad.topmovies.network;

import com.samsad.topmovies.models.MovieResponse;
import com.samsad.topmovies.models.ResponseMovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);


    @GET("movie/{id}")
    Call<ResponseMovieDetails> getDetails(@Path("id") String id, @Query("api_key") String apiKey);

    @GET("movie")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey,@Query("sort_by") String sort );

    /*ttps://api.themoviedb.org/3/discover/movie?api_key=<<api_key>>&language=en-US&
    sort_by=popularity.desc&include_adult=false&include_video=false&page=1*/
}
