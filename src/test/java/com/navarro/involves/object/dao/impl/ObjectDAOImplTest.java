package com.navarro.involves.object.dao.impl;

import com.navarro.involves.MicroTests;
import com.navarro.involves.constants.SystemConstants;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.file_reader.impl.CsvFileReader;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.object.dto.ObjectDTO;

import java.util.List;
import java.util.Optional;

public class ObjectDAOImplTest extends MicroTests {

    private static final String ATTRIBUTE_TWO = "attribute_two";
    private static final String VALUE_TWO = "line_one_attr_two";

    private final Optional<String> jvmArgsFilename = Optional.ofNullable(System.getProperty(SystemConstants.JVM_ARGS_CSV_FILENAME_NAME));
    private final String fileName = jvmArgsFilename.isPresent() ? jvmArgsFilename.get() : SystemConstants.DEFAULT_CSV_FILENAME_NAME;
    private final FileReader fileReader = new CsvFileReader();
    private final ObjectDAO objectDAO = new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance()));

    private void beforeRun(){
        fileReader.readFileAndPopulateDataSource(fileName);
    }


    public void testAssertThatObjectDAOCountAllReturnAllLines() {
        beforeRun();
        super.assertEquals(objectDAO.countAll(), 2);
    }

    public void testCountDistinct(){
        beforeRun();
        assertEquals(objectDAO.countDistinct(ATTRIBUTE_TWO),1);
    }

    public void testFilter(){
        beforeRun();
        List<ObjectDTO> filter = objectDAO.filter(ATTRIBUTE_TWO, VALUE_TWO);
        super.assertEquals(filter.size(),1);
    }
}