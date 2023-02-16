package rueda.inma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class ActivitySegunda extends AppCompatActivity {

    TextView datosNombre;
    TextView datosApellidos;
    TextView datosEmail;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setTitle("Activity segunda");

        Datos datos = null;

        obtenerComponentes();

        if(getIntent().getExtras() != null) {
            datos = (Datos) getIntent().getSerializableExtra("datos");
            mostrarInformacion(datos);
        }

        Datos finalDatos = datos;
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ocultarDatos();
                } else {
                    mostrarInformacion(finalDatos);
                }
            }
        });
    }

    private void ocultarDatos() {
        datosNombre.setText("Nombre: " + "*****");
        datosApellidos.setText("Apellidos: " + "*****");
        datosEmail.setText("Email: " + "*****");
    }

    private void mostrarInformacion(Datos datos) {
        if (datos.getNombre() != null) {
            datosNombre.setText("Nombre: " + datos.getNombre().toString());
        }

        if (datos.getApellidos() != null) {
            datosApellidos.setText("Apellidos: " + datos.getApellidos().toString());
        }

        if (datos.getEmail() != null) {
            datosEmail.setText("Email: " + datos.getEmail().toString());
        }
    }

    private void obtenerComponentes() {
        datosNombre = (TextView) findViewById(R.id.datosNombre);
        datosApellidos = (TextView) findViewById(R.id.datosApellidos);
        datosEmail = (TextView) findViewById(R.id.datosEmail);
        switch1 = (Switch) findViewById(R.id.switch1);
    }

    @Override
    public void onBackPressed() {
        Intent activity = new Intent(ActivitySegunda.this, MainActivity.class);
        startActivity(activity);
        finish();
    }


}