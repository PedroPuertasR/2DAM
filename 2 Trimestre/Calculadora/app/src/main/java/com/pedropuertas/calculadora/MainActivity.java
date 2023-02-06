package com.pedropuertas.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Button btnMemo;
    float num1 = 0.0f;
    float num2 = 0.0f;
    float total = 0.0f;
    float memo = 0.0f;
    String operacion = "";

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        btnMemo = findViewById(R.id.btnME);
    }

    public void pulsar0(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("0");
            }else{
                resultado.setText(resultado.getText() + "0");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("0");
            }else{
                resultado.setText(resultado.getText() + "0");
            }
        }
    }

    public void pulsar1(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("1");
            }else{
                resultado.setText(resultado.getText() + "1");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("1");
            }else{
                resultado.setText(resultado.getText() + "1");
            }
        }
    }
    public void pulsar2(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("2");
            }else{
                resultado.setText(resultado.getText() + "2");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("2");
            }else{
                resultado.setText(resultado.getText() + "2");
            }
        }
    }

    public void pulsar3(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("3");
            }else{
                resultado.setText(resultado.getText() + "3");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("3");
            }else{
                resultado.setText(resultado.getText() + "3");
            }
        }
    }

    public void pulsar4(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("4");
            }else{
                resultado.setText(resultado.getText() + "4");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("4");
            }else{
                resultado.setText(resultado.getText() + "4");
            }
        }
    }

    public void pulsar5(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("5");
            }else{
                resultado.setText(resultado.getText() + "5");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("5");
            }else{
                resultado.setText(resultado.getText() + "5");
            }
        }
    }

    public void pulsar6(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("6");
            }else{
                resultado.setText(resultado.getText() + "6");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("6");
            }else{
                resultado.setText(resultado.getText() + "6");
            }
        }
    }

    public void pulsar7(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("7");
            }else{
                resultado.setText(resultado.getText() + "7");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("7");
            }else{
                resultado.setText(resultado.getText() + "7");
            }
        }
    }

    public void pulsar8(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("8");
            }else{
                resultado.setText(resultado.getText() + "8");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("8");
            }else{
                resultado.setText(resultado.getText() + "8");
            }
        }
    }

    public void pulsar9(View view) {
        if(operacion.equals("")){
            num1 = Float.parseFloat(resultado.getText().toString());
            if(num1 == 0.0f){
                resultado.setText("9");
            }else{
                resultado.setText(resultado.getText() + "9");
            }
        }else{
            num2 = Float.parseFloat(resultado.getText().toString());
            if(num2 == 0.0f){
                resultado.setText("9");
            }else{
                resultado.setText(resultado.getText() + "9");
            }
        }
    }

    public void pulsarME(View view){
        if(btnMemo.getText().toString().equals("M")){
            resultado.setText("" + memo);
            btnMemo.setText("ME");
            memo = 0.0f;
        }else{
            memo = Float.parseFloat(resultado.getText().toString());
            btnMemo.setText("M");
        }
    }

    public void borrarDatos(View view){
        resultado.setText("0");
        num1 = 0.0f;
        num2 = 0.0f;
        operacion = "";
    }

    public void dividirNum(View view) {
        num1 = Float.parseFloat(resultado.getText().toString());
        operacion = "/";
        resultado.setText("0");
    }

    public void multiNum(View view){
        num1 = Float.parseFloat(resultado.getText().toString());
        operacion = "*";
        resultado.setText("0");
    }

    public void restarNum(View view){
        num1 = Float.parseFloat(resultado.getText().toString());
        operacion = "-";
        resultado.setText("0");
    }

    public void sumarNum(View view){
        num1 = Float.parseFloat(resultado.getText().toString());
        operacion = "+";
        resultado.setText("0");
    }

    public void porcenNum(View view){
        num1 = Float.parseFloat(resultado.getText().toString());
        operacion = "%";
        resultado.setText("0");
    }

    public void mostrarResultado(View view) {
        num2 = Float.parseFloat(resultado.getText().toString());

        if (operacion.equals("+")) {
            total = num1 + num2;
            resultado.setText("" + total);
        } else if (operacion.equals("-")) {
            total = num1 - num2;
            resultado.setText("" + total);
        } else if (operacion.equals("/")) {
            if (num2 == 0.0f) {
                resultado.setText("0");
                Toast.makeText(this, "OPERACIÓN NO VÁLIDA", Toast.LENGTH_LONG).show();
            } else {
                total = num1 / num2;
                resultado.setText("" + total);
            }
        } else if (operacion.equals("*")) {
            total = num1 * num2;
            resultado.setText("" + total);
        } else if(operacion.equals("%")){
            total = num1 % num2;
            resultado.setText("" + total);
        }else{
            Toast.makeText(this, "REALICE UNA OPERACIÓN VÁLIDA", Toast.LENGTH_LONG).show();
        }

        num1 = 0.0f;
        num2 = 0.0f;
        operacion = "";
        total = 0.0f;

    }

    public void borrarNum(View view){
       if(resultado.equals("0")){
           Toast.makeText(this, "NO HAY NINGÚN NÚMERO", Toast.LENGTH_LONG).show();
       }else{
           String cadena = resultado.getText().toString();

           cadena = cadena.substring(0, cadena.length() - 1);

           resultado.setText(cadena);
       }

    }
}