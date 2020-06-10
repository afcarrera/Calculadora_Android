package com.example.core.calculadora.interfaces;

import com.example.core.calculadora.modelo.Numero;

/**
 * OperacionModeloInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  OperacionModeloImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public interface OperacionModeloInterface {

    /**
     * Realiza la operación de suma en memoria.
     *
     * @param num1 Sumando de la operación de suma en memoria
     * @return Retorna la suma de dos números
     */
    void sumarMemoria(double num1);

    /**
     * Realiza la operación de resta en memoria.
     *
     * @param num1 Minuendo de la operación de resta en memoria
     * @return Retorna la resta de dos números
     */
    void restarMemoria(double num1);

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param numero Numero que se intenta ingresar por pantalla
     */
    void validarIngresoNumero(String numero);

    /**
     * Valida que la cadena sea ingresado de manera correcta.
     *
     * @param cadena Cadena que se intenta ingresar
     */
    void validarIngresoCadena(String cadena);

    /** Realiza la operación obtenida de la cadena */
    void realizarOperacion();

    /** Borra el numero que se ha ingresado por pantalla */
    void vaciarNumeroPantalla();

    /** Borra el contenido de la cadena de la operación */
    void vaciarCadenaOperacion();

    /**
     * Ingresa número a memoria.
     *
     * @param numero Valor del número que estará en memoria
     */
    void ingresarNumeroMemoria(String numero);

    /**
     * Valida que haya un número en memoria
     *
     * @return Número en memoria.
     */
    String validarNumeroMemoria();

    /** Devuelve el número ingresado en memoria */
    void devolverNumeroMemoria();

    /**
     * Realiza el factorial de un numero
     *
     * @param numero Valor del número del cual se requiere el factorial
     *
     * @return Resultado del factorial.
     */
    Double obtenerFactorial(Double numero);

    /**
     * Realiza el cambio se signo de un numero
     *
     * @param numero Valor del número del cual se requiere cambiar el signo
     *
     * @return Número cambiado de signo.
     */
    Double cambiarSigno(Double numero);

    /**
     * Realiza el logaritmo de un numero
     *
     * @param numero Valor del número del cual se requiere el logaritmo.
     *
     * @return Resultado del logaritmo.
     */
    Double obtenerLogaritmo(Double numero);
}
