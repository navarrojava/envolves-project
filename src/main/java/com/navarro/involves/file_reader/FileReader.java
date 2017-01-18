package com.navarro.involves.file_reader;

import com.navarro.involves.exception.FileNotFoundException;
import com.navarro.involves.object.dto.ObjectDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;


public interface FileReader {

    ArrayList<ObjectDTO> mountListObjectsFromFile(String filename) throws FileNotFoundException, IOException;
    Supplier<Stream<String>> readFile(String fileName) throws IOException, FileNotFoundException;
    void readFileAndPopulateDataSource(String Filename);
}
