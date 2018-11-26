/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author super
 */
public class OtraCasilla extends Casilla {
    
    OtraCasilla(int numeroCasilla, TipoCasilla tipo) {
        super(numeroCasilla, tipo);
    }
    
    @Override
    public String toString() {
        return "\nCasilla{" + "tipo=" + getTipo() + ", numeroCasilla=" + getNumeroCasilla() + "}";
    }
}
