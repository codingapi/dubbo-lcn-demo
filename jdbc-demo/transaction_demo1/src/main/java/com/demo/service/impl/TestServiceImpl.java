package com.demo.service.impl;

import com.demo.service.Test3Service;
import com.demo.service.TestService;
import com.codingapi.tx.annotation.TxTransaction;
import com.demo.dao.TestDao;
import com.demo.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lorne on 2017/6/7.
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestDao testDao;

    @Autowired
    private Test2Service test2Service;

    @Autowired
    private Test3Service test3Service;


    @Override
    @TxTransaction(isStart = true)
    @Transactional
    public String hello() {

        String name = "jdbc_demo1";
        testDao.save(name);

        String res2 =  test2Service.test();

        String res3 =  test3Service.test();

        long t2 = System.currentTimeMillis();

        int v = 100/0;
        return name;
    }

}
