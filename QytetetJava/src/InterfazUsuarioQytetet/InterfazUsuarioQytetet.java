/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuarioQytetet;

import modeloqytetet.Qytetet;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class InterfazUsuarioQytetet {
    Qytetet modelo = Qytetet.getInstance();
    
    public ArrayList<String> obtenerNombreJugadores() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int obtenerOpcionMenu(ArrayList<String> operacionesJuegoValidas) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int elegirCasilla(int opcionMenu) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<String> obtenerOperacionesJuegoValidas() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu) {
        throw new UnsupportedOperationException("Sin implementar");
    }
            
    public void realizarOperacion(int opcionElegida, int casillaElegida) {
        throw new UnsupportedOperationException("Sin implementar");
    }
            
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    public int elegirOperacion() {
        throw new UnsupportedOperationException("Sin implementar");
    }
}
