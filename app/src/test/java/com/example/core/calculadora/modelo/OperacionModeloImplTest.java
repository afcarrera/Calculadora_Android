package com.example.core.calculadora.modelo;

import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;
import com.example.core.calculadora.presentador.OperacionPresentadorImpl;
import com.example.core.calculadora.vista.OperacionMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * OperacionModeloImplTest.java:
 *
 *  Clase para realizar pruebas unitarias de la clase OperacionModeloImpl.
 *
 * @author Alberto Carrera
 * @version 1.0, 31/05/2020
 */

@RunWith(MockitoJUnitRunner.class)
public class OperacionModeloImplTest {

    /** Presentador de la aplicación */
    @Mock
    private OperacionPresentadorInterface presentador;

    /** Modelo de la aplicación */
    private OperacionModeloImpl modelo;

    /**
     * Inicializa el atributo modelo e ingresa un número a memoria para testeo.
     *
     * @throws Exception Excepción elevada durante el proceso de instanciación
     */
    @Before
    public void setUp() throws Exception {
        modelo = new OperacionModeloImpl(presentador);
        modelo.ingresarNumeroMemoria("5");
    }

    /**
     * Prueba del método sumar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void sumar() throws Exception {
        modelo.sumar(1,2);
        verify(presentador).mostrarResultado("3.0");
    }

    /**
     * Prueba del método restar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void restar() throws Exception {
        modelo.restar(1,2);
        verify(presentador).mostrarResultado("-1.0");
    }

    /**
     * Prueba del método multiplicar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void multiplicar() throws Exception {
        modelo.multiplicar(1,2);
        verify(presentador).mostrarResultado("2.0");
    }

    /**
     * Prueba del método dividir de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void dividir() throws Exception {
        modelo.dividir(1,2);
        verify(presentador).mostrarResultado("0.5");
    }

    /**
     * Prueba del método dividir para cero de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void dividirParaCero() throws Exception {
        modelo.dividir(1,0);
        verify(presentador).mostrarOperacionInvalida();
    }

    /**
     * Prueba del método para validar el ingreso de un Numero.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void validarIngresoNumero() throws Exception {
        modelo.validarIngresoNumero(".");
        verify(presentador).mostrarResultado("0.");
    }

    /**
     * Prueba del método ingresarNumeroMemoria de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void ingresarNumeroMemoria() throws Exception {
        modelo.ingresarNumeroMemoria("6.5");
        verify(presentador).mostrarNumeroMemoria("6.5");
    }


    /**
     * Prueba del método sumarMemoria de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void sumarMemoria() throws Exception {
        modelo.sumarMemoria(3);
        verify(presentador).mostrarNumeroMemoria("8.0");
    }

    /**
     * Prueba del método restarMemoria de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void restarMemoria() throws Exception {
        modelo.restarMemoria(2);
        verify(presentador).mostrarNumeroMemoria("3.0");
    }

    /**
     * Prueba  del método devolverNumeroMemoria de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void devolverNumeroMemoria() throws Exception {
        verify(presentador).mostrarNumeroMemoria("5");
    }


}