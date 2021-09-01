/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author j4ckdev
 */
public class dbConnectionTest {

    public dbConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Probar la conexión a la base de datos principal
     */
    @Test
    public void shouldConnectToMainDatabase() {
        System.out.println("Conexión a la base de datos principal");
        Connection notExpectedResult = null;
        Connection result = dbConnection.get("veterinaria");
        assertNotEquals(notExpectedResult, result);
    }
    
    /**
     * Probar la conexión a la base de datos de pruebas
     */
    @Test
    public void shouldConnectToTestDatabase() {
        System.out.println("Conexión a la base de datos de pruebas");
        Connection notExpectedResult = null;
        Connection result = dbConnection.get("veterinariaTest");
        assertNotEquals(notExpectedResult, result);
    }
}
