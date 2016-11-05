package comun;

/**
 *
 * @author Oscar Arenas
 */
public class Contacto implements Comparable<Contacto> {

    private String nombre;
    private String telefono;
    private String direccionPostal;
    private String correoElectronico;

    public Contacto() {
        nombre = "";
        telefono = "";
        direccionPostal = "";
        correoElectronico = "";
    }

    public Contacto(String nombre_contacto, String telefono_contacto, String direccionPostal_contacto, String correoElectronico_contacto) {
        nombre = nombre_contacto;
        telefono = telefono_contacto;
        direccionPostal = direccionPostal_contacto;
        correoElectronico = correoElectronico_contacto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
    
    @Override
    public int compareTo(Contacto cuenta) {
        return this.nombre.compareToIgnoreCase(cuenta.nombre);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", DireccionPostal: " + direccionPostal + ", Correo Eletrónico: " + correoElectronico;
    }
}
