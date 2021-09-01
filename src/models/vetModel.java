/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author WILLY
 */
public class vetModel {

    private int propId;
    private String propUsuario;
    private String propApellido;
    private String propNombre;
    private String propTelefono;

    public vetModel(int propId, String propUsuario, String propApellido, String propNombre, String propTelefono) {
        this.propId = propId;
        this.propUsuario = propUsuario;
        this.propApellido = propApellido;
        this.propNombre = propNombre;
        this.propTelefono = propTelefono;
    }

    public int getPropId() {
        return propId;
    }

    public String getPropUsuario() {
        return propUsuario;
    }

    public String getPropApellido() {
        return propApellido;
    }

    public String getPropNombre() {
        return propNombre;
    }

    public String getPropTelefono() {
        return propTelefono;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }

    public void setPropUsuario(String propUsuario) {
        this.propUsuario = propUsuario;
    }

    public void setPropApellido(String propApellido) {
        this.propApellido = propApellido;
    }

    public void setPropNombre(String propNombre) {
        this.propNombre = propNombre;
    }

    public void setPropTelefono(String propTelefono) {
        this.propTelefono = propTelefono;
    }
    
}
