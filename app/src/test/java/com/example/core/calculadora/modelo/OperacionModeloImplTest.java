package com.example.core.calculadora.modelo;

import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;

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

    /** Clase Número */
    private Numero numero1;

    /** Clase Número */
    private Numero numero2;

    /**
     * Inicializa el atributo modelo e ingresa un número a memoria para testeo.
     *
     * @throws Exception Excepción elevada durante el proceso de instanciación
     */
    @Before
    public void setUp() throws Exception {
        modelo = new OperacionModeloImpl(presentador);
        modelo.ingresarNumeroMemoria("5");
        numero1 = new Numero();
        numero2 = new Numero();
    }

    /**
     * Prueba del método sumar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void sumar() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(4.0);
        numero1.setNumero(2.0);
        numero2.setNumero(2.0);
        assertEquals(Operacion.sumar(numero1,numero2).getNumero(), resultado.getNumero());
    }

    /**
     * Prueba del método restar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void restar() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(4.0);
        numero1.setNumero(6.0);
        numero2.setNumero(2.0);
        assertEquals(Operacion.restar(numero1,numero2).getNumero(), resultado.getNumero());
    }

    /**
     * Prueba del método multiplicar de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void multiplicar() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(4.0);
        numero1.setNumero(2.0);
        numero2.setNumero(2.0);
        assertEquals(Operacion.multiplicar(numero1,numero2).getNumero(), resultado.getNumero());
    }

    /**
     * Prueba del método dividir de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void dividir() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(1.0);
        numero1.setNumero(2.0);
        numero2.setNumero(2.0);
        assertEquals(Operacion.dividir(numero1,numero2).getNumero(), resultado.getNumero());
    }

    /**
     * Prueba del método dividir para cero de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void dividirParaCero() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(2.0/0.0);
        numero1.setNumero(2.0);
        numero2.setNumero(0.0);
        assertEquals(Operacion.dividir(numero1,numero2).getNumero(), resultado.getNumero());
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

    /**
     * Prueba  del método obtenerFactorial de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void obtenerFactorial() throws Exception {
        Double resultado=40320.0;
        assertEquals(modelo.obtenerFactorial(8.0), resultado);
    }

    /**
     * Prueba  del método obtenerModulo de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void obtenerModulo() throws Exception {
        Numero resultado = new Numero();
        resultado.setNumero(-2.0);
        numero1.setNumero(-5.0);
        numero2.setNumero(-3.0);
        assertEquals(Operacion.obtenerModulo(numero1,numero2).getNumero(), resultado.getNumero());
    }

    /**
     * Prueba  del método obtenerModulo de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void obtenerLogaritmo() throws Exception {
        Double resultado=3.0;
        assertEquals(modelo.obtenerLogaritmo(1000.0), resultado);
    }

    /**
     * Prueba  del método obtenerRaizCuadrada de la clase OperacionModeloImpl.
     *
     * @throws Exception Excepción elevada durante el proceso de prueba
     */
    @Test
    public void obtenerRaizCuadrada() throws Exception {
        Double resultado=10.0;
        assertEquals(modelo.obtenerRaizCuadrada(100.0), resultado);
    }

}