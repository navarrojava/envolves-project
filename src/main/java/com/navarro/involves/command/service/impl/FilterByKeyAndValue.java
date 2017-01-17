package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.object.dto.ObjectDTO;
import com.navarro.involves.writter.Writer;
import com.navarro.involves.writter.impl.ConsoleWriterImpl;

import java.util.List;
import java.util.Set;

public class FilterByKeyAndValue extends CommandServiceImpl {

    public FilterByKeyAndValue(ObjectDAO objectDAO) {
        super(objectDAO);
    }

    @Override
    public void execute(String... queryParams) {
        Writer w = new ConsoleWriterImpl();

        List<ObjectDTO> filter = objectDAO.filter(queryParams[0], queryParams[1]);
        int size = filter.size();
        if (size > 0) {
            Set<String> keys = filter.get(0).getAttributes().keySet();

            w.writeInfo(keys.toString());

            for (ObjectDTO objectDTO : filter) {
                w.writeInfo(objectDTO.getAttributes().values().toString());
            }
        }else {
            //TODO create NoOneValueFoundException
            w.writeError("No one value found");
        }
    }
}

