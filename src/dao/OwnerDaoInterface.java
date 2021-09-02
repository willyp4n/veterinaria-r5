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

    public List<OwnerModel> getOwners();

    public OwnerModel getOwner(int Id);

    public boolean addOwner(OwnerModel propietario);

    public boolean updateOwner(OwnerModel propietario);

    public boolean deleteOwner(int propId);

}
