package com.samsad.topmovies.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsad.topmovies.R;
import com.samsad.topmovies.models.Genres;
import com.samsad.topmovies.models.ResponseMovieDetails;
import com.samsad.topmovies.service.MovieService;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import static com.samsad.topmovies.activity.MainActivity.RECEIVER_DETAILS;
import static com.samsad.topmovies.service.MovieService.ACTION_DETAILS;

public class DetailsActivity extends BaseActivity {
    String movieId;
    ResponseMovieDetails movieDetails;
    private Context context;
    ImageView bannerImage;
    private TextView descriptionTxv;
    private TextView durationTxv;
    private TextView dateTxv;
    private TextView ratingTxv;
    private TextView genreTxv;
    private TextView languageTxv;
    private TextView budgetTxv;
    private TextView revenueTxv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details);
            context = DetailsActivity.this;
            movieId = getIntent().getExtras().getString("MOVIE_ID");
            initUI();
            setLoading();
            showProgress();
            Intent intent = new Intent(context, MovieService.class);
            intent.setAction(ACTION_DETAILS);
            intent.putExtra("MOVIE_ID", movieId);
            startService(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initUI() {
        try{
            bannerImage = findViewById(R.id.bannerImage);
            descriptionTxv = (TextView) findViewById(R.id.descriptionTxv);
            durationTxv = (TextView) findViewById(R.id.durationTxv);
            dateTxv = (TextView) findViewById(R.id.dateTxv);
            ratingTxv = (TextView) findViewById(R.id.ratingTxv);
            genreTxv = (TextView) findViewById(R.id.genreTxv);
            languageTxv = (TextView) findViewById(R.id.languageTxv);
            budgetTxv = (TextView) findViewById(R.id.budgetTxv);
            revenueTxv = (TextView) findViewById(R.id.revenueTxv);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                hideProgress();
                Bundle bundle = intent.getExtras();
                movieDetails = bundle.getParcelable("DATA");
                String imageUrl = IMAGE_URL + movieDetails.getBackdrop_path();
                Picasso.get().load(imageUrl).into(bannerImage);
                descriptionTxv.setText(movieDetails.getOverview());

                durationTxv.setText(movieDetails.getRuntime()+" minutes");
                dateTxv.setText(movieDetails.getRelease_date());
                ratingTxv.setText(movieDetails.getVote_average());

                DecimalFormat df = new DecimalFormat("0.00M");
                Long budget = Long.valueOf(movieDetails.getBudget());
                Long revenue = Long.valueOf(movieDetails.getRevenue());
                budgetTxv.setText(df.format(budget / 1000000));
                revenueTxv.setText(df.format(revenue / 1000000));
                String genre = " ";
                Genres[] gen = movieDetails.getGenres();
                for (int i=0;i<gen.length;i++){
                    genre += gen[i].getName()+",";
                }
                genreTxv.setText(genre.substring(0, genre.length() - 1));
                languageTxv.setText(movieDetails.getOriginal_language().toUpperCase());
            }
            catch (Exception e){
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(RECEIVER_DETAILS));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
