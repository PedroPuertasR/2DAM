package rueda.inma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textoNombre;
    EditText textoApellidos;
    EditText textoEmail;
    Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Activity principal");
        obtenerComponentes();

        // Controlar el click del botos
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarCampos()) {
                    Datos datos = new Datos();
                    datos.setNombre(textoNombre.getText().toString());
                    datos.setApellidos(textoApellidos.getText().toString());
                    datos.setEmail(textoEmail.getText().toString());

                    enviarDatos(datos);
                }
            }
        });
    }

    /**
     * Envia datos de la actividad principal a la segunda
     */
    private void enviarDatos(Datos datos) {
        Intent activity = new Intent(MainActivity.this, ActivitySegunda.class);
        activity.putExtra("datos", datos);
        startActivity(activity);
        finish();
    }

    /**
     * Valida que los campos esten rellenos al hacer click
     * @return
     */
    private boolean validarCampos() {
        if (TextUtils.isEmpty(textoNombre.getText())) {
            textoNombre.setError("Debe introducir su nombre");
            return false;
        }

        if (TextUtils.isEmpty(textoApellidos.getText())) {
            textoApellidos.setError("Debe introducir sus apellidos");
            return false;
        }

        if (TextUtils.isEmpty(textoEmail.getText())) {
            textoEmail.setError("Debe introducir su email");
            return false;
        }

        return true;
    }

    /**
     * Obtiene los componentes de la pantalla
     */
    private void obtenerComponentes() {
        textoNombre = (EditText) findViewById(R.id.textoNombre);
        textoApellidos = (EditText) findViewById(R.id.textoApellidos);
        textoEmail = (EditText) findViewById(R.id.textoEmail);
        botonEnviar = (Button) findViewById(R.id.botonEnviar);
    }
}