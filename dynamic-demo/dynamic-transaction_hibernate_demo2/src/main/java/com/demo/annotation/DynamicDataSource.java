package com.demo.annotation;

import java.lang.annotation.*;

/**
 * create by lorne on 2017/12/7
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicDataSource {

    String name() default "default";

}
