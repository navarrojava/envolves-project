package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.writter.Writer;

public class CountDistinct extends CommandServiceImpl {


    public CountDistinct(ObjectDAO objectDAO, Writer writer) {
        super(objectDAO, writer);
    }

    @Override
    public void execute(String... queryParams) {
        writer.writeInfo(String.valueOf(objectDAO.countDistinct(queryParams[0])));
    }
}
