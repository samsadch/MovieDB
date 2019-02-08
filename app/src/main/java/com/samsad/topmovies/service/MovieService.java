package com.samsad.topmovies.service;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samsad.topmovies.R;
import com.samsad.topmovies.models.MovieResponse;
import com.samsad.topmovies.models.ResponseMovieDetails;
import com.samsad.topmovies.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.samsad.topmovies.activity.BaseActivity.BASE_URL;
import static com.samsad.topmovies.activity.MainActivity.MOVIE_LIST;
import static com.samsad.topmovies.activity.MainActivity.RECEIVER_DETAILS;
import static com.samsad.topmovies.activity.MainActivity.RECEIVER_LIST;

public class MovieService extends IntentService {

    private MovieResponse movieResponse;

    public static final String ACTION_DETAILS = "action.details";
    public static final String ACTION_LIST = "action.list";

    public MovieService() {
        super("MovieService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent.getAction().equalsIgnoreCase(ACTION_LIST)) {
            getTopRatedMovies();
        } else if (intent.getAction().equalsIgnoreCase(ACTION_DETAILS)) {
            String id = intent.getStringExtra("MOVIE_ID");
            getMovieDetails(id);
        }
    }

    private void getMovieDetails(String id) {
        try{
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            ApiClient api = retrofit.create(ApiClient.class);

            Call<ResponseMovieDetails> call = api.getDetails(id,getString(R.string.api_key));
            call.enqueue(new Callback<ResponseMovieDetails>() {
                @Override
                public void onResponse(Call<ResponseMovieDetails> call, Response<ResponseMovieDetails> response) {
                    try {
                        Intent intent = new Intent(RECEIVER_DETAILS);
                        intent.putExtra("DATA", response.body());
                        sendBroadcast(intent);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseMovieDetails> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void getTopRatedMovies() {
        try{
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            ApiClient api = retrofit.create(ApiClient.class);

            Call<MovieResponse> call = api.getTopRatedMovies(getString(R.string.api_key)/*,"popularity.desc"*/);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    try {
                        movieResponse = response.body();

                        Intent intent = new Intent(RECEIVER_LIST);
                        intent.putParcelableArrayListExtra(MOVIE_LIST, movieResponse.getMovieList());
                        sendBroadcast(intent);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
