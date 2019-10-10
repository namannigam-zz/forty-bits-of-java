package com.stackoverflow.nullpointer.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogAll {
    public static void main(String[] args) {

        System.Logger logger = System.getLogger(LogAll.class.getName());

        logger.log(System.Logger.Level.ALL, "This will be printed on ALL");
        logger.log(System.Logger.Level.TRACE, "This will be printed on TRACE");
        logger.log(System.Logger.Level.DEBUG, "This will be printed on DEBUG"); // typically mapped to/from j.u.l.Level.FINEST/FINE/CONFIG
        logger.log(System.Logger.Level.INFO, "This will be printed on INFO");
        logger.log(System.Logger.Level.WARNING, "This will be printed on WARNING");
        logger.log(System.Logger.Level.ERROR, "This will be printed on ERROR");
        logger.log(System.Logger.Level.OFF, "This will be printed on OFF");

        Logger LOGGER = Logger.getLogger(LogAll.class.getName());

        LOGGER.log(Level.ALL, "This will be printed on ALL");
        LOGGER.log(Level.FINEST, "This will be printed on FINEST"); //gone
        LOGGER.log(Level.FINER, "This will be printed on FINER");
        LOGGER.log(Level.FINE, "This will be printed on FINE");
        LOGGER.log(Level.CONFIG, "This will be printed on CONFIG"); //gone
        LOGGER.log(Level.INFO, "This will be printed on INFO");
        LOGGER.log(Level.WARNING, "This will be printed on WARNING");
        LOGGER.log(Level.SEVERE, "This will be printed on SEVERE");
        LOGGER.log(Level.OFF, "This will be printed on OFF");

    }
}