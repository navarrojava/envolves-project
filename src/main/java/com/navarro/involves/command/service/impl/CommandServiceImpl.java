package com.navarro.involves.command.service.impl;

import com.navarro.involves.command.service.CommandService;
import com.navarro.involves.command.enums.CommandTypes;
import com.navarro.involves.exception.CommandNotFoundException;
import com.navarro.involves.exception.QueryParamOutOfBoundException;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;

import java.util.Optional;

public class CommandServiceImpl implements CommandService {

    final ObjectDAO objectDAO;

    public CommandServiceImpl(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    @Override
    public void execute(String... queryParams) {

    }


    @Override
    public void matchCommand(String commandFromConsole) throws CommandNotFoundException, QueryParamOutOfBoundException {

        CommandTypes[] values = CommandTypes.values();
        Optional<CommandTypes> command = Optional.ofNullable(values[0].command(commandFromConsole));


        if (command.isPresent()) {
            command.get().execute(commandFromConsole);
        } else {
            throw new CommandNotFoundException(commandFromConsole);
        }
    }

    String[] queryParamCommand(String command, String commandConsole) {
        return commandConsole.replace(command, "").trim().split(" ");
    }
}
