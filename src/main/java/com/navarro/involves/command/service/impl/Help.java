package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.writter.Writer;

public class Help extends CommandServiceImpl {

    public Help(ObjectDAOImpl objectDAO, Writer writer) {
        super(objectDAO, writer);
    }

    @Override
    public void execute(String... queryParams) {


    }
}
