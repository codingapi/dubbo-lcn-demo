package com.demo.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.demo.dao.TestDao;
import com.demo.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.lorne.tx.mq.service.impl.MQTransactionServiceImpl;

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

        String name = "jdbc_demo2";

        testDao.save(name);

        return name;

    }
}
