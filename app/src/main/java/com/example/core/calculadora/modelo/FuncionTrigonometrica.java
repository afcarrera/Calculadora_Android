package com.example.core.calculadora.modelo;

import android.graphics.Path;

/**
 * FuncionTrigonometrica.java:
 *
 *  Clase que contiene metodos de funciones trigonometricas.
 *
 * @author Alberto Carrera
 * @version 1.0, 11/06/2020
 * @since 1.0, 11/06/2020
 */
public class FuncionTrigonometrica {

    /**
     * Realiza la función de seno.
     *
     * @param valor Numero a obtener el seno
     * @return Retorna el resultado final de la funcion
     */
    public static Numero obtenerSeno(Numero valor) {
        Double acum=0.0,signo=1.0,r=14.0;
        valor.setNumero(valor.getNumero()*Math.PI/180);
        for(int i=1; i<100; i+=2)
        {
            acum += signo* Operacion.potenciar(valor,
                    new Numero(Double.parseDouble(""+i))).getNumero()
                    / Operacion.obtenerFactorial(Double.parseDouble(""+i));
            signo *= -1;
        }
        valor.setNumero(acum);
        r=Math.pow(10,r);
        valor.setNumero(Math.rint(valor.getNumero()*r)/r);
        return valor;
    }

    /**
     * Realiza la función de coseno.
     *
     * @param valor Numero a obtener el coseno
     * @return Retorna el resultado final de la funcion
     */
    public static Numero obtenerCoseno(Numero valor) {
        Double acum=0.0,signo=1.0,r=14.0;
        valor.setNumero(valor.getNumero()*Math.PI/180);
        for(int i=0; i<100; i+=2)
        {
            acum += signo* Operacion.potenciar(valor,
                    new Numero(Double.parseDouble(""+i))).getNumero()
                    / Operacion.obtenerFactorial(Double.parseDouble(""+i));
            signo *= -1;
        }
        valor.setNumero(acum);
        r=Math.pow(10,r);
        valor.setNumero(Math.rint(valor.getNumero()*r)/r);
        return valor;
    }
}

