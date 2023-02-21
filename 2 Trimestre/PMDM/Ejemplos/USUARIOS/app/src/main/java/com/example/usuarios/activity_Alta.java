package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_Alta extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button buttonGuardar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        buttonGuardar = (Button) findViewById(R.id.botonGuardarAlta);

        editText1 = (EditText) findViewById(R.id.textoNombre);
        editText2 = (EditText) findViewById(R.id.textoFecha);
        editText3 = (EditText) findViewById(R.id.textoEmail);


        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = editText1.getText().toString();
                String texto2 = editText2.getText().toString();
                String texto3 = editText3.getText().toString();

                Intent intent = new Intent(activity_Alta.this, activity_VerDatos.class);
                intent.putExtra("texto1", texto1);
                intent.putExtra("texto2", texto2);
                intent.putExtra("texto3", texto3);
                startActivity(intent);
            }
        });

            }


     public void volver(View view) {
        Intent intent = new Intent(activity_Alta.this, MainActivity.class);
        startActivity(intent);
     }
}
