package com.navarro.involves.reader;

import com.navarro.involves.command.service.CommandService;
import com.navarro.involves.exception.CommandNotFoundException;
import com.navarro.involves.exception.QueryParamOutOfBoundException;
import com.navarro.involves.writter.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    private final CommandService commandService;
    private final Writer writer;

    public ConsoleReader(CommandService commandService, Writer writer) {
        this.commandService = commandService;
        this.writer = writer;
    }

    @Override
    public void startRead() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = in.readLine()) != null) {
                try {
                    commandService.matchCommand(s);
                } catch (CommandNotFoundException | QueryParamOutOfBoundException e) {
                    writer.writeError(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
