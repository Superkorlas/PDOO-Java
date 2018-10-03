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
public class Jugador {
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
        propiedades = new ArrayList();
        cartaLibertad = null;
        // HAY QUE INICIALIZAR casillaActual!!!!
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cuantasCasasHotelTengo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa getCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla getCasillaActual(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean getEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int obtenerCapital(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
        
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarLibertad(int cantidad){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
  /*
    public void setAttribute(attribute){
        throw new UnsupportedOperationException("Sin implementar");
    }
  */
    
    void setCartaLibertad(Sorpresa carta){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla;
    }
    
    void setEncarcelado(boolean encarcelado /* = false*/){
        this.encarcelado = encarcelado;
    }
    
    void setEncarceladoSinPoderSalir(boolean encarceladoSinPoderSalir /* = true*/){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void setHaTiradoDado(boolean haTiradoDado /* = true*/){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setSaldo(int saldo){
        this.saldo = saldo;
    }
    
    boolean tengoCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean venderPropiedad(Casilla casilla){
        throw new UnsupportedOperationException("Sin implementar");
    } 
    
    @Override
    public String toString() {
        return "Jugador{"+ "nombre=" + nombre + ", encarcelado=" + encarcelado + ", saldo=" + saldo + ", casillaActual=" + casillaActual + ", cartaLibertad=" + cartaLibertad + '}';
    }
}















