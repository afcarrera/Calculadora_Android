package com.example.core.calculadora.interfaces;

import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;

/**
 * GraficadorPresentadorInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  GraficadorPresentadorImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 19/06/2020
 * @since 1.0, 19/06/2020
 */

public interface GraficadorPresentadorInterface {

    /**
     * Grafica la funcion requerida.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     * @param funcion funcion a calcular
     */
    void graficarFuncion(Canvas canvas, String numero, String funcion);
}

