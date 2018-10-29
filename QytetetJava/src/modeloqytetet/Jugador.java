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
public class Jugador implements Comparable {
    boolean encarcelado;
    String nombre;
    int saldo;
    ArrayList<TituloPropiedad> propiedades;
    Casilla casillaActual;
    Sorpresa cartaLibertad;
    
    Jugador(String nombre){
        this.nombre = nombre;
        encarcelado = false;
        saldo = 7500;
        propiedades = new ArrayList<>();
        cartaLibertad = null;
        casillaActual = null;
    }
    
    @Override
    public int compareTo(Object otroJugador){
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital - this.obtenerCapital();
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cuantasCasasHotelTengo(){
        int numCasHot = 0;
        for(TituloPropiedad pr: propiedades){
            numCasHot += pr.getNumCasas() + pr.getNumHoteles();
        }
        
        return numCasHot;
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa cartaDevuelta = this.cartaLibertad;
        this.cartaLibertad = null;
        
        return cartaDevuelta;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean esDeMiPropiedad(TituloPropiedad titulo){
        for( TituloPropiedad ti: this.propiedades){
            if(ti == titulo)
                return true;
        }
        return false;
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa getCartaLibertad(){
        return cartaLibertad;
    }
    
    Casilla getCasillaActual(){
        return casillaActual;
    }
    
    boolean getEncarcelado(){
        return encarcelado;
    }
    
    String getNombre(){
        return nombre;
    }
    
    ArrayList<TituloPropiedad> getPropiedades(){
        return propiedades;
    }
    
    int getSaldo(){
        return saldo;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad){
        saldo += cantidad;
        return saldo;
    }
    
    int obtenerCapital(){
        int capital = getSaldo();
        for(TituloPropiedad pr: propiedades){
            capital += pr.getPrecioEdificar()*(pr.getPrecioCompra() + pr.getNumCasas() + pr.getNumHoteles());
        }
        return capital;
    }
    
        
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada){
        ArrayList<TituloPropiedad> resultado = new ArrayList<>();
        
        for(TituloPropiedad ti: propiedades){
            if(hipotecada && ti.getHipotecada()){
                resultado.add(ti);
            }
            else if(!hipotecada && !ti.getHipotecada()){
                resultado.add(ti);
            }
        }
        
        return resultado;
    }
    
    void pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto(){
        saldo -= casillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setCartaLibertad(Sorpresa carta){
        this.cartaLibertad = carta;
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    boolean tengoCartaLibertad(){
        return cartaLibertad != null;
    }
    
    boolean tengoSaldo(int cantidad){
        return saldo > cantidad;
    }
    
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    } 
    
    @Override
    public String toString() {
        return "Jugador{"+ "nombre=" + nombre + ", encarcelado=" + encarcelado + ", saldo=" + saldo + ", capital=" + obtenerCapital() + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + '}';
    }
}















