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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.OwnerModel;
import utils.dbConnection;

public class OwnerDao implements OwnerDaoInterface {
    
    String dbName;
    
    OwnerDao (String dbName){
        this.dbName = dbName;
    }
      
    @Override
    public List<OwnerModel> obtenerPropietarios() {
        Connection conn = null;
        List<OwnerModel> propietarios = new ArrayList();
        try {
            conn = dbConnection.get(dbName);
            String sql = "SELECT * FROM propietario;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                OwnerModel propietario = new OwnerModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5));
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return propietarios;
    }
    @Override
    public OwnerModel obtenerPropietario(int id) {
        Connection conn = null;
        OwnerModel propietario = null;
        try {
            conn = dbConnection.get(dbName);
            String sql = "SELECT * FROM propietario WHERE propId = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                propietario = new OwnerModel(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return propietario;
    }

    @Override
    public void actualizarPropietario(OwnerModel propietario) {
        Connection conn = null;
        try {
            conn = dbConnection.get(dbName);
            String sql = "UPDATE propietario SET propUsuario=?, propNombre=?, propApellido=?, propTelefono=? WHERE propId=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, propietario.getPropUsuario());
            statement.setString(2, propietario.getPropNombre());
            statement.setString(3, propietario.getPropApellido());
            statement.setString(4, propietario.getPropTelefono());
            statement.setInt(5, propietario.getPropId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + " actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
    @Override
    public void eliminarPropietario(int id) {
        Connection conn = null;
        try {
            conn = dbConnection.get(dbName);
            String sql = "DELETE FROM propietario WHERE propId=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" Borrado exitoso !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    @Override
    public void agregarPropietario(OwnerModel propietario) {
        Connection conn = null;
        try {
            conn = dbConnection.get(dbName);
            String sql = "INSERT INTO propietario(propUsuario,propNombre,propApellido,propTelefono) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, propietario.getPropUsuario());
            statement.setString(2, propietario.getPropNombre());
            statement.setString(3, propietario.getPropApellido());
            statement.setString(4, propietario.getPropTelefono());        
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + " creado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
