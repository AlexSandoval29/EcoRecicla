package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import java.util.ArrayList;

public class pantalla_estadisticas extends AppCompatActivity {

    private TableLayout myTableLayout;
    private EditText txtMes;
    private EditText txtMaterial;
    private EditText txtPrecio;
    private String[] header={"Mes", "Material", "Valor"};
    private ArrayList<String[]> rows = new ArrayList<>();
    private TablaDinamica tablaDinamica;

    private Button btnRetroceso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_estadisticas2);

        myTableLayout =findViewById(R.id.myTableLayout);
        txtMes = findViewById(R.id.txtMes);
        txtMaterial = findViewById(R.id.txtMaterial);
        txtPrecio = findViewById(R.id.txtPrecio);

        tablaDinamica = new TablaDinamica(myTableLayout,getApplicationContext());
        tablaDinamica.addHeader(header);
        tablaDinamica.addData(getClients());

        btnRetroceso = findViewById(R.id.btnRetroceso);
        btnRetroceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPantallaPrincipal();
            }
        });
    }
    public void save(View view){
        String[]item=new String[]{"Mayo",txtMaterial.getText().toString(),txtPrecio.getText().toString()};
        tablaDinamica.addItems(item);
    }
    private ArrayList<String[]>getClients(){
        rows.add(new String[]{"Enero", "Papel", "25.000"});
        rows.add(new String[]{"Enero", "Carton", "20.000"});
        rows.add(new String[]{"Febrero", "Vidrio", "32.000"});
        rows.add(new String[]{"Marzo", "PLastico", "23.000"});
        return rows;
    }
    public void  irPantallaPrincipal(){
        Intent pantalla = new Intent(this, pantalla_principal.class);
        startActivity(pantalla);
    }
}