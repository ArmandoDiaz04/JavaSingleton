/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singletonlogs;

/**
 *
 * @author chris
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton para la conexión a la base de datos
class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        initializeDatabaseConnection();
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void initializeDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/user_database";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
