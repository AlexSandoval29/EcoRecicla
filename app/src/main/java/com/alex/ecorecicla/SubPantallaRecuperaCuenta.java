package com.alex.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;

import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SubPantallaRecuperaCuenta extends AppCompatActivity {

    private EditText ingresaCorreo;
    private Button btnEnviarCorreo;
    private EditText insertarCodigo;
    private EditText insertNuevaContrasena;
    private EditText insertConfirmarNuevaContrasena;
    private Button btnIniciSesionRecupera;

    private String codigoGenerado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pantalla_recupera_cuenta);
        //relacion de los objetos de la parte grafica a la logica
        ingresaCorreo = findViewById(R.id.ingresaCorreo);
        btnEnviarCorreo = findViewById(R.id.btnEnviarCorreo);
        insertarCodigo = findViewById(R.id.insertarCodigo);
        insertNuevaContrasena = findViewById(R.id.insertNuevaContrasena);
        insertConfirmarNuevaContrasena = findViewById(R.id.insertConfirmarNuevaContrasena);
        btnIniciSesionRecupera = findViewById(R.id.btnIniciSesionRecupera);

        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //captura del dato del correo.
                String correoIngresado = ingresaCorreo.getText().toString().trim();
                //condicion para que el campo del correo sea obloigatorio
                if (correoIngresado.isEmpty()) {
                    //mnostrar un mensaje de error en caso de que este vacio
                    mostrarMnesajeError("Campo de Correo  esta vacio, por favor rectifica",Color.RED);
                } else if (!(correoIngresado.contains("@") && correoIngresado.contains(".com") &&
                        correoIngresado.length() > 8 && correoIngresado.length() < 30)) {
                    mostrarMnesajeError("Este correo tiene un formato no valido",Color.RED);
                } else {
                    codigoGenerado = generarCodigo(4);

                    new AlertDialog.Builder(SubPantallaRecuperaCuenta.this)
                            .setTitle("Tu codigo es:")
                            .setMessage("El codigo es: " + codigoGenerado)
                            .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                            .show();
                }


            }
        });

        btnIniciSesionRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //captura de los datos
                String CorreoRegistro = ingresaCorreo.getText().toString().trim();
                String codigoIngresado = insertarCodigo.getText().toString().trim();
                String nuevaContrasena = insertNuevaContrasena.getText().toString().trim();
                String confirmarContrasena = insertConfirmarNuevaContrasena.getText().toString().trim();

                if (CorreoRegistro.isEmpty() || codigoIngresado.isEmpty() || nuevaContrasena.isEmpty()
                        || confirmarContrasena.isEmpty()) {
                    mostrarMnesajeError("Completa todos los campos por favor", Color.BLUE);


                } else if (!(CorreoRegistro.contains("@") && CorreoRegistro.contains(".com") &&
                        CorreoRegistro.length() > 8 && CorreoRegistro.length() < 30)) {
                    mostrarMnesajeError("Este correo tiene un formato no valido",Color.RED);
                } else if (!codigoIngresado.equals(codigoGenerado)) {
                    mostrarMnesajeError("El codigo ingresado no es correcto",Color.RED);
                } else if (!nuevaContrasena.equals(confirmarContrasena)) {
                    mostrarMnesajeError("Las contraseñas no coinciden", Color.RED);
                }else if(usuarioExiste(CorreoRegistro)){
                    mostrarMnesajeError("El usuario no existe en nuestros registros",Color.GREEN);
                } else if (actualizarContrasena(CorreoRegistro, nuevaContrasena)) {
                    mostrarMnesajeError("La contraseña ha sido actualizada exitosamente",Color.GREEN);
                    irPantallaInicioSesion();
                }
            }
        });

    }

    //metodo para crear un codigo numerico para la recuperacijon de la cuenta.
    private String generarCodigo(int longitud) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10);
            code.append(digito);
        }
        return code.toString();
    }

    //para comodidad de escritura, un metodo para mostrar los mensajes de error
    private void mostrarMnesajeError(String mensaje,int color) {
        SpannableString spannableString = new SpannableString(mensaje);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, mensaje.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Toast.makeText(SubPantallaRecuperaCuenta.this, spannableString, Toast.LENGTH_SHORT).show();
    }


    //Metodo para actualizar la contrasena
    private boolean actualizarContrasena(String correoIngresado, String nuevaContrasena) {
        String archivo = "usuarios.txt";
        boolean actualizado = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            StringBuilder nuevoContenido = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String correoGuardado = partes[0].trim();
                    String contrasenaGuardada = partes[1].trim();

                    if (correoGuardado.equals(correoIngresado)) {
                        //Actualiza la contraseña
                        nuevoContenido.append(correoIngresado).append(",").append(nuevaContrasena).append("\n");
                        actualizado = true;
                    } else {
                        nuevoContenido.append(linea).append("\n");

                    }
                }
            }
            reader.close();

            //sobre escribir el contenidop nuevo en el arhivo
            if (actualizado) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                writer.write(nuevoContenido.toString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return actualizado;
    }

    //metodo para ir a la pantalla de inicio de sesion
    public void irPantallaInicioSesion() {
        Intent principalScreen = new Intent(this, MainActivity.class);
        startActivity(principalScreen);
    }

    public boolean usuarioExiste(String correoRegistro) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            // Abre el archivo para la lectura usando el contexto actual
            fileInputStream = openFileInput("usuarios.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");

                // Verifica que haya al menos un dato en la línea
                if (datos.length > 0) {
                    String usuarioGuardado = datos[0].trim();

                    // Compara el correo ingresado con el correo guardado
                    if (usuarioGuardado.equals(correoRegistro)) {
                        return true; // El usuario ya existe
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierra los recursos en el bloque finally
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

        return false; // El usuario no existe
    }



}


