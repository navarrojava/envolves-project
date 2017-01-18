package com.navarro.involves.command.service;

import com.navarro.involves.exception.CommandNotFoundException;
import com.navarro.involves.exception.QueryParamsNumberNotMatchException;

public interface CommandService {

    void execute(String... queryParams);
    void matchCommand(String commandFromConsole) throws CommandNotFoundException, QueryParamsNumberNotMatchException;
}
