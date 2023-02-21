package com.example.usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void alta (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Alta.class);
        startActivity(intent);
    }

    public void recomendacion (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Recomendacion.class);
        startActivity(intent);
    }
    public void aficiones (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Aficiones.class);
        startActivity(intent);
    }

    public void verDatos (View  view){
        Intent intent= new Intent (MainActivity.this, activity_VerDatos.class);
        startActivity(intent);
    }

    public void valoracion (View  view){
        Intent intent= new Intent (MainActivity.this, activity_Valoracion.class);
        startActivity(intent);
    }

    public void cerrar (View  view){
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


}

