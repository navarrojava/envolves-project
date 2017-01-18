package com.navarro.involves;

import com.navarro.involves.command.service.impl.CommandServiceImpl;
import com.navarro.involves.constants.SystemConstants;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.file_reader.impl.CsvFileReader;
import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.reader.ConsoleReader;
import com.navarro.involves.reader.Reader;
import com.navarro.involves.writter.impl.ConsoleWriterFactory;
import com.navarro.involves.writter.impl.ConsoleWriterImpl;

import java.io.IOException;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws IOException {

        final Optional<String> jvmArgsFilename = Optional.ofNullable(System.getProperty(SystemConstants.JVM_ARGS_CSV_FILENAME_NAME));
        final String fileName = jvmArgsFilename.orElse(SystemConstants.DEFAULT_CSV_FILENAME_NAME);

        FileReader csvFileReader = new CsvFileReader();
        Reader consoleReader = new ConsoleReader(new CommandServiceImpl(new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance())), ConsoleWriterFactory.getInstance()), new ConsoleWriterImpl());

        csvFileReader.readFileAndPopulateDataSource(fileName);
        consoleReader.startRead();
    }
}

