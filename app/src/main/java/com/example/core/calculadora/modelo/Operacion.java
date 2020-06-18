package com.example.core.calculadora.modelo;

/**
 * Operacion.java:
 *
 *  Clase que contiene metodos de operaciones básicas.
 *
 * @author Alberto Carrera
 * @version 1.0, 09/06/2020
 * @since 1.0, 31/05/2020
 */

public class Operacion {
    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     * @return Retorna el resultado final de la operación
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
     * @return Retorna el resultado final de la operación
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
     * @return Retorna el resultado final de la operación
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
     * @return Retorna el resultado final de la operación
     */
    public static Numero dividir(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        try{
            resultado.setNumero(num1.getNumero()/num2.getNumero());
        }catch (ArithmeticException e){

        }catch (Exception e){

        }
        return resultado;
    }

    /**
     * Realiza la operación de potencia.
     *
     * @param num1 Base de la operación de potencia
     * @param num2 Exponente de la operación de potencia
     * @return Retorna el resultado final de la operación
     */
    public static Numero potenciar(Numero num1, Numero num2) {
        Numero resultado=new Numero(1.0);
        try{
            if(num2.getNumero()<0.0){
                num2.setNumero(num2.getNumero()*(-1.0));
                for (double i = 1.0; i<=num2.getNumero(); i+=1) {
                    resultado.setNumero(num1.getNumero()*resultado.getNumero());
                }
                resultado.setNumero(1.0/resultado.getNumero());
            }else{
                for (double i = 1.0; i<=num2.getNumero(); i+=1) {
                    resultado.setNumero(num1.getNumero()*resultado.getNumero());
                }
            }

        }catch (ArithmeticException e){

        }catch (Exception e){

        }
        return resultado;
    }

    /**
     * Realiza el factorial de un numero
     *
     * @param numero Valor del número del cual se requiere el factorial     *
     * @return resultado del factorial.
     */
    public static Double obtenerFactorial(Double numero) {
        if (numero == 0)
            return 1.0;
        else
            return numero * obtenerFactorial(numero - 1);
    }

    /**
     * Realiza la operación de obtenerModulo.
     *
     * @param num1 Dividendo de la operación de modulo
     * @param num2 Divisor de la operación de modulo
     * @return Retorna el resultado final de la operación
     */
    public static Numero obtenerModulo(Numero num1, Numero num2) {
        Numero resultado=new Numero();
        try{
            if(num1.getNumero()<0&&num2.getNumero()>0){
                while (num1.getNumero()<0){
                    num1.setNumero(num1.getNumero()+num2.getNumero());
                }
                resultado.setNumero(num1.getNumero()%(num2.getNumero()));
                return resultado;
            }
            if(num1.getNumero()>0&&num2.getNumero()<0){
                num1.setNumero(num1.getNumero()*(-1));
                num2.setNumero(num2.getNumero()*(-1));
                while (num1.getNumero()<0){
                    num1.setNumero(num1.getNumero()+num2.getNumero());
                }
                resultado.setNumero(num1.getNumero()%(num2.getNumero()));
                resultado.setNumero(resultado.getNumero()*(-1));
                return resultado;
            }
            resultado.setNumero(num1.getNumero()%(num2.getNumero()));
        }catch (ArithmeticException e){

        }catch (Exception e){

        }
        return resultado;
    }
}
