package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_consejos1 extends AppCompatActivity {

    private Button btnsiguiente;
    private Button btnmenuprincipalconsejos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos1);

        btnsiguiente = findViewById(R.id.btnsiguiente);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irConsejo2();
            }
        });
        btnmenuprincipalconsejos1 = findViewById(R.id.btnmenuprincipalconsejos1);
        btnmenuprincipalconsejos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
irPrincipal();
            }
        });
    }

    public void irConsejo2(){
        Intent consejo2 = new Intent(this, pantalla_consejos2.class);
        startActivity(consejo2);
    }
    public void irPrincipal(){
        Intent principal = new Intent(this, pantalla_principal.class);
        startActivity(principal);
    }

}