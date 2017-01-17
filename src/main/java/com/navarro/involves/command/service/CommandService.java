package com.navarro.involves.command.service;

import com.navarro.involves.exception.CommandNotFoundException;
import com.navarro.involves.exception.QueryParamOutOfBoundException;

public interface CommandService {

    void execute(String... queryParams);
    void matchCommand(String commandFromConsole) throws CommandNotFoundException, QueryParamOutOfBoundException;
}
