package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_consejos6 extends AppCompatActivity {

    private Button btnanteriorconsejo6;
    private Button btnmenuprincipalconsejos6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos6);

        btnanteriorconsejo6= findViewById(R.id.btnanteriorconsejo6);
        btnanteriorconsejo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejo5();
            }
        });
        btnmenuprincipalconsejos6 = findViewById(R.id.btnmenuprincipalconsejos6);
        btnmenuprincipalconsejos6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipal6();
            }
        });
    }
    public void irConsejo5(){
        Intent consejo6 = new Intent(this, pantalla_consejos5.class);
        startActivity(consejo6);
    }
    public void irPrincipal6(){
        Intent principal6 = new Intent(this, pantalla_principal.class);
        startActivity(principal6);
    }
}