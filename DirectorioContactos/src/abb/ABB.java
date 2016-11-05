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
public class ABB<E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public ABB() {
        raiz = null;
    }

    public NodoBinario<E> getRaiz() {
        return raiz;
    }
    
    public void add(E nodo) {
        
        NodoBinario<E> nodoActual = raiz;
        boolean nodoIngresado = false;

        if(raiz == null)
        {
            raiz = new NodoBinario(nodo);
            nodoIngresado = true;
        }
        
        while(!nodoIngresado)
        {
            if(nodoActual.getItem().compareTo(nodo) > 0)
            {
                if(nodoActual.getHijoIzquierdo() == null){
                    nodoActual.setHijoIzquierdo(new NodoBinario(nodo));
                    nodoIngresado = true;
                }else{
                    nodoActual = nodoActual.getHijoIzquierdo();
                }
            }else
            {
                if(nodoActual.getHijoDerecho()== null){
                    nodoActual.setHijoDerecho(new NodoBinario(nodo));
                    nodoIngresado = true;

                }else{
                    nodoActual = nodoActual.getHijoDerecho();
                }
            }
        }
    }
    
    public boolean deleteSubArbol(E clave){

        if(raiz == null)
        {
            raiz = null;
            return true;
        }
        
        boolean nodoEliminado = false;

        NodoBinario<E> nodoActual = raiz;

        while(!nodoEliminado && nodoActual != null)
        {
            if(nodoActual.getItem().compareTo(clave) > 0)
            {
                if(nodoActual.getHijoIzquierdo().getItem().compareTo(clave) == 0){
                    nodoActual.setHijoIzquierdo(null);
                    nodoEliminado = true;
                }else{
                    nodoActual = nodoActual.getHijoIzquierdo();
                }
            }else
                if(nodoActual.getItem().compareTo(clave) < 0)
                {
                    if(nodoActual.getHijoDerecho().getItem().compareTo(clave) == 0){
                        nodoActual.setHijoDerecho(null);
                        nodoEliminado = true;
                    }else{
                        nodoActual = nodoActual.getHijoDerecho();
                    }
                }
        }
        
        return nodoEliminado;
    }
    
    public void print(){
        print(raiz, "");
    }

    private void print(NodoBinario<E> r, String espacio){
        if(r!=null){
            print(r.getHijoDerecho(), espacio + "    ");
            System.out.println(espacio + r.getItem());
            print(r.getHijoIzquierdo(), espacio + "    ");
        }
    }
    
    public int size() {
        return size(raiz);
    }

    private int size(NodoBinario<E> r) {
        if (r != null) {
            return 1 + size(r.getHijoIzquierdo()) + size(r.getHijoDerecho());
        } else {
            return 0;
        }
    }
    
    public E elementoMayor(){
        
        if(raiz.getHijoDerecho() == null){
            return raiz.getItem();
        }
        
        E nodoMayor = raiz.getHijoDerecho().getItem();
        NodoBinario<E> nodoActual = raiz;
        
        while(nodoActual != null)
        {
            if(nodoActual.getHijoDerecho() != null)
            {
                nodoActual = nodoActual.getHijoDerecho();
            }else{
                nodoMayor = nodoActual.getItem();
                nodoActual = null;
            }
        }
        return nodoMayor;
    }
}
