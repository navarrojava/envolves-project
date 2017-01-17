package com.navarro.involves.exception;


public class CommandNotFoundException extends Throwable {

    private static final String MESSAGE_NOT_FOUND = "The command typed \"%s\" don`t mach any available command ";

    public CommandNotFoundException() {
        super();
    }

    public CommandNotFoundException(String message) {
       super(String.format(MESSAGE_NOT_FOUND, message));
    }

    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }

}
