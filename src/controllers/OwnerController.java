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
import dao.OwnerDaoInterface;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.OwnerModel;

public class OwnerController {
    private OwnerDaoInterface ownerDao;

    public OwnerController(OwnerDaoInterface ownerDao) {
        this.ownerDao = ownerDao;
    }

    public DefaultTableModel readOwners() {
        String[] titulos = {"Id", "Usuario", "Apellido", "Nombre", "Telefono"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        List<OwnerModel> propietarios = ownerDao.getOwners();
        for (OwnerModel propietario : propietarios) {
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

    public void updateOwner(OwnerModel l) {
        ownerDao.deleteOwner(l);
    }

    public void addOwner(OwnerModel l) {
        ownerDao.addOwner(l);
    }
    
    public void deleteOwner(int id){
        ownerDao.eliminarPropietario(id);
    }
}
    

