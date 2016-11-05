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

        if (raiz == null) {
            raiz = new NodoBinario(nodo);
            nodoIngresado = true;
        }

        while (!nodoIngresado) {
            if (nodoActual.getItem().compareTo(nodo) > 0) {
                if (nodoActual.getHijoIzquierdo() == null) {
                    nodoActual.setHijoIzquierdo(new NodoBinario(nodo));
                    nodoIngresado = true;
                } else {
                    nodoActual = nodoActual.getHijoIzquierdo();
                }
            } else {
                if (nodoActual.getHijoDerecho() == null) {
                    nodoActual.setHijoDerecho(new NodoBinario(nodo));
                    nodoIngresado = true;

                } else {
                    nodoActual = nodoActual.getHijoDerecho();
                }
            }
        }
    }

    public boolean deleteSubArbol(E clave) {

        if (raiz == null) {
            raiz = null;
            return true;
        }

        boolean nodoEliminado = false;

        NodoBinario<E> nodoActual = raiz;

        while (!nodoEliminado && nodoActual != null) {
            if (nodoActual.getItem().compareTo(clave) > 0) {
                if (nodoActual.getHijoIzquierdo().getItem().compareTo(clave) == 0) {
                    nodoActual.setHijoIzquierdo(null);
                    nodoEliminado = true;
                } else {
                    nodoActual = nodoActual.getHijoIzquierdo();
                }
            } else if (nodoActual.getItem().compareTo(clave) < 0) {
                if (nodoActual.getHijoDerecho().getItem().compareTo(clave) == 0) {
                    nodoActual.setHijoDerecho(null);
                    nodoEliminado = true;
                } else {
                    nodoActual = nodoActual.getHijoDerecho();
                }
            }
        }

        return nodoEliminado;
    }

    public void print() {
        print(raiz, "");
    }

    private void print(NodoBinario<E> r, String espacio) {
        if (r != null) {
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

    public int numHojas() {
        return numHojas(raiz);
    }

    private int numHojas(NodoBinario<E> nodo) {
        if (nodo != null) {
            if (nodo.esHoja()) {
                return 1;
            } else {
                return numHojas(nodo.getHijoIzquierdo()) + numHojas(nodo.getHijoDerecho());
            }
        } else {
            return 0;
        }
    }

    public int AlturaArbol() {
        return AlturaArbol(raiz, 1);
    }

    public int AlturaArbol(NodoBinario<E> raizArbol, int alto) {

        int altoIzquierdo = alto;
        int altoDerecho = alto;

        if (raizArbol.getHijoIzquierdo() != null) {
            altoIzquierdo = AlturaArbol(raizArbol.getHijoIzquierdo(), alto + 1);
        }

        if (raizArbol.getHijoDerecho() != null) {
            altoDerecho = AlturaArbol(raizArbol.getHijoDerecho(), alto + 1);
        }

        return Math.max(altoDerecho, altoIzquierdo);
    }

    public boolean CompleteABB() {
        int[] niveles  = new int[AlturaArbol()];
        CompleteABB(raiz, 0, niveles);
        
        return niveles[AlturaArbol()-1] == (AlturaArbol()-1)*2;
    }

    private void CompleteABB(NodoBinario<E> nodoRaiz, int nivelActual, int[] niveles) {
        
        if(nodoRaiz == null) return;
        niveles[nivelActual]++;
        
        CompleteABB(nodoRaiz.getHijoDerecho(), nivelActual+1, niveles);
        CompleteABB(nodoRaiz.getHijoIzquierdo(), nivelActual+1, niveles);
    }
    
    String[] niveles;
public void imprimirNivel() {
        niveles = new String[AlturaArbol() + 1];

        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + " En nivel: " + i);
        }
    }

    public void imprimirNivel(NodoBinario<E> pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getItem()+ ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getHijoDerecho(), nivel2 + 1);
            imprimirNivel(pivote.getHijoIzquierdo(), nivel2 + 1);
        }
    }

    
    
    public E elementoMayor() {

        if (raiz.getHijoDerecho() == null) {
            return raiz.getItem();
        }

        E nodoMayor = raiz.getHijoDerecho().getItem();
        NodoBinario<E> nodoActual = raiz;

        while (nodoActual != null) {
            if (nodoActual.getHijoDerecho() != null) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                nodoMayor = nodoActual.getItem();
                nodoActual = null;
            }
        }
        return nodoMayor;
    }
}
