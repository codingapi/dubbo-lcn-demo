package com.demo.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.demo.dao.TestDao;
import com.demo.entity.Test;
import com.demo.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lorne on 2017/6/7.
 */
@Service
public class Test2ServiceImpl implements Test2Service {


    @Autowired
    private TestDao testDao;


    @Override
    @Transactional
    @TxTransaction
    public String test() {

        String name = "mybatis_demo2";
        Test test = new Test();
        test.setName(name);
        testDao.save(test);

        return name;
    }
}
