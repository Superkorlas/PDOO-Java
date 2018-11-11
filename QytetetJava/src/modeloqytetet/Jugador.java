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
      int coste = titulo.calcularCosteCancelar();
      boolean hipotecada = false;
      if(coste < saldo){
        modificarSaldo(-coste);
        hipotecada = titulo.cancelarHipoteca();
      }
      return hipotecada;
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
        boolean esDeMiPropiedad = this.esDeMiPropiedad(casillaActual.getTitulo());
        if (!esDeMiPropiedad) {
            boolean tienePropietario = casillaActual.tengoPropietario();
            if (tienePropietario) {
                boolean pEncarcelado = casillaActual.propietarioEncarcelado();
                if (!pEncarcelado) {
                    boolean estaHipotecada = casillaActual.getTitulo().getHipotecada();
                    return !(estaHipotecada);
                }
            }
        }
        return false;
        //return(!esDeMiPropiedad & tienePropietario & !pEncarcelado & !estaHipotecada);
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa cartaDevuelta = this.cartaLibertad;
        this.cartaLibertad = null;
        
        return cartaDevuelta;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificada = false;
        int numCasas = titulo.getNumCasas();
        if (numCasas < 4) {
            int costeEdificarCasa = titulo.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarCasa);
            if (tengoSaldo) {
                titulo.edificarCasa();
                this.modificarSaldo(-costeEdificarCasa);
                edificada = true;
            }
        }
        return edificada;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificado = false;
        int numCasas = titulo.getNumCasas();
        if (numCasas >= 4) {
            int costeEdificarHotel = titulo.getPrecioEdificar();
            boolean tengoSaldo = this.tengoSaldo(costeEdificarHotel);
            if (tengoSaldo) {
                titulo.edificarHotel();
                this.modificarSaldo(-costeEdificarHotel);
                edificado = true;
            }
        }
        return edificado;
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
        int costeAlquiler = casillaActual.pagarAlquiler();
        this.modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto(){
        saldo -= casillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad){
        boolean tengoSaldo = this.tengoSaldo(cantidad);
        if (tengoSaldo) {
            this.setEncarcelado(false);
            this.modificarSaldo(-cantidad);
        }
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















