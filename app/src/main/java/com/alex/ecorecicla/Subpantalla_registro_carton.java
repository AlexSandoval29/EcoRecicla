package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import android.os.Bundle;

public class Subpantalla_registro_carton extends AppCompatActivity {

    private EditText editTextPesoKiloCarton;
    private EditText editTextValorKiloCarton;
    private Button btnCalcularCarton;
    private Button btnRegresar;
    private TextView txtResultadoCarton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpantalla_registro_carton);

        editTextPesoKiloCarton = findViewById(R.id.editTextPesoKiloCarton);
        editTextValorKiloCarton = findViewById(R.id.editTextValorKiloCarton);
        btnCalcularCarton = findViewById(R.id.btnCalcularCarton);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtResultadoCarton = findViewById(R.id.txtResultadoCarton);


        // Botón Calcular Carton
        btnCalcularCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PesoKiloPapel = editTextPesoKiloCarton.getText().toString().trim();
                if (PesoKiloPapel.isEmpty()){
                    String mensajeVacio = "Campo del peso esta vacio, por favor ingresar datos";
                    SpannableString spannableString = new SpannableString(mensajeVacio);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeVacio.length(), 0);
                }else{
                    String mensajeError = "Los datos son incorrectos";
                    SpannableString spannableString = new SpannableString(mensajeError);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeError.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Toast.makeText(Subpantalla_registro_carton.this, "Peso kilo Papel", Toast.LENGTH_SHORT).show();
                }
                String ValorKiloCarton = editTextValorKiloCarton.getText().toString().trim();
                if (ValorKiloCarton.isEmpty()){
                    String mensajeVacio = "Campo del valor del kilo esta vacio, por favor ingresar dato";
                    SpannableString spannableString = new SpannableString(mensajeVacio);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeVacio.length(), 0);
                }else{
                    String mensajeError = "Los datos son incorrectos";
                    SpannableString spannableString = new SpannableString(mensajeError);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeError.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Toast.makeText(Subpantalla_registro_carton.this, "Valor kilo Papel", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Botón Regresar
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaPrincipal();
            }
        });

    }
    public void irPantallaPrincipal() {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }
}