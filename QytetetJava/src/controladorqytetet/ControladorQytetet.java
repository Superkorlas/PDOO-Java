/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorqytetet;

import modeloqytetet.EstadoJuego;
import modeloqytetet.MetodoSalirCarcel;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class ControladorQytetet {
    
    private static final ControladorQytetet instance = new ControladorQytetet();
    
    private modeloqytetet.Qytetet modelo = modeloqytetet.Qytetet.getInstance();
    private ArrayList<String> nombreJugadores;
    
    private ControladorQytetet() {
        
    }
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores) {
        this.nombreJugadores = nombreJugadores;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas() {
        ArrayList<Integer> operacionesValidas = new ArrayList();
        return operacionesValidas;
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu) {
        boolean necesitaElegir = false;
        OpcionMenu valorOpcionElegida = OpcionMenu.values()[opcionMenu];
        if (null != valorOpcionElegida) { 
            switch (valorOpcionElegida) {
                case HIPOTECARPROPIEDAD:
                    necesitaElegir = true;
                    break;
                case CANCELARHIPOTECA:
                    necesitaElegir = true;
                    break;
                case EDIFICARCASA:
                    necesitaElegir = true;
                    break;
                case EDIFICARHOTEL:
                    necesitaElegir = true;
                    break;
                case VENDERPROPIEDAD:
                    necesitaElegir = true;
                    break;
            }
        }
        return necesitaElegir;
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu) {
        ArrayList<Integer> casillasValidas = new ArrayList();
        OpcionMenu valorOpcionElegida = OpcionMenu.values()[opcionMenu];
        if (null != valorOpcionElegida) { 
            switch (valorOpcionElegida) {
                case HIPOTECARPROPIEDAD:
                    casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false);
                    break;
                case CANCELARHIPOTECA:
                    casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true);
                    break;
                case EDIFICARCASA:
                    casillasValidas = modelo.obtenerPropiedadesJugador();
                    break;
                case EDIFICARHOTEL:
                    casillasValidas = modelo.obtenerPropiedadesJugador();
                    break;
                case VENDERPROPIEDAD:
                    casillasValidas = modelo.obtenerPropiedadesJugador();
                    break;
            }
        }
        return casillasValidas;
    }
    
    public String realizarOperacion(int opcionElegida, int casillaElegida) {
        String resultado = null;
        OpcionMenu valorOpcionElegida = OpcionMenu.values()[opcionElegida];
        if (null != valorOpcionElegida) { 
            switch (valorOpcionElegida) {
                case INICIARJUEGO:
                    modelo.inicializarJuego(nombreJugadores);
                    break;
                case TERMINARJUEGO:
                    break;
                case MOSTRARJUGADORACTUAL:
                    resultado = modelo.getJugadorActual().toString();
                    break;
                case MOSTRARJUGADORES:
                    resultado = modelo.getJugadores().toString();
                    break;
                case MOSTRARTABLERO:
                    resultado = modelo.getTablero().toString();
                    break;
                case CANCELARHIPOTECA:
                    modelo.cancelarHipoteca(casillaElegida);
                    break;
                default:
                    break;
            }
        }
        return resultado;
    }
}
