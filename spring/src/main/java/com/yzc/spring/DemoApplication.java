package com.yzc.spring;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.yzc.spring.annotation.EnableHelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableSwagger2Doc
@EnableTransactionManagement
@SpringBootApplication

//@EnableAspectJAutoProxy
@EnableHelloWorld
//@EnableServer(type = Server.Type.HTTP)
@EnableFeignClients(basePackages = "com.yzc.spring.service.facade.base")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
