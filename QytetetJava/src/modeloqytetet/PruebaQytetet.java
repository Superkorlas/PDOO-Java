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
        ArrayList<String> nombres;
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

/*
       for (Sorpresa it : juego.getMazo()) {
           System.out.println(it.toString());
       }
       
       for (Sorpresa it : Mayor0()) {
           System.out.println(it.toString());
       }
              
       for (Sorpresa it : TipoIrCasilla()) {
           System.out.println(it.toString());
       }
                     
       for (Sorpresa it : DevuelveTipo(TipoSorpresa.PAGARCOBRAR)) {
           System.out.println(it.toString());
       }
*/
       // Acciones sobre el tablero
       System.out.println("Por desgracia esta partida la jugaran: ");
       for(Jugador j: juego.getJugadores()){
           System.out.println(j.toString());
       }
       
       System.out.println(juego.toString());
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
