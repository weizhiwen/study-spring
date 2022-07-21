package com.shixin.dao.impl;

import com.shixin.dao.DemoDao;

import java.util.List;

public class DemoDaoOracleImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return List.of("oracle", "oracle", "oracle");
    }
}
