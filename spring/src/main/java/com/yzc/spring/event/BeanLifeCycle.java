package com.yzc.spring.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author :  20160301301
 * @date : 2018/7/31 15:37
 */
@Component
public class BeanLifeCycle implements ApplicationContextAware, BeanFactoryAware, BeanNameAware, BeanPostProcessor, InitializingBean, DisposableBean {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("setApplicationContext applicationContext:" + applicationContext);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.debug("setBeanFactory beanFactory:" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        logger.debug("setBeanName BeanName:" + s);
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.debug("postProcessBeforeInitialization Object:" + o + " String:" + s);
        return o;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("afterPropertiesSet");
    }

    @PostConstruct
    public void initMethod() throws Exception {
        logger.debug("initMethod");
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.debug("postProcessBeforeInitialization Object:" + o + " String:" + s);
        return o;
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("destroy");
    }

    @PreDestroy
    public void destroyMethod() throws Exception {
        logger.debug("destroyMethod");
    }
}
