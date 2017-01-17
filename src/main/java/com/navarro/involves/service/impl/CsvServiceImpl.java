package com.navarro.involves.service.impl;

import com.navarro.involves.constants.SystemConstants;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.exception.FileNotFoundException;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.file_reader.impl.CsvFileReader;
import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.object.dto.ObjectDTO;
import com.navarro.involves.service.CsvService;
import com.navarro.involves.writter.Writer;
import com.navarro.involves.writter.impl.ConsoleWriterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CsvServiceImpl implements CsvService {


    private final FileReader csvFileReader = new CsvFileReader();
    private ObjectDAO objectDAO = null;


    public CsvServiceImpl() {
        readCsvFile();
    }

    @Override
    public void readCsvFile() {
        try {
            this.objectDAO = new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance().setObjects(mountListObjectsFromFile())));
        } catch (FileNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ObjectDTO> mountListObjectsFromFile() throws FileNotFoundException, IOException {
        return csvFileReader.mountListObjectsFromFile();
    }


}
