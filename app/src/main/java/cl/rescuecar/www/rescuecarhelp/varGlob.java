package cl.rescuecar.www.rescuecarhelp;

import android.app.Application;

/**
 * Created by juansebastian on 5/7/17.
 */

public class varGlob extends Application {
    private String rut;
    private String div;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String tipos;


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String servicios) {
        this.tipos = servicios;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
