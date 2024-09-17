package com.example.a004singleton.services;

import android.widget.Toast;

import com.example.a004singleton.MainActivity;
import com.example.a004singleton.MainActivity2;

public class ServicePantallaPrincipal {

    /*public ServicePantallaPrincipal(MainActivity padre){
        this.padre = padre;
    }*/
    public void saludar(){
        Toast.makeText(MainActivity.getInstance(),
                "Saludar Android!",
                Toast.LENGTH_SHORT).show();
        // INTENT
            // 2 LÍNEAS DE CÓDIGO
    }
    public void altaUsuario(){
        Toast.makeText(MainActivity2.getInstance(),
                        "Hola 2ª pantalla",
                            Toast.LENGTH_SHORT).show();
    }

}
