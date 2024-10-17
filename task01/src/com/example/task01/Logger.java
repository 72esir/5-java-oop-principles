package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String Name;
    private Level Level;

    public Logger(String name){
        Name = name;
        Level = Level.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, Level level){
        Name = name;
        Level = level;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name){
        if(loggers.get(name) == null){
            loggers.put(name,new Logger(name));
        }
        return loggers.get(name);
    }

    public String getName(){
        return this.Name;
    }

    public Level getLevel(){
        return this.Level;
    }

    public void setLevel(Level level){
        Level = level;
    }

    public void log(Level level, String message) {
        if (Level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, message);
            System.out.println(printMessage);
        }
    }

    public void log(Level level, String format, Object... objects) {
        if (Level.ordinal() <= level.ordinal()){
            System.out.println(MessageFormat.format(format, objects));
        }
    }

    public void debug(String message){
        this.log(Level.DEBUG, message);
    }

    public void debug(String format, Object... objects){
        this.log(Level.DEBUG, format, objects);
    }

    public void info(String mesage){
        this.log(Level.INFO, mesage);
    }

    public void info(String format, Object... objects){
        this.log(Level.INFO, format, objects);
    }

    public void warning(String message){
        this.log(Level.WARNING, message);
    }

    public void warning(String format, Object... objects){
        this.log(Level.WARNING, format, objects);
    }

    public void error(String message){
        this.log(Level.ERROR, message);
    }

    public void error(String format, Object... objects){
        this.log(Level.ERROR, format, objects);
    }
}