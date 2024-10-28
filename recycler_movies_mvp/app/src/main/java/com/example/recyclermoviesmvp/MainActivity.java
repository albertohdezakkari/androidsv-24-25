package com.example.recyclermoviesmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recyclermoviesmvp.json_mapper.Movie;
import com.example.recyclermoviesmvp.json_mapper.MovieResponse;
import com.example.recyclermoviesmvp.retrofit.RetrofitClient;
import com.example.recyclermoviesmvp.utils._SV2_INF_THE_BEST;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imgPortada);
        //initRecyclerView();
        // initThreadImageView();
        //initGlide();
         initSVTeamImageView();
    }

    private void initSVTeamImageView() {
        String myUrl = "https://lh4.googleusercontent.com/proxy/JG73x59mTNYlvZ5cQsk9mBag4NiNL_O58q4YC0DtyiSsEw8W2iQcAZhYTyEPbfr1DM3CWbT-LgJ8T8QDy6tKjRGHODw4UDQgN9ZF-rta-ifXdWwCmqw";
        _SV2_INF_THE_BEST.Builder builder = new _SV2_INF_THE_BEST.Builder(myUrl, imagen);

        // builder.generateImage().build();
        builder.build().load();

    }

    private void initGlide() {
        // Simplemente usa Glide para cargar la imagen en el ImageView
        Glide.with(getBaseContext())
                .load("https://lh4.googleusercontent.com/proxy/JG73x59mTNYlvZ5cQsk9mBag4NiNL_O58q4YC0DtyiSsEw8W2iQcAZhYTyEPbfr1DM3CWbT-LgJ8T8QDy6tKjRGHODw4UDQgN9ZF-rta-ifXdWwCmqw")
                //.placeholder(R.drawable.placeholder) // Imagen temporal mientras carga
                //.error(R.drawable.error) // Imagen en caso de error de carga
                .into(imagen); // Cargar la imagen en el ImageView
    }

    // URL => https://w7.pngwing.com/pngs/379/413/png-transparent-300-logo-sparta-film-logo-blood-love-miscellaneous-text-thumbnail.png
    static Bitmap bitmap;
    private void initThreadImageView() {
        new Thread(() ->{
            try {
                URL url = new URL("https://lh4.googleusercontent.com/proxy/JG73x59mTNYlvZ5cQsk9mBag4NiNL_O58q4YC0DtyiSsEw8W2iQcAZhYTyEPbfr1DM3CWbT-LgJ8T8QDy6tKjRGHODw4UDQgN9ZF-rta-ifXdWwCmqw");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(input);

                Runnable actualizarUI =new Runnable() {
                    @Override
                    public void run() {
                        imagen.setImageBitmap(bitmap);
                    }
                };
                runOnUiThread(actualizarUI);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

    private RecyclerView recyclerView;
    // private PeliculaAdapter1 adapter;

    private void initRecyclerView(){
       // recyclerView = findViewById(R.id.recyclerViewPeliculas);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //peliculas = cargarDatos();


        //recyclerView.setAdapter(adapter);

    }
    private void initRetrofit(){
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