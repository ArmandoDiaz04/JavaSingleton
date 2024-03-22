///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package singletonlogs;
//
//import singletonlogs.Logger.ILogger;
//import singletonlogs.Logger.Singleton;
//
///**
// *
// * @author chris
// */
//// Implementación del Singleton con el Logger
//class SingletonImplementation implements Singleton {
//    //class SingletonImplementation  {
//    private static SingletonImplementation instance;
//    private ILogger logger;
//
//    private SingletonImplementation(ILogger logger) {
//        this.logger = logger;
//    }
////falta el zyncronacion
//    public static  SingletonImplementation getInstance() {
//        if (instance == null) {
//            // Se puede usar cualquier implementación de Logger aquí
//            instance = new SingletonImplementation(new LoggerImplementation(SingletonImplementation.class.getName()));
//        }
//        return instance;
//    }
//
////    @Override
////    public void doSomething() {
////        // Haciendo algo y registrando en los logs
////        logger.log("Doing something...");
////    }
//}
