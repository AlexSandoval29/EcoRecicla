package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class pantalla_principal extends AppCompatActivity {

    private ImageButton imageButtonEstadisticas;

    private ImageButton imageButtonRegistro;

    private ImageButton imageButtonConsejos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        imageButtonEstadisticas = findViewById(R.id.imageButtonEstadisticas);
        imageButtonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaEstadisticas();
            }
        });

        imageButtonRegistro = findViewById(R.id.imageButtonRegistro);
        imageButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaRegistro();
            }
        });

        imageButtonConsejos = findViewById(R.id.imageButtonConsejos);
        imageButtonConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaConsejos1();
            }
        });


    }

    public void irPantallaEstadisticas(){
        Intent pantallaEstadisticas = new Intent(this, pantalla_estadisticas.class);
        startActivity(pantallaEstadisticas);
    }

    public void  irPantallaRegistro(){
        Intent pantallaRegistro = new Intent(this,pantalla_registro.class);
        startActivity(pantallaRegistro);
    }

    public void irPantallaConsejos1(){
        Intent pantallaConsejos = new Intent(this, pantalla_consejos1.class);
        startActivity(pantallaConsejos);
    }
}