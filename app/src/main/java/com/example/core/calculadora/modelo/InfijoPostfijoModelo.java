package com.example.core.calculadora.modelo;
import java.util.Stack;

/**
 * PostfijoResultadoModelo.java:
 *
 *  Clase que transforma una operación de infijo a postfijo.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public class InfijoPostfijoModelo {

    /**
     * Transforma de notación infija a postfija
     *
     * @param infijo Cadena en infijo
     * @return Retorna la notación  postfija
     */
     public static String TransformarInfijoPosfijo(String infijo){//<- entra la expresion infija
        String postfij = null; //<- Inicializando variable postfijo, será usada al final
        String expr = Depurar(infijo); //<- Depurando la expresion infija,
        // por si llega a tener espacios innecesarios o algo por el estilo
        String[] arrayInfix = expr.split(" "); //<- mediante medodo split
        // meteremos cada caracter en array por cada espacio encontrado

        //Declaración de las pilas
        Stack <String> E = new Stack <String> (); //<- Pila entrada
        Stack <String> P = new Stack <String> (); //<- Pila temporal para operadores
        Stack <String> S = new Stack <String> (); //<- Pila salida

        for (int i=arrayInfix.length-1; i>=0;i--){//<- Añadiendo el array a la Pila de entrada (E)
          E.push(arrayInfix[i]);
        }
        try {
          //Algoritmo Infijo a Postfijo
          while (!E.isEmpty()) { //<- Mientras que la pila E contenga algo

            switch (DefinirPreferencia(E.peek())){
              //Caso para apertura de parentesis
              case 1:
                   P.push(E.pop());//<- apilar en P lo desapilado por E (
                   break;
              //Caso para suma o resta
              case 3:
                    while(DefinirPreferencia(P.peek()) >= DefinirPreferencia(E.peek())) {
                      S.push(P.pop());//<- apilar en S lo desapiplado en P
                    }
                    P.push(E.pop());//<- apilar en P lo desapilado en E
                   break;
              //Caso para productos y cocientes
              case 4:
                    while(DefinirPreferencia(P.peek()) >= DefinirPreferencia(E.peek())) {
                      S.push(P.pop());//<- apilar en S lo desapiplado en P
                    }
                    P.push(E.pop());//<- apilar en P lo desapilado en E
                   break;
              //Caso para parentesis cerrados
              case 2:
                    while(!P.peek().equals("(")) {
                      S.push(P.pop());//<- apilar en S lo desapilado en P )
                    }
                    P.pop();//<- Desapilar en P
                    E.pop();//<- Desapilar en E
                    break;
              //Caso para potencias
              case 5:
                    while(DefinirPreferencia(P.peek()) >= DefinirPreferencia(E.peek())) {
                      S.push(P.pop());//<- apilar en S lo desapiplado en P
                    }
                    P.push(E.pop());//<- apilar en P lo desapilado en E
                   break;
              //Cuaquier otro caso
              default:
                 S.push(E.pop());  //<- apilar en S lo desapilado en E
            }
              }
              String infij = expr.replace(" ", ""); //<- Eliminacion de
            // `impurezas´ en la expresiones algebraicas
              postfij = S.toString().replaceAll("[\\]\\[,]", "");

            }catch(Exception ex){
              //JOptionPane.showMessageDialog(null, "Error en la expresión algebraica"+ ex);
            // <- Avisamos si la expresion esta mal escrita
            }
        return postfij;
    }

    /** Depura la expresión infija
     *
     * @param s Cadena en infijo
     * @return Retorna expresión depurada
     */
    private static String Depurar(String s) {
        s = s.replaceAll("\\s+", ""); //<- Elimina espacios en blanco
        s = "(" + s + ")";
        String simbols = "+-x/^()";
        String str = "";

        for (int i = 0; i < s.length(); i++) {//<- Deja espacios entre operadores
          if (simbols.contains("" + s.charAt(i))) {
            str += " " + s.charAt(i) + " ";
          }else str += s.charAt(i);
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    /**
     * Define la jerarquia de los operadores
     *
     * @param oper Cadena de operadores
     * @return Retorna el valor de la jerarquia de los operadores
     */
    private static int DefinirPreferencia(String oper) {
        int prf=0;

        if (oper.equals("^")){
            prf = 5;
        }
        if (oper.equals("x") || oper.equals("/")){
            prf = 4;
        }
        if (oper.equals("+") || oper.equals("-")){
            prf = 3;
        }
        if (oper.equals(")")){
            prf=2;
        }
        if (oper.equals("(")){
            prf = 1;
        }
        return prf;
    }

}