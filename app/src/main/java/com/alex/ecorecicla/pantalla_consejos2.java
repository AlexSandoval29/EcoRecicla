package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_consejos2 extends AppCompatActivity {

    private Button btnanteriorconsejo2;

    private Button btnsiguienteconsejo2;

    private Button btnmenuprincipalconsejos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos2);

        btnanteriorconsejo2 = findViewById(R.id.btnanteriorconsejo2);
        btnanteriorconsejo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejo1();
            }
        });

        btnsiguienteconsejo2 = findViewById(R.id.btnsiguienteconsejo2);
        btnsiguienteconsejo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejo3();
            }
        });
        btnmenuprincipalconsejos2 = findViewById(R.id.btnmenuprincipalconsejos2);
        btnmenuprincipalconsejos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipal2();
            }
        });

    }

    public void irConsejo1(){
        Intent consejo1 = new Intent(this, pantalla_consejos1.class);
        startActivity(consejo1);
    }

    public void irConsejo3(){
        Intent consejo2 = new Intent(this, pantalla_consejos3.class);
        startActivity(consejo2);
    }
    public void irPrincipal2(){
        Intent principal2 = new Intent(this, pantalla_principal.class);
        startActivity(principal2);
    }
}