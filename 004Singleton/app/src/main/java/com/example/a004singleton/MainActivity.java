package com.example.a004singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a004singleton.services.ServicePantallaPrincipal;

public class MainActivity extends AppCompatActivity {
    private Button btnSaludar;

    // onload: Javascript //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaludar = findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            // ServicePantallaPrincipal.saludar();
            ServicePantallaPrincipal service = new ServicePantallaPrincipal();
                    // service.saludar();
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                            "Saludar Android!",
                            Toast.LENGTH_SHORT).show();
            }
        });
        // setContentView(R.layout.activity_main);

    }
}