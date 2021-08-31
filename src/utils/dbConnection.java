package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author j4ckdev
 */
public class dbConnection {

    public static Connection get() {
        dbCredentials credentials = new dbCredentials();
        Connection dbConnection = null;
        try {
            String host = credentials.ip;
            String accessPort = credentials.accessPort;
            String user = credentials.user;
            String pass = credentials.pass;
            String dbName = "veterinaria";
            String dbUrl = "jdbc:mysql://" + host + ":" + accessPort + "/" + dbName;
            dbConnection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dbConnection;
    }
}
