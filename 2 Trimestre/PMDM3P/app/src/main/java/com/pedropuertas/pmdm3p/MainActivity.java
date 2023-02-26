package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonAlta;
    private Button botonSalir;
    private Button botonVer;
    private Button botonSwitch;
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
        botonSwitch = (Button) findViewById(R.id.btnSpinner);
        botonProgress =(Button) findViewById(R.id.btnProgress);
        botonCheck = (Button) findViewById(R.id.btnCheck);
        botonRadio = (Button) findViewById(R.id.btnRadio);

        botonAlta.setOnClickListener(this);
        botonSalir.setOnClickListener(this);
        botonVer.setOnClickListener(this);
        botonCheck.setOnClickListener(this);
        botonProgress.setOnClickListener(this);
        botonRadio.setOnClickListener(this);
        botonSwitch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent inte;

        Intent intent = getIntent();
        lista = intent.getStringArrayListExtra("lista");

        switch (view.getId()){
            case R.id.btnAlta:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this,AltasActivity.class);
                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }
                }else{
                    inte = new Intent(MainActivity.this, AltasActivity.class);
                }

                startActivity(inte);
                break;
            case R.id.btnVer:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this, VerActivity.class);

                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }

                    startActivity(inte);
                }else{
                    inte = new Intent(MainActivity.this, VerActivity.class);
                    startActivity(inte);
                }
                break;
            case R.id.btnRadio:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this, RadioActivity.class);

                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }

                    startActivity(inte);
                }else{
                    inte = new Intent(MainActivity.this, RadioActivity.class);
                    startActivity(inte);
                }
                break;
            case R.id.btnCheck:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this, CheckActivity.class);

                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }

                    startActivity(inte);
                }else{
                    inte = new Intent(MainActivity.this, CheckActivity.class);
                    startActivity(inte);
                }
                break;
            case R.id.btnProgress:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this, ProgressActivity.class);

                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }

                    startActivity(inte);
                }else{
                    inte = new Intent(MainActivity.this, ProgressActivity.class);
                    startActivity(inte);
                }
                break;
            case R.id.btnSpinner:
                if(getIntent() != null){
                    inte = new Intent(MainActivity.this, SwitchActivity.class);

                    if(lista != null){
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }

                    startActivity(inte);
                }else{
                    inte = new Intent(MainActivity.this, SwitchActivity.class);
                    startActivity(inte);
                }
                break;
            case R.id.btnSalir:
                System.exit(0);
                break;
        }
    }
}