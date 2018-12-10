/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistatextualqytetet;

import controladorqytetet.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class VistaTextualQytetet {
    
    private static ControladorQytetet controlador;
    
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
    
    public int elegirCasilla(int opcionMenu) {
        return 1;
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos) {
        Scanner in = new Scanner(System.in);
        String valor = new String();
        do{
            valor=in.next();
        }while(!(valoresCorrectos.contains(valor)) || (valoresCorrectos.isEmpty() && (!valor.equals(""))));
        return valor;
    }
    
    public int elegirOperacion() {
        ArrayList<Integer> operacionesValidas = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> operacionesValidasString = new ArrayList();
        for (Integer operacion : operacionesValidas) {
            operacionesValidasString.add(operacion.toString());
        }
        String operacion = this.leerValorCorrecto(operacionesValidasString);
        return Integer.parseInt(operacion);
    }
    
    
    public static void main(String[] args)  {
        System.out.println("============================================\n"+
                           "============BIENVENIDO A QYTETET============\n"+
                           "============================================\n"+
                           "=========Alejandro de la Plata Ramos========\n"+
                           "===========Robin Costas del Moral===========\n"+
                           "============================================\n");
        
        VistaTextualQytetet ui = new VistaTextualQytetet();
        controlador.setNombreJugadores(ui.obtenerNombreJugadores());
        int operacionElegida, casillaElegida = 0;
        boolean necesitaElegirCasilla;
        do {
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla) {
                casillaElegida = ui.elegirCasilla(operacionElegida);
            }
            if (!necesitaElegirCasilla || casillaElegida >= 0) {
                System.out.println(controlador.realizarOperacion(operacionElegida, casillaElegida));
            }
        } while (1 == 1);
    }
}
