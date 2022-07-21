package com.shixin.dao.impl;

import com.shixin.dao.DemoDao;

import java.util.List;

public class DemoDaoMySqlImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return List.of("mysql", "mysql", "mysql");
    }
}
