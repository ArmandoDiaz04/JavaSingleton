package singletonlogs;

import java.io.Writer;
import singletonlogs.Logger.ILogger;
import singletonlogs.Logger.Singleton;

/**
 *
 * @author chris
 */
public class SingletonLogs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obteniendo la instancia del primer Logger
        ILogger logger1 = DatabaseLogger.getInstance(DatabaseSingleton.class.getName());

        // Obteniendo la instancia del primer Singleton
        Singleton databaseSingleton1 = DatabaseSingleton.getInstance(logger1);

        // Obteniendo la instancia del segundo Logger
        ILogger logger2 = DatabaseLogger.getInstance(DatabaseSingleton.class.getName());

        // Obteniendo la instancia del segundo Singleton
        Singleton databaseSingleton2 = DatabaseSingleton.getInstance(logger2);

        // Insertando un nuevo usuario en la base de datos a través del primer Singleton
        databaseSingleton1.insertUser("usuario_prueba1", "prueba@example.com", "contraseña");

        // Insertando un nuevo usuario en la base de datos a través del segundo Singleton
        databaseSingleton2.insertUser("usuario_prueba2", "prueba2@example.com", "otra_contraseña");

        // Insertando un nuevo usuario en la base de datos
        databaseSingleton1.insertUser("usuario_prueba4", "prueba@example.com", "contraseña");

        // Intentando insertar un usuario con el mismo nombre de usuario
        databaseSingleton2.insertUser("usuario_prueba4", "prueba2@example.com", "otra_contraseña");

        System.out.println("databaseSingleton = " + databaseSingleton1);
        System.out.println("databaseSingleton2 = " + databaseSingleton2);
        System.out.println("logger = " + logger1);
        System.out.println("logger2 = " + logger2);

        // Comparando referencias de objetos
        System.out.println("¿databaseSingleton y databaseSingleton2 son la misma instancia? " + (databaseSingleton1 == databaseSingleton2));
        System.out.println("¿logger y logger2 son la misma instancia? " + (logger1 == logger2));

    }
}
