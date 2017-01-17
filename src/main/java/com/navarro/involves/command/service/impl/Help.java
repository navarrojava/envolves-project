package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.writter.Writer;

public class Help extends CommandServiceImpl {

    public Help(ObjectDAOImpl objectDAO, Writer writer) {
        super(objectDAO, writer);
    }

    @Override
    public void execute(String... queryParams) {

        writer.writeInfo("Available commands:\n");
        writer.writeInfo(" 'count *' -> Writes to the console the total count of imported records\n" );
        writer.writeInfo(" 'count distinct [property] ' -> Writes in the console the total of distinct property values (column) sent\n" );
        writer.writeInfo(" 'filter [property] [value] ' -> Writes in the console the header row and all the lines in which the property sent has the sent value\n" );
    }
}
