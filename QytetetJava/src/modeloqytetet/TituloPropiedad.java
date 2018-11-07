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
      int coste_alquiler = (int) (calcularCosteHipotecar() * 1.1);
      return coste_alquiler;
    }
    
    int calcularCosteHipotecar() {
        return(int) (hipotecaBase + (numCasas * 0.5 * hipotecaBase) + (numHoteles * hipotecaBase)); 
    }
    
    int calcularImporteAlquiler() {
        int costeAlquiler = (int) (alquilerBase + (alquilerBase * ((numCasas*0.2) + numHoteles*0.5)));
        return costeAlquiler;
    }
    
    int calcularPrecioVenta(){
        return (int) (precioCompra + ((numCasas + numHoteles)*precioEdificar*factorRevalorizacion));
    }
    
    boolean cancelarHipoteca(){
        hipotecada = false;
        return true;
    }
    
    void cobrarAlquiler(int coste){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void edificarCasa(){
        numCasas++;
    }
    
    void edificarHotel(){
        numHoteles++;
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
        int costeAlquiler = this.calcularImporteAlquiler();
        propietario.modificarSaldo(costeAlquiler);
        return costeAlquiler;
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
