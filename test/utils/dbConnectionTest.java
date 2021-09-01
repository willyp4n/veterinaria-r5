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

    String dbName = "veterinariaTest";

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
     * Probar la conexión a la base de datos
     */
    @Test
    public void testGet() {
        System.out.println("Conexión a la base de datos");
        Connection notExpectedResult = null;
        Connection result = dbConnection.get("veterinaria");
        assertNotEquals(notExpectedResult, result);
    }
}
