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
public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    // Casillas que SI son de tipo CALLE
    Casilla(int numeroCasilla, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        tipo = TipoCasilla.CALLE;
        this.setTitulo(titulo);
        coste = titulo.getPrecioCompra();
    }
    
    // Casillas que NO son de tipo CALLE
    Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        coste = -1;
        this.tipo = tipo;
        this.titulo = null;
    }
    
    TituloPropiedad AsignarPropietario (Jugador jugador) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    
    int getCoste() {
        return coste;
    }
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }

    TipoCasilla getTipo() {
        return tipo;
    }

    TituloPropiedad getTitulo() {
        return titulo;
    }
    
    int pagarAlquiler() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado() {
       return titulo.propietarioEncarcelado();
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    boolean soyEdificable(){
        return tipo == TipoCasilla.CALLE;
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }

    @Override
    public String toString() {
        if (tipo == TipoCasilla.CALLE) {
            return "\nCasilla{" + "tipo=" + tipo + ", numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", titulo=" + titulo + "}";
        } else {
            return "\nCasilla{" + "tipo=" + tipo + ", numeroCasilla=" + numeroCasilla + "}";
        }
    }
    
    
}
