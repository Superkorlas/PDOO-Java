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
        boolean comprado = false;
        int costeCompra = casillaActual.getCoste();
        
        if(costeCompra<saldo){
            comprado = true;
            
            TituloPropiedad titulo = casillaActual.AsignarPropietario(this);
            
            propiedades.add(titulo);
            
            modificarSaldo(-costeCompra);
        }
        
        return comprado;
    }
    
    int cuantasCasasHotelTengo(){
        int numCasHot = 0;
        for(TituloPropiedad pr: propiedades){
            numCasHot += pr.getNumCasas() + pr.getNumHoteles();
        }
        
        return numCasHot;
    }
    
    boolean deboPagarAlquiler(){
        boolean esDeMiPropiedad     = this.esDeMiPropiedad(casillaActual.getTitulo());
        boolean tienePropietario    = casillaActual.tengoPropietario();
        boolean pEncarcelado        = casillaActual.propietarioEncarcelado();
        boolean estaHipotecada      = casillaActual.getTitulo().getHipotecada();

        return(!esDeMiPropiedad & tienePropietario & !pEncarcelado & !estaHipotecada);
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
        propiedades.remove(titulo);
        titulo.setPropietario(null);
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
    
    //! Era boolean pero que es lo que devolveriamos?
    void hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca=titulo.hipotecar();
        modificarSaldo(costeHipoteca);
    }
    
    void irACarcel(Casilla casilla){
        setCasillaActual(casilla);
        setEncarcelado(true);
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
    
    //! Era boolean, pero que devuelve?
    void venderPropiedad(Casilla casilla){
        TituloPropiedad titulo = casilla.getTitulo();
        eliminarDeMisPropiedades(titulo);
        int precioVenta = titulo.calcularPrecioVenta();
        modificarSaldo(precioVenta);
    } 
    
    @Override
    public String toString() {
        return "Jugador{"+ "nombre=" + nombre + ", encarcelado=" + encarcelado + ", saldo=" + saldo + ", capital=" + obtenerCapital() + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + '}';
    }
}















