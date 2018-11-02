/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author robin
 */
public class TituloPropiedad {
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private boolean hipotecada;
    private String nombre;
    private int numCasas;
    private int numHoteles;
    private int precioCompra;
    private int precioEdificar;
    private Jugador propietario;

    TituloPropiedad(String nombre, int precioCompra, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
        
        this.hipotecada=false;
        this.numCasas=0;
        this.numHoteles=0;
        
        this.propietario = null;
    }

    int calcularCosteCancelar() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularCosteHipotecar() {
        return(int) (hipotecaBase + (numCasas * 0.5 * hipotecaBase) + (numHoteles * hipotecaBase)); 
    }
    
    int calcularImporteAlquiler() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularPrecioVenta(){
        return (int) (precioCompra + ((numCasas + numHoteles)*precioEdificar*factorRevalorizacion));
    }
    
    void cancelarHipoteca(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarHotel(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int getAlquilerBase() {
        return alquilerBase;
    }

    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    int getHipotecaBase() {
        return hipotecaBase;
    }

    boolean getHipotecada() {
        return hipotecada;
    }

    String getNombre() {
        return nombre;
    }

    int getNumCasas() {
        return numCasas;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    int getPrecioCompra() {
        return precioCompra;
    }

    int getPrecioEdificar() {
        return precioEdificar;
    }
    
    Jugador getPropietario(){
        return propietario;
    }

    
    int hipotecar(){
        setHipotecada(true);
        int costeHipoteca=calcularCosteHipotecar();
        return costeHipoteca;
    }
    
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        return propietario.encarcelado;
    }
    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario;
    }

    
    boolean tengoPropietario(){
        return propietario != null;
    }
    
    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + '}';
    }
    
    
   
    
    
}
