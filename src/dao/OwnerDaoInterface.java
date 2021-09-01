/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author WILLY
 */
import java.util.List;
import models.OwnerModel;

public interface OwnerDaoInterface {

    public List<OwnerModel> obtenerPropietarios();

    public OwnerModel obtenerPropietario(int Id);

    public void agregarPropietario(OwnerModel propietario);

    public void actualizarPropietario(OwnerModel propietario);

    public void eliminarPropietario(int propId);

}
