/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet; 

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alejandro
 */
public class PruebaQytetet {
    
    private static Qytetet juego = Qytetet.getInstance();
    private static final Scanner in = new Scanner(System.in);
    
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args)  {
        /*/ Nombres de jugadores
        System.out.println("============================================\n"+
                           "============BIENVENIDO A QYTETET============\n"+
                           "============================================\n"+
                           "=========Alejandro de la Plata Ramos========\n"+
                           "===========Robin Costas del Moral===========\n"+
                           "============================================\n");
        juego.inicializarJuego(getNombreJugadores());*/
      
       System.out.println("Pruebas de ejecución:\n");
       ejecucionPruebasHastaSesion4();
    }
    
    
    static private ArrayList<String> getNombreJugadores(){
        ArrayList<String> nombres=new ArrayList<>();
        
        int n;
        do{
            System.out.print("Introduce el numero de jugadores[2 a 4]:\n==>");
            n=in.nextInt();
        }while(n<2 || n>4);
        
        System.out.println("Muy bien, habra " + n + " jugadores, ahora sus nombres:");
        in.nextLine();
        
        for(int i=1; i<(n+1); i++){
            System.out.print("Jugador" + i + ": ");
            String s = in.nextLine();
            nombres.add(s);
        }
        
        return nombres;
    }
    
    static private void InicializarEntornoParaTest() {
        ArrayList<String> nombres = new ArrayList();
        nombres.add("Plata");
        nombres.add("Robin");
        nombres.add("Charo");
        nombres.add("Angela");
        juego.inicializarJuego(nombres); 
    }
    
    static private void ejecucionPruebasHastaSesion4() {
        EjecutarTest();
        // Mostramos resultado
        System.out.println("\n\n\n");
        mostrarEstadoJugadores();
    }
    
    static private void EjecutarTest() {
        testMoverJugadores();
        testAplicarSorpresa();
        testComprarCalleYCobrar();
        testEdificarCasaYCobrar();
        testEdificarHotelYCobrar();
        testHipotecarPropiedadEIntentarCobrar();
        testCancelarHipotecaYCobrar();
        testJugadorEncarceladoNoCobra();
    }
    
    static private void testMoverJugadores() {
        System.out.println("\n\n\nTest mover jugadores");
        InicializarEntornoParaTest();
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(juego.tirarDado());
            juego.siguienteJugador();
        }
    }
    
    static private void testAplicarSorpresa() {
        System.out.println("\n\n\nTest aplicar sorpresa");
        InicializarEntornoParaTest();
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(7);
            juego.aplicarSorpresa();
            System.out.println("Jugador actual: " + juego.jugadorActual);
            System.out.println(juego.getCartaActual().toString() + "\n");
            juego.siguienteJugador();
        }  
    }
    
    static private void testComprarCalleYCobrar() {
        System.out.println("\n\n\nTest comprar calle y cobrar");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testEdificarCasaYCobrar() {
        System.out.println("\n\n\nTest edificar casa y cobrar");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testEdificarHotelYCobrar() {
        System.out.println("\n\n\nTest edificar hotel y cobrar");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.edificarHotel(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testHipotecarPropiedadEIntentarCobrar() {
        System.out.println("\n\n\nTest hipotecar propiedad e intentar cobrar");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.hipotecarPropiedad(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testCancelarHipotecaYCobrar() {
        System.out.println("\n\n\nTest cancelar hipoteca y cobrar");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.hipotecarPropiedad(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.cancelarHipoteca(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testJugadorEncarceladoNoCobra() {
        System.out.println("\n\n\nTest encarcelar jugador y no cobra");
        InicializarEntornoParaTest();
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.mover(15); // movemos jugador a casilla de JUEZ para moverlo a la casilla de la carcel
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testConvertirmeEspeculador() {
        System.out.println("\n\n\nTest convertirme en especulador");
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(7);
            juego.aplicarSorpresa();
            System.out.println("Jugador actual: " + juego.jugadorActual.toString());
            System.out.println(juego.getCartaActual().toString() + "\n");
            juego.siguienteJugador();
        }  
    }
    
    static private void mostrarEstadoJugadores() {
        for(Jugador j: juego.getJugadores()){
           System.out.println(j.toString());
       }
    }
    
    static private ArrayList<Sorpresa> Mayor0(){
       ArrayList<Sorpresa> resultado = new ArrayList<>();
       
       for (Sorpresa it : juego.getMazo()) {
           if(it.getValor() > 0){
               resultado.add(it);
           }
       }
       return resultado;
    }
    
    static private ArrayList<Sorpresa> TipoIrCasilla(){
       ArrayList<Sorpresa> resultado = new ArrayList<>();
       
       for (Sorpresa it : juego.getMazo()) {
           if(it.getTipo() == TipoSorpresa.IRACASILLA) {
               resultado.add(it);
           }
       }
       return resultado;
    }
    
    static private ArrayList<Sorpresa> DevuelveTipo(TipoSorpresa tipo){
       ArrayList<Sorpresa> resultado = new ArrayList<>();
       
       for (Sorpresa it : juego.getMazo()) {
           if(it.getTipo() == tipo) {
               resultado.add(it);
           }
       }
       return resultado;
    }
}
