package com.example.psu_sweng888_listview.movieAdaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.psu_sweng888_listview.R;

import java.util.List;

import models.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {

    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.movie_item, parent, false);
        }

        Movie movie = getItem(position);

        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView year = convertView.findViewById(R.id.txtYear);
        TextView rating = convertView.findViewById(R.id.txtRating);

        title.setText(movie.getTitle());
        year.setText("Year: " + movie.getReleaseYear());
        rating.setText("Rating: " + movie.getRating());

        return convertView;
    }
}
