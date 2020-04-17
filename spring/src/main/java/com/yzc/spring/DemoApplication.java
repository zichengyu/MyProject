package com.yzc.spring;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.yzc.spring.annotation.EnableHelloWorld;
import com.yzc.spring.annotation.EnableServer;
import com.yzc.spring.service.base.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableSwagger2Doc
@EnableTransactionManagement
@SpringBootApplication

//@EnableAspectJAutoProxy
@EnableHelloWorld
@EnableServer(type = Server.Type.HTTP)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(DemoApplication.class);
//        context.refresh();
//        // 1
//        String helloWorld = context.getBean("helloWorld", String.class);
//        System.err.printf("helloWorld bean is: %s \n", helloWorld);
//
//        // 2
//		Server server = context.getBean(Server.class);
//
//
//
//		System.err.printf("server bean is: %s \n", server);
//        context.close();
    }
}
