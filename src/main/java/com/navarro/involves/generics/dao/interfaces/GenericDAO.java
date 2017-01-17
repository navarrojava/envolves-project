package com.navarro.involves.generics.dao.interfaces;


import java.util.List;

public interface GenericDAO<T> {


    int countAll();
    int countDistinct(String key);
    List<T> filter(String key, String value);


}
