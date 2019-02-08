package com.samsad.topmovies.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.samsad.topmovies.R;
import com.samsad.topmovies.adapter.MoviesAdapter;
import com.samsad.topmovies.models.Movie;
import com.samsad.topmovies.models.MovieResponse;
import com.samsad.topmovies.databinding.ActivityMainBinding;
import com.samsad.topmovies.service.MovieService;

import java.util.ArrayList;

import static com.samsad.topmovies.service.MovieService.ACTION_LIST;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private MoviesAdapter adapter;
    private ArrayList<Movie> movieList = new ArrayList<>();

    public static final String MOVIE_LIST = "movie.list";
    public static final String RECEIVER_LIST = "service.receiver.list";
    public static final String RECEIVER_DETAILS = "service.receiver.details";

    private MovieResponse movieResponse;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(getString(R.string.pupular_movies));
        context = MainActivity.this;
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        startMovieService();
        setLoading(getString(R.string.loading_message));
        showProgress();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        // Retrieve the SearchView and plug it into SearchManager
       /* final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

        return true;
    }

    private void initRecyclerView() {
        try {
            if(isValid(movieList)) {
                recyclerView = binding.movieRcv;
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setNestedScrollingEnabled(false);
                adapter = new MoviesAdapter(movieList, this);
                recyclerView.setAdapter(adapter);
            }
        }
        catch(Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            hideProgress();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                movieList = bundle.getParcelableArrayList(MOVIE_LIST);
                int k = movieList.size();
                if ( k > 15 )
                    movieList.subList(15, k).clear();
                initRecyclerView();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(RECEIVER_LIST));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    private void startMovieService() {
        try{
            Intent intent = new Intent(this, MovieService.class);
            intent.setAction(ACTION_LIST);
            startService(intent);
        }catch (Exception e){
            hideProgress();
            e.printStackTrace();
        }
    }
}
