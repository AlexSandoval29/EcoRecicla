package com.alex.ecorecicla;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SubPantallaRegistro extends AppCompatActivity {

    private EditText insertCorreoRegistro;
    private EditText elijenombreUsuarioRegistro;
    private EditText contrasenaRegistro;
    private EditText confirmaContrasenaRegistro;

    private Button btnInicioSesionRegistro;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pantalla_registro);
        //pasar el contexto
        AccesoUsuarios accesoUsuarios = new AccesoUsuarios(this);
        context = getApplicationContext();
        // relacion de los elementos graficos en la parte logica:
        //Estos elementos corresponden a los EditText
        insertCorreoRegistro = findViewById(R.id.insertCorreoRegistro);
        elijenombreUsuarioRegistro = findViewById(R.id.elijenombreUsuarioRegistro);
        contrasenaRegistro = findViewById(R.id.contrasenaRegistro);
        confirmaContrasenaRegistro = findViewById(R.id.confirmaContrasenaRegistro);
        //Este elemento corresponde al boton de inicio:
        btnInicioSesionRegistro = findViewById(R.id.btnInicioSesionRegistro);
        // Aca esta el desencadenante para el boton de registro quien dará el paso a la pantalla
        // del menu principal y asi mismo dejará registrado al usuario
        btnInicioSesionRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //en este espacio se van a capturar los datos del usuario
                String CorreoRegistro = insertCorreoRegistro.getText().toString();
                String NombreUsuario = elijenombreUsuarioRegistro.getText().toString();
                String ContrasenaRegistra = contrasenaRegistro.getText().toString();
                String ConfirmaContrasenaRegistroD = confirmaContrasenaRegistro.getText().toString();

                //aca se hace el llamado de los metodos de registrarUsuario y de usuarioExiste provenientes de la clase AccesoUsuarios

                AccesoUsuarios accesoUsuarios = new AccesoUsuarios(SubPantallaRegistro.this);
                boolean result = accesoUsuarios.registrarUsuario(CorreoRegistro, NombreUsuario, ContrasenaRegistra, ConfirmaContrasenaRegistroD);
                if(result){
                    irPantallaprincipal();
                }
            }

        });

    }




    //metodo para ir a la pantalla principal
    public void irPantallaprincipal() {
        Intent principalScreen = new Intent(this, pantalla_principal.class);
        startActivity(principalScreen);
    }
}




