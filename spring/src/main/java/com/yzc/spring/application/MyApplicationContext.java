package com.yzc.spring.application;

import com.yzc.spring.transation.TestTransaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author :  20160301301
 * @date : 2018/9/6 9:26
 */
public class MyApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/*.xml");
        applicationContext.refresh();

        TestTransaction testTransaction = (TestTransaction)applicationContext.getBean("testTransaction");

        testTransaction.transaction();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
