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

    /////////PATRÓN SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance(){
        return padre;
    }

    ////// FIN
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SINGLETON
        this.padre = this;
        // FIN SINGLETON
        ServicePantallaPrincipal service = new ServicePantallaPrincipal(); // 0x5454af
        btnSaludar = findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.saludar();
            }
        });
        // setContentView(R.layout.activity_main);

    }
}