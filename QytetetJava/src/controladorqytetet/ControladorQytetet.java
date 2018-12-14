/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorqytetet;

import modeloqytetet.EstadoJuego;
import java.util.ArrayList;
import modeloqytetet.MetodoSalirCarcel;

/**
 *
 * @author super
 */
public class ControladorQytetet {
    
    private static final ControladorQytetet instance = new ControladorQytetet();
    
    private modeloqytetet.Qytetet modelo = modeloqytetet.Qytetet.getInstance();
    private ArrayList<String> nombreJugadores;
    
    private boolean terminarJuego = false;
    
    private ControladorQytetet() {
        
    }
    
    public static ControladorQytetet getInstance() {
        return instance;
    }
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores) {
        this.nombreJugadores = nombreJugadores;
    }
    
    public boolean isTerminarJuego() {
        return terminarJuego;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas() {
        ArrayList<Integer> operacionesValidas = new ArrayList();
        if (modelo.getEstadoJuego() == null) {
            operacionesValidas.add(OpcionMenu.INICIARJUEGO.ordinal());
        } else {
            operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
            operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
            operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
            operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
            switch(modelo.getEstadoJuego()) {
                case JA_CONSORPRESA:
                    operacionesValidas.add(OpcionMenu.APLICARSORPRESA.ordinal());
                    break;
                case ALGUNJUGADORENBANCARROTA:
                    operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                    break;
                case JA_PUEDESCOMPRAROGESTIONAR:
                    operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                    operacionesValidas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                    if (!modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false).isEmpty()) {
                        operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                        operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                        operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                        operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    }
                    if (!modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true).isEmpty()) {
                        operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    }
                    break;
                case JA_PUEDEGESTIONAR:
                    operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                    if (!modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false).isEmpty()) {
                        operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                        operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                        operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                        operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    }
                    if (!modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true).isEmpty()) {
                        operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    }
                    break;
                case JA_PREPARADO:
                    operacionesValidas.add(OpcionMenu.JUGAR.ordinal());
                    break;
                case JA_ENCARCELADO:
                    operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                    break;
                case JA_ENCARCELADOCONOPCIONDELIBERTAD:
                    operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                    operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
                    break; 
            }
        }
        
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
                    terminarJuego = true;
                    resultado = "Juego finalizado.";
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
                case JUGAR:
                    modelo.jugar();
                    resultado = "Turno de: \n" + modelo.getJugadorActual();
                    break;
                case APLICARSORPRESA:
                    resultado = modelo.getCartaActual().toString();
                    modelo.aplicarSorpresa();
                    break;
                case INTENTARSALIRCARCELPAGANDOLIBERTAD:
                    boolean haPodidoSalirCarcelPagando = modelo.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                    if (haPodidoSalirCarcelPagando) {
                        resultado = "Has salido de la carcel.";
                    } else {
                        resultado = "No has conseguido salir de la carcel.";
                    }
                    break;
                case INTENTARSALIRCARCELTIRANDODADO:
                    boolean haPodidoSalirCarcelTirandoDado = modelo.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                    if (haPodidoSalirCarcelTirandoDado) {
                        resultado = "Has salido de la carcel.";
                    } else {
                        resultado = "No has conseguido salir de la carcel.";
                    }
                    break;
                case COMPRARTITULOPROPIEDAD:
                    boolean haPodidoComprarPropiedad = modelo.comprarTituloPropiedad();
                    if (haPodidoComprarPropiedad) {
                        resultado = "Has comprado la propiedad.";
                    } else {
                        resultado = "No puedes comprar la propiedad.";
                    }
                    break;
                case HIPOTECARPROPIEDAD:
                    modelo.hipotecarPropiedad(casillaElegida);
                    break;
                case EDIFICARCASA:
                    boolean haPodidoEdificarCasa = modelo.edificarCasa(casillaElegida);
                    if (haPodidoEdificarCasa) {
                        resultado = "Casa edificada correctamente.";
                    } else {
                        resultado = "No puedes edificar casa.";
                    }
                    break;
                case EDIFICARHOTEL:
                    boolean haPodidoEdificarHotel = modelo.edificarHotel(casillaElegida);
                    if (haPodidoEdificarHotel) {
                        resultado = "Hotel edificado correctamente.";
                    } else {
                        resultado = "No puedes edificar hotel.";
                    }
                    break;
                case VENDERPROPIEDAD:
                    modelo.venderPropiedad(casillaElegida);
                    break;
                case PASARTURNO:
                    modelo.siguienteJugador();
                    break;
                case OBTENERRANKING:
                    terminarJuego = true;
                    resultado = modelo.obtenerRanking().toString();
                    break;
                default:
                    break;
            }
        }
        return resultado;
    }
}
