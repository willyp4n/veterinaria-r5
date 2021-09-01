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
import model.vetModel;

public interface vetDaoInterface {

    public List<vetModel> obtenerPropietario();

    public vetModel obtenerPropietario(int Id);

    public void agregarPropietario(vetModel propietario);

    public void actualizarPropietario(vetModel propietario);

    public void eliminarPropietario(int propId);

}
