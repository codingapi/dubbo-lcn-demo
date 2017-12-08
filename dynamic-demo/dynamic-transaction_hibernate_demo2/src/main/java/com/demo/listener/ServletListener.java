package com.demo.listener;

import com.codingapi.tx.datasource.relational.LCNDynamicTransactionDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * create by lorne on 2017/12/7
 */
@Component
public class ServletListener implements ApplicationContextAware {


    @Resource(name = "datasource")
    private DataSource datasource;

    @Autowired
    private LCNDynamicTransactionDataSource lcnDynamicTransactionDataSource;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("init load 2 datasource .");

        lcnDynamicTransactionDataSource.addDataSource("datasource",datasource);

        System.out.println("end load 2 datasource .");
    }

}
