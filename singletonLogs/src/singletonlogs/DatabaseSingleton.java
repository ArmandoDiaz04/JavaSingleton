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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import singletonlogs.Logger.ILogger;
import singletonlogs.Logger.Singleton;

// Implementación del Singleton con el Logger
class DatabaseSingleton implements Singleton {
    private static DatabaseSingleton instance; // Instancia única de DatabaseSingleton
    private ILogger logger;
    private Connection connection;

    // Constructor privado para evitar la instanciación directa
    DatabaseSingleton(ILogger logger) {
        this.logger = logger;
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Método estático para obtener la instancia única de DatabaseSingleton
    public static synchronized DatabaseSingleton getInstance(ILogger logger) {
        if (instance == null) {
            instance = new DatabaseSingleton(logger);
        }
        return instance;
    }

    @Override
    public void insertUser(String username, String email, String password) {
        String sqlCheck = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement statementCheck = connection.prepareStatement(sqlCheck)) {
            statementCheck.setString(1, username);
            try (ResultSet resultSet = statementCheck.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    logger.log("El nombre de usuario ya está en uso: " + username);
                    return; // Salir del método si el nombre de usuario ya está en uso
                }
            }
        } catch (SQLException e) {
            logger.log("Error al verificar la existencia del nombre de usuario: " + e.getMessage());
            return; // Salir del método si hay un error al verificar el nombre de usuario
        }

        String sqlInsert = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
            logger.log("Nuevo usuario registrado: " + username);
        } catch (SQLException e) {
            logger.log("Error al insertar nuevo usuario: " + e.getMessage());
        }
    }
}
