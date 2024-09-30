package com.svalero.retrofitthemoviesdb;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.svalero.retrofitthemoviesdb.json_mapper.Movie;
import com.svalero.retrofitthemoviesdb.json_mapper.MovieResponse;
import com.svalero.retrofitthemoviesdb.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<MovieResponse> call = RetrofitClient.getInstance().
                getPopularMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    // Procesa y muestra las películas aquí
                    for (Movie myMovie:movies
                    ) {
                        Toast.makeText(MainActivity.this,
                                "Movie:" + myMovie.getTitle(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}