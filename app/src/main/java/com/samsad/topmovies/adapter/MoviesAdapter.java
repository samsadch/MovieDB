package com.samsad.topmovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.samsad.topmovies.R;
import com.samsad.topmovies.activity.DetailsActivity;
import com.samsad.topmovies.databinding.ListItemMovieBinding;
import com.samsad.topmovies.models.Movie;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.samsad.topmovies.activity.BaseActivity.IMAGE_URL;

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private ArrayList<Movie> movieList;
    private LayoutInflater inflater;
    private Context context;

    public MoviesAdapter(ArrayList<Movie> movies, Context context) {
        this.movieList = movies;
        this.context =context;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //View view = inflater.inflate(R.layout)

        ListItemMovieBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.list_item_movie, viewGroup, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            final Movie movie = movieList.get(position);
            holder.binding.setMovie(movie);
            holder.binding.topLlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("MOVIE_ID",movie.getId());
                    context.startActivity(intent);
                }
            });


            DateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd MMMM yyyy");
            Date date = originalFormat.parse(movie.getRelease_date());
            String formattedDate = targetFormat.format(date);  // 20120821
            holder.binding.dateTxv.setText(formattedDate);
            String imageUrl = IMAGE_URL + movie.getPoster_path();
            Picasso.get().load(imageUrl).into(holder.binding.movieImage);
            holder.binding.languageTxv.setText(movie.getOriginal_language().toUpperCase());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemMovieBinding binding;

        public ViewHolder(final ListItemMovieBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
