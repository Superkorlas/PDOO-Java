/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistatextualqytetet;
import modeloqytetet.*;
import controladorqytetet.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class VistaTextualQytetet {
    
    private static ControladorQytetet controlador = ControladorQytetet.getInstance();
    
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
        System.out.println("COMENCEMOS!!");
        do {
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla) {
                casillaElegida = ui.elegirCasilla(operacionElegida);
            }
            if (!necesitaElegirCasilla || casillaElegida >= 0) {
                System.out.println(controlador.realizarOperacion(operacionElegida, casillaElegida));
            }
        } while (true);
    }
    
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
        ArrayList<Integer> casillasValidas = controlador.obtenerCasillasValidas(opcionMenu);
        ArrayList<String> casillasValidasString = new ArrayList();
        for (Integer operacion : casillasValidas) {
            casillasValidasString.add(operacion.toString());
        }
        Collections.sort(casillasValidas);
        mostrarCasillasValidas(casillasValidas);
        String operacion = this.leerValorCorrecto(casillasValidasString);
        return Integer.parseInt(operacion);
    }
    
    public int elegirOperacion() {
        ArrayList<Integer> operacionesValidas = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> operacionesValidasString = new ArrayList();
        for (Integer operacion : operacionesValidas) {
            operacionesValidasString.add(operacion.toString());
        }
        Collections.sort(operacionesValidas);
        mostrarOperacionesValidas(operacionesValidas);
        String operacion = this.leerValorCorrecto(operacionesValidasString);
        return Integer.parseInt(operacion);
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos) {
        Scanner in = new Scanner(System.in);
        String valor = new String();
        do{
            valor=in.next();
        }while(!((valoresCorrectos.contains(valor)) || valoresCorrectos.isEmpty()));
        return valor;
    }
    
    public void mostrarOperacionesValidas(ArrayList<Integer> operacionesValidas) {
        System.out.println("Operaciones que puedes realizar:");
        for (int operacion  : operacionesValidas) {
            System.out.println("(" + operacion + ") " + OpcionMenu.values()[operacion]);
        }
    }
    
    public void mostrarCasillasValidas(ArrayList<Integer> casillasValidas) {
        System.out.println("Casillas donde puedes realizar la operación:");
        System.out.println(casillasValidas);
    }
}
