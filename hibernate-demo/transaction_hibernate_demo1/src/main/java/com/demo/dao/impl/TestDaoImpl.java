package com.demo.dao.impl;

import com.demo.dao.TestDao;
import com.demo.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lorne on 2017/6/8.
 */
@Repository
public class TestDaoImpl extends BaseDaoImpl<Test,String> implements TestDao {




}
