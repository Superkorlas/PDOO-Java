/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Superkorlas
 */
public abstract class Casilla {
    private int numeroCasilla;
    //private int coste;
    private TipoCasilla tipo;
    
    Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
    }
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }

    protected TipoCasilla getTipo() {
        return tipo;
    }

    protected boolean soyEdificable() {
        return tipo == TipoCasilla.CALLE;
    }    
}
