package com.example.psu_sweng888_listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.psu_sweng888_listview.movieAdaptor.MovieAdapter;

import java.util.ArrayList;

import models.Movie;

public class MainActivity extends AppCompatActivity {

    private ListView movieListView;
    private ArrayList<Movie> movies;

    private final ActivityResultLauncher<Intent> movieDetailsLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        Toast.makeText(
                                MainActivity.this,
                                "Successfully returned from movie details",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListView = findViewById(R.id.movieListView);
        movies = loadMovieData();

        MovieAdapter adapter = new MovieAdapter(this, movies);
        movieListView.setAdapter(adapter);

        movieListView.setOnItemClickListener((parent, view, position, id) -> {
            Movie selectedMovie = movies.get(position);

            Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
            intent.putExtra("movie", selectedMovie);

            movieDetailsLauncher.launch(intent);
        });
    }

    private ArrayList<Movie> loadMovieData(){
        ArrayList<Movie> movies = new ArrayList<>();

        Movie movie1 = new Movie(
                "Obsession",
                "Horror",
                "Curry Barker",
                2026,
                "R",
                6480,
                "After breaking the mysterious \"One Wish Willow\" to win his crush's heart, a hopeless romantic finds himself getting exactly what he asked for but soon discovers that some desires come at a dark, sinister price.");

        Movie movie2 = new Movie(
                "The Drama",
                "Drama",
                "Kristoffer Borgli",
                2026,
                "R",
                6300,
                "A happily-engaged couple is put to the test when an unexpected turn sends their wedding week off the rails.");

        Movie movie3 = new Movie(
                "Backrooms",
                "Horror",
                "Kane Parsons",
                2026,
                "R",
                6600,
                "After a therapist's patient disappears into a dimension beyond reality, she must venture into the unknown to save him.");

        Movie movie4 = new Movie(
                "One Battle After Another",
                "Action",
                "Paul Thomas Anderson",
                2025,
                "R",
                9660,
                "When their enemy resurfaces after 16 years, a group of ex-revolutionaries reunite to rescue the daughter of one of their own.");


        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        return movies;
    }
}