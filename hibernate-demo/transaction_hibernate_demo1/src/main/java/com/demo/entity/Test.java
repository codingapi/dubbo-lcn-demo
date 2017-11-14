package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lorne on 2017/6/14.
 */
@Entity
@Table(name = "t_test")
public class Test extends BaseEntity {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
