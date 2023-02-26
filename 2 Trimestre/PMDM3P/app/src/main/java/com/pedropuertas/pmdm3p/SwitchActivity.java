package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class SwitchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;
    private Button botonAceptar;
    private Switch swVip;
    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        botonVolver = (Button) findViewById(R.id.btnVolverS);
        botonAceptar = (Button) findViewById(R.id.btnAceptarS);
        swVip = (Switch) findViewById(R.id.swVip);

        botonVolver.setOnClickListener(this);
        botonAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent inte;

        if(v.getId() == R.id.btnVolverS){
            if(getIntent() != null){
                inte = new Intent(SwitchActivity.this, MainActivity.class);
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");
                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }
            }else{
                inte = new Intent(SwitchActivity.this, MainActivity.class);
            }

            startActivity(inte);
        }else {

            String vip = "";

            if(swVip.isChecked()){
                vip = "Sí";
                Log.e("CHK", "Check pulsado");
            }else{
                vip = "No";
                Log.e("CHK", "Check no pulsado");
            }

            if(getIntent() != null){
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");

                if(lista != null){
                    lista.set(6, vip);

                    inte = new Intent(SwitchActivity.this, MainActivity.class);
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }else{
                    lista = new ArrayList<String>();

                    lista.add("");
                    lista.add("");
                    lista.add("");
                    lista.add("");
                    lista.add("");
                    lista.add("");
                    lista.add(vip);

                    inte = new Intent(SwitchActivity.this, MainActivity.class);

                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }

                startActivity(inte);
            }else{

                lista = new ArrayList<String>();

                lista.add("");
                lista.add("");
                lista.add("");
                lista.add("");
                lista.add("");
                lista.add("");
                lista.add(vip);

                inte = new Intent(SwitchActivity.this, MainActivity.class);

                inte.putStringArrayListExtra("lista", lista);
                Log.i("AL", "Transportando lista a otro activity.");

                startActivity(inte);
            }
        }
    }
}