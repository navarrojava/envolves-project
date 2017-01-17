package com.navarro.involves.command.enums;

import com.navarro.involves.command.service.CommandService;
import com.navarro.involves.command.service.impl.CountAll;
import com.navarro.involves.command.service.impl.CountDistinct;
import com.navarro.involves.command.service.impl.FilterByKeyAndValue;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.exception.QueryParamOutOfBoundException;
import com.navarro.involves.object.dao.impl.ObjectDAOImpl;

import java.util.Optional;

public enum CommandTypes {

    COUNT_ALL("count *", new CountAll(new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()))), 0),
    COUNT_DISTINCT("count distinct", new CountDistinct(new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()))), 1),
    FILTER("filter",new FilterByKeyAndValue(new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()))), 2);

    private final CommandService commandService;
    private String command;
    private final int queryParams;

     CommandTypes(String s, CommandService commandService, int queryParams) {
            this.commandService = commandService;
        this.command = s;
         this.queryParams = queryParams;
     }

     public String getLiterals() {
        return command;
    }

    public void execute(String commandFromConsole) throws QueryParamOutOfBoundException {

        Optional<String[]> queryParamsFromConsole = queryParams(commandFromConsole);

        if (proced(queryParamsFromConsole)){
            commandService.execute(queryParamsFromConsole.isPresent() ? queryParamsFromConsole.get() : null);
        } else {
            throw new QueryParamOutOfBoundException(queryParams, queryParamsFromConsole.isPresent() ? queryParamsFromConsole.get().length : 0);
        }
    }

    private boolean proced(Optional<String[]> s ){

        return ((queryParams == 0) || !s.isPresent()) ||
                (s.isPresent() && s.get().length == queryParams);
    }
    public boolean verifyIfMatch(String s) {

        return s.contains(COUNT_ALL.getLiterals()) ||
                s.contains(COUNT_DISTINCT.getLiterals()) ||
                s.contains(FILTER.getLiterals());

    }

    public CommandTypes command(String command){
        return  command.contains(COUNT_ALL.getLiterals()) ? COUNT_ALL:
                command.contains(COUNT_DISTINCT.getLiterals()) ? COUNT_DISTINCT :
                        command.contains(FILTER.getLiterals()) ? FILTER:
                                null;
    }

    private Optional<String[]> queryParams(String commandConsole){
        String trim = commandConsole.replace(this.getLiterals(), "").trim();
       return  trim.isEmpty() ? Optional.empty() : Optional.of(trim.split(" "));
    }
}
