/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuarioQytetet;

import modeloqytetet.Qytetet;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class InterfazUsuarioQytetet {
    Qytetet modelo = Qytetet.getInstance();
    
    public ArrayList<String> obtenerNombreJugadores() {
        ArrayList<String> nombres = new ArrayList<>();
        System.out.print("Introduce el numero de jugadores[2 a 4]:\n==>");
        ArrayList<String> valoresCorrectos = new ArrayList();
        valoresCorrectos.add("2");
        valoresCorrectos.add("3");
        valoresCorrectos.add("4");
        int numJugadores = Integer.parseInt(this.leerValorCorrecto(valoresCorrectos));
        System.out.println("Muy bien, habra " + numJugadores + " jugadores, ahora sus nombres:");
        valoresCorrectos.clear();
        for(int i=1; i<(numJugadores+1); i++){
            System.out.print("Jugador" + i + ": ");
            String s = leerValorCorrecto(valoresCorrectos);
            nombres.add(s);
        }
        return nombres;
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
        Scanner in = new Scanner(System.in);
        String valor = new String();
        do{
            valor=in.next();
        }while(!(valoresCorrectos.contains(valor)) || (valoresCorrectos.isEmpty() && (valor != "")));
        return valor;
    }
    
    public int elegirOperacion() {
        throw new UnsupportedOperationException("Sin implementar");
    }
}
