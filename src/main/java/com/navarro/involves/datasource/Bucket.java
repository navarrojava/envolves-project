package com.navarro.involves.datasource;

import com.navarro.involves.object.dto.ObjectDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Bucket implements Serializable {

    private String name;
    private ArrayList<ObjectDTO> objects;

    public String getName() {
        return name;
    }

    public Bucket setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<ObjectDTO> getObjects() {
        return objects;
    }

    public Bucket setObjects(ArrayList<ObjectDTO> objects) {
        this.objects = objects;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(name, bucket.name) &&
                Objects.equals(objects, bucket.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, objects);
    }
}
