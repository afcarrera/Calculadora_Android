package com.example.core.calculadora.interfaces;

import android.graphics.Canvas;
import android.view.View;

/**
 * GraficadorModeloInterface.java:
 *
 *  Interface con los métodos a implementarse en la clase
 *  GraficadorModeloImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 19/06/2020
 * @since 1.0, 19/06/2020
 */

public interface GraficadorModeloInterface {

    /**
     * Realiza el gráfico de seno.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     */
    void graficarFuncionSeno(Canvas canvas, String numero);

    /**
     * Realiza el gráfico de coseno.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     */
    void graficarFuncionCoseno(Canvas canvas, String numero);
}
