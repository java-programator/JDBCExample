package pl.altkom;

// https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableMain {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            String url = "jdbc:sqlite:database.sqlite";
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE users (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT);");
            statement.executeUpdate("INSERT INTO users VALUES (1, 'Paweł');");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
