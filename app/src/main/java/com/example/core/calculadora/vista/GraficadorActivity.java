package com.example.core.calculadora.vista;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.core.calculadora.R;
import com.example.core.calculadora.interfaces.GraficadorPresentadorInterface;
import com.example.core.calculadora.interfaces.GraficadorVistaInterface;
import com.example.core.calculadora.presentador.GraficadorPresentadorImpl;

/**
 * GraficadorActivity.java:
 *
 *  Clase principal del graficador, implementa la interface GraficadorVistaInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 19/06/2020
 * @since 1.0, 19/06/2020
 */

public class GraficadorActivity extends AppCompatActivity implements GraficadorVistaInterface {

    /** Layout Principal del graficador */
    private RelativeLayout layoutPrincipal ;

    /** Muestra el numero a graficar */
    private TextView txtFuncion;

    /** Presentador del graficador */
    private GraficadorPresentadorInterface presentador;

    /** Numero a graficar en el graficador */
    private String numero;

    /** Funcion a graficar en el graficador */
    private String funcion;

    /**
     * Ejecuta la lógica de arranque básica de la aplicación.
     *
     * @param savedInstanceState Estado guardado de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graficador);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try {
            numero = getIntent().getStringExtra("Numero");
            funcion = getIntent().getStringExtra("Funcion");
            txtFuncion = (TextView) findViewById(R.id.txtFuncion);
            layoutPrincipal = (RelativeLayout) findViewById(R.id.layoutPrincipal);
            layoutPrincipal.setBackgroundColor(255);
            presentador = new GraficadorPresentadorImpl(this);
            Lienzo fondo = new Lienzo(this);
            layoutPrincipal.addView(fondo);
        }catch (Exception e){

        }
    }

    /** Clase de lienzo del graficador */
    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            presentador.graficarFuncion(canvas,numero,funcion);
        }
    }
    /**
     * Grafica la funcion requerida.
     *
     * @param funcion Resultado de la funcion
     */
    @Override
    public void mostrarFuncion(String funcion){
        txtFuncion.setText(funcion);
    }
}
