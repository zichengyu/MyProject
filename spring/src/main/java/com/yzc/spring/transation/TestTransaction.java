package com.yzc.spring.transation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :  20160301301
 * @date : 2018/9/6 9:50
 */
@Service
public class TestTransaction {

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, timeout= 30)
    public void transaction(){
        System.out.println("test transaction");
    }

    public void rollback(){
        System.out.println("test rollback");
    }

}
