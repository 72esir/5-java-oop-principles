package com.example.task01;
import java.text.MessageFormat;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private String name;
    private Level level;

    public Logger(){}
    public Logger(String name){
        this.name = name;
        level = Level.INFO;
        loggers.put(name, this);
    }
    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }
    public String getName() {
        return name;
    }

    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel() {
        return level;
    }

    public static Logger getLogger(String name){
        if (loggers.get(name) == null){
            loggers.put(name,new Logger(name));
        }
        return loggers.get(name);
    }

    public void debug (String message){
        log(Level.DEBUG, message);
    }
    public void debug (String format, Object... args){
        log(Level.DEBUG, format, args);
    }
    public void info (String message){
        log(Level.INFO, message);
    }
    public void info (String format, Object... args){
        log(Level.INFO, format, args);
    }
    public void warning (String message){
        log(Level.WARNING, message);
    }
    public void warning (String format, Object... args){
        log(Level.WARNING, format, args);
    }
    public void error (String message){
        log(Level.ERROR, message);
    }
    public void error (String format, Object... args){
        log(Level.ERROR, format, args);
    }
    public void log (Level level, String message){
        if(this.level.ordinal()<= level.ordinal()){

            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}", level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()), name, message));
        }
    }
    public void log (Level level,String format, Object... args){
        log(level, MessageFormat.format(format,args));
    }
}
