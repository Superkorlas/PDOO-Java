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
    public Casilla(int numeroCasilla, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        tipo = TipoCasilla.CALLE;
        this.setTitulo(titulo);
        coste = titulo.getPrecioCompra();
    }
    
    // Casillas que NO son de tipo CALLE
    public Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        coste = -1;
        this.tipo = tipo;
        this.titulo = null;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        if (tipo == TipoCasilla.CALLE) {
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", tipo=" + tipo + ", titulo=" + titulo + '}';
        } else {
            return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", tipo=" + tipo + '}';
        }
    }
    
    
}
