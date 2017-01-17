package com.navarro.involves.writter.impl;

import com.navarro.involves.writter.Writer;


public class ConsoleWriterImpl implements Writer {

    private static final String ERROR = "\u001B[31m";
    private static final String INFO = "\u001B[34m";
    private static final String WARNING = "\u001B[33m";



    @Override
    public void writeError(String message) {
        System.out.println(ERROR + message);
    }

    @Override
    public void writeInfo(String message) {
        System.out.println(INFO+ message);
    }

    @Override
    public void writeWarning(String message) {
        System.out.println(WARNING+message);
    }
}
