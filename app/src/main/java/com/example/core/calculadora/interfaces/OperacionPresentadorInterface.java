package com.example.core.calculadora.interfaces;

import android.view.View;
import android.widget.TextView;

import com.example.core.calculadora.vista.OperacionMainActivity;

/**
 * OperacionPresentadorInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  OperacionPresentadorImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 09/06/2020
 * @since 1.0, 31/05/2020
 */

public interface OperacionPresentadorInterface {

    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    void mostrarResultado(String resultado);

    /**
     * Muestra el número que esta en memoria
     *
     * @param numeroMemoria Número que esta en memoria
     */
    void mostrarNumeroMemoria(String numeroMemoria);

    /**
     * Muestra el operador de la operación a realizar en memoria.
     *
     * @param operador Operador de la operación a realizar en memoria
     */
    void mostrarOperadorMemoria(String operador);

    /**
     * Muestra el número que esta en memoria
     *
     * @param numeroMemoria Número que esta en memoria
     */
    void mostrarNumeroMemoriaPantalla(String numeroMemoria);

    /**
     * Muestra el mensaje "Operación Inválida" cuando
     * una operación es inválida
     */
    void mostrarOperacionInvalida();

    /**
     * Muestra la cadena que contiene la operación.
     *
     * @param cadenaOperacion Cadena que contiene la operación
     */
    void mostrarCadenaOperacion(String cadenaOperacion);

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void validarIngresoNumero(View view,TextView txtPantalla);

    /**
     * Realiza la operación.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void realizarOperacion(View view, TextView txtPantalla);

    /**
     * Ingresa un número a memoria.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void ingresarNumeroMemoria(View view, TextView txtPantalla);

    /**
     * Obtiene el factorial de un número.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void obtenerFactorial(View view, TextView txtPantalla);

    /**
     * Realiza el cambio se signo de un numero
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void cambiarSigno(View view, TextView txtPantalla);

    /**
     * Obtiene el logaritmo de un número.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void obtenerLogaritmo(View view, TextView txtPantalla);

    /**
     * Obtiene la raiz cuadrada de un número.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void obtenerRaizCuadrada(View view, TextView txtPantalla);

    /**
     * Obtiene la funcion trigonometrica de un número.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void obtenerFuncionTrigonometrica(View view, TextView txtPantalla);


    /**
     * Convierte un numero
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void convertirNumero(View view, TextView txtPantalla);

    /**
     * Borra todas las operaciones y numeros.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     * @param txtCadenaOperacion Cadena de la operación
     */
    void borrarTodo(View view, TextView txtPantalla, TextView txtCadenaOperacion);

    /**
     * Borra el numero que esta en pantalla
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void borrarPantalla(View view, TextView txtPantalla);

    /**
     * Borra el ultimo caracter de lo que esta en pantalla
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void borrarCaracterPantalla(View view, TextView txtPantalla);

    /**
     * Inicia la pantalla para graficar una funcion
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     * @param principal Vista principal de la app
     */
    void iniciarGraficador(View view, TextView txtPantalla, OperacionMainActivity principal);

}

