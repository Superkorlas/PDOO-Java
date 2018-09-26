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
public class Qytetet {
    private ArrayList<Sorpresa> mazo = new ArrayList<>();

    protected ArrayList<Sorpresa> getMazo() {
        return mazo;
    }
    
    protected void InicializarCartas() {
        mazo.add(new Sorpresa("De vuelta al pricipio, vuelves a la casilla de salida", 0, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Que suerte, te vas a la carcel", 0, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Poca broma, te vas a la ultima casilla del juego", 0, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Felicidades maquina, recibes dinero de todos por tu cumple", 50, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Vaya, te toca pagar a todos por moroso", 100, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Al margen de la ley", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Todos te pagan", 100, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Debes pagar tus deudas con el resto", 50, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("¡Tus casas y hoteles generan beneficios!", 100, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Te toca pagar impuesto por tus casas y hoteles", 200, TipoSorpresa.PORCASAHOTEL));
    }
}
