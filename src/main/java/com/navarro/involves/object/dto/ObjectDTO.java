package com.navarro.involves.object.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public class ObjectDTO implements Serializable {

    private HashMap<String, String> attributes;
    private UUID uuid;

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public ObjectDTO setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
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

        return attributes.equals(that.attributes);

    }

    @Override
    public int hashCode() {
        return attributes.hashCode();
    }

    @Override
    public String toString() {
        return attributes.toString();
    }


}
