package utils;

/**
 * LÉEME
 * -> Crear un archivo con el nombre de dbCredentials y dentro crée una clase con el mismo nombre
 * -> Copie las variables en el nuevo archivo y coloque los valores que corresponden para aceeder a su base de datos
 * @author j4ckdev
 */
public class dbCredentialsExample {
    private final String ip = "su ip de acceso"; // Si es un base de datos local, por defecto es 127.0.0.1
    private final String accessPort = "su puerto"; // Por defecto es 3306
    private final String user = "Su usuario de acceso a la base de datos"; 
    private final String pass = "Su contraseña de acceso a la base de datos";

    public String getIp() {
        return ip;
    }

    public String getAccessPort() {
        return accessPort;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
}
