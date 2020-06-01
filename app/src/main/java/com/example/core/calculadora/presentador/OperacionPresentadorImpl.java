package com.example.core.calculadora.presentador;

import com.example.core.calculadora.modelo.OperacionModeloImpl;
import com.example.core.calculadora.interfaces.OperacionModeloInterface;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;
import com.example.core.calculadora.interfaces.OperacionVistaInterface;

/**
 * OperacionPresentadorImpl.java:
 *
 *  Clase implementada de la interface OperacionPresentadorInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public class OperacionPresentadorImpl implements OperacionPresentadorInterface {

    /** Vista de la aplicación */
    private OperacionVistaInterface vista;

    /** Modelo de la aplicación */
    private OperacionModeloInterface modelo;

    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param vista Vista de la aplicación
     */
    public OperacionPresentadorImpl(OperacionVistaInterface vista) {
        this.vista = vista;
        this.modelo = new OperacionModeloImpl(this);
    }

    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    @Override
    public void mostrarResultado(String resultado) {
        if (vista != null) {
            vista.mostrarResultado(resultado);
        }
    }

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    @Override
    public void mostrarOperacionInvalida() {
        if (vista != null) {
            vista.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     */
    @Override
    public void sumar(double num1, double num2) {
        if (modelo != null) {
            modelo.sumar(num1, num2);
        }
    }

    /**
     * Realiza la operación de resta.
     *
     * @param num1 Minuendo de la operación de resta
     * @param num2 Sustraendo de la operación de resta
     */
    @Override
    public void restar(double num1, double num2) {
        if (modelo != null) {
            modelo.restar(num1, num2);
        }
    }

    /**
     * Realiza la operación de multiplicación.
     *
     * @param num1 Primer factor de la operación de multiplicación
     * @param num2 Segundo factor de la operación de multiplicación
     */
    @Override
    public void multiplicar(double num1, double num2) {
        if (modelo != null) {
            modelo.multiplicar(num1, num2);
        }
    }

    /**
     * Realiza la operación de división.
     *
     * @param num1 Dividendo de la operación de división
     * @param num2 Divisor de la operación de división
     */
    @Override
    public void dividir(double num1, double num2) {
        if (modelo != null) {
            modelo.dividir(num1, num2);
        }
    }
}
