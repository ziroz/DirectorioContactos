/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

import abb.NodoBinario;

/**
 *
 * @author Ciro
 */
public class DirectorioContactos extends abb.ABB {

    public Contacto BuscarContactoNombre(String nombreContacto) {

        NodoBinario<Contacto> nodoActual = super.getRaiz();
        Contacto nodoEncontrado = null;

        while (nodoActual != null && nodoEncontrado == null) {
            if (nodoActual.getItem().getNombre().compareTo(nombreContacto) == 0) {
                nodoEncontrado = nodoActual.getItem();
            } else if (nodoActual.getItem().getNombre().compareTo(nombreContacto) > 0) {
                if (nodoActual.getHijoIzquierdo() == null) {
                    nodoActual = null;
                } else {
                    nodoActual = nodoActual.getHijoIzquierdo();
                }
            } else {
                if (nodoActual.getHijoDerecho() == null) {
                    nodoActual = null;
                } else {
                    nodoActual = nodoActual.getHijoDerecho();
                }
            }
        }

        return nodoEncontrado;
    }

    public Contacto BuscarContactoCorreo(String correo) {
        return BuscarContactoCorreo(correo, super.getRaiz());
    }

    private Contacto BuscarContactoCorreo(String correo, NodoBinario<Contacto> nodoRaiz) {

        if (nodoRaiz != null) {
            if (nodoRaiz.getItem().getCorreoElectronico().compareTo(correo) == 0) {
                return nodoRaiz.getItem();
            }

            Contacto buscarIzquierda = BuscarContactoCorreo(correo, nodoRaiz.getHijoIzquierdo());
            if (buscarIzquierda != null) {
                return buscarIzquierda;
            }

            Contacto buscarDerecha = BuscarContactoCorreo(correo, nodoRaiz.getHijoDerecho());
            if (buscarDerecha != null) {
                return buscarDerecha;
            }
        }
        return null;
    }

    public Contacto BuscarPorCadena(String cadena) {
        return BuscarPorCadena(cadena, super.getRaiz());
    }

    private Contacto BuscarPorCadena(String cadena, NodoBinario<Contacto> nodoRaiz) {

        if (nodoRaiz != null) {
            if (nodoRaiz.getItem().getNombre().toLowerCase().contains(cadena.toLowerCase())
                || nodoRaiz.getItem().getCorreoElectronico().toLowerCase().contains(cadena.toLowerCase())
                || nodoRaiz.getItem().getDireccionPostal().toLowerCase().contains(cadena.toLowerCase())) {
                return nodoRaiz.getItem();
            }

            Contacto buscarIzquierda = BuscarPorCadena(cadena, nodoRaiz.getHijoIzquierdo());
            if (buscarIzquierda != null) {
                return buscarIzquierda;
            }

            Contacto buscarDerecha = BuscarPorCadena(cadena, nodoRaiz.getHijoDerecho());
            if (buscarDerecha != null) {
                return buscarDerecha;
            }
        }
        return null;
    }
    
    public String ContactosOrdenAlfabetico() {
        return ContactosOrdenAlfabetico(super.getRaiz());
    }

    private String ContactosOrdenAlfabetico(NodoBinario<Contacto> nodoRaiz) {
        if(nodoRaiz == null) return "";
        
        return ContactosOrdenAlfabetico(nodoRaiz.getHijoIzquierdo()) 
                + " " + nodoRaiz.getItem().getNombre() 
                + ", " + ContactosOrdenAlfabetico(nodoRaiz.getHijoDerecho());
    }
    
    public String ObtenerCorreosInvalidos() {
        return ObtenerCorreosInvalidos(super.getRaiz());
    }

    private String ObtenerCorreosInvalidos(NodoBinario<Contacto> nodoRaiz) {
        if(nodoRaiz == null) return "";
        
        return (!nodoRaiz.getItem().getCorreoValido() ? nodoRaiz.getItem().getNombre() + " (" + nodoRaiz.getItem().getCorreoElectronico() + "), " : "")
                + ObtenerCorreosInvalidos(nodoRaiz.getHijoIzquierdo()) 
                + ObtenerCorreosInvalidos(nodoRaiz.getHijoDerecho());
    }
}
