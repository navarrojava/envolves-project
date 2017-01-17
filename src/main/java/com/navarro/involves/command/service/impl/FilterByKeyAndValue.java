package com.navarro.involves.command.service.impl;

import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.object.dto.ObjectDTO;
import com.navarro.involves.writter.Writer;

import java.util.List;
import java.util.Set;

public class FilterByKeyAndValue extends CommandServiceImpl {

    public FilterByKeyAndValue(ObjectDAO objectDAO, Writer writer) {
        super(objectDAO, writer);
    }

    @Override
    public void execute(String... queryParams) {

        List<ObjectDTO> filter = objectDAO.filter(queryParams[0], queryParams[1]);
        int size = filter.size();
        if (size > 0) {
            Set<String> keys = filter.get(0).getAttributes().keySet();

            writer.writeInfo(keys.toString());

            for (ObjectDTO objectDTO : filter) {
                writer.writeInfo(objectDTO.getAttributes().values().toString());
            }
        }else {
            //TODO create NoOneValueFoundException
            writer.writeError("No one value found");
        }
    }
}

