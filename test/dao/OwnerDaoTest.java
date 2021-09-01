/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.ArrayList;
import models.OwnerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.dbConnection;

/**
 *
 * @author j4ckdev
 */
public class OwnerDaoTest {

    String dbName = "veterinariaTest";

    public OwnerDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        try {
            System.out.println("%% Restablecer la tabla propietario %%");
            Connection dbTest = dbConnection.get(dbName);
            Statement tableStatement = dbTest.createStatement();
            String queryDeleteTable = "drop table if exists propietario;";
            tableStatement.execute(queryDeleteTable);

            String queryCreateTable = "create table propietario(propId int primary key auto_increment,propUsuario varchar(30) not null,"
                    + "propApellido varchar(30) not null default \" \",propNombre varchar(30) not null,propTelefono char(25) null);";
            tableStatement.execute(queryCreateTable);

            String[][] ownersDataTest = {{"usuario1", "nombre1", "apellido1", "0123456789"}, {"usuario2", "nombre2", "apellido2", "1234567890"}};
            String queryInsertData = "insert into propietario(propUsuario,propApellido,propNombre,propTelefono) values (?,?,?,?);";
            for (String[] ownerData : ownersDataTest) {
                PreparedStatement dataStatement = dbTest.prepareStatement(queryInsertData);
                dataStatement.setString(1, ownerData[0]);
                dataStatement.setString(2, ownerData[1]);
                dataStatement.setString(3, ownerData[2]);
                dataStatement.setString(4, ownerData[3]);
                int rowsUpdated = dataStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("El registro de adicionó correctamente");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Código: " + ex.getErrorCode() + "\nDescripción: " + ex.getMessage());
        }
        System.out.println("%%-------- Fin restauración --------%%");
    }

    @After
    public void tearDown() {
    }

    /**
     * Probar que se puede obtener la información de todos los propietarios
     */
    @Test
    public void shouldReturnAllOwners() {
        System.out.println("Obtener la información de todos los propietarios");
        OwnerDao ownerDao = new OwnerDao(dbName);
        OwnerModel testData1 = new OwnerModel(1, "usuario1", "nombre1", "apellido1", "0123456789");
        OwnerModel testData2 = new OwnerModel(2, "usuario2", "nombre2", "apellido2", "1234567890");
        List<OwnerModel> expectedResult = new ArrayList();
        expectedResult.add(testData1);
        expectedResult.add(testData2);
        List<OwnerModel> result = ownerDao.obtenerPropietarios();
        assertEquals(expectedResult.toString(), result.toString());
    }

    /**
     * Probar que retorne la información de un propietario especificado
     */
    @Test
    public void shouldReturnOneOwner() {
        System.out.println("Obtener la información de un propietario especificado");
        OwnerDao ownerDao = new OwnerDao(dbName);
        OwnerModel expectedResult = new OwnerModel(1, "usuario1", "nombre1", "apellido1", "0123456789");
        OwnerModel result = ownerDao.obtenerPropietario(1);
        assertEquals(expectedResult.toString(), result.toString());
    }

    /**
     * Probar que actualice la información de un propietario especificado
     */
    @Test
    public void shouldUpdateOwnerData() {
        System.out.println("Actualizar la información de un propietario especificado");
        OwnerModel dataToUpdate = new OwnerModel(1, "usuario1", "nombre1", "apellido1", "2345678901");
        OwnerDao ownerDao = new OwnerDao(dbName);
        boolean result = ownerDao.actualizarPropietario(dataToUpdate);
        assertTrue(result);
    }

    /**
     * Probar que se elimine un propietario
     */
    @Test
    public void shouldDeleteAnOwner() {
        System.out.println("Eliminar la información de un propietario especificado");
        OwnerDao ownerDao = new OwnerDao(dbName);
        boolean result = ownerDao.eliminarPropietario(2);
        assertTrue(result);
    }

    /**
     * Probar que se agregue un nuevo propietario
     */
    @Test
    public void shouldAddANewOwner() {
        System.out.println("Agregar la información de un nuevo propietario");
        OwnerModel newOwner = new OwnerModel(3, "jdoe", "John", "Doe", "2345678901");
        OwnerDao ownerDao = new OwnerDao(dbName);
        boolean result = ownerDao.agregarPropietario(newOwner);
        assertTrue(result);
    }

}
