package com.yzc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 23:06
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.err.println("configureMessageConverters :" + converters);
        converters.add(0, new MappingJackson2HttpMessageConverter());
        System.err.println("configureMessageConverters :" + converters);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.err.println("extendMessageConverters :" + converters);
    }
}
