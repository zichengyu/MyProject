package com.yzc.spring.annotation;

import com.yzc.spring.config.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
