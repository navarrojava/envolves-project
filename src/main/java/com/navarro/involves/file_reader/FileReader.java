package com.navarro.involves.file_reader;

import com.navarro.involves.exception.FileNotFoundException;
import com.navarro.involves.object.dto.ObjectDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;


public interface FileReader {

    ArrayList<ObjectDTO> mountListObjectsFromFile() throws FileNotFoundException, IOException;
    Supplier<Stream<String>> readFile(Optional<String> fileName) throws IOException, FileNotFoundException;
    void readFile();
}
