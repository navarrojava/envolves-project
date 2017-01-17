package com.navarro.involves.object.dao.impl;

import com.navarro.involves.MicroTests;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.file_reader.impl.CsvFileReader;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;

public class ObjectDAOImplTest extends MicroTests {

    private final FileReader fileReader = new CsvFileReader();
    private final ObjectDAO objectDAO = new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()));

    private void beforeRun(){
        fileReader.readFile();
    }


    public void testAssertThatObjectDAOCountAllReturnAllLines() {
        super.assertEquals(objectDAO.countAll(), 2);
    }



}