/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author alejandro
 */
public class Sorpresa {
    String texto;
    int valor;
    TipoSorpresa tipo;

    public Sorpresa(String texto, int valor, TipoSorpresa tipo) {
        this.texto = texto;
        this.tipo = tipo;
        this.valor = valor;
    }

    protected String getTexto() {
        return texto;
    }

    protected TipoSorpresa getTipo() {
        return tipo;
    }

    protected int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return ("Sorpresa{" + "texto=" + texto + ", tipo=" + tipo + ", valor=" + valor + '}');
    }
    
    
}
