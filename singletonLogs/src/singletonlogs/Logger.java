/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singletonlogs;

/**
 *
 * @author chris
 */
public class Logger {

    // Interfaz para el Logger
    interface ILogger {

        void log(String message);
    }

// Interfaz para el Singleton
    interface Singleton {

        void insertUser(String username, String email, String password);
    }

}
