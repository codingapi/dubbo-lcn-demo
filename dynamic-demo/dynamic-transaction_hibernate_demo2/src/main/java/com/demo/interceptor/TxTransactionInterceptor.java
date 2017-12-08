package com.demo.interceptor;

import com.codingapi.tx.datasource.bean.LCNDataSourceLocal;
import com.codingapi.tx.dubbo.interceptor.TxManagerInterceptor;
import com.demo.annotation.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by lorne on 2017/6/28.
 */
@Aspect
@Component
public class TxTransactionInterceptor implements Ordered {


    @Override
    public int getOrder() {
        return 1;
    }

    @Autowired
    private TxManagerInterceptor txManagerInterceptor;

    private Logger logger = LoggerFactory.getLogger(TxTransactionInterceptor.class);

    @Around("execution(* com.demo.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        Class<?> clazz = point.getTarget().getClass();
        DynamicDataSource dynamicDataSource =  clazz.getAnnotation(DynamicDataSource.class);
        if(dynamicDataSource!=null){
            LCNDataSourceLocal lcnDataSourceLocal = new LCNDataSourceLocal();
            lcnDataSourceLocal.setKey(dynamicDataSource.name());
            LCNDataSourceLocal.setCurrent(lcnDataSourceLocal);

            logger.info("change datasource " + dynamicDataSource.name());

        }
        return txManagerInterceptor.around(point);
    }
}
