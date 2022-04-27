package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
    public static Connection getDBConnection() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String url = "jdbc:mysql://" + resourceBundle.getString("db.host") + ":" +
                resourceBundle.getString("db.port") + "/" + resourceBundle.getString("db.name");

        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}
