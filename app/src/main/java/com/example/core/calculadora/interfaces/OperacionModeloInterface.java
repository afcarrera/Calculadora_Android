package com.example.core.calculadora.interfaces;

/**
 * OperacionModeloInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  OperacionPresentadorImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public interface OperacionModeloInterface {

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

    /**
     * Realiza la operación de suma en memoria.
     *
     * @param num1 Sumando de la operación de suma en memoria
     */
    void sumarMemoria(double num1);

    /**
     * Realiza la operación de resta en memoria.
     *
     * @param num1 Sustraendo de la operación de resta en memoria
     */
    void restarMemoria(double num1);

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param numero Numero que se intenta ingresar por pantalla
     */
    void validarIngresoNumero(String numero);

    /** Borra el numero que se ha ingresado por pantalla */
    void vaciarNumeroPantalla();

    /**
     * Ingresa el primer número para la operación a realizar.
     *
     * @param numero Valor del primer número para la operación
     */
    void ingresarPrimerNumero(String numero);

    /**
     * Ingresa el segundo número para la operación a realizar.
     *
     * @param numero Valor del segundo número para la operación
     */
    void ingresarSegundoNumero(String numero);

    /**
     * Ingresa el operador para la operación a realizar.
     *
     * @param operador Valor del operador para la operación
     */
    void ingresarOperador(String operador);

    /**
     * Ingresa el número a memoria.
     *
     * @param numeroMemoria Valor del número a ingresar por memoria
     */
    void ingresarNumeroMemoria(String numeroMemoria);

    /** Valida que se haya ingresado el primer número
     * para la operación a realizar */
    String validarPrimerNumero();

    /** Valida que se haya ingresado el segundo número
     * para la operación a realizar */
    String validarSegundoNumero();

    /** Valida que haya un operador para la operación a realizar */
    String validarOperador();

    /** Valida que haya un número ingresado en memoria */
    String validarNumeroMemoria();

    /** Devuelve el número ingresado en memoria */
    void devolverNumeroMemoria();
}
