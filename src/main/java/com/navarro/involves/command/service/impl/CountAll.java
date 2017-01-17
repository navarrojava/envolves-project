package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.writter.Writer;
import com.navarro.involves.writter.impl.ConsoleWriterImpl;

public class CountAll extends CommandServiceImpl {

    public CountAll(ObjectDAO objectDAO) {
        super(objectDAO);
    }

    @Override
    public void execute(String... queryParams) {
        Writer w = new ConsoleWriterImpl();
        w.writeInfo(String.valueOf(objectDAO.countAll()));
    }
}
