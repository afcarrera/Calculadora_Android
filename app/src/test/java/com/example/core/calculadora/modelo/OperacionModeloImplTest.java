package com.example.core.calculadora.modelo;

import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
     * Inicializa el atributo modelo.
     *
     * @throws Exception Excepción elevada durante el proceso de instanciación
     */
    @Before
    public void setUp() throws Exception {
        modelo = new OperacionModeloImpl(presentador);
    }

    /**
     * Prueba 1 del método sumar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de suma
     */
    @Test
    public void sumar() throws Exception {
        modelo.sumar(1,2);
        verify(presentador).mostrarResultado("3.0");
    }

    /**
     * Prueba 1 del método restar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de resta
     */
    @Test
    public void restar() throws Exception {
        modelo.restar(1,2);
        verify(presentador).mostrarResultado("-1.0");
    }

    /**
     * Prueba 1 del método multiplicar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de multiplicación
     */
    @Test
    public void multiplicar() throws Exception {
        modelo.multiplicar(1,2);
        verify(presentador).mostrarResultado("2.0");
    }

    /**
     * Prueba 1 del método dividir de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de división
     */
    @Test
    public void dividir() throws Exception {
        modelo.dividir(1,2);
        verify(presentador).mostrarResultado("0.5");
    }

    /**
     * Prueba 1 del método dividir para cero de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el mensaje de operación invalida
     * porque el resultado de la operación de división es 0
     */
    @Test
    public void dividirParaCero() throws Exception {
        modelo.dividir(1,0);
        verify(presentador).mostrarOperacionInvalida();
    }

    /**
     * Prueba 2 del método sumar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de suma
     */
    @Test
    public void sumar1() throws Exception {
        modelo.sumar(-1.5,2.2);
        verify(presentador).mostrarResultado("0.7000000000000002");
    }

    /**
     * Prueba 2 del método restar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de resta
     */
    @Test
    public void restar1() throws Exception {
        modelo.restar(-1.5,2.2);
        verify(presentador).mostrarResultado("-3.7");
    }

    /**
     * Prueba 2 del método multiplicar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de multiplicación
     */
    @Test
    public void multiplicar1() throws Exception {
        modelo.multiplicar(-1.5,2.2);
        verify(presentador).mostrarResultado("-3.3000000000000003");
    }

    /**
     * Prueba 2 del método dividir de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el resultado de la operación de división
     */
    @Test
    public void dividir1() throws Exception {
        modelo.dividir(-1.5,2.2);
        verify(presentador).mostrarResultado("-0.6818181818181818");
    }

    /**
     * Prueba 2 del método dividir para cero de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     * @verify Muestra el mensaje de operación invalida
     * porque el resultado de la operación de división es 0
     */
    @Test
    public void dividirParaCero1() throws Exception {
        modelo.dividir(-1.5,0);
        verify(presentador).mostrarOperacionInvalida();
    }

}