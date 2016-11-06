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

    public NodoBinario<E> padre(E item) {
        NodoBinario<E> auxiliar = raiz;
        NodoBinario<E> padre = null;

        while (auxiliar != null) {
            int comparar = item.compareTo(auxiliar.getItem());
            if (comparar == 0) {
                if (padre != null) {
                    return padre;
                } else {
                    return null;
                }
            } else if (comparar > 0) {
                padre = auxiliar;
                auxiliar = auxiliar.getHijoDerecho();
            } else {
                padre = auxiliar;
                auxiliar = auxiliar.getHijoIzquierdo();
            }
        }

        return null;
    }
    
    public boolean deleteNodo(NodoBinario<E> nodo) {

        /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = nodo.getHijoDerecho()!= null;
        boolean tieneNodoIzquierda = nodo.getHijoIzquierdo()!= null;
        
        NodoBinario<E> nodoPadre = padre(nodo.getItem());
        
        /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */

        /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            if(nodoPadre.getHijoDerecho() == nodo) {
                nodoPadre.setHijoDerecho(null);
                return true;
            }
            
            if(nodoPadre.getHijoIzquierdo()== nodo) {
                nodoPadre.setHijoIzquierdo(null);
                return true;
            }
        }

        /* Caso 2: Tiene un hijo y el otro no */
        // falta por implementar

        /* Caso 3: Tiene ambos hijos */
        // falta por implementar

        return false;
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
    
    public int[] cantidadNodosPorNivel() {
        int[] niveles = new int[AlturaArbol()];
        cantidadNodosPorNivel(raiz, 0, niveles);
        return niveles;
    }

    public void cantidadNodosPorNivel(NodoBinario<E> pivote, int nivelActual, int[] niveles) {
        if (pivote != null) {
            niveles[nivelActual]++;
            cantidadNodosPorNivel(pivote.getHijoDerecho(), nivelActual + 1, niveles);
            cantidadNodosPorNivel(pivote.getHijoIzquierdo(), nivelActual + 1, niveles);
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
