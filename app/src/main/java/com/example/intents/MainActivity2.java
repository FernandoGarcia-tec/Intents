package com.example.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtCampo;
    private Button btnR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Relacionar componentes
        txtCampo = (TextView) findViewById(R.id.txtMensaje);
        //recibimos los datos de la primera actividad
        String user = getIntent().getExtras().getString("usuario");
        String pass = getIntent().getExtras().getString("clave");

        //escribir los datos en el text view
        txtCampo.setText("-bienvenido"+"\n"+user+"\n"+pass);

        //Relacionar el boton con la vista y la logica
        btnR = (Button) findViewById(R.id.btnRegresar);
    }
    /**
     * Metodo para regresar a la activity 1
     *
     */
    public void regresarActivity(View vista) {
        //crear un objeto intent
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
    }

}