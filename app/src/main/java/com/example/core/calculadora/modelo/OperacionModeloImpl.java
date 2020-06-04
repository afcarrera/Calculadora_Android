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

    /** Modelo de la aplicación */
    private OperacionModelo modelo;

    /** Presentador de la aplicación */
    private OperacionPresentadorInterface presentador;

    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param operationPresenter Presentador de la aplicación
     */
    public OperacionModeloImpl(OperacionPresentadorInterface operationPresenter) {
        this.presentador = operationPresenter;
        this.modelo= new OperacionModelo();
    }

    /**
     * Realiza la operación de suma.
     *
     * @param num1 Primer sumando de la operación de suma
     * @param num2 Segundo sumando de la operación de suma
     */
    @Override
    public void sumar(double num1, double num2) {
        modelo.setResultado(num1 + num2);
        presentador.mostrarResultado(Double.toString(modelo.getResultado()));
    }

    /**
     * Realiza la operación de resta.
     *
     * @param num1 Minuendo de la operación de resta
     * @param num2 Sustraendo de la operación de resta
     */
    @Override
    public void restar(double num1, double num2) {
        modelo.setResultado(num1 - num2);
        presentador.mostrarResultado(Double.toString(modelo.getResultado()));
    }

    /**
     * Realiza la operación de multiplicación.
     *
     * @param num1 Primer factor de la operación de multiplicación
     * @param num2 Segundo factor de la operación de multiplicación
     */
    @Override
    public void multiplicar(double num1, double num2) {
        modelo.setResultado(num1 * num2);
        presentador.mostrarResultado(Double.toString(modelo.getResultado()));
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
            modelo.setResultado(num1 / num2);
            presentador.mostrarResultado(Double.toString(modelo.getResultado()));
        } else {
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la operación de suma en memoria.
     *
     * @param num1 Sumando de la operación de suma en memoria
     */
    @Override
    public void sumarMemoria(double num1){
        modelo.setNumeroMemoria(""+(Double.parseDouble(modelo.getNumeroMemoria())+num1));
        presentador.mostrarNumeroMemoria(modelo.getNumeroMemoria());
        presentador.mostrarOperadorMemoria("M+");
    }

    /**
     * Realiza la operación de resta en memoria.
     *
     * @param num1 Sustraendo de la operación de resta en memoria
     */
    @Override
    public void restarMemoria(double num1){
        modelo.setNumeroMemoria(""+(Double.parseDouble(modelo.getNumeroMemoria())-num1));
        presentador.mostrarNumeroMemoria(modelo.getNumeroMemoria());
        presentador.mostrarOperadorMemoria("M-");
    }

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param numero Numero que se intenta ingresar por pantalla
     */
    @Override
    public void validarIngresoNumero(String numero){
        int contador=0;
        if(modelo.getNumeroPantalla()!=null){
            modelo.setNumeroPantalla(modelo.getNumeroPantalla()+numero);
        }else{
            modelo.setNumeroPantalla(numero);
        }
        if(modelo.getNumeroPantalla().charAt(0)=='.'){
            modelo.setNumeroPantalla("0.");
            presentador.mostrarResultado(modelo.getNumeroPantalla());
        }else{
            for(int i=1; i<modelo.getNumeroPantalla().length(); i++){
                if(modelo.getNumeroPantalla().charAt(i)=='.'){
                    contador++;
                }
            }
            if(contador==0||contador==1){
                presentador.mostrarResultado(modelo.getNumeroPantalla());
            }else{
                modelo.setNumeroPantalla(modelo.getNumeroPantalla().substring(0
                        ,modelo.getNumeroPantalla().length()-1));
                presentador.mostrarResultado(modelo.getNumeroPantalla());
            }
        }
    }

    /** Borra el numero que se ha ingresado por pantalla */
    @Override
    public void vaciarNumeroPantalla(){
        modelo.setNumeroPantalla("");
    }

    /**
     * Ingresa el primer número para la operación a realizar.
     *
     * @param numero Valor del primer número para la operación a realizar
     */
    @Override
    public void ingresarPrimerNumero(String numero){
        modelo.setPrimerNumero(numero);
    }

    /**
     * Ingresa el segundo número para la operación a realizar.
     *
     * @param numero Valor del segundo número para la operación a realizar
     */
    @Override
    public void ingresarSegundoNumero(String numero){
        modelo.setSegundorNumero(numero);
    }

    /**
     * Ingresa el operador para la operación a realizar.
     *
     * @param operador Valor del operador para la operación a realizar
     */
    @Override
    public void ingresarOperador(String operador){
        modelo.setTipoOperacion(operador);
    }

    /**
     * Ingresa número a memoria.
     *
     * @param numero Valor del número que estará en memoria
     */
    @Override
    public void ingresarNumeroMemoria(String numero){
        modelo.setNumeroMemoria(numero);
        presentador.mostrarNumeroMemoria(modelo.getNumeroMemoria());
    }

    /** Valida que se haya ingresado el primer número para la operación a realizar */
    @Override
    public String validarPrimerNumero(){
        return modelo.getPrimerNumero();
    }

    /** Valida que se haya ingresado el segundo número para la operación a realizar */
    @Override
    public String validarSegundoNumero(){
        return modelo.getSegundorNumero();
    }

    /** Valida que haya un operador para la operación a realizar */
    @Override
    public String validarOperador(){
        return modelo.getTipoOperacion();
    }

    /** Valida que haya un número en memoria */
    @Override
    public String validarNumeroMemoria(){
        return modelo.getNumeroMemoria();
    }

    /** Devuelve el número ingresado en memoria */@Override
    public void devolverNumeroMemoria(){
        if(modelo.getNumeroMemoria()!=""){
            presentador.mostrarNumeroMemoriaPantalla(modelo.getNumeroMemoria());
        }
    }
}

