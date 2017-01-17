package com.navarro.involves.command.service.impl;

import com.navarro.involves.command.enums.CommandTypes;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.writter.Writer;
import com.navarro.involves.writter.impl.ConsoleWriterImpl;

public class CountDistinct extends CommandServiceImpl {


    public CountDistinct(ObjectDAO objectDAO) {
        super(objectDAO);
    }

    @Override
    public void execute(String... queryParams) {
        Writer w = new ConsoleWriterImpl();
        String[] strings = super.queryParamCommand(CommandTypes.COUNT_DISTINCT.getLiterals(), queryParams[0]);

        w.writeInfo(String.valueOf(objectDAO.countDistinct(strings[0])));
    }
}
