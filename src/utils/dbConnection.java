package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author j4ckdev
 */
public class dbConnection {

    public static Connection get(String dbName) {
        dbCredentials credentials = new dbCredentials();
        Connection dbConnection = null;
        try {
            String host = credentials.ip;
            String accessPort = credentials.accessPort;
            String user = credentials.user;
            String pass = credentials.pass;
            String dbUrl = "jdbc:mysql://" + host + ":" + accessPort + "/" + dbName;
            dbConnection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dbConnection;
    }
}
