package com.example.core.calculadora.presentador;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.core.calculadora.interfaces.GraficadorModeloInterface;
import com.example.core.calculadora.interfaces.GraficadorPresentadorInterface;
import com.example.core.calculadora.interfaces.GraficadorVistaInterface;
import com.example.core.calculadora.modelo.GraficadorModeloImpl;

/**
 * GraficadorPresentadorImpl.java:
 *
 *  Clase implementada de la interface GraficadorPresentadorInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 19/06/2020
 * @since 1.0, 19/06/2020
 */

public class GraficadorPresentadorImpl implements GraficadorPresentadorInterface {

    /** Vista del graficador */
    private GraficadorVistaInterface vista;

    /** Modelo del graficador */
    private GraficadorModeloInterface modelo;

    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param vista Vista de la aplicación
     */
    public GraficadorPresentadorImpl(GraficadorVistaInterface vista) {
        this.vista = vista;
        this.modelo = new GraficadorModeloImpl(this);
    }

    /**
     * Grafica la funcion requerida.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     * @param funcion funcion a calcular
     */
    public void graficarFuncion(Canvas canvas, String numero, String funcion){
        int xMax=canvas.getWidth();
        int yMax=canvas.getHeight();
        int tamanioLineaPrincipal=3;
        int ejeX=-8;
        vista.mostrarFuncion(funcion);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255,0,0,0);
        pincel1.setTextSize(36);
        for(int i=90;i<yMax;i+=3){
            canvas.drawCircle(xMax/2,i,tamanioLineaPrincipal, pincel1);
        }
        for(int i=0;i<xMax;i+=3){
            canvas.drawCircle(i,yMax/2,tamanioLineaPrincipal, pincel1);
        }

        pincel1.setARGB(255,150,150,150);
        for(int i=90;i<yMax;i+=25){
            canvas.drawLine(0,i,xMax,i,pincel1);
        }
        for(int j=0;j<xMax;j+=25){
            canvas.drawLine(j,90,j,yMax,pincel1);
        }
        canvas.drawLine(1000,90,999,yMax,pincel1);
        pincel1.setARGB(255,0,0,0);
        canvas.drawText("1",(xMax/2)+20,(yMax/2)-100,pincel1);
        canvas.drawText("-1",(xMax/2)+20,(yMax/2)+100,pincel1);
        for(int j=0;j<xMax/2;j+=110){
            canvas.drawText(""+ejeX,j,(yMax/2)+30,pincel1);
            ejeX++;
        }
        for(int k=xMax/2+110;k<xMax;k+=110){
            canvas.drawText(""+ejeX,k,(yMax/2)+30,pincel1);
            ejeX++;
        }
        if(funcion.charAt(3)=='S'){
            modelo.graficarFuncionSeno(canvas,numero);
        }else{
            modelo.graficarFuncionCoseno(canvas,numero);
        }

    }
}
