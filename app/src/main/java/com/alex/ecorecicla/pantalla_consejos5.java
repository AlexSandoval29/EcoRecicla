package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_consejos5 extends AppCompatActivity {

    private Button btnanteriorconsejo5;

    private Button btnsiguienteconsejo5;
    private Button btnmenuprincipalconsejos5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos5);

        btnanteriorconsejo5 = findViewById(R.id.btnanteriorconsejo5);
        btnanteriorconsejo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejo4();
            }
        });
        btnsiguienteconsejo5 = findViewById(R.id.btnsiguienteconsejo5);
        btnsiguienteconsejo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejoseis();
            }
        });
        btnmenuprincipalconsejos5 = findViewById(R.id.btnmenuprincipalconsejos5);
        btnmenuprincipalconsejos5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipal5();
            }
        });

    }

    public void irConsejo4(){
        Intent consejo4 = new Intent(this, pantalla_consejos4.class);
        startActivity(consejo4);
    }

    public void irConsejoseis(){
        Intent consejo6 = new Intent(this, pantalla_consejos6.class);
        startActivity(consejo6);
    }

    public void irPrincipal5(){
        Intent principal5 = new Intent(this, pantalla_principal.class);
        startActivity(principal5);
    }
}