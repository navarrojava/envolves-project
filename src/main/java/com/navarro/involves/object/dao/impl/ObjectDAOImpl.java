package com.navarro.involves.object.dao.impl;

import com.navarro.involves.datasource.DataSource;
import com.navarro.involves.object.dao.interfaces.ObjectDAO;
import com.navarro.involves.object.dto.ObjectDTO;

import java.util.List;

public  class ObjectDAOImpl  implements ObjectDAO {

    private final DataSource<ObjectDTO> dataSource;

    public ObjectDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int countAll() {
        return dataSource.countAll();
    }

    @Override
    public int countDistinct(String key) {
        return dataSource.countDistinct(key);
    }

    @Override
    public List<ObjectDTO> filter(String key, String value) {
        return dataSource.filter(key,value);
    }
}
