package com.example.psu_sweng888_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import models.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Movie Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finishWithResult());

        TextView titleTextView = findViewById(R.id.detailsTitle);
        TextView yearTextView = findViewById(R.id.detailsYear);
        TextView ratingTextView = findViewById(R.id.detailsRating);
        TextView genreTextView = findViewById(R.id.detailsGenre);
        TextView descriptionTextView = findViewById(R.id.detailsDescription);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        if (movie != null) {
            titleTextView.setText(movie.getTitle());
            yearTextView.setText("Year: " + movie.getReleaseYear());
            ratingTextView.setText("Rating: " + movie.getRating());
            genreTextView.setText("Genre: " + movie.getGenre());
            descriptionTextView.setText(movie.getDescription());
        }

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finishWithResult();
            }
        });
    }

    private void finishWithResult() {
        Intent resultIntent = new Intent();
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}