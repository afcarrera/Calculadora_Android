package com.example.core.calculadora.modelo;
import com.example.core.calculadora.interfaces.OperacionModeloInterface;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;

/**
 * OperacionModeloImpl.java:
 *
 *  Clase implementada de la interface OperacionModeloInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 07/06/2020
 * @since 1.0, 31/05/2020
 */

public class OperacionModeloImpl implements OperacionModeloInterface {


    /** Presentador de la aplicación */
    private OperacionPresentadorInterface presentador;

    /** Cajas de texto de la aplicación */
    private ObjetosPantalla objetosPantalla;


    /**
     * Instancia los atributos de la clase implementada presentador.
     *
     * @param operationPresenter Presentador de la aplicación
     */
    public OperacionModeloImpl(OperacionPresentadorInterface operationPresenter) {
        this.presentador = operationPresenter;
        this.objetosPantalla= new ObjetosPantalla();
    }

    /**
     * Realiza la operación de suma en memoria.
     *
     * @param num1 Sumando de la operación de suma en memoria
     */
    @Override
    public void sumarMemoria(double num1){
        objetosPantalla.setNumeroMemoria(""+(Double.parseDouble(
                objetosPantalla.getNumeroMemoria())+num1));
        Double num=Double.parseDouble(objetosPantalla.getNumeroMemoria());
        if(num.isNaN()){
            objetosPantalla.setNumeroMemoria("");
            presentador.mostrarNumeroMemoria(objetosPantalla.getNumeroMemoria());
            presentador.mostrarOperadorMemoria("");
            presentador.mostrarOperacionInvalida();
        }else{
            presentador.mostrarNumeroMemoria(objetosPantalla.getNumeroMemoria());
            presentador.mostrarOperadorMemoria(" M+");
        }
    }

    /**
     * Realiza la operación de resta en memoria.
     *
     * @param num1 Minuendo de la operación de resta en memoria
     */
    @Override
    public void restarMemoria(double num1){
        objetosPantalla.setNumeroMemoria(""+(Double.parseDouble(
                objetosPantalla.getNumeroMemoria())-num1));
        Double num=Double.parseDouble(objetosPantalla.getNumeroMemoria());
        if(num.isNaN()){
            presentador.mostrarOperacionInvalida();
            objetosPantalla.setNumeroMemoria("");
            presentador.mostrarNumeroMemoria(objetosPantalla.getNumeroMemoria());
            presentador.mostrarOperadorMemoria("");
        }else{

            presentador.mostrarNumeroMemoria(objetosPantalla.getNumeroMemoria());
            presentador.mostrarOperadorMemoria(" M-");
        }
    }

    /**
     * Valida que el numero sea ingresado de manera correcta.
     *
     * @param numero Numero que se intenta ingresar por pantalla
     */
    @Override
    public void validarIngresoNumero(String numero){
        int contador=0;

        if(objetosPantalla.getNumeroPantalla()!=null){
            objetosPantalla.setNumeroPantalla(objetosPantalla.getNumeroPantalla()+numero);
        }else{
            objetosPantalla.setNumeroPantalla(numero);
        }
        if(objetosPantalla.getNumeroPantalla().charAt(0)=='.'){
            objetosPantalla.setNumeroPantalla("0.");
            presentador.mostrarResultado(objetosPantalla.getNumeroPantalla());
        }else{
            for(int i=1; i<objetosPantalla.getNumeroPantalla().length(); i++){
                if(objetosPantalla.getNumeroPantalla().charAt(i)=='.'){
                    contador++;
                }
            }
            if(contador==0||contador==1){
                presentador.mostrarResultado(objetosPantalla.getNumeroPantalla());
            }else{
                objetosPantalla.setNumeroPantalla(objetosPantalla.getNumeroPantalla().substring(0
                        ,objetosPantalla.getNumeroPantalla().length()-1));
                presentador.mostrarResultado(objetosPantalla.getNumeroPantalla());
            }
        }
    }
    /**
     * Valida que la cadena sea ingresado de manera correcta.
     *
     * @param cadena Cadena que se intenta ingresar
     */
    @Override
    public void validarIngresoCadena(String cadena){

        if(objetosPantalla.getCadenaOperacion()!=null){
            objetosPantalla.setCadenaOperacion(objetosPantalla.getCadenaOperacion()+cadena);
        }else{
            objetosPantalla.setCadenaOperacion(cadena);
        }

        presentador.mostrarCadenaOperacion(objetosPantalla.getCadenaOperacion());
    }

    /** Realiza la operación obtenida de la cadena*/
    @Override
    public void realizarOperacion(){
        Numero resultado=
                NotacionInversa.TransformarPostfijoResultado(
                                objetosPantalla.getCadenaOperacion());
        if(resultado.getNumero().isNaN()){
            presentador.mostrarOperacionInvalida();
        }else{
            presentador.mostrarResultado(resultado.getNumero().toString());
        }

    }

    /** Borra el numero que se ha ingresado por pantalla */
    @Override
    public void vaciarNumeroPantalla(){
        objetosPantalla.setNumeroPantalla("");
    }

    /** Borra el contenido de la cadena de la operación */
    @Override
    public void vaciarCadenaOperacion(){
        objetosPantalla.setCadenaOperacion("");
    }

    /**
     * Ingresa número a memoria.
     *
     * @param numero Valor del número que estará en memoria
     */
    @Override
    public void ingresarNumeroMemoria(String numero){
        objetosPantalla.setNumeroMemoria(numero);
        presentador.mostrarNumeroMemoria(objetosPantalla.getNumeroMemoria());
    }

    /**
     * Valida que haya un número en memoria
     *
     * @return Número en memoria.
     */
    @Override
    public String validarNumeroMemoria(){
        return objetosPantalla.getNumeroMemoria();
    }

    /** Devuelve el número ingresado en memoria */
    @Override
    public void devolverNumeroMemoria(){
        if(objetosPantalla.getNumeroMemoria()!=""){
            presentador.mostrarNumeroMemoriaPantalla(objetosPantalla.getNumeroMemoria());
        }
    }

    /**
     * Realiza el obtenerFactorial de un numero
     *
     * @return resultador del obtenerFactorial.
     */
    @Override
    public Double obtenerFactorial(Double numero) {
        if (numero == 0)
            return 1.0;
        else
            return numero * obtenerFactorial(numero - 1);
    }
}

