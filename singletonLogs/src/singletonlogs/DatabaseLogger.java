/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singletonlogs;

/**
 *
 * @author chris
 */
import java.util.logging.Logger;
import singletonlogs.Logger.ILogger;

// Implementación del Logger
import java.util.logging.Logger;

// Implementación del Logger con Singleton
class DatabaseLogger implements ILogger {
    private static DatabaseLogger instance;
    private Logger logger;

    private DatabaseLogger(String name) {
        this.logger = Logger.getLogger(name);
    }

    public static synchronized DatabaseLogger getInstance(String name) {
        if (instance == null) {
            instance = new DatabaseLogger(name);
        }
        return instance;
    }

    @Override
    public void log(String message) {
        System.out.println("[Database Log] " + message);
    }
}

