package com.example.core.calculadora.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.example.core.calculadora.R;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;
import com.example.core.calculadora.interfaces.OperacionVistaInterface;
import com.example.core.calculadora.presentador.OperacionPresentadorImpl;

/**
 * OperacionMainActivity.java:
 *
 *  Clase principal de la aplicación, implementa la interface OperacionVistaInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public class OperacionMainActivity extends AppCompatActivity implements OperacionVistaInterface {

    /** Primer número ingresado para la operación */
    private TextView numero1;

    /** Segundo número ingresado para la operación */
    private TextView numero2;

    /** Resultado de la operación */
    private TextView txtResultado;

    /** Presentador de la aplicación */
    private OperacionPresentadorInterface presentador;

    /**
     * Ejecuta la lógica de arranque básica de la aplicación.
     *
     * @param savedInstanceState Estado guardado de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = (TextView)findViewById(R.id.txtNumero1);
        numero2 = (TextView)findViewById(R.id.txtNumero2);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        presentador = new OperacionPresentadorImpl(this);
    }

    /**
     * Realiza la operación de suma.
     *
     * @param view Vista de la aplicación
     */
    public void realizarSuma(View view) {
        try {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            presentador.sumar(num1, num2);
        } catch (NumberFormatException e) {
            mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la operación de resta.
     *
     * @param view Vista de la aplicación
     */
    public void realizarResta(View view) {
        try {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            presentador.restar(num1, num2);
        } catch (NumberFormatException e) {
            mostrarOperacionInvalida();
        }

    }

    /**
     * Realiza la operación de multiplicación.
     *
     * @param view Vista de la aplicación
     */
    public void realizarMultiplicacion(View view) {
        try {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            presentador.multiplicar(num1, num2);
        } catch (NumberFormatException e) {
            mostrarOperacionInvalida();
        }

    }

    /**
     * Realiza la operación de división.
     *
     * @param view Vista de la aplicación
     */
    public void realizarDivision(View view) {
        try {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            presentador.dividir(num1, num2);
        } catch (NumberFormatException e) {
            mostrarOperacionInvalida();
        }

    }

    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    @Override
    public void mostrarResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    @Override
    public void mostrarOperacionInvalida() {
        Toast.makeText(this, "Operación Invalida", Toast.LENGTH_SHORT).show();
    }
}

