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
        String[] titles = {"Id", "Usuario", "Apellido", "Nombre", "Telefono"};
        DefaultTableModel table = new DefaultTableModel(null, titles);

        List<OwnerModel> owners = ownerDao.getOwners();
        owners.stream().map((owner) -> {
            String[] row = new String[5];
            row[0] = owner.getPropId() + "";
            row[1] = owner.getPropUsuario();
            row[2] = owner.getPropApellido();
            row[3] = owner.getPropNombre();
            row[4] = owner.getPropTelefono();
            return row;
        }).forEachOrdered((row) -> {
            table.addRow(row);
        });
        return table;
    }

    public DefaultTableModel readOwner(int id) {
        String[] titles = {"Id", "Usuario", "Apellido", "Nombre", "Telefono"};
        DefaultTableModel table = new DefaultTableModel(null, titles);

        OwnerModel owner = ownerDao.getOwner(id);
        String[] row = new String[5];
        if (owner != null) {
            row[0] = owner.getPropId()+"";
            row[1] = owner.getPropUsuario();
            row[2] = owner.getPropApellido();
            row[3] = owner.getPropNombre();
            row[4] = owner.getPropTelefono();            
        } else {
            row[0] = "";
            row[1] = "";
            row[2] = "";
            row[3] = "";
            row[4] = "";            
        }
        table.addRow(row);
        return table;
    }

    public boolean updateOwner(OwnerModel owner) {
        return ownerDao.updateOwner(owner);
    }

    public boolean addOwner(OwnerModel owner) {
        return ownerDao.addOwner(owner);
    }

    public boolean deleteOwner(int id) {
        return ownerDao.deleteOwner(id);
    }
}
