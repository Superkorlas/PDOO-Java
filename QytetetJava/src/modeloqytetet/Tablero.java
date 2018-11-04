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

    Tablero() {
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
        
        TituloPropiedad tituloPropiedadCalle1 = new TituloPropiedad("Viso", 558, 356, 12.5f, 55, 550);
        Casilla casillaCalle1 = new Casilla(1, tituloPropiedadCalle1);
        casillas.add(casillaCalle1);
        
        TituloPropiedad tituloPropiedadCalle2 = new TituloPropiedad("Parque Los Angeles", 794, 670, 18.0f, 50, 600);
        Casilla casillaCalle2 = new Casilla(2, tituloPropiedadCalle2);
        casillas.add(casillaCalle2);
        
        TituloPropiedad tituloPropiedadCalle3 = new TituloPropiedad("Calle San Andres", 787, 324, 13.0f, 65, 475);
        Casilla casillaCalle3 = new Casilla(3, tituloPropiedadCalle3);
        casillas.add(casillaCalle3);
        
        TituloPropiedad tituloPropiedadCalle4 = new TituloPropiedad("Barrio Alto", 565, 402, 10.0f, 50, 200);
        Casilla casillaCalle4 = new Casilla(4, tituloPropiedadCalle4);
        casillas.add(casillaCalle4);
        
        Casilla casillaCarcel = new Casilla(5, TipoCasilla.CARCEL);
        casillas.add(casillaCarcel);
        carcel = casillaCarcel;
        
        TituloPropiedad tituloPropiedadCalle6 = new TituloPropiedad("La Estacion", 934, 334, 14.0f, 95, 865);
        Casilla casillaCalle6 = new Casilla(6, tituloPropiedadCalle6);
        casillas.add(casillaCalle6);
        
        Casilla casillaSorpresa = new Casilla(7, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa);
        
        TituloPropiedad tituloPropiedadCalle8 = new TituloPropiedad("Barrio San Francisco", 918, 268, 13.9f, 90, 789);
        Casilla casillaCalle8 = new Casilla(8, tituloPropiedadCalle8);
        casillas.add(casillaCalle8);
        
        TituloPropiedad tituloPropiedadCalle9 = new TituloPropiedad("Calle San Isidro", 998, 313, 16.87f, 100, 1000);
        Casilla casillaCalle9 = new Casilla(9, tituloPropiedadCalle9);
        casillas.add(casillaCalle9);
        
        Casilla casillaParking = new Casilla(10, TipoCasilla.PARKING);
        casillas.add(casillaParking);
        
        TituloPropiedad tituloPropiedadCalle11 = new TituloPropiedad("Alcazaba", 814, 670, 20.0f, 75, 650);
        Casilla casillaCalle11 = new Casilla(11, tituloPropiedadCalle11);
        casillas.add(casillaCalle11);
        
        Casilla casillaImpuesto = new Casilla(12, TipoCasilla.IMPUESTO);
        casillas.add(casillaImpuesto);
        
        Casilla casillaSorpresa2 = new Casilla(13, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa2);
        
        TituloPropiedad tituloPropiedadCalle14 = new TituloPropiedad("La Esperanza", 989, 674, 19.0f, 70, 980);
        Casilla casillaCalle14 = new Casilla(14, tituloPropiedadCalle14);
        casillas.add(casillaCalle14);
        
        Casilla casillaJuez = new Casilla(15, TipoCasilla.JUEZ);
        casillas.add(casillaJuez);
        
        TituloPropiedad tituloPropiedadCalle16 = new TituloPropiedad("Meson de Arroyo", 903, 535, 14.75f, 85, 865);
        Casilla casillaCalle16 = new Casilla(16, tituloPropiedadCalle16);
        casillas.add(casillaCalle16);
        
        TituloPropiedad tituloPropiedadCalle17 = new TituloPropiedad("El Cuellos", 686, 599, 20.0f, 100, 530);
        Casilla casillaCalle17 = new Casilla(17, tituloPropiedadCalle17);
        casillas.add(casillaCalle17);
        
        Casilla casillaSorpresa3 = new Casilla(18, TipoCasilla.SORPRESA);
        casillas.add(casillaSorpresa3);
        
        TituloPropiedad tituloPropiedadCalle19 = new TituloPropiedad("Alfaguara", 755, 387, 19.75f, 70, 350);
        Casilla casillaCalle19 = new Casilla(19, tituloPropiedadCalle19);
        casillas.add(casillaCalle19);
        /* ... */
        
                
    }
    
    boolean esCasillaCarcel(int numeroCasilla) {
        return (carcel.getNumeroCasilla() == numeroCasilla);
    }

    Casilla getCarcel() {
        return carcel;
    }
    
    ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    Casilla ObtenerCasillaFinal(Casilla casilla, int desplazamiento) {
        return casillas.get((casilla.getNumeroCasilla() + desplazamiento)%casillas.size());
    }

    Casilla ObtenerCasillaNumero (int numeroCasilla /* = casillaFinal*/) {
        return casillas.get(numeroCasilla);
    }
    
    @Override
    public String toString() {
        return "Tablero={" + "Casillas:\n\t" + casillas + carcel + '}';
    }
    
}
