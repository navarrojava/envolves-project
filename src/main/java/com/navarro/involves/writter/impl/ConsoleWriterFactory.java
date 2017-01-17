package com.navarro.involves.writter.impl;

public class ConsoleWriterFactory {
    private static ConsoleWriterImpl ourInstance = new ConsoleWriterImpl();

    public static ConsoleWriterImpl getInstance() {
        return ourInstance;
    }

    private ConsoleWriterFactory() {
    }
}
