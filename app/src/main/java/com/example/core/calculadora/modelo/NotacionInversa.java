package com.example.core.calculadora.modelo;
import java.util.Stack;
import java.util.ArrayList;

/**
 * NotacionInversa.java:
 *
 *  Clase que transforma una operación de postfijo a un resultado.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public class NotacionInversa {

    /**
     * Transforma de notacion postfija a resultado
     *
     * @param cadenaPostfijo Cadena en postfijo
     * @return Retorna el resultado final de la operación
     */
    public static Numero TransformarPostfijoResultado(String cadenaPostfijo){//<- Entra la expresion
        cadenaPostfijo=TransformarInfijoPosfijo(cadenaPostfijo);
        // postfija con espacios
        String expr = cadenaPostfijo;  //<- expr va a contener lo que tenia postfijo
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
        String operadores = "+─x/^"; //<- declarar varibale con los operadores
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
     * @param operando Valor del operando
     * @param num2 Valor del numero 2
     * @param num1 Valor del numero 1
     * @return Retorna el resultado de la operación realizada
     */
    private static Numero Evaluar(String operando, String num2, String num1) {
        Double numero1=Double.parseDouble(num1);
        Double numero2=Double.parseDouble(num2);
        if (operando.equals("+")){
            return Operacion.sumar(new Numero(numero1),new Numero(numero2));
        }
        if (operando.equals("─")){
            return Operacion.restar(new Numero(numero1),new Numero(numero2));
        }
        if (operando.equals("x")){
            return Operacion.multiplicar(new Numero(numero1),new Numero(numero2));
        }
        if (operando.equals("/")){
            return Operacion.dividir(new Numero(numero1),new Numero(numero2));
        }
        if (operando.equals("^")){
            return Operacion.potenciar(new Numero(numero1),new Numero(numero2));
        }
        return new Numero(0.0);
      }

    /**
     * Transforma de notación infija a postfija
     *
     * @param cadenaInfijo Cadena en infijo
     * @return Retorna la notación  postfija
     */
    public static String TransformarInfijoPosfijo(String cadenaInfijo){//<- entra la expresion infija
        String postfij = null; //<- Inicializando variable postfijo, será usada al final
        String expr = Depurar(cadenaInfijo); //<- Depurando la expresion infija,
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
        }
        return postfij;
    }

    /** Depura la expresión infija
     *
     * @param cadenaInfijo Cadena en infijo
     * @return Retorna expresión depurada
     */
    private static String Depurar(String cadenaInfijo) {
        cadenaInfijo = cadenaInfijo.replaceAll("\\s+", ""); //<- Elimina espacios en blanco
        cadenaInfijo = "(" + cadenaInfijo + ")";
        String simbols = "+─x/^()";
        String str = "";

        for (int i = 0; i < cadenaInfijo.length(); i++) {//<- Deja espacios entre operadores
            if (simbols.contains("" + cadenaInfijo.charAt(i))) {
                str += " " + cadenaInfijo.charAt(i) + " ";
            }else str += cadenaInfijo.charAt(i);
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    /**
     * Define la jerarquia de los operadores
     *
     * @param cadenaOperadores Cadena de operadores
     * @return Retorna el valor de la jerarquia de los operadores
     */
    private static int DefinirPreferencia(String cadenaOperadores) {
        int prf=0;

        if (cadenaOperadores.equals("^")){
            prf = 5;
        }
        if (cadenaOperadores.equals("x") || cadenaOperadores.equals("/")){
            prf = 4;
        }
        if (cadenaOperadores.equals("+") || cadenaOperadores.equals("─")){
            prf = 3;
        }
        if (cadenaOperadores.equals(")")){
            prf=2;
        }
        if (cadenaOperadores.equals("(")){
            prf = 1;
        }
        return prf;
    }

}