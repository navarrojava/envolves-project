package com.navarro.involves.file_reader.impl;

import com.navarro.involves.constants.SystemConstants;
import com.navarro.involves.datasource.BucketFactory;
import com.navarro.involves.datasource.impl.MemoryDataSource;
import com.navarro.involves.exception.FileNotFoundException;
import com.navarro.involves.file_reader.FileReader;
import com.navarro.involves.object.dao.impl.ObjectDAOImpl;
import com.navarro.involves.object.dto.ObjectDTO;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class CsvFileReader implements FileReader {


    public Supplier<Stream<String>> readFile(String csvFileName) throws FileNotFoundException, IOException {

        Supplier<Stream<String>> documentStream;

        if (getFilePath(csvFileName).isPresent()) {
            documentStream = () -> {
                Stream<String> lines = null;
                try {
                    lines = Files.lines(Paths.get(getFilePath(csvFileName).get()));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return lines;
            };
        } else {
            throw new FileNotFoundException(csvFileName);
        }
        return documentStream;
    }


    public ArrayList<ObjectDTO> mountListObjectsFromFile(String filename) throws FileNotFoundException, IOException {
        Supplier<Stream<String>> documentStream = readFile(filename);
        Optional<String> lineThatContainKeys = documentStream.get().findFirst();
        String[] keys = getKeys(lineThatContainKeys);

        ArrayList<ObjectDTO> objects = new ArrayList<>();
        documentStream
                .get()
                .skip(1)
                .forEach(values -> objects.add(mountObject(keys, getKeys(Optional.of(values)))));

        return objects;
    }

    @Override
    public void readFileAndPopulateDataSource(String fileName) {
        try {
            new ObjectDAOImpl(new MemoryDataSource(BucketFactory.getInstance().setObjects(mountListObjectsFromFile(fileName))));
        } catch (FileNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private Optional<String> getFilePath(String fileName) {

        URL resource = getClass().getClassLoader().getResource(fileName);
        Optional<String> path = Optional.ofNullable(resource != null ? resource.getPath() : null);
        return path.isPresent() ?
                path :
                Optional.empty();
    }

    private ObjectDTO mountObject(String[] keys, String[] values) {
        ObjectDTO o = new ObjectDTO();
        HashMap<String, String> attributes = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            attributes.put(keys[i], values[i]);
        }
        o.setAttributes(attributes);
        o.setUuid(UUID.randomUUID());

        return o;
    }

    private String[] getKeys(Optional<String> lineThatContainKeys) {
        return lineThatContainKeys.isPresent() ? lineThatContainKeys.get().split(Pattern.quote(",")) : new String[0];
    }

}
