package com.demo.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.demo.dao.TestDao;
import com.demo.service.Test4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lorne on 2017/6/7.
 */
@Service
public class Test4ServiceImpl implements Test4Service {


    @Autowired
    private TestDao testDao;


    @Override
    @Transactional
    @TxTransaction
    public String test() {

        String name = "jdbc_demo4";

        testDao.save(name);

        //  int v = 100/0;

        return name;

    }
}
