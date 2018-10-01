/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;


/**
 *
 * @author alejandro
 */
public class PruebaQytetet {
    static Qytetet juego = new Qytetet();

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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // Inicilizaciones
        juego.Inicializar();
        //juego.InicializarTablero();
        //juego.InicializarCartas();
       
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
       
       // Acciones sobre el tablero
       System.out.println("Información del Tablero:");
       System.out.println(juego.getTablero().toString());
    }
    
}
