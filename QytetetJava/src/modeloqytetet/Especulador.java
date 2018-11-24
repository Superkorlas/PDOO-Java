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
public class Especulador extends Jugador{
    
    private int fianza;
    
    protected Especulador(Jugador j, int fianza) {
        super(j);
        this.fianza = fianza;
    }
    
    protected void pagarImpuesto(int cantidad){
        saldo -= casillaActual.getCoste()/2;
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        return this;
    }
    
    @Override
    protected boolean deboIrACarcel(){
       return (super.deboIrACarcel() && pagarFianza());
    }
    
    private boolean pagarFianza(){
        if(saldo >= fianza){
            modificarSaldo(-fianza);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        
        if(titulo.getNumCasas()==8){
            return false;
        }
        else {
            return saldo >= titulo.getPrecioEdificar();
        }
    }
    
    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
            
        if(titulo.getNumHoteles()==8){
            return false;
        }
        else if(titulo.getNumCasas() < 4){
            return false;
        }
        else {
            return saldo >= titulo.getPrecioEdificar();
        }
    }
    
    @Override
    public String toString(){
        return (super.toString() + "Fianza: " + this.fianza);
    }
    
}
