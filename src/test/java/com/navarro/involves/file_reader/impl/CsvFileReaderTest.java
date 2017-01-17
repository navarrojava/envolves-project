package com.navarro.involves.file_reader.impl;


import com.navarro.involves.MicroTests;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.exception.FileNotFoundException;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;

import java.io.IOException;

public class CsvFileReaderTest extends MicroTests {

    private final FileReader fileReader = new CsvFileReader();
    private final ObjectDAO objectDAO = new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()));

   public void assertThatCsvFileReaderReadAllLines() throws FileNotFoundException, IOException {
        fileReader.readFile();
        super.assertEquals(fileReader.mountListObjectsFromFile().size(), 2);

    }
}