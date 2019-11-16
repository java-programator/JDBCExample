package pl.altkom;

import java.sql.*;

public class ReadTableMain {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            String url = "jdbc:sqlite:database.sqlite";
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next()) {
                System.out.println("--------------------------------");
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString("name"));
            }
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
