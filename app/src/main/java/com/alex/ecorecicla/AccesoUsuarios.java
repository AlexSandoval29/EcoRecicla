package com.alex.ecorecicla;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccesoUsuarios {

    private Context context; // contexto para acceder a archivos

   public AccesoUsuarios(Context context){
        this.context = context.getApplicationContext();

   }

   //metodo para registrar un nuevo usuario
   public boolean registrarUsuario(String CorreoRegistro, String NombreUsuario, String ContrasenaRegistra, String ConfirmaContrasenaRegistroD) {
       //este metodo crea el archivo txt para la posterior escrictura de los datos
       crearArchivo();

       if (usuarioExiste(CorreoRegistro)) {
           // Muestra un mensaje si el usuario ya está registrado
           mostrarToast( "El usuario con este correo ya está registrado.",Color.RED);

           return false;
       }

       //condiciona los campos vacios
       if (CorreoRegistro.isEmpty() || NombreUsuario.isEmpty() || ContrasenaRegistra.isEmpty() || ConfirmaContrasenaRegistroD.isEmpty()) {
           mostrarToast("Algun campo esta vacio, por favor rectifica",Color.BLUE);
           return false;
       }
       // Condiciona longitudes por seguridad (seguridad basica)
       if (CorreoRegistro.length() > 8 && CorreoRegistro.length() < 30 && CorreoRegistro.contains("@") && CorreoRegistro.contains(".com") &&
               NombreUsuario.length() > 5 && NombreUsuario.length() < 15 && ContrasenaRegistra.length() >= 15 && ContrasenaRegistra.length() < 20
               && ConfirmaContrasenaRegistroD.equals(ContrasenaRegistra) && contieneLetraMayuscula(ContrasenaRegistra) && contieneNumero(ContrasenaRegistra)) {
           Log.d("Registro", "Validación exitosa.");

           //aca guarda los datos en en archivo

           try (FileOutputStream fileOutputStream = context.openFileOutput("usuarios.txt", Context.MODE_APPEND);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))) {

               bufferedWriter.write(CorreoRegistro + "," + ContrasenaRegistra + "," + NombreUsuario);
               bufferedWriter.newLine();
               bufferedWriter.flush();
               Log.d("Registro", "Datos escritos en usuarios.txt.");
               //mostar el Toast con un color distintivo
               mostrarToast("Usuario registrado correctamente",Color.GREEN);

           } catch (IOException e) {
               e.printStackTrace();
               // Mostrar un mensaje de error si ocurre una excepción Y  UN COLOR DISTINTIVO
               mostrarToast("Ocurrio un error inesperado, intenta nuevamente",Color.RED);
           }
       } else {
           // Mostrar un mensaje de error si la validación falla
           mostrarToast("Verifica los campos e intenta nuevamente.",Color.RED);
       }
       return false;
   }

//metodo para crear el archivo txt
    private void crearArchivo() {
        // Asegúrate de que 'context' esté inicializado y no sea nulo
        if (context == null) {
            Log.d("TestFile", "Contexto no disponible.");
            return;
        }

        // Crea una instancia de File apuntando al directorio interno de archivos y al nombre del archivo "usuarios.txt"
        File file = new File(context.getFilesDir(), "usuarios.txt");

        if(!file.exists()){
            try {
                //  crear el nuevo archivo
                if (file.createNewFile()) {
                    // Si el archivo se crea exitosamente, se muestra un mensaje en el log
                    Log.d("TestFile", "Archivo usuarios.txt creado exitosamente.");
                } else {
                    // Si el archivo no se puede crear (posiblemente ya existe), se muestra un mensaje en el log
                    Log.d("TestFile", "No se pudo crear el archivo usuarios.txt.");
                }
            } catch (IOException e) {
                // Si ocurre una excepción durante la creación del archivo, se muestra el error en el log
                e.printStackTrace();
                Log.d("TestFile", "Error al crear el archivo usuarios.txt.");
            }
        }else{
            Log.d("TestFile", "El archivo txt ya existe");
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

private void mostrarToast(String mensaje,int color){
    SpannableString spannableString = new SpannableString(mensaje);
    spannableString.setSpan(new ForegroundColorSpan(color), 0, mensaje.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    Toast.makeText(context, spannableString, Toast.LENGTH_SHORT).show();
}


    //metodo de verificacion para ver si el usuario existe
    public boolean usuarioExiste(String CorreoRegistro) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            // Abre el archivo para la lectura
            fileInputStream = context.openFileInput("usuarios.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");

                // hay al menos un dato en la línea
                if (datos.length > 0) {
                    String usuarioGuardado = datos[0];

                    // Compara el correo ingresado con el correo guardado
                    if (usuarioGuardado.equals(CorreoRegistro)) {
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

