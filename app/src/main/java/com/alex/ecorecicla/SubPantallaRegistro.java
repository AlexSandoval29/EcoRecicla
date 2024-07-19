package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import android.widget.Button;


public class SubPantallaRegistro extends AppCompatActivity {

    private EditText insertCorreoRegistro;
    private EditText elijenombreUsuarioRegistro;
    private EditText contrasenaRegistro;
    private EditText confirmaContrasenaRegistro;

    private Button btnInicioSesionRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pantalla_registro);

        btnInicioSesionRegistro = findViewById(R.id.btnInicioSesionRegistro);
        btnInicioSesionRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    // vamos a capturar los datos en un arrayList - e iniciar sesion con el usuario nuevo dirigiendo este a la pantalla principal



}