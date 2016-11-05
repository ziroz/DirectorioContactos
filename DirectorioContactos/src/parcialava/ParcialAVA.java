/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialava;

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
        directorio.add(new Contacto("Juan", "11", "22", "33"));
        directorio.add(new Contacto("Ricardo", "44", "55", "66"));
        directorio.add(new Contacto("Carlos", "77", "88", "99"));
        directorio.add(new Contacto("Andres", "11", "22", "33@gmail.com"));
        
        Contacto buscar = directorio.BuscarContactoNombre("Jan");
        Contacto buscarContacto = directorio.BuscarContactoCorreo("33@gail.com");
        //directorio.print();
        
                System.out.println(buscar);

        //Preorder
        //System.out.println(directorio.getRaiz().toStringPostOrder());
    }

}