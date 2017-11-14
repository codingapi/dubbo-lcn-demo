package com.demo.service.impl;

import com.demo.dao.TestDao;
import com.demo.entity.Test;
import com.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/7/8.
 */
@Service
public class DemoServiceImpl implements DemoService {



    @Autowired
    private TestDao testDao;


    @Override
    public void test() {
        String name = "hello_demo2";
        Test test = new Test();
        test.setName(name);
        testDao.save(test);
    }
}
