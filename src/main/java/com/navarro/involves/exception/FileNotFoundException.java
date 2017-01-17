package com.navarro.involves.exception;

public class FileNotFoundException extends Throwable {

    public FileNotFoundException() { super(); }
    public FileNotFoundException(String message) {
        System.out.println(String.format("File \" %s \" not found",message)); }
    public FileNotFoundException(String message, Throwable cause) { super(message, cause); }
    public FileNotFoundException(Throwable cause) { super(cause); }

}
