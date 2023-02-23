package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAlta;
    private Button botonSalir;
    private Button botonVer;
    private Button botonSpinner;
    private Button botonCheck;
    private Button botonRadio;
    private Button botonProgress;

    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAlta = (Button) findViewById(R.id.btnAlta);
        botonSalir = (Button) findViewById(R.id.btnSalir);
        botonVer = (Button) findViewById(R.id.btnVer);
        botonSpinner = (Button) findViewById(R.id.btnSpinner);
        botonProgress =(Button) findViewById(R.id.btnProgress);
        botonCheck = (Button) findViewById(R.id.btnCheck);
        botonRadio = (Button) findViewById(R.id.btnRadio);

        botonAlta.setOnClickListener(this);
        botonSalir.setOnClickListener(this);
        botonVer.setOnClickListener(this);
        botonCheck.setOnClickListener(this);
        botonProgress.setOnClickListener(this);
        botonRadio.setOnClickListener(this);
        botonSpinner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent inte;

        if (view.getId() == R.id.btnAlta){
            if(getIntent() != null){
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");
                inte = new Intent(MainActivity.this,AltasActivity.class);
                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                }
            }else{
                inte = new Intent(MainActivity.this, AltasActivity.class);
            }

            startActivity(inte);
        }else if(view.getId() == R.id.btnVer){
            if(getIntent() != null){
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");

                inte = new Intent(MainActivity.this, VerActivity.class);

                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                }

                startActivity(inte);
            }else{
                inte = new Intent(MainActivity.this, VerActivity.class);
                startActivity(inte);
            }
        }else if(view.getId() == R.id.btnCheck){
            inte = new Intent(this,CheckActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnRadio){
            inte = new Intent(this,RadioActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnSpinner){
            inte = new Intent(this,SpinnerActivity.class);
            startActivity(inte);
        }else if(view.getId() == R.id.btnProgress){
            inte = new Intent(this,ProgressActivity.class);
            startActivity(inte);
        }
        else{
            finish();
        }

    }
}