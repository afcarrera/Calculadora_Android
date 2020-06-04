package com.example.core.calculadora.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
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

    /** Muestra lo que hay en la pantalla */
    private TextView txtPantalla;

    /** Primer Número de la Operacion */
    private TextView txtNumeroMemoria;

    /** Operador de la Operacion */
    private TextView txtOperadorMemoria;

    /** Boton número 1 */
    private Button btn1;

    /** Boton número 2 */
    private Button btn2;

    /** Boton número 3 */
    private Button btn3;

    /** Boton número 4 */
    private Button btn4;

    /** Boton número 5 */
    private Button btn5;

    /** Boton número 6 */
    private Button btn6;

    /** Boton número 7 */
    private Button btn7;

    /** Boton número 8 */
    private Button btn8;

    /** Boton número 9 */
    private Button btn9;

    /** Boton número 0 */
    private Button btn0;

    /** Boton punto */
    private Button btnPunto;

    /** Boton operación de suma */
    private Button btnSuma;

    /** Boton operación de resta */
    private Button btnResta;

    /** Boton operación de multiplicación */
    private Button btnMultiplicación;

    /** Boton operación de división */
    private Button btnDivisión;

    /** Boton operación de igual */
    private Button btnIgual;

    /** Boton M+ */
    private Button btnMPlus;

    /** Boton M- */
    private Button btnMMenos;

    /** Boton MR */
    private Button btnMR;

    /** Boton AC */
    private Button btnAC;

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
        txtPantalla = (TextView)findViewById(R.id.txtPantalla);
        txtNumeroMemoria = (TextView)findViewById(R.id.txtNumeroMemoria);
        txtOperadorMemoria = (TextView)findViewById(R.id.txtOperadorMemoria);
        btn0 = (Button)findViewById(R.id.btnCero);
        btn1 = (Button)findViewById(R.id.btnUno);
        btn2 = (Button)findViewById(R.id.btnDos);
        btn3 = (Button)findViewById(R.id.btnTres);
        btn4 = (Button)findViewById(R.id.btnCuatro);
        btn5 = (Button)findViewById(R.id.btnCinco);
        btn6 = (Button)findViewById(R.id.btnSeis);
        btn7 = (Button)findViewById(R.id.btnSiete);
        btn8 = (Button)findViewById(R.id.btnOcho);
        btn9 = (Button)findViewById(R.id.btnNueve);
        btnPunto = (Button)findViewById(R.id.btnPunto);
        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnResta = (Button)findViewById(R.id.btnResta);
        btnMultiplicación = (Button)findViewById(R.id.btnMultiplicacion);
        btnDivisión = (Button)findViewById(R.id.btnDivision);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnMPlus = (Button)findViewById(R.id.btnMPlus);
        btnMMenos = (Button)findViewById(R.id.btnMMenos);
        btnMR = (Button)findViewById(R.id.btnMR);
        btnAC = (Button)findViewById(R.id.btnAC);

        btn0.setOnClickListener(listenerIngresarNumero);
        btn1.setOnClickListener(listenerIngresarNumero);
        btn2.setOnClickListener(listenerIngresarNumero);
        btn3.setOnClickListener(listenerIngresarNumero);
        btn4.setOnClickListener(listenerIngresarNumero);
        btn5.setOnClickListener(listenerIngresarNumero);
        btn6.setOnClickListener(listenerIngresarNumero);
        btn7.setOnClickListener(listenerIngresarNumero);
        btn8.setOnClickListener(listenerIngresarNumero);
        btn9.setOnClickListener(listenerIngresarNumero);
        btnPunto.setOnClickListener(listenerIngresarNumero);
        btnSuma.setOnClickListener(listenerSeleccionarOperacion);
        btnResta.setOnClickListener(listenerSeleccionarOperacion);
        btnMultiplicación.setOnClickListener(listenerSeleccionarOperacion);
        btnDivisión.setOnClickListener(listenerSeleccionarOperacion);
        btnIgual.setOnClickListener(listenerSeleccionarOperacion);
        btnMPlus.setOnClickListener(listenerIngresarMemoria);
        btnMMenos.setOnClickListener(listenerIngresarMemoria);
        btnMR.setOnClickListener(listenerIngresarMemoria);
        btnAC.setOnClickListener(listenerBorrarTodo);

        presentador = new OperacionPresentadorImpl(this);
    }

    /** Escucha los botones de números de la aplicación. */
    private View.OnClickListener listenerIngresarNumero = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.validarIngresoNumero(view,txtPantalla);
        }
    };

    /** Escucha los botones de las operaciones de la aplicación. */
    private View.OnClickListener listenerSeleccionarOperacion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.realizarOperacion(view,txtPantalla);
        }
    };

    /** Escucha los botones del número que se guarda en memoria de la aplicación. */
    private View.OnClickListener listenerIngresarMemoria = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.ingresarNumeroMemoria(view,txtPantalla);
        }
    };

    /** Escucha el botón para borrar todo. */
    private View.OnClickListener listenerBorrarTodo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.borrarTodo(view,txtPantalla);
        }
    };


    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    @Override
    public void mostrarResultado(String resultado) {
        txtPantalla.setText(resultado);
    }

    /**
     * Muestra el número que esta en memoria
     *
     * @param numeroMemoria Número que esta en memoria
     */
    @Override
    public void mostrarNumeroMemoria(String numeroMemoria) {
        txtNumeroMemoria.setText(numeroMemoria);
    }

    /**
     * Muestra el operador de la operación a realizar en memoria.
     *
     * @param operador Operador de la operación a realizar en memoria
     */
    @Override
    public void mostrarOperadorMemoria(String operador) {
        txtOperadorMemoria.setText(operador);
    }

    /**
     * Muestra el número que esta en memoria
     *
     * @param numeroMemoria Número que esta en memoria
     */
    @Override
    public void mostrarNumeroMemoriaPantalla(String numeroMemoria) {
        txtPantalla.setText(numeroMemoria);
    }

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    @Override
    public void mostrarOperacionInvalida() {
        Toast.makeText(this, "Operación Invalida", Toast.LENGTH_SHORT).show();
    }
}

