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

public class Subpantalla_registro_vidrio extends AppCompatActivity {

    private EditText editTextPesoKiloVidrio;
    private EditText editTextValorKiloVidrio;
    private Button btnCalcularVidrio;
    private Button btnRegresar;
    private TextView txtResultadoVidrio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpantalla_registro_vidrio);


        editTextPesoKiloVidrio = findViewById(R.id.editTextPesoKiloVidrio);
        editTextValorKiloVidrio = findViewById(R.id.editTextValorKiloVidrio);
        btnCalcularVidrio = findViewById(R.id.btnCalcularVidrio);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtResultadoVidrio = findViewById(R.id.txtResultadoVidrio);

        // Botón Calcular Papel
        btnCalcularVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PesoKiloPapel = editTextPesoKiloVidrio.getText().toString().trim();
                if (PesoKiloPapel.isEmpty()){
                    String mensajeVacio = "Campo del peso esta vacio, por favor ingresar datos";
                    SpannableString spannableString = new SpannableString(mensajeVacio);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeVacio.length(), 0);
                }else{
                    String mensajeError = "Los datos son incorrectos";
                    SpannableString spannableString = new SpannableString(mensajeError);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeError.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Toast.makeText(Subpantalla_registro_vidrio.this, "Peso kilo Papel", Toast.LENGTH_SHORT).show();
                }
                String ValorKiloPapel = editTextValorKiloVidrio.getText().toString().trim();
                if (ValorKiloPapel.isEmpty()){
                    String mensajeVacio = "Campo del valor del kilo esta vacio, por favor ingresar dato";
                    SpannableString spannableString = new SpannableString(mensajeVacio);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeVacio.length(), 0);
                }else{
                    String mensajeError = "Los datos son incorrectos";
                    SpannableString spannableString = new SpannableString(mensajeError);
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mensajeError.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Toast.makeText(Subpantalla_registro_vidrio.this, "Valor kilo Papel", Toast.LENGTH_SHORT).show();
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