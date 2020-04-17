package com.yzc.spring.annotation;


import com.yzc.spring.extern.ServerImportBeanDefinitionRegistrar;
import com.yzc.spring.service.base.Server;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    Server.Type type();
}
