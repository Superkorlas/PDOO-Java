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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularImporteAlquiler() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int calcularPrecioVenta(){
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }

    
    int hipotecar(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int pagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean propietarioEncarcelado(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    void setPropietario(Jugador propietario){
        throw new UnsupportedOperationException("Sin implementar");
    }

    
    boolean tengoPropietario(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre + ", hipotecada=" + hipotecada + ", precioCompra=" + precioCompra + ", alquilerBase=" + alquilerBase + ", factorRevalorizacion=" + factorRevalorizacion + ", hipotecaBase=" + hipotecaBase + ", precioEdificar=" + precioEdificar + ", numHoteles=" + numHoteles + ", numCasas=" + numCasas + '}';
    }
    
    
   
    
    
}
