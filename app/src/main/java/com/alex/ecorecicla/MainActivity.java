package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnRecupera;
    private Button btnregistrate;

    private Button btnIniciosesion;

    private EditText EditTextNombre;

    private EditText EditTextContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecupera = findViewById(R.id.btnRecupera);
        //Este es el botón para navegar hacia la pantalla de recuperar la cuenta
        btnRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSubPantallaRecuperaCuenta();
            }
        });

        btnregistrate = findViewById(R.id.btnregistrate);
        btnregistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSupantallaRegistro();
            }
        });

        btnIniciosesion = findViewById(R.id.btnIniciosesion);
        btnIniciosesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaPrincipal();
            }
        });





    }


    //Este intent es para conectar la pantalla de inicio de sesión con la subpantalla de recuperar cuenta
    public void irSubPantallaRecuperaCuenta(){
        Intent recupera = new Intent(this,SubPantallaRecuperaCuenta.class);
        startActivity(recupera);
    }
    //Este intent es para conectar la pantalla de inicio de sesión con la subpantalla de registro
    public void irSupantallaRegistro(){
        Intent registrate = new Intent(this, SubPantallaRegistro.class);
        startActivity(registrate);
    }
    //Este intent es para conectar la pantalla de inicio de sesión con la pantalla principal
   public void irPantallaPrincipal(){
        Intent principal = new Intent(this, pantalla_principal.class);
        startActivity(principal);
   }
}