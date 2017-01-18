package com.navarro.involves.command.service.impl;

import com.navarro.involves.command.enums.CommandTypes;
import com.navarro.involves.command.service.CommandService;
import com.navarro.involves.exception.CommandNotFoundException;
import com.navarro.involves.exception.QueryParamsNumberNotMatchException;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.writter.Writer;

import java.util.Optional;

public class CommandServiceImpl implements CommandService {

     final ObjectDAO objectDAO;
     final Writer writer;

    public CommandServiceImpl(ObjectDAO objectDAO, Writer writer) {
        this.objectDAO = objectDAO;
        this.writer = writer;
    }

    @Override
    public void execute(String... queryParams) {

    }



    @Override
    public void matchCommand(String commandFromConsole) throws CommandNotFoundException, QueryParamsNumberNotMatchException {

        CommandTypes[] values = CommandTypes.values();
        Optional<CommandTypes> command = Optional.ofNullable(values[0].command(commandFromConsole));

        if (command.isPresent()) {
            command.get().execute(commandFromConsole);
        } else {
            throw new CommandNotFoundException(commandFromConsole);
        }
    }
}
