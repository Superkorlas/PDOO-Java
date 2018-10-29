/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.Random;

/**
 *
 * @author super
 */
public class Dado {
    private static final Dado instance = new Dado();
    private int valor;
    private Random r;
    
    private Dado(){
        r = new Random();
    }
    
    public static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        valor = r.nextInt(6)+1;
        return valor;
    }
    
    public int getValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return "\nDado{" + "valor=" + valor + '}';
    }
    
}
