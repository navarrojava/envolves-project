package com.navarro.involves.datasource.impl;

import com.navarro.involves.constants.SystemConstants;
import com.navarro.involves.datasource.Bucket;
import com.navarro.involves.datasource.DataSource;
import com.navarro.involves.object.dto.ObjectDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class MemoryDataSource extends DataSource<ObjectDTO> {

    private static final List<Bucket> buckets = new ArrayList<>();


    public MemoryDataSource(Bucket bucket) {
        buckets.add(bucket);
    }


    private Bucket getBucketByName(String name) {
        Optional<Bucket> bucket = buckets.stream().filter(o -> o.getName().equals(name)).findFirst();
        return bucket.isPresent() ? bucket.get() : null;
    }

    private Bucket getDefaultBucket() {
        return getBucketByName(SystemConstants.DEFAULT_BUCKET_NAME);
    }

    @Override
    public List<ObjectDTO> filter(String attribute, String value) {

        List<ObjectDTO> objectDTOs = new ArrayList<>();
        getDefaultBucket()
                .getObjects()
                .stream()
                .filter(o -> o.getAttibutes().get(attribute) != null && o.getAttibutes().get(attribute).equalsIgnoreCase(value))
                .forEach(objectDTOs::add);

        return objectDTOs;
    }

    @Override
    public int countAll() {
        return getDefaultBucket()
                .getObjects().size();
    }

    @Override
    public int countDistinct(String key) {

        Stream<String> objectDTOStream = getDefaultBucket()
                .getObjects()
                .stream()
                .filter(o -> o.getAttibutes().get(key) != null)
                .map(objectDTO -> objectDTO.getAttibutes().get(key)).distinct();

        return (int) objectDTOStream.count();
    }
}


