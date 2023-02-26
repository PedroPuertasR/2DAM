package com.pedropuertas.pmdm3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonVolver;
    private Button botonAceptar;
    private RadioGroup grupo;
    private RadioButton btnSelec;
    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        botonVolver = (Button) findViewById(R.id.btnVolverR);
        botonAceptar = (Button) findViewById(R.id.btnAceptarR);
        grupo = (RadioGroup) findViewById(R.id.rbGroup);

        botonAceptar.setOnClickListener(this);
        botonVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent inte;

        if(v.getId() == R.id.btnVolverR){
            if(getIntent() != null){
                inte = new Intent(RadioActivity.this, MainActivity.class);
                Intent intent = getIntent();
                lista = intent.getStringArrayListExtra("lista");
                if(lista != null){
                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");
                }
            }else{
                inte = new Intent(RadioActivity.this, MainActivity.class);
            }

            startActivity(inte);
        }else{
            String animal = "";
            int selectId = grupo.getCheckedRadioButtonId();

            btnSelec = (RadioButton) findViewById(selectId);

            animal = btnSelec.getText().toString();

            if(animal.equalsIgnoreCase("")){
                Toast.makeText(this, "Seleccione una opción válida", Toast.LENGTH_SHORT).show();
                Log.w("ANI", "Animal no seleccionado");
            }else{
                if(getIntent() != null){
                    Intent intent = getIntent();
                    lista = intent.getStringArrayListExtra("lista");

                    if(lista != null){
                        lista.set(5, animal);

                        inte = new Intent(RadioActivity.this, MainActivity.class);
                        inte.putStringArrayListExtra("lista", lista);
                        Log.i("AL", "Transportando lista a otro activity.");
                    }else{
                        lista = new ArrayList<String>();

                        lista.add("");
                        lista.add("");
                        lista.add("");
                        lista.add("");
                        lista.add("");
                        lista.add(animal);
                        lista.add("");

                        inte = new Intent(RadioActivity.this, MainActivity.class);

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
                    lista.add(animal);
                    lista.add("");

                    inte = new Intent(RadioActivity.this, MainActivity.class);

                    inte.putStringArrayListExtra("lista", lista);
                    Log.i("AL", "Transportando lista a otro activity.");

                    startActivity(inte);
                }
            }
        }
    }
}