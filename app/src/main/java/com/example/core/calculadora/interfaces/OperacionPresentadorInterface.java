package com.example.core.calculadora.interfaces;

/**
 * OperacionPresentadorInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase OperacionPresentadorImpl.
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

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    void mostrarOperacionInvalida();

    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     */
    void sumar(double num1, double num2);

    /**
     * Realiza la operación de resta.
     *
     * @param num1 Minuendo de la operación de resta
     * @param num2 Sustraendo de la operación de resta
     */
    void restar(double num1, double num2);

    /**
     * Realiza la operación de multiplicación.
     *
     * @param num1 Primer factor de la operación de multiplicación
     * @param num2 Segundo factor de la operación de multiplicación
     */
    void multiplicar(double num1, double num2);

    /**
     * Realiza la operación de división.
     *
     * @param num1 Dividendo de la operación de división
     * @param num2 Divisor de la operación de división
     */
    void dividir(double num1, double num2);
}

