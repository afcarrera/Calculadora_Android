package com.example.core.calculadora.presentador;

import android.view.View;
import android.widget.TextView;

import com.example.core.calculadora.R;
import com.example.core.calculadora.modelo.OperacionModeloImpl;
import com.example.core.calculadora.interfaces.OperacionModeloInterface;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;
import com.example.core.calculadora.interfaces.OperacionVistaInterface;

/**
 * OperacionPresentadorImpl.java:
 *
 *  Clase implementada de la interface OperacionPresentadorInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

public class OperacionPresentadorImpl implements OperacionPresentadorInterface {

    /** Vista de la aplicación */
    private OperacionVistaInterface vista;

    /** Modelo de la aplicación */
    private OperacionModeloInterface modelo;

    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param vista Vista de la aplicación
     */
    public OperacionPresentadorImpl(OperacionVistaInterface vista) {
        this.vista = vista;
        this.modelo = new OperacionModeloImpl(this);
    }

    /**
     * Muestra el resultado de la operación realizada.
     *
     * @param resultado Resultado de la operación
     */
    @Override
    public void mostrarResultado(String resultado) {
        if (vista != null) {
            vista.mostrarResultado(resultado);
        }
    }

    /**
     * Muestra el número que esta en memoria
     *
     * @param numeroMemoria Número que esta en memoria
     */
    @Override
    public void mostrarNumeroMemoria(String numeroMemoria) {
        if (vista != null) {
            vista.mostrarNumeroMemoria(numeroMemoria);
        }
    }

    /**
     * Muestra el operador de la operación a realizar en memoria.
     *
     * @param operador Operador de la operación a realizar en memoria
     */
    @Override
    public void mostrarOperadorMemoria(String operador) {
        if (vista != null) {
            vista.mostrarOperadorMemoria(operador);
        }
    }

    /**
     * Muestra el número que esta en memoria en pantalla
     *
     * @param numeroMemoria Número que esta en memoria
     */
    @Override
    public void mostrarNumeroMemoriaPantalla(String numeroMemoria) {
        if (vista != null) {
            modelo.vaciarNumeroPantalla();
            vista.mostrarNumeroMemoriaPantalla(numeroMemoria);
        }
    }

    /** Muestra el mensaje "Operación Inválida" cuando una operación es inválida */
    @Override
    public void mostrarOperacionInvalida() {
        if (vista != null) {
            vista.mostrarOperacionInvalida();
        }
    }

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param view Numero que se intenta ingresar por pantalla
     */
    @Override
    public void validarIngresoNumero(View view,TextView txtPantalla){
        String numero;
        switch (view.getId()){
            case R.id.btnUno: numero = "1"; break;
            case R.id.btnDos: numero = "2"; break;
            case R.id.btnTres: numero = "3"; break;
            case R.id.btnCuatro: numero = "4"; break;
            case R.id.btnCinco: numero = "5"; break;
            case R.id.btnSeis: numero = "6"; break;
            case R.id.btnSiete: numero = "7"; break;
            case R.id.btnOcho: numero = "8"; break;
            case R.id.btnNueve: numero = "9"; break;
            case R.id.btnCero: numero = "0"; break;
            case R.id.btnPunto: numero = "."; break;
            default: numero = "";
        }
        if (modelo != null) {
            modelo.validarIngresoNumero(numero);
        }
    }

    /**
     * Realiza la operación.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    @Override
    public void realizarOperacion(View view,TextView txtPantalla){
        String operador;
            switch (view.getId()) {
                case R.id.btnSuma:
                    operador = "+";
                    break;
                case R.id.btnResta:
                    operador = "-";
                    break;
                case R.id.btnMultiplicacion:
                    operador = "*";
                    break;
                case R.id.btnDivision:
                    operador = "/";
                    break;
                case R.id.btnIgual:
                    operador = modelo.validarOperador();
                    break;
                default:
                    operador = "";
            }
        if (modelo != null) {
            realizarOperacion(operador,txtPantalla);
            modelo.ingresarOperador(operador);
        }
    }

    /**
     * Escoge la operación a realizar.
     *
     * @param operador operador de la operación a realizar
     */
    public void escogerOperacion(String operador){
        if(operador=="+"){
            modelo.sumar(Double.parseDouble(modelo.validarPrimerNumero()),
                    Double.parseDouble(modelo.validarSegundoNumero()));
        }
        if(operador=="-"){
            modelo.restar(Double.parseDouble(modelo.validarPrimerNumero()),
                    Double.parseDouble(modelo.validarSegundoNumero()));
        }
        if(operador=="*"){
            modelo.multiplicar(Double.parseDouble(modelo.validarPrimerNumero()),
                    Double.parseDouble(modelo.validarSegundoNumero()));
        }
        if(operador=="/"){
            modelo.dividir(Double.parseDouble(modelo.validarPrimerNumero()),
                    Double.parseDouble(modelo.validarSegundoNumero()));
        }
    }

    /**
     * Ingresa el operador para la operación a realizar.
     *
     * @param operador operador de la operación a realizar
     * @param txtPantalla Número ingresado por pantalla
     */
    public void realizarOperacion(String operador, TextView txtPantalla){
        if(txtPantalla.getText().toString()!=""){
            if(modelo.validarPrimerNumero()!=""){
                if(modelo.validarOperador()!="") {
                    modelo.ingresarSegundoNumero(txtPantalla.getText().toString());
                    txtPantalla.setText(null);
                    modelo.vaciarNumeroPantalla();
                    escogerOperacion(modelo.validarOperador());
                    modelo.ingresarPrimerNumero(txtPantalla.getText().toString());
                    modelo.ingresarSegundoNumero("");
                    if(operador!="=") {
                        modelo.ingresarOperador(operador);
                    }else{
                        modelo.ingresarOperador(operador);
                    }
                }
            }else{
                modelo.ingresarPrimerNumero(txtPantalla.getText().toString());
                if(operador!="=") {
                    modelo.ingresarOperador(operador);
                }
                modelo.vaciarNumeroPantalla();
                modelo.ingresarSegundoNumero("");
            }
        }
    }

    /**
     * Ingresa un número a memoria.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    public void ingresarNumeroMemoria(View view, TextView txtPantalla){
        double numero =0;
        try {
            numero = Double.parseDouble(txtPantalla.getText().toString());
        }catch (NumberFormatException e){
            switch (view.getId()) {
                case R.id.btnMR:
                    if(modelo.validarNumeroMemoria()!=""){
                        modelo.devolverNumeroMemoria();
                    }
                    return;
            }
        }
        if(modelo.validarNumeroMemoria()!=""){
            if(txtPantalla.getText().toString()!="") {
                switch (view.getId()) {
                    case R.id.btnMPlus:
                        modelo.sumarMemoria(numero);
                        break;
                    case R.id.btnMMenos:
                        modelo.restarMemoria(numero);
                        break;
                    case R.id.btnMR:
                        modelo.devolverNumeroMemoria();
                        break;
                }
            }
        }else{
            switch (view.getId()) {
                case R.id.btnMR:
                    if(modelo.validarNumeroMemoria()!=""){
                        modelo.devolverNumeroMemoria();
                    }
                    return;
            }
            modelo.ingresarNumeroMemoria(txtPantalla.getText().toString());
        }

    }

    /**
     * Borra todas las operaciones y numeros.
     *
     * @param view Vista de la aplicación
     * @param txtPantalla Número ingresado por pantalla
     */
    public void borrarTodo(View view, TextView txtPantalla){
        txtPantalla.setText(null);
        modelo.vaciarNumeroPantalla();
        modelo.ingresarPrimerNumero("");
        modelo.ingresarSegundoNumero("");
        modelo.ingresarOperador("");
    }
}
