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
public class Calle extends Casilla {
    
    private TituloPropiedad titulo;
    private int coste;
    
    Calle(int numeroCasilla, TituloPropiedad titulo) {
        super(numeroCasilla, TipoCasilla.CALLE);
        setTitulo(titulo);
        coste = titulo.getPrecioCompra();
    }
    
    int getCoste() {
        return coste;
    }
    
    public TituloPropiedad AsignarPropietario (Jugador jugador) {
        titulo.setPropietario(jugador);
        return titulo;
    }
    
    protected TituloPropiedad getTitulo() {
        return titulo;
    }
    
    public int pagarAlquiler() {
        int costeAlquiler = titulo.pagarAlquiler();
        return costeAlquiler;
    }
    
    private void setTitulo (TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    protected boolean tengoPropietario() {
        return titulo.tengoPropietario();
    }
    
    boolean propietarioEncarcelado() {
       return titulo.propietarioEncarcelado();
    }
    
    @Override
    public String toString() {
        return "\nCasilla{" + "tipo=" + getTipo() + ", numeroCasilla=" + getNumeroCasilla() + ", coste=" + coste + ", titulo=" + titulo + "}";
    }
}
