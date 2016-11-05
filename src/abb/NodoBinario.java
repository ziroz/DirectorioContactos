/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author Oscar Arenas
 * @param <E>
 */
public class NodoBinario<E> {

    private NodoBinario<E> hijoIzquierdo;
    private E item;
    private NodoBinario<E> hijoDerecho;

    public NodoBinario(E item) {
        this.item = item;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public NodoBinario(NodoBinario<E> hijoIzquierdo, E item, NodoBinario<E> hijoDerecho) {
        this.hijoIzquierdo = hijoIzquierdo;
        this.item = item;
        this.hijoDerecho = hijoDerecho;
    }

    public NodoBinario<E> getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    
    public void setHijoIzquierdo(NodoBinario<E> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public NodoBinario<E> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<E> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijos(NodoBinario<E> hijoIzquierdo, NodoBinario<E> hijoDerecho) {
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }
    
    public String toStringPostOrder() {
        String cadena = "";

        if (hijoIzquierdo != null) {
            cadena += " " + hijoIzquierdo.toStringPostOrder();
        }
        if (hijoDerecho != null) {
            cadena += " " + hijoDerecho.toStringPostOrder();
        }
        cadena += " " + item;
        

        return cadena;
    }
    
    public String toStringInOrder() {
        String cadena = "";

        if (hijoIzquierdo != null) {
            cadena += " " + hijoIzquierdo.toStringPostOrder();
        }
        cadena += " " + item;
        if (hijoDerecho != null) {
            cadena += " " + hijoDerecho.toStringPostOrder();
        }
        

        return cadena;
    }
}
