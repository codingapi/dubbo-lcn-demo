package com.demo.dao.impl;

import com.demo.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lorne on 2017/6/8.
 */
@Repository
public class TestDaoImpl implements TestDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public int save(String name) {
        String sql = "insert into t_test(name) values(?) ";
        return jdbcTemplate.update(sql,name);
    }
}
