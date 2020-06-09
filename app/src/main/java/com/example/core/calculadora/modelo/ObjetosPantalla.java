package com.example.core.calculadora.modelo;

/**
 * Numero.java:
 *
 *  Clase que contiene las cajas de texto de la pantalla.
 *
 * @author Alberto Carrera
 * @version 1.0, 08/06/2020
 * @since 1.0, 31/05/2020
 */

public class ObjetosPantalla {
    /** Nuúmero que se muestra por pantalla */
    private String numeroPantalla;

    /** Cadena de la operación */
    private String cadenaOperacion;

    /** Número en memoria */
    private String numeroMemoria;

    /** Consturctor de la clase ObjetosPantalla*/
    public ObjetosPantalla(){
        this.cadenaOperacion ="";
        this.numeroMemoria="";
        this.numeroPantalla="";
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

    /** Cadena de la operación */
    public String getCadenaOperacion() {
        return cadenaOperacion;
    }

    /**
     * Almacena la cadena de la operación.
     *
     * @param cadenaOperacion Valor a almacenar en el atributo "cadenaOperacion"
     */
    public void setCadenaOperacion(String cadenaOperacion) {
        this.cadenaOperacion = cadenaOperacion;
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
