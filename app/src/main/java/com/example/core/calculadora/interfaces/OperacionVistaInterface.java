package com.example.core.calculadora.interfaces;

/**
 * OperacionVistaInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  OperacionMainActivity.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public interface OperacionVistaInterface {

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
     * Muestra el número que esta en memoria en pantalla
     *
     * @param numeroMemoria Número que esta en memoria
     */
    void mostrarNumeroMemoriaPantalla(String numeroMemoria);

    /** Muestra el mensaje "Operación Inválida"
     * cuando una operación es inválida */
    void mostrarOperacionInvalida();

    /**
     * Muestra la cadena que contiene la operación.
     *
     * @param cadenaOperacion Cadena que contiene la operación
     */
    void mostrarCadenaOperacion(String cadenaOperacion);
}
