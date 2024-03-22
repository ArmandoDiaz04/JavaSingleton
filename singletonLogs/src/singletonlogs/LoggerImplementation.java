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
class LoggerImplementation implements ILogger {
    private Logger logger;

    public LoggerImplementation(String name) {
        this.logger = Logger.getLogger(name);
    }

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
