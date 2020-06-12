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
 * @version 1.0, 09/06/2020
 * @since 1.0, 31/05/2020
 */

public class OperacionMainActivity extends AppCompatActivity implements OperacionVistaInterface {

    /** Muestra lo que hay en la pantalla */
    private TextView txtPantalla;

    /** Primer Número de la Operación */
    private TextView txtNumeroMemoria;

    /** Operador de la Operación */
    private TextView txtOperadorMemoria;

    /** Memoria */
    private TextView txtMemoria;

    /** Operación */
    private TextView txtOperacion;

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

    /** Boton número A */
    private Button btnA;

    /** Boton número B */
    private Button btnB;

    /** Boton número C */
    private Button btnCe;

    /** Boton número D */
    private Button btnD;

    /** Boton número E */
    private Button btnE;

    /** Boton número F */
    private Button btnF;

    /** Boton punto */
    private Button btnPunto;

    /** Boton para cambiar de signo */
    private Button btnCambioSigno;

    /** Boton operación de suma */
    private Button btnSuma;

    /** Boton operación de resta */
    private Button btnResta;

    /** Boton operación de multiplicación */
    private Button btnMultiplicación;

    /** Boton operación de división */
    private Button btnDivisión;

    /** Boton operación de módulo */
    private Button btnModulo;

    /** Boton operación de división */
    private Button btnExponente;

    /** Boton operación de factorial */
    private Button btnFactorial;

    /** Boton operación de logaritmo en base 10 */
    private Button btnLogaritmo;

    /** Boton operación de raiz cuadrada */
    private Button btnRaizCuadrada;

    /** Boton operación de igual */
    private Button btnIgual;

    /** Boton función seno */
    private Button btnSeno;

    /** Boton función coseno */
    private Button btnCoseno;

    /** Boton M+ */
    private Button btnMPlus;

    /** Boton M- */
    private Button btnMMenos;

    /** Boton MR */
    private Button btnMR;

    /** Boton DEL */
    private Button btnDEL;

    /** Boton C */
    private Button btnC;

    /** Boton AC */
    private Button btnAC;

    /** Boton Decimal a Binario */
    private Button btnDecimalBinario;

    /** Boton Decimal a Octal */
    private Button btnDecimalOctal;

    /** Boton Decimal a Hexadecimal */
    private Button btnDecimalHexadecimal;

    /** Boton Binario a Decimal */
    private Button btnBinarioDecimal;

    /** Boton Octal a Decimal */
    private Button btnOctalDecimal;

    /** Boton Hexadecimal a Decimal */
    private Button btnHexadecimalDecimal;

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
        try {
            txtPantalla = (TextView) findViewById(R.id.txtPantalla);
            txtNumeroMemoria = (TextView) findViewById(R.id.txtNumeroMemoria);
            txtOperadorMemoria = (TextView) findViewById(R.id.txtOperadorMemoria);
            txtMemoria = (TextView) findViewById(R.id.txtMemoria);
            txtOperacion = (TextView) findViewById(R.id.txtOperacion);
            btn0 = (Button) findViewById(R.id.btnCero);
            btn1 = (Button) findViewById(R.id.btnUno);
            btn2 = (Button) findViewById(R.id.btnDos);
            btn3 = (Button) findViewById(R.id.btnTres);
            btn4 = (Button) findViewById(R.id.btnCuatro);
            btn5 = (Button) findViewById(R.id.btnCinco);
            btn6 = (Button) findViewById(R.id.btnSeis);
            btn7 = (Button) findViewById(R.id.btnSiete);
            btn8 = (Button) findViewById(R.id.btnOcho);
            btn9 = (Button) findViewById(R.id.btnNueve);
            btnA = (Button) findViewById(R.id.btnA);
            btnB = (Button) findViewById(R.id.btnB);
            btnCe = (Button) findViewById(R.id.btnCe);
            btnD = (Button) findViewById(R.id.btnD);
            btnE = (Button) findViewById(R.id.btnE);
            btnF = (Button) findViewById(R.id.btnF);
            btnPunto = (Button) findViewById(R.id.btnPunto);
            btnCambioSigno = (Button) findViewById(R.id.btnCambioSigno);
            btnSuma = (Button) findViewById(R.id.btnSuma);
            btnResta = (Button) findViewById(R.id.btnResta);
            btnMultiplicación = (Button) findViewById(R.id.btnMultiplicacion);
            btnDivisión = (Button) findViewById(R.id.btnDivision);
            btnModulo = (Button) findViewById(R.id.btnModulo);
            btnIgual = (Button) findViewById(R.id.btnIgual);
            btnMPlus = (Button) findViewById(R.id.btnMPlus);
            btnMMenos = (Button) findViewById(R.id.btnMMenos);
            btnMR = (Button) findViewById(R.id.btnMR);
            btnDEL = (Button) findViewById(R.id.btnDEL);
            btnC = (Button) findViewById(R.id.btnC);
            btnAC = (Button) findViewById(R.id.btnAC);
            btnExponente = (Button) findViewById(R.id.btnExponente);
            btnFactorial = (Button) findViewById(R.id.btnFactorial);
            btnLogaritmo = (Button) findViewById(R.id.btnLogaritmo);
            btnRaizCuadrada = (Button) findViewById(R.id.btnRaizCuadrada);
            btnSeno = (Button) findViewById(R.id.btnSeno);
            btnCoseno = (Button) findViewById(R.id.btnCoseno);
            btnDecimalBinario= (Button) findViewById(R.id.btnDecimalBinario);
            btnDecimalOctal= (Button) findViewById(R.id.btnDecimalOctal);
            btnDecimalHexadecimal= (Button) findViewById(R.id.btnDecimalHexadecimal);
            btnBinarioDecimal= (Button) findViewById(R.id.btnBinarioDecimal);
            btnOctalDecimal= (Button) findViewById(R.id.btnOctalDecimal);
            btnHexadecimalDecimal= (Button) findViewById(R.id.btnHexadecimalDecimal);
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
            btnA.setOnClickListener(listenerIngresarNumero);
            btnB.setOnClickListener(listenerIngresarNumero);
            btnCe.setOnClickListener(listenerIngresarNumero);
            btnD.setOnClickListener(listenerIngresarNumero);
            btnE.setOnClickListener(listenerIngresarNumero);
            btnF.setOnClickListener(listenerIngresarNumero);
            btnPunto.setOnClickListener(listenerIngresarNumero);
            btnCambioSigno.setOnClickListener(listenerCambioSigno);
            btnSuma.setOnClickListener(listenerSeleccionarOperacion);
            btnResta.setOnClickListener(listenerSeleccionarOperacion);
            btnMultiplicación.setOnClickListener(listenerSeleccionarOperacion);
            btnDivisión.setOnClickListener(listenerSeleccionarOperacion);
            btnModulo.setOnClickListener(listenerSeleccionarOperacion);
            btnExponente.setOnClickListener(listenerSeleccionarOperacion);
            btnIgual.setOnClickListener(listenerSeleccionarOperacion);
            btnMPlus.setOnClickListener(listenerIngresarMemoria);
            btnMMenos.setOnClickListener(listenerIngresarMemoria);
            btnMR.setOnClickListener(listenerIngresarMemoria);
            btnDEL.setOnClickListener(ListenerBorrarCaracter);
            btnC.setOnClickListener(listenerBorrarPantalla);
            btnAC.setOnClickListener(listenerBorrarTodo);
            btnFactorial.setOnClickListener(listenerFactorial);
            btnLogaritmo.setOnClickListener(listenerLogaritmo);
            btnRaizCuadrada.setOnClickListener(listenerRaizCuadrada);
            btnSeno.setOnClickListener(listenerSeleccionarFuncionTrigonometrica);
            btnCoseno.setOnClickListener(listenerSeleccionarFuncionTrigonometrica);
            btnDecimalBinario.setOnClickListener(listenerConvertirNumero);
            btnDecimalOctal.setOnClickListener(listenerConvertirNumero);
            btnDecimalHexadecimal.setOnClickListener(listenerConvertirNumero);
            btnBinarioDecimal.setOnClickListener(listenerConvertirNumero);
            btnOctalDecimal.setOnClickListener(listenerConvertirNumero);
            btnHexadecimalDecimal.setOnClickListener(listenerConvertirNumero);
        }catch (Exception e){

        }
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
            presentador.borrarTodo(view,txtPantalla,txtOperacion);
        }
    };

    /** Escucha el botón para borrar el último caracter de lo que hay en pantalla. */
    private View.OnClickListener ListenerBorrarCaracter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.borrarCaracterPantalla(view,txtPantalla);
        }
    };

    /** Escucha el botón para borrar lo que hay en pantalla. */
    private View.OnClickListener listenerBorrarPantalla = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.borrarPantalla(view,txtPantalla);
        }
    };

    /** Escucha el botón para realizar la operación del Factorial. */
    private View.OnClickListener listenerFactorial = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.obtenerFactorial(view,txtPantalla);
        }
    };

    /** Escucha el botón para cambiar de signo al número mostrado por pantalla. */
    private View.OnClickListener listenerCambioSigno = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.cambiarSigno(view,txtPantalla);
        }
    };

    /** Escucha el botón para realizar la operación de Logartimo. */
    private View.OnClickListener listenerLogaritmo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.obtenerLogaritmo(view,txtPantalla);
        }
    };

    /** Escucha el botón para realizar la operación de raiz cuadrada. */
    private View.OnClickListener listenerRaizCuadrada = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.obtenerRaizCuadrada(view,txtPantalla);
        }
    };

    /** Escucha el botón para realizar la operación de raiz cuadrada. */
    private View.OnClickListener listenerSeleccionarFuncionTrigonometrica
            = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.obtenerFuncionTrigonometrica(view,txtPantalla);
        }
    };

    /** Escucha el botón para realizar la conversion de un número */
    private View.OnClickListener listenerConvertirNumero = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presentador.convertirNumero(view,txtPantalla);
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
        txtMemoria.setText("Memoria:    ");
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

    /**
     * Muestra la cadena que contiene la operación.
     *
     * @param cadenaOperacion Cadena que contiene la operación
     */
    @Override
    public void mostrarCadenaOperacion(String cadenaOperacion){
        txtOperacion.setText(cadenaOperacion);
    }
}

