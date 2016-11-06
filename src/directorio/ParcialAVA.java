/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import abb.ABB;
import abb.NodoBinario;
import comun.Contacto;
import comun.DirectorioContactos;

/**
 *
 * @author Steven Ciro Pineda
 */
public class ParcialAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DirectorioContactos directorio = new DirectorioContactos();
        directorio.add(new Contacto("Matias", "77", "88", "99"));
        directorio.add(new Contacto("Juan", "11", "22", "DHFGJ@fg.hj?"));
        directorio.add(new Contacto("Ricardo", "44", "55", "66"));
        directorio.add(new Contacto("Carlos", "77", "88", "99"));
        directorio.add(new Contacto("Luis", "77", "88", "99"));
        directorio.add(new Contacto("Sebastian", "77", "88", "99"));
        directorio.add(new Contacto("Pedro", "77", "88@", "99"));
        //directorio.add(new Contacto("Andres", "11", "22", "33@gmail.com"));
        
        Contacto buscar = directorio.BuscarContactoNombre("88@");
        Contacto buscarContacto = directorio.BuscarContactoCorreo("33@gail.com");
        Contacto buscarLike = directorio.BuscarPorCadena("dro");
        //directorio.print();
        
        //Nodos Por Nivel
        int[] nodosPorNivel = directorio.cantidadNodosPorNivel();
        
        for (int i = 0; i < nodosPorNivel.length; i++) {
            System.out.println("Nivel " + i + "  Cantidad = " + nodosPorNivel[i]);
        }
        //  System.out.println(buscar);
        //System.out.println(directorio.CompleteABB());
        //Mostrar Contactos en Orden Alfabetico
        //System.out.println(directorio.ContactosOrdenAlfabetico());
        
        //Busqueda Like
        System.out.println(buscarLike);

        //Correos Invalidos
        //System.out.println(directorio.ObtenerCorreosInvalidos());
    }

}