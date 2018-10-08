/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class Qytetet {
    private static final Qytetet instance = new Qytetet();
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    private Tablero tablero;
    public static int MAX_JUGADORES;
    static int NUM_SORPRESAS;
    public static int NUM_CASILLAS;
    static int PRECIO_LIBERTAD;
    static int SALDO_SALIDA;
    Sorpresa cartaActual;
    ArrayList<Jugador> jugadores;
    Jugador jugadorActual;
    Dado dado;
    
    private Qytetet(){
        MAX_JUGADORES = 4;
        NUM_SORPRESAS = 10;
        NUM_CASILLAS = 20;
        PRECIO_LIBERTAD = 200;
        SALDO_SALIDA = 1000;
        cartaActual = null;
        dado = null;
        jugadorActual = null;
        jugadores = new ArrayList<>();
    }
    
    public static Qytetet getInstance(){
        return instance;
    }
    
    void actuarSiEnCasillaEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void actuarSiEnCasillaNoEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void aplicarSorpresa() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador() {
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void hipotecarPropiedad(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void mover(int numCasillaDestino) {
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int obtenerSaldoJugadorActual() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void salidaJugadores() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int tirarDado() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean venderPropiedad(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    //Aniadidos algunos \n
    @Override
    public String toString() {
        return "\nQytetet{\n" + "\tmazo=" + mazo + "\n\ttablero=" + tablero + "\n\tcartaActual=" + cartaActual + "\n\tjugadores=" + jugadores + "\n\tjugadorActual=" + jugadorActual + "\n\tdado=" + dado + '}';
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
