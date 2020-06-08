package com.example.core.calculadora.modelo;

/**
 * Numero.java:
 *
 *  Clase que contiene metodos de operaciones básicas.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public class Operacion {
    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     */
    public static Numero sumar(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        resultado.setNumero(num1.getNumero()+num2.getNumero());
        return resultado;
    }

    /**
     * Realiza la operación de resta.
     *
     * @param num1 Minuendo de la operación de resta
     * @param num2 Sustraendo de la operación de resta
     */
    public static Numero restar(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        resultado.setNumero(num1.getNumero()-num2.getNumero());
        return resultado;
    }

    /**
     * Realiza la operación de multiplicación.
     *
     * @param num1 Primer factor de la operación de multiplicación
     * @param num2 Segundo factor de la operación de multiplicación
     */
    public static Numero multiplicar(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        resultado.setNumero(num1.getNumero()*num2.getNumero());
        return resultado;
    }

    /**
     * Realiza la operación de división.
     *
     * @param num1 Dividendo de la operación de división
     * @param num2 Divisor de la operación de división
     */
    public static Numero dividir(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        try{
            resultado.setNumero(num1.getNumero()/num2.getNumero());
        }catch (ArithmeticException e){

        }
        return resultado;
    }

    /**
     * Realiza la operación de potencia.
     *
     * @param num1 Base de la operación de potencia
     * @param num2 Exponente de la operación de potencia
     */
    public static Numero potenciar(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        try{
            resultado.setNumero(Math.pow(num1.getNumero(),num2.getNumero()));
        }catch (ArithmeticException e){

        }
        return resultado;
    }
}
