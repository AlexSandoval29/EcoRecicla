package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class pantalla_consejos4 extends AppCompatActivity {

    private Button btnanteriorconsejo4;

    private Button btnsiguienteconsejo4;

    private Button btnmenuprincipalconsejos4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos4);
        btnanteriorconsejo4 = findViewById(R.id.btnanteriorconsejo4);
        btnanteriorconsejo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejotres();
            }
        });

        btnsiguienteconsejo4 = findViewById(R.id.btnsiguienteconsejo4);
        btnsiguienteconsejo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejoCinco();
            }
        });
        btnmenuprincipalconsejos4 = findViewById(R.id.btnmenuprincipalconsejos4);
        btnmenuprincipalconsejos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipal4();
            }
        });
    }

    public void irConsejotres(){
        Intent consejo3 = new Intent(this, pantalla_consejos3.class);
        startActivity(consejo3);
    }

    public void irConsejoCinco(){
        Intent consejo5 = new Intent(this, pantalla_consejos5.class);
        startActivity(consejo5);
    }

    public void irPrincipal4(){
        Intent principal4 = new Intent(this, pantalla_principal.class);
        startActivity(principal4);
    }

}