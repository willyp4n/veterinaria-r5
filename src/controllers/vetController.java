/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author WILLY
 */
import dao.vetDaoInterface;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.vetModel;

public class vetController {
    private vetDaoInterface vetDao;

    public vetController(vetDaoInterface vetDao) {
        this.vetDao = vetDao;
    }

    public DefaultTableModel consultarPropietarios() {
        String[] titulos = {"Id", "Usuario", "Apellido", "Nombre", "Telefono"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        List<vetModel> propietarios = vetDao.obtenerPropietario();
        for (vetModel propietario : propietarios) {
            String[] registro = new String[5];
            registro[0] = propietario.getPropId() + "";
            registro[1] = propietario.getPropUsuario();
            registro[2] = propietario.getPropApellido() + "";
            registro[3] = propietario.getPropNombre()+ "";
            registro[4] = propietario.getPropTelefono()+ "";
            model.addRow(registro);
        }
        return model;
    }

    public void actualizarLibro(vetModel l) {
        vetDao.actualizarPropietario(l);
    }

    public void agregarLibro(vetModel l) {
        vetDao.agregarPropietario(l);
    }
    
    public void eliminarPropietario(int id){
        vetDao.eliminarPropietario(id);
    }
}
    

