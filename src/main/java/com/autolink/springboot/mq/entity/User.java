package com.autolink.springboot.mq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by shileichao on 2018/5/10.
 */
@Data
public class User implements Serializable{

    private String name;

    private String pass;
}
