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
    /*    ArrayList<String> nombres;
        // Nombres de jugadores
        System.out.println("============================================\n"+
                           "============BIENVENIDO A QYTETET============\n"+
                           "============================================\n"+
                           "=========Alejandro de la Plata Ramos========\n"+
                           "===========Robin Costas del Moral===========\n"+
                           "============================================\n");
        nombres = getNombreJugadores();
        // Inicilizaciones
        juego.inicializarJuego(nombres);

       // Acciones sobre el tablero
       System.out.println("Por desgracia esta partida la jugaran: ");
       mostrarEstadoJugadores();
       
       System.out.println(juego.toString());
    */   
       System.out.println("Pruebas de ejecución:\n");
       ejecucionPruebasHastaSesion3();
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
    
    static private void ejecucionPruebasHastaSesion3() {
        ArrayList<String> nombres = new ArrayList();
        nombres.add("Plata");
        nombres.add("Robin");
        nombres.add("Charo");
        nombres.add("Angela");
        
        juego.inicializarJuego(nombres);
        //System.out.println("Jugador actual: " + juego.jugadorActual);
        
        //testMoverJugadores();
        //testAplicarSorpresa();
        testComprarCalleYCobrar();
        
        // Mostramos resultado
        System.out.println("\n\n\n");
        mostrarEstadoJugadores();
    }
    
    static private void testMoverJugadores() {
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            juego.mover(i+1);
            juego.siguienteJugador();
        }
    }
    
    static private void testAplicarSorpresa() {
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
        juego.comprarTituloPropiedad();
        System.out.println(juego.jugadorActual.getNombre() + juego.getJugadorActual().getPropiedades());
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
