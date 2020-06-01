package com.example.core.calculadora.modelo;
import com.example.core.calculadora.interfaces.OperacionModeloInterface;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;

/**
 * OperacionModeloImpl.java:
 *
 *  Clase implementada de la interface OperacionModeloInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public class OperacionModeloImpl implements OperacionModeloInterface {

    /** Resultado de la operación */
    private double resultado;

    /** Presentador de la aplicación */
    private OperacionPresentadorInterface presentador;

    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param operationPresenter Presentador de la aplicación
     */
    public OperacionModeloImpl(OperacionPresentadorInterface operationPresenter) {
        this.presentador = operationPresenter;
    }

    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     */
    @Override
    public void sumar(double num1, double num2) {
        resultado =  num1 + num2;
        presentador.mostrarResultado(Double.toString(resultado));
    }

    /**
     * Realiza la operación de resta.
     *
     * @param num1 Minuendo de la operación de resta
     * @param num2 Sustraendo de la operación de resta
     */
    @Override
    public void restar(double num1, double num2) {
        resultado = num1 - num2;
        presentador.mostrarResultado(Double.toString(resultado));
    }

    /**
     * Realiza la operación de multiplicación.
     *
     * @param num1 Primer factor de la operación de multiplicación
     * @param num2 Segundo factor de la operación de multiplicación
     */
    @Override
    public void multiplicar(double num1, double num2) {
        resultado = num1 * num2;
        presentador.mostrarResultado(Double.toString(resultado));
    }

    /**
     * Realiza la operación de división.
     *
     * @param num1 Dividendo de la operación de división
     * @param num2 Divisor de la operación de división
     */
    @Override
    public void dividir(double num1, double num2) {
        if (num2 != 0) {
            resultado = num1 / num2;
            presentador.mostrarResultado(Double.toString(resultado));
        } else {
            presentador.mostrarOperacionInvalida();
        }
    }
}

