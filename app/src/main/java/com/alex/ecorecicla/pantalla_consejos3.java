package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class pantalla_consejos3 extends AppCompatActivity {

    private Button btnanteriorconsejo3;
    private Button btnsiguienteconsejo3;
    private Button btnmenuprincipalconsejos3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos3);
        btnanteriorconsejo3 = findViewById(R.id.btnanteriorconsejo3);
        btnanteriorconsejo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejoDos();
            }
        });
        btnsiguienteconsejo3 = findViewById(R.id.btnsiguienteconsejo3);
        btnsiguienteconsejo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
irConsejo4();
            }
        });
        btnmenuprincipalconsejos3 = findViewById(R.id.btnmenuprincipalconsejos3);
        btnmenuprincipalconsejos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipal3();
            }
        });
    }

    public void irConsejoDos(){
        Intent consejo2 = new Intent(this, pantalla_consejos2.class);
        startActivity(consejo2);
    }

    public void irConsejo4(){
        Intent consejo4 = new Intent(this, pantalla_consejos4.class);
        startActivity(consejo4);
    }
    public void irPrincipal3(){
        Intent principal3 = new Intent(this, pantalla_principal.class);
        startActivity(principal3);
    }
}