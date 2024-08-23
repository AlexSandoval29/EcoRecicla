
package com.alex.ecorecicla;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

            private Button btnRecupera;
            private Button btnregistrate;

            private Button btnIniciosesion;

            private EditText EditTextNombre;

            private EditText EditTextContrasena;

            private CheckBox chrecordarme;



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                btnRecupera = findViewById(R.id.btnRecupera);
                //Este es el botón para navegar hacia la pantalla de recuperar la cuenta
                btnRecupera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        irSubPantallaRecuperaCuenta();
                    }
                });

                btnregistrate = findViewById(R.id.btnregistrate);
                btnregistrate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        irSupantallaRegistro();
                    }
                });

                btnIniciosesion = findViewById(R.id.btnIniciosesion);

                //enlace de los edittext de la parte grafica a la partelogica
                EditTextNombre = findViewById(R.id.EditTextNombre);
                EditTextContrasena = findViewById(R.id.EditTextContrasena);
                chrecordarme = findViewById(R.id.chrecordarme);

                Context context = getApplicationContext();

                //ejecucion del boton de inicio de sesion
                btnIniciosesion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //captura de los datos
                        String CorreoInicio = EditTextNombre.getText().toString();
                        String contrasenaInicio = EditTextContrasena.getText().toString();
                        //esta variable recordar es para los metodos que nos guarda los datos de inicio de sesion
                        boolean recordar = chrecordarme.isChecked();
                        //se cargan datos de inicio de sesion encaso de existir
                        cargarDatosInicioSesion();
                        //esta llamado es para el checkbox y ver si se quiere guardar los datos de inicio de sesion
                        guardaInicioSesion(CorreoInicio,contrasenaInicio,recordar);
                        //realizar verificacion de seguridad de los campos
                        seguridad(CorreoInicio,contrasenaInicio);

                        if(verificarCredenciales(CorreoInicio,contrasenaInicio)){
                            irPantallaPrincipal();
                            mostrarToast("Bienvenid/a",Color.BLUE);
                        }else{
                            mostrarToast("El correo o la contraseña es/son incorrectos",Color.RED);
                        }
                    }
                });
    }

            // LOGICA OPARA NAVEGACION ENTRE PANTALLAS
    //Este intent es para conectar la pantalla de inicio de sesión con la subpantalla de recuperar cuenta
    public void irSubPantallaRecuperaCuenta(){
        Intent recupera = new Intent(this,SubPantallaRecuperaCuenta.class);
        startActivity(recupera);
    }

    private void mostrarToast(String mensaje,int color){
        SpannableString spannableString = new SpannableString(mensaje);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, mensaje.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Toast.makeText(MainActivity.this, spannableString, Toast.LENGTH_SHORT).show();
    }

    //Este intent es para conectar la pantalla de inicio de sesión con la subpantalla de registro
    public void irSupantallaRegistro(){
        Intent registrate = new Intent(this, SubPantallaRegistro.class);
        startActivity(registrate);
    }
    //Este intent es para conectar la pantalla de inicio de sesión con la pantalla principal
   public void irPantallaPrincipal(){
        Intent principal = new Intent(this, pantalla_principal.class);
        startActivity(principal);
   }
// metodo para verificar los datos ingresados con los que se encuentran en el archivo txt
   private boolean verificarCredenciales(String CorreoInicio, String contrasenaInicio) {
                FileInputStream fileInputStream = null;
                BufferedReader bufferedReader = null;


                try {
                    fileInputStream = openFileInput("usuarios.txt");
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String linea;
                    while ((linea = bufferedReader.readLine()) != null) {
                        String[] datos = linea.split(",");
                        if (datos.length >= 3) {  // hay al menos 3 campos
                            String correoGuardado = datos[0];
                            String contrasenaGuardada = datos[1];
                            String nombreUsuarioGuardado = datos[2];

                            if (correoGuardado.equals(CorreoInicio) && contrasenaGuardada.equals(contrasenaInicio)) {
                                return true; // Credenciales correctas
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // Cerrar recursos
                    try {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            }

            //metodo para recordar(Guardar)los datos de inicio de sesion en el checbox
  private void guardaInicioSesion(String CorreoInicio, String contrasenaInicio,Boolean recordar ){
                SharedPreferences sharedPreferences = getSharedPreferences
                        ("UsuarioPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

  if(recordar){
     editor.putString("correo",CorreoInicio);
     editor.putString("contrasena",contrasenaInicio);
     editor.putBoolean("recordar",true);
  }else{
     editor.remove("correo");
     editor.remove("contrasena");
     editor.putBoolean("recordar",false);
  }
     editor.apply();}
//metodo para cargar los datos de inicio de sesion
    private void cargarDatosInicioSesion() {
        SharedPreferences sharedPreferences = getSharedPreferences("UsuarioPreferencias", MODE_PRIVATE);
        boolean recordar = sharedPreferences.getBoolean("recordar", false);

        if (recordar) {
            String correoGuardado = sharedPreferences.getString("correo", "");
            String contrasenaGuardada = sharedPreferences.getString("contrasena", "");

            EditTextNombre.setText(correoGuardado);
            EditTextContrasena.setText(contrasenaGuardada);
            chrecordarme.setChecked(true); // Marca el CheckBox
        }
            }


    //metodo para condicionar la contraseña a que contenga una mayuscula por lo menos
    private boolean contieneLetraMayuscula(String ContrasenaRegistra) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(ContrasenaRegistra);
        return matcher.find();
    }

    //metodo para verificar que en la contraseña exista al menos un numero
    private boolean contieneNumero(String ContrasenaRegistra){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(ContrasenaRegistra);
        return  matcher.find();
    }



    //condiciona los campos vacios
    private void seguridad(String CorreoInicio, String contrasenaInicio){
        if (CorreoInicio.isEmpty() || contrasenaInicio.isEmpty() ) {
            String mensajeVacio = "Algun campo esta vacio, por favor rectifica";
            SpannableString spannableString = new SpannableString(mensajeVacio);
            spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, mensajeVacio.length(), 0);
            Toast.makeText(MainActivity.this, spannableString, Toast.LENGTH_SHORT).show();
            return; // salir del metodo en caso de que algun campo este vacio
        }

        // Condiciona longitudes por seguridad (seguridad basica)
        if (CorreoInicio.length() > 8 && CorreoInicio.length() < 30 && CorreoInicio.contains("@") && CorreoInicio.contains(".com") &&
                contrasenaInicio.length() >= 15 && contrasenaInicio.length() < 20 && contieneLetraMayuscula(contrasenaInicio) && contieneNumero(contrasenaInicio)) {
            Log.d("Registro", "Validación exitosa.");
            String mensajeVacio = "Datos no validos, por favor rectifica";
            SpannableString spannableString = new SpannableString(mensajeVacio);
            spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, mensajeVacio.length(), 0);
            Toast.makeText(MainActivity.this, spannableString, Toast.LENGTH_SHORT).show();
            }
}

}