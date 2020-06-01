package com.example.core.calculadora.interfaces;

/**
 * OperacionVistaInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase OperacionMainActivity.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public interface OperacionVistaInterface {

    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    void mostrarResultado(String resultado);

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    void mostrarOperacionInvalida();
}
