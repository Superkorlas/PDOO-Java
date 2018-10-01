/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author Superkorlas
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;

    public Tablero() {
        Inicializar();
    }
    
    private void Inicializar() {
        casillas = new ArrayList();
        
        /*@TODO: 
         * Diseñar y crear casillas.
         * Al mismo tiempo, insertarlas en ArrayList casillas.
         * Si es de tipo CALLE, crear también su correspondiente Titulo.
         * Hacer que carcel apunte a la casilla de carcel.
         */
        Casilla casillaSalida = new Casilla(0, TipoCasilla.SALIDA);
        casillas.add(casillaSalida);
        
        TituloPropiedad tituloPropiedadCalle = new TituloPropiedad("", 0, 0, 0.0f, 0, 0);
        Casilla casillaCalle = new Casilla(1, tituloPropiedadCalle);
        casillas.add(casillaCalle);
        
        Casilla casillaCarcel = new Casilla(5, TipoCasilla.CARCEL);
        casillas.add(casillaCarcel);
        carcel = casillaCarcel;
        
        Casilla casillaSorpresa = new Casilla(7, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa);
        
        Casilla casillaParking = new Casilla(10, TipoCasilla.PARKING);
        casillas.add(casillaParking);
        
        Casilla casillaImpuesto = new Casilla(12, TipoCasilla.IMPUESTO);
        casillas.add(casillaImpuesto);
        
        Casilla casillaSorpresa2 = new Casilla(13, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa2);
        
        Casilla casillaJuez = new Casilla(15, TipoCasilla.JUEZ);
        casillas.add(casillaJuez);
        
        Casilla casillaSorpresa3 = new Casilla(18, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa3);
        /* ... */
        
                
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public Casilla getCarcel() {
        return carcel;
    }

    @Override
    public String toString() {
        return "Tablero - " + "Casillas:\n" + casillas + carcel + '}';
    }
    
}
