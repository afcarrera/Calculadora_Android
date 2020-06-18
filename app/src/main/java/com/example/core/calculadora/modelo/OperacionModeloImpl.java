package com.example.core.calculadora.modelo;
import com.example.core.calculadora.interfaces.OperacionModeloInterface;
import com.example.core.calculadora.interfaces.OperacionPresentadorInterface;

/**
 * OperacionModeloImpl.java:
 *
 *  Clase implementada de la interface OperacionModeloInterface.
 *
 * @author Alberto Carrera
 * @version 1.0, 09/06/2020
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
     * Realiza el factorial de un numero
     *
     * @param numero Valor del número del cual se requiere el factorial
     *
     * @return resultado del factorial.
     */
    @Override
    public Double obtenerFactorial(Double numero) {
        return Operacion.obtenerFactorial(numero);
    }

    /**
     * Realiza el cambio se signo de un numero
     *
     * @param numero Valor del número del cual se requiere cambiar el signo
     *
     * @return Número cambiado de signo.
     */
    @Override
    public Double cambiarSigno(Double numero) {
        if(numero!=0)
            return numero * (-1.0);
        return 0.0;
    }

    /**
     * Realiza el logaritmo de un numero
     *
     * @param numero Valor del número del cual se requiere el logaritmo.
     *
     * @return resultado del logaritmo.
     */
    @Override
    public Double obtenerLogaritmo(Double numero) {
        if(numero<=0.0){
          return 0.0/0.0;
        }else {
            Double val = 0.0;
            Double i, accurate = 10.0, reps = 0.0, b = 10.0;
            while (numero != 1 && accurate >= 0) {
                for (i = 0.0; numero >= b; i++) numero /= b;
                numero = Operacion.potenciar(new Numero(numero), new Numero(10.0)).getNumero();
                val = 10 * (val + i);
                accurate--;
                reps++;
            }
            return val / Operacion.potenciar(new Numero(10.0), new Numero(reps)).getNumero();
        }
    }

    /**
     * Realiza la raiz cuadrada de un numero
     *
     * @param numero Valor del número del cual se requiere la raiz cuadrada.
     *
     * @return Resultado de la raiz cuadrada.
     */
    @Override
    public Double obtenerRaizCuadrada(Double numero){
        Double resultado=1.0;
        if (numero > 0) {
            for(int i=0;i<100;i++){
                resultado=(resultado+(numero/resultado))/2;
            }
        }else if(numero<0){
            resultado=0.0/0.0;
        }else{
            resultado=0.0;
        }
        return resultado;
    }

    /**
     * Realiza la función seno de un numero
     *
     * @param numero Valor del número del cual se requiere el seno.
     */
    @Override
    public void obtenerSeno(Double numero){
        Numero resultado=
                FuncionTrigonometrica.obtenerSeno(new Numero(numero));
        if(resultado.getNumero().isNaN()){
            presentador.mostrarOperacionInvalida();
        }else{
            presentador.mostrarResultado(resultado.getNumero().toString());
        }
    }

    /**
     * Realiza la función coseno de un numero
     *
     * @param numero Valor del número del cual se requiere el coseno.
     */
    @Override
    public void obtenerCoseno(Double numero){
        Numero resultado=
                FuncionTrigonometrica.obtenerCoseno(new Numero(numero));
        if(resultado.getNumero().isNaN()){
            presentador.mostrarOperacionInvalida();
        }else{
            presentador.mostrarResultado(resultado.getNumero().toString());
        }
    }

    /**
     * Realiza la conversion de binario a decimal
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirBinarioDecimal(String numero){
        try{
            Integer resultado= Integer.parseInt(numero,2);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(resultado.toString());
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la conversion de octal a decimal
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirOctalDecimal(String numero){
        try{
            Integer resultado= Integer.parseInt(numero,8);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(resultado.toString());
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la conversion de hexadecimal a decimal
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirHexadecimalDecimal(String numero){
        try{
            Integer resultado= Integer.parseInt(numero,16);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(resultado.toString());
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la conversion de decimal a binario
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirDecimalBinario(String numero){
        try{
            int num=Integer.parseInt(numero);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(Integer.toBinaryString(num));
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la conversion de decimal a octal
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirDecimalOctal(String numero){
        try{
            int num=Integer.parseInt(numero);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(Integer.toOctalString(num));
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

    /**
     * Realiza la conversion de decimal a hexadecimal
     *
     * @param numero Valor del número del cual se requiere la conversion.
     */
    @Override
    public void convertirDecimalHexadecimal(String numero){
        try{
            int num=Integer.parseInt(numero);
            vaciarNumeroPantalla();
            presentador.mostrarResultado(Integer.toHexString(num).toUpperCase());
        }catch (NumberFormatException e){
            presentador.mostrarOperacionInvalida();
        }
    }

}

