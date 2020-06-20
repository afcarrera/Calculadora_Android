package com.example.core.calculadora.modelo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.core.calculadora.interfaces.GraficadorModeloInterface;
import com.example.core.calculadora.interfaces.GraficadorPresentadorInterface;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * GraficadorModeloImpl.java:
 *
 *  Clase implementada de la interface GraficadorModeloInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 19/06/2020
 * @since 1.0, 19/06/2020
 */


public class GraficadorModeloImpl implements GraficadorModeloInterface {

    /** Presentador del graficador */
    private GraficadorPresentadorInterface presentador;

    /**
     * Instancia los atributos de la clase implementada modelo.
     *
     * @param operationPresenter Presentador de la aplicación
     */
    public GraficadorModeloImpl(GraficadorPresentadorInterface operationPresenter) {
        this.presentador = operationPresenter;
    }
    /**
     * Realiza el gráfico de seno.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     */
    public void graficarFuncionSeno(Canvas canvas, String numero){
        double angulo=Double.parseDouble(numero);
        float x = canvas.getWidth()/2;
        float y = canvas.getHeight()/2;
        int tamanio=5;
        int impY=290;
        double equis,ye;
        String cadena;
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Paint pincel1 = new Paint();
        pincel1.setTextSize(48);
        pincel1.setARGB(255, 34, 98, 96);
        angulo=angulo*-1.0;
        if(angulo<=0){
            for(double r = 0; r >= angulo; r -= 1) {
                x += 2;
                y = (100*FuncionTrigonometrica.obtenerSeno(
                        new Numero(r)).getNumero().floatValue())+canvas.getHeight()/2;
                canvas.drawCircle(x, y,tamanio, pincel1);
            }
            canvas.drawCircle(x, y,tamanio*2, pincel1);
            pincel1.setARGB(255, 0, 0, 0);
            equis=angulo*Math.PI/180;
            ye=(y-canvas.getHeight()/2)/100;
            if(equis==0){
                cadena="("+df.format((equis))+";";
            }else{
                cadena="("+df.format(-(equis))+";";
            }
            if(ye==0){
                cadena=cadena+df.format((ye))+")";
            }else{
                cadena=cadena+df.format(-(ye))+")";
            }
            canvas.drawText(cadena,x,impY,pincel1);
        }else{
            for(double r = 0; r <= angulo; r += 1) {
                x -= 2;
                y = (100*FuncionTrigonometrica.obtenerSeno(
                        new Numero(r)).getNumero().floatValue())+canvas.getHeight()/2;
                canvas.drawCircle(x, y,tamanio, pincel1);
            }
            canvas.drawCircle(x, y,tamanio*2, pincel1);
            pincel1.setARGB(255, 0, 0, 0);
            equis=angulo*Math.PI/180;
            ye=(y-canvas.getHeight()/2)/100;
            if(equis==0){
                cadena="("+df.format((equis))+";";
            }else{
                cadena="("+df.format(-(equis))+";";
            }
            if(ye==0){
                cadena=cadena+df.format((ye))+")";
            }else{
                cadena=cadena+df.format(-(ye))+")";
            }
            canvas.drawText(cadena,x,impY,pincel1);
        }
    }

    /**
     * Realiza el gráfico de coseno.
     *
     * @param canvas canvas
     * @param numero Número ingresado por pantalla
     */
    public void graficarFuncionCoseno(Canvas canvas, String numero){
        double angulo=Double.parseDouble(numero);
        int x = canvas.getWidth()/2;
        float y = canvas.getHeight()/2;
        int tamanio=5;
        int impY=290;
        double equis,ye;
        String cadena;
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Paint pincel1 = new Paint();
        pincel1.setTextSize(48);
        pincel1.setARGB(255, 34, 98, 96);
        angulo=angulo*-1.0;
        if(angulo<=0){
            for(double r = 180; r >= angulo+180; r -= 1) {
                x += 2;
                y = (100*FuncionTrigonometrica.obtenerCoseno(
                        new Numero(r)).getNumero().floatValue())+canvas.getHeight()/2;
                canvas.drawCircle(x, y,tamanio, pincel1);
            }
            canvas.drawCircle(x, y,tamanio*2, pincel1);
            pincel1.setARGB(255, 0, 0, 0);
            equis=angulo*Math.PI/180;
            ye=(y-canvas.getHeight()/2)/100;
            if(equis==0){
                cadena="("+df.format((equis))+";";
            }else{
                cadena="("+df.format(-(equis))+";";
            }
            if(ye==0){
                cadena=cadena+df.format((ye))+")";
            }else{
                cadena=cadena+df.format(-(ye))+")";
            }
            canvas.drawText(cadena,x,impY,pincel1);
        }else{
            for(double r = 180; r <= angulo+180; r += 1) {
                x -= 2;
                y = (100*FuncionTrigonometrica.obtenerCoseno(
                        new Numero(r)).getNumero().floatValue())+canvas.getHeight()/2;
                canvas.drawCircle(x, y,tamanio, pincel1);
            }
            canvas.drawCircle(x, y,tamanio*2, pincel1);
            pincel1.setARGB(255, 0, 0, 0);
            equis=angulo*Math.PI/180;
            ye=(y-canvas.getHeight()/2)/100;
            if(equis==0){
                cadena="("+df.format((equis))+";";
            }else{
                cadena="("+df.format(-(equis))+";";
            }
            if(ye==0){
                cadena=cadena+df.format((ye))+")";
            }else{
                cadena=cadena+df.format(-(ye))+")";
            }
            canvas.drawText(cadena,x,impY,pincel1);
        }
    }
}
