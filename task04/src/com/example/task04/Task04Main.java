package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        // Создаем обработчики для логирования
        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = new FileHandler("logs/app.log");
        RotationFileHandler rotationFileHandler = new RotationFileHandler("logs/rotatedLog_", ChronoUnit.HOURS);

        MemoryHandler memoryHandler = new MemoryHandler(3, consoleHandler, fileHandler);

        // Создаем Logger с уровнем INFO, который использует обработчики console и file
        Logger logger = new Logger("AppLogger", Level.DEBUG);


        memoryHandler.log("First message");
        memoryHandler.log("Second message");
        memoryHandler.log("Third message");
        memoryHandler.log("Fourth message");

        // Логгируем разные уровни
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warning("This is a WARNING message");
        logger.error("This is an ERROR message");

        rotationFileHandler.log("This is a log for rotated file.");
    }
}

