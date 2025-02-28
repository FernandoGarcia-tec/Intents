package com.example.intents;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Declarar componentes
    private Button btnV;
    private EditText txtL,txtP;

    //variables para comparar el login y el password
    private String nombre = "Fernando";
    private String clave = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Relacionar componentes entre la vista y la logica
        btnV = (Button) findViewById(R.id.btnValidar);
        txtL = (EditText) findViewById(R.id.txtLogin);
        txtP = (EditText) findViewById(R.id.txtPass);
    }
    /**
     * Metodo para el boton
     */
    public void  saltarActividad(View vista){
        //Leer los datos de los campos de texto
        String name = txtL.getText().toString();
        String pass = txtP.getText().toString();

        //comparamos las credenciales con los datos
        if (nombre.equals(name)&& clave.equals(pass)){
        //Crear el intent para saltar entre actividades
            Intent i = new Intent(this, MainActivity2.class);
        //agregamos los datos al intent
            i.putExtra("usuario",name);
            i.putExtra("clave",pass);

            startActivity(i);
        }else {
            printMensajeError(name,pass);
        }
    }
/*
metodo para desplegar la ventana de error
 */
    private void printMensajeError(String name, String pass) {
        AlertDialog.Builder vent = new AlertDialog.Builder(this);
        //Agregamos los parametros a la ventana
        vent.setTitle("Error");

        //Agregar icon
        vent.setIcon(R.drawable.alerticon);
        vent.setMessage("Las credenciales no coinciden"+ "\n"+
                name+"\n"
                +pass);
        vent.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //ocultamos la ventana
                dialog.dismiss();
                // Limpiar los campos
                txtL.setText(null);
                txtP.setText(null);

                //Poner el cursor
                txtL.requestFocus();
            }
        });
        vent.show();
    }
}