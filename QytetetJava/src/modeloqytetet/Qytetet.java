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
        dado = Dado.getInstance();
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
        boolean deboPagarAlquiler = jugadorActual.deboPagarAlquiler();
        if (deboPagarAlquiler) {
            jugadorActual.pagarAlquiler();
            if (jugadorActual.getSaldo() < 0) {
                estadoJuego = EstadoJuego.ALGUNJUGADORENBANCARROTA;
            }
        }
        Casilla casilla = this.obtenerCasillaJugadorActual();
        boolean tengoPropietario = casilla.tengoPropietario();
        if (estadoJuego != EstadoJuego.ALGUNJUGADORENBANCARROTA) {
            if (tengoPropietario) {
                estadoJuego = EstadoJuego.JA_PUEDEGESTIONAR;
            } else {
                estadoJuego = EstadoJuego.JA_PUEDESCOMPRAROGESTIONAR;
            }
        }
    }
    
    void actuarSiEnCasillaNoEdificable() {
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        Casilla casillaActual = jugadorActual.getCasillaActual();
        
        if(casillaActual.getTipo() == TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }
        else if(casillaActual.getTipo() == TipoCasilla.JUEZ){
            encarcelarJugador();
        }
        else if(casillaActual.getTipo() == TipoCasilla.SORPRESA){
            cartaActual = mazo.get(0);
            mazo.remove(cartaActual);
            setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
        }
    }
    
    public void aplicarSorpresa() {
        estadoJuego = EstadoJuego.JA_PUEDEGESTIONAR;
        if (cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL) {
            jugadorActual.setCartaLibertad(cartaActual);
        } else {
            mazo.add(cartaActual);
            if (cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR) {
                jugadorActual.modificarSaldo(cartaActual.getValor());
                if (jugadorActual.getSaldo() < 0) {
                    estadoJuego = EstadoJuego.ALGUNJUGADORENBANCARROTA;
                }
            } else if (cartaActual.getTipo() == TipoSorpresa.IRACASILLA) {
                int valor = cartaActual.getValor();
                boolean casillaCarcel = tablero.esCasillaCarcel(valor);
                if (casillaCarcel) {
                    this.encarcelarJugador();
                } else {
                    this.mover(valor);
                }
            } else if (cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL) {
                int cantidad = cartaActual.getValor();
                int numeroTotal = jugadorActual.cuantasCasasHotelTengo();
                jugadorActual.modificarSaldo(cantidad * numeroTotal);
                if (jugadorActual.getSaldo() < 0) {
                    estadoJuego = EstadoJuego.ALGUNJUGADORENBANCARROTA;
                }
            } else if (cartaActual.getTipo() == TipoSorpresa.PORJUGADOR) {
                for (Jugador jugador : jugadores) {
                    if (jugador != jugadorActual) {
                        jugador.modificarSaldo(cartaActual.getValor());
                        if (jugador.getSaldo() < 0) {
                        estadoJuego = EstadoJuego.ALGUNJUGADORENBANCARROTA;
                        }
                        jugadorActual.modificarSaldo(-cartaActual.getValor());
                        if (jugadorActual.getSaldo() < 0) {
                            estadoJuego = EstadoJuego.ALGUNJUGADORENBANCARROTA;
                        }
                    }
                }
            }
        }
    }
    
    public boolean cancelarHipoteca(int numeroCasilla) {
      Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
      boolean resultado = jugadorActual.cancelarHipoteca(casilla.getTitulo());
      setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
      return resultado;
    }
    
    public boolean comprarTituloPropiedad() {
        boolean comprado = jugadorActual.comprarTituloPropiedad();
        if(comprado == true){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        return comprado;
    }
    
    public boolean edificarCasa(int numeroCasilla) {
        boolean edificada = false;
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        edificada = jugadorActual.edificarCasa(titulo);
        if (edificada) {
            estadoJuego = EstadoJuego.JA_PUEDEGESTIONAR;
        }
        return edificada;
    }
    
    public boolean edificarHotel(int numeroCasilla) {
        boolean edificado = false;
        Casilla casilla = tablero.ObtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        edificado = jugadorActual.edificarHotel(titulo);
        if (edificado) {
            estadoJuego = EstadoJuego.JA_PUEDEGESTIONAR;
        }
        return edificado;
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
            
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
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
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
        this.salidaJugadores(); // No es seguro que vaya aquí
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
        if (metodo == MetodoSalirCarcel.TIRANDODADO) {
            int resultado = this.tirarDado();
            if (resultado > 5) {
                jugadorActual.setEncarcelado(false);
            }
        } else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD) {
            jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
        }
        boolean libre = jugadorActual.getEncarcelado();
        return libre;
    }
    
    public void jugar() {
        tirarDado();
        Casilla destino = tablero.ObtenerCasillaFinal(jugadorActual.casillaActual,getValorDado());
        mover(destino.getNumeroCasilla());
    }
    
    public void mover(int numCasillaDestino) {
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
        return jugadorActual.getCasillaActual();
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero() {
        return tablero.getCasillas();
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador() {
        ArrayList<TituloPropiedad> propiedades = jugadorActual.getPropiedades();
        ArrayList<Integer> resultado = new ArrayList();
        for (TituloPropiedad propiedad : propiedades) {
            for (Casilla casilla : tablero.getCasillas()) {
                if (casilla.getTitulo() == propiedad) {
                    resultado.add(casilla.getNumeroCasilla());
                }
            }
        }
        return resultado;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca) {
        ArrayList<TituloPropiedad> propiedades = jugadorActual.obtenerPropiedades(estadoHipoteca);
        ArrayList<Integer> resultado = new ArrayList();
        for (TituloPropiedad propiedad : propiedades) {
            for (Casilla casilla : tablero.getCasillas()) {
                if (casilla.getTitulo() == propiedad) {
                    resultado.add(casilla.getNumeroCasilla());
                }
            }
        }
        return resultado;
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
        estadoJuego = EstadoJuego.JA_PREPARADO;
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador() {
        jugadorActual = jugadores.get((jugadores.indexOf(jugadorActual) + 1) % jugadores.size());
        
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
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
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
        mazo.add(new Sorpresa("Poca broma, te vas a la ultima casilla del juego", tablero.getCasillas().size()-1, TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Felicidades maquina, recibes dinero por tu cumple", 50, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Vaya, te toca pagar a todos por moroso", 100, TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Al margen de la ley", 0, TipoSorpresa.SALIRCARCEL));
        mazo.add(new Sorpresa("Todos te pagan", 100, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Debes pagar tus deudas con el resto", 50, TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("¡Tus casas y hoteles generan beneficios!", 100, TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Te toca pagar impuesto por tus casas y hoteles", 200, TipoSorpresa.PORCASAHOTEL));
        Collections.shuffle(mazo);
    }
}
