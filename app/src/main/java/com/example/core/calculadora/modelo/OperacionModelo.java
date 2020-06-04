package com.example.core.calculadora.modelo;

/**
 * Created by Core on 4/6/2020.
 */

public class OperacionModelo {
    /** Nuúmero que se muestra por pantalla */
    private String numeroPantalla;

    /** Primer Numero de la operación */
    private String primerNumero;

    /** Segundo Numero de la operación */
    private String segundorNumero;

    /** Resultado de la operación */
    private double resultado;

    /** Tipo de la operación */
    private String tipoOperacion;

    /** Número en memoria */
    private String numeroMemoria;

    /** consturctor de la clase */
    public OperacionModelo(){
        this.primerNumero = "";
        this.segundorNumero= "";
        this.tipoOperacion="";
        this.numeroMemoria="";
    }

    /** Nuúmero que se muestra por pantalla */
    public String getNumeroPantalla() {
        return numeroPantalla;
    }

    /**
     * Almacena el número que aparece en pantalla de la operación.
     *
     * @param numeroPantalla Valor a almacenar en el atributo "numeroPantalla"
     */
    public void setNumeroPantalla(String numeroPantalla) {
        this.numeroPantalla = numeroPantalla;
    }

    /** Obtiene el primer número de la operación */
    public String getPrimerNumero() {
        return primerNumero;
    }

    /**
     * Almacena el primer número de la operación.
     *
     * @param primerNumero Valor a almacenar en el atributo "primerNumero"
     */
    public void setPrimerNumero(String primerNumero) {
        this.primerNumero = primerNumero;
    }

    /** Obtiene el segundo número de la operación */
    public String getSegundorNumero() {
        return segundorNumero;
    }

    /**
     * Almacena el segundo número de la operación.
     *
     * @param segundorNumero Valor a almacenar en el atributo "segundorNumero"
     */
    public void setSegundorNumero(String segundorNumero) {
        this.segundorNumero = segundorNumero;
    }

    /** Obtiene el resultado de la operación */
    public double getResultado() {
        return resultado;
    }

    /**
     * Almacena el resultado de la operación.
     *
     * @param resultado Valor a almacenar en el atributo "resultado"
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    /** Tipo de la operación */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Almacena el tipo de la operación.
     *
     * @param tipoOperacion Valor a almacenar en el atributo "tipoOperacion"
     */
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /** Obtiene el número en memoria */
    public String getNumeroMemoria() {
        return numeroMemoria;
    }

    /**
     * Almacena el número en memoria.
     *
     * @param numeroMemoria Valor a almacenar en el atributo "numeroMemoria"
     */
    public void setNumeroMemoria(String numeroMemoria) {
        this.numeroMemoria = numeroMemoria;
    }
}
