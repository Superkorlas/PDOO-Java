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
        carcel = new Casilla(1, TipoCasilla.CARCEL);
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
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
    
}
