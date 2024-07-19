package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_registro extends AppCompatActivity {

    private Button btnPapel;
    private Button btnCarton;
    private Button btnPlastico;

    private Button btnVidrio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);


        btnPapel = findViewById(R.id.btnPapel);
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDubPatnallaRegistroPapel();
            }
        });
        btnCarton = findViewById(R.id.btnCarton);
        btnCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSubPantallaRegistroCarton();
            }
        });

        btnPlastico = findViewById(R.id.btnPlastico);
        btnPlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSubPantallaRegistroPlastico();
            }
        });

        btnVidrio = findViewById(R.id.btnVidrio);
        btnVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSubPantallaRegistroVidrio();
            }
        });

    }

    public void irDubPatnallaRegistroPapel(){
        Intent pantallaRegistroPapel = new Intent(this, Subpantalla_registro_papel.class);
        startActivity(pantallaRegistroPapel);
    }

    public void irSubPantallaRegistroCarton(){
        Intent pantallaRegistroCarton = new Intent(this, Subpantalla_registro_carton.class);
        startActivity(pantallaRegistroCarton);
    }
    public void irSubPantallaRegistroPlastico(){
        Intent pantallaRegistroPlastico = new Intent(this, Subpantalla_registro_plastico.class);
        startActivity(pantallaRegistroPlastico);
    }

    public void irSubPantallaRegistroVidrio(){
        Intent pantallaRegistroVidrio = new Intent(this, Subpantalla_registro_vidrio.class);
        startActivity(pantallaRegistroVidrio);
    }

}

