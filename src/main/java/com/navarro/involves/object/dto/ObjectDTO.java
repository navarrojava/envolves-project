package com.navarro.involves.object.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public class ObjectDTO implements Serializable {

    private HashMap<String, String> attibutes;
    private UUID uuid;

    public HashMap<String, String> getAttibutes() {
        return attibutes;
    }

    public ObjectDTO setAttibutes(HashMap<String, String> attibutes) {
        this.attibutes = attibutes;
        return this;
    }


    public UUID getUuid() {
        return uuid;
    }

    public ObjectDTO setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectDTO that = (ObjectDTO) o;

        return attibutes.equals(that.attibutes);

    }

    @Override
    public int hashCode() {
        return attibutes.hashCode();
    }

    @Override
    public String toString() {
        return attibutes.toString();
    }


}
