package com.example.core.calculadora.interfaces;

import android.view.View;
import android.widget.TextView;

/**
 * OperacionPresentadorInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  OperacionPresentadorImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
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
     * Borra todas las operaciones y numeros.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    void borrarTodo(View view, TextView txtPantalla);
}

