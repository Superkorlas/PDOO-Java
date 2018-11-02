/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    private Tablero tablero;
    
    public static final int MAX_JUGADORES = 4;
    static final int NUM_SORPRESAS = 10;
    public static final int NUM_CASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;
        
    EstadoJuego estadoJuego;
    Sorpresa cartaActual;
    ArrayList<Jugador> jugadores;
    Jugador jugadorActual;
    Dado dado;
    Random r;
    
    private Qytetet(){
        cartaActual = null;
        dado = null;
        jugadorActual = null;
        jugadores = new ArrayList<>();
        r = new Random();
    }

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    void actuarSiEnCasillaEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void actuarSiEnCasillaNoEdificable() {
        setEstadoJuego(EstadoJuego.JA_PUEDESGESTIONAR);
        Casilla casillaActual = jugadorActual.getCasillaActual();
        
        if(casillaActual.getTipo() == TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }
        else if(casillaActual.getTipo() == TipoCasilla.JUEZ){
            encarcelarJugador();
        }
        else if(casillaActual.getTipo() == TipoCasilla.SORPRESA){
            mazo.remove(cartaActual);
            setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
        }
    }
    
    public void aplicarSorpresa() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad() {
        boolean comprado = jugadorActual.comprarTituloPropiedad();
        if(comprado == true){
            setEstadoJuego(EstadoJuego.JA_PUEDESGESTIONAR);
        }
        return comprado;
    }
    
    public boolean edificarCasa(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador() {
        if(!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            
            jugadorActual.irACarcel(casillaCarcel);
            
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }
        else{
            Sorpresa carta = jugadorActual.devolverCartaLibertad();
            
            mazo.add(carta);
            
            setEstadoJuego(EstadoJuego.JA_PUEDESGESTIONAR);
        }
    }
    
    public Sorpresa getCartaActual() {
        return cartaActual;
    }
    
    Dado getDado() {
        return dado;
    }
    
    Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    ArrayList<Sorpresa> getMazo(){
        return mazo;
    }
    
    public int getValorDado() {
        return dado.getValor();
    }
    
    public void hipotecarPropiedad(int numeroCasilla) {
        Casilla casilla;
        casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        jugadorActual.hipotecarPropiedad(casilla.getTitulo());
        setEstadoJuego(EstadoJuego.JA_PUEDESGESTIONAR);
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();        
    }   
    
    private void inicializarJugadores(ArrayList<String> nombres) {
        for (String nombre : nombres) {
            Jugador j= new Jugador(nombre);
            jugadores.add(j);
        }
    }
    
    private void inicializarTablero(){
        this.tablero=new Tablero();
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void jugar() {
        tirarDado();
        Casilla destino = tablero.ObtenerCasillaFinal(jugadorActual.casillaActual,getValorDado());
        mover(destino.getNumeroCasilla());
    }
    
    void mover(int numCasillaDestino) {
        Casilla casillaInicial = jugadorActual.getCasillaActual();
        Casilla casillaFinal = tablero.ObtenerCasillaNumero(numCasillaDestino);
        
        jugadorActual.setCasillaActual(casillaFinal);
        
        if(numCasillaDestino < casillaInicial.getNumeroCasilla()){
            jugadorActual.modificarSaldo(SALDO_SALIDA);
        }
        
        if(casillaFinal.soyEdificable()){
            actuarSiEnCasillaEdificable();
        }
        else{
            actuarSiEnCasillaNoEdificable();
        }
    }
    
    public Casilla obtenerCasillaJugadorActual() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void obtenerRanking() {
        Collections.sort(jugadores);
    }
    
    public int obtenerSaldoJugadorActual() {
        return jugadorActual.saldo;
    }
    
    private void salidaJugadores() {
        for(Jugador j: jugadores){
            j.casillaActual = tablero.ObtenerCasillaNumero(0);
        }
        jugadorActual = jugadores.get(r.nextInt(jugadores.size()));
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador() {
        jugadorActual = jugadores.get((jugadores.indexOf(jugadorActual) + 1)%MAX_JUGADORES);
        
        if(jugadorActual.getEncarcelado()){
            estadoJuego = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        }
        else{
            estadoJuego = EstadoJuego.JA_PREPARADO;
        }
    }
    
    int tirarDado() {
        return dado.tirar();
    }
    
    //! Era boolean pero no se que es lo que deberia de devolver
    public void venderPropiedad(int numeroCasilla) {
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        jugadorActual.venderPropiedad(casilla);
        setEstadoJuego(EstadoJuego.JA_PUEDESGESTIONAR);
    }

    //Aniadidos algunos \n
    @Override
    public String toString() {
        return "\nQytetet{\n\testadoJuego="+ estadoJuego + "\n\tmazo=" + mazo + "\n\ttablero=" + tablero + "\n\tcartaActual=" + cartaActual + "\n\tjugadores=" + jugadores + "\n\tjugadorActual=" + jugadorActual + "\n\tdado=" + dado + '}';
    }
    
    // No salen en el guión exactamente así ----------------------------------------------
    public Tablero getTablero() {
        return tablero;
    }
    
    /*  Cambiado el nombre, el guion de la p1 no se corresponde con el de la p2 en algunas cosas: 
     *      InicializarCartas -> inicializarCartasSorpresa
     */
    protected void inicializarCartasSorpresa() {
        mazo.add(new Sorpresa("De vuelta al pricipio, vuelves a la casilla de salida", 0, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Que suerte, te vas a la carcel", tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Poca broma, te vas a la ultima casilla del juego", 0, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Felicidades maquina, recibes dinero de todos por tu cumple", 50, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Vaya, te toca pagar a todos por moroso", 100, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Al margen de la ley", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Todos te pagan", 100, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Debes pagar tus deudas con el resto", 50, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("¡Tus casas y hoteles generan beneficios!", 100, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Te toca pagar impuesto por tus casas y hoteles", 200, TipoSorpresa.PORCASAHOTEL));
    }
}
