package com.example.core.calculadora.modelo;
import java.util.Stack;
import java.util.ArrayList;

/**
 * PostfijoResultadoModelo.java:
 *
 *  Clase que transforma una operación de postfijo a un resultado.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public class PostfijoResultadoModelo {

    /**
     * Transforma de notacion postfija a resultado
     *
     * @param postfijo Cadena en postfijo
     * @return Retorna el resultado final de la operación
     */
    public static Numero TransformarPostfijoResultado(String postfijo){//<- Entra la expresion
        // postfija con espacios
        String expr = postfijo;  //<- expr va a contener lo que tenia postfijo
        String[] post = expr.split(" ");  //<- El metodo split dividirá por cada espacio
        // y almacenará cada division en un array
        Numero resultado = new Numero();

        //Declaración de las pilas
        Stack < String > E = new Stack < String > (); //<-Pila entrada
        Stack < String > P = new Stack < String > (); //<-Pila de operandos

        for (int i=post.length-1; i>=0;i--) {//<- Añadiendo post (array) a la Pila de entrada (E)
            E.push(post[i]);
        }
        //Algoritmo de Evaluación Postfija
        String operadores = "+-x/^"; //<- declarar varibale con los operadores
        while (!E.isEmpty()) {//<- mientras que E contenga algo
            if (operadores.contains("" + E.peek())) { //<- La pila E solo contdrá operadores,
                // la pila S operandos
            P.push(Evaluar(E.pop(), P.pop(), P.pop()).getNumero().toString());//<-Apilar en
                // P la operacion (Operador, num1, num2)
            }else {
            P.push(E.pop());//<- Apilar en P lo desapilado en E
            }
        }
        resultado.setNumero(Double.parseDouble(P.peek())); //<- Igualacion en una variable
        // el resultado encontrado en el ultimo nivel de P, P.peek() para que pueda ser retornada

        return resultado;
     }

    /** Evalua la operación a realizar.
     *
     * @param op Valor del operando
     * @param n2 Valor del numero 2
     * @param n1 Valor del numero 1
     * @return Retorna el resultado de la operación realizada
     */
    private static Numero Evaluar(String op, String n2, String n1) {
        ArrayList <Numero> numeros = new ArrayList<Numero>();
        for(int i=0;i<3;i++){
            Numero n = new Numero();
            numeros.add(n);
        }
        numeros.get(0).setNumero(Double.parseDouble(n1));
        numeros.get(1).setNumero(Double.parseDouble(n2));
        numeros.get(2).setNumero(0.0);
        if (op.equals("+")){
            return Operacion.sumar(numeros.get(0),numeros.get(1));
        }
        if (op.equals("-")){
            return Operacion.restar(numeros.get(0),numeros.get(1));
        }
        if (op.equals("x")){
            return Operacion.multiplicar(numeros.get(0),numeros.get(1));
        }
        if (op.equals("/")){
            return Operacion.dividir(numeros.get(0),numeros.get(1));
        }
        if (op.equals("^")){
            return Operacion.potenciar(numeros.get(0),numeros.get(1));
        }
        return numeros.get(2);
      }
}