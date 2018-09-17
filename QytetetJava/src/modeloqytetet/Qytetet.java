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
        mazo.add(new Sorpresa("", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("", 1, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("", 2, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("", 3, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("", 4, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("", 5, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("", 6, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("", 7, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("", 8, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("", 0, TipoSorpresa.PAGARCOBRAR));
    }
}
