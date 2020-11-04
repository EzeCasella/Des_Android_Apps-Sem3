package com.example.mascotassem3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText correo = (EditText) findViewById(R.id.correo);
        EditText mensaje = (EditText) findViewById(R.id.mensaje);

        findViewById(R.id.btn_enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Enviar mail aca.. PERO CON LIBRERIA MAS NUEVA (intent a gmail)", Toast.LENGTH_LONG).show();
            }
        });
    }
}