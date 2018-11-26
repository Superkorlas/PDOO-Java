/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import modeloqytetet.Jugador;
import modeloqytetet.Qytetet;

/**
 *
 * @author super
 */
public class MainTest {
    private static Qytetet juego = Qytetet.getInstance();
    
    public static void main(String[] args)  {
        System.out.println("Pruebas de ejecución:\n");
       ejecucionPruebasHastaSesion3();
    }
    
    static private void ejecucionPruebasHastaSesion3() {
        ArrayList<String> nombres = new ArrayList();
        nombres.add("Plata");
        nombres.add("Robin");
        nombres.add("Charo");
        nombres.add("Angela");
        juego.inicializarJuego(nombres);        
        EjecutarTests();
        // Mostramos resultado
        System.out.println("\n\n\n");
        mostrarEstadoJugadores();
    }
    
    static private void EjecutarTests() {
        //testMoverJugadores();
        //testAplicarSorpresa();
        //testComprarCalleYCobrar();
        //testEdificarCasaYCobrar();
        //testEdificarHotelYCobrar();
        //testHipotecarPropiedadEIntentarCobrar();
        //testCancelarHipotecaYCobrar();
        //testJugadorEncarceladoNoCobra();*/
    }
  
    static private void testMoverJugadores() {
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(1);
            juego.siguienteJugador();
        }
    }

    /*static private void testAplicarSorpresa() {
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(7);
            juego.aplicarSorpresa();
            System.out.println("Jugador actual: " + juego.jugadorActual);
            System.out.println(juego.getCartaActual().toString() + "\n");
            juego.siguienteJugador();
        }  
    }
    
    static private void testComprarCalleYCobrar() {
        juego.mover(1);
        juego.comprarTituloPropiedad();
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testEdificarCasaYCobrar() {
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.edificarCasa(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testEdificarHotelYCobrar() {
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
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.hipotecarPropiedad(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testCancelarHipotecaYCobrar() {
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.hipotecarPropiedad(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        juego.cancelarHipoteca(juego.getJugadorActual().getCasillaActual().getNumeroCasilla());
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
        juego.siguienteJugador();
        juego.mover(1);
    }
    
    static private void testJugadorEncarceladoNoCobra() {
        juego.mover(1);
        juego.comprarTituloPropiedad();
        juego.mover(15); // movemos jugador a casilla de JUEZ para moverlo a la casilla de la carcel
        juego.siguienteJugador();
        juego.mover(1);
    }*/
    
    static private void mostrarEstadoJugadores() {
        for(Jugador j: juego.getJugadores()){
           System.out.println(j.toString());
       }
    }
}