package com.svalero.retrofitthemoviesdb.movies_api;

import com.svalero.retrofitthemoviesdb.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    // Routers!!! express.js
    @GET("movie/popular?api_key=61e0d26ead78a0b630a6ffe401e15a6a")
    Call<MovieResponse> getPopularMovies();

}
