package com.navarro.involves.datasource;


import java.util.List;

public abstract class DataSource<T> {


    public int countAll() {
        return 0;
    }

    public int countDistinct(String key) {
        return 0;
    }

    public List<T> filter(String key, String value) {
        return null;
    }

}

