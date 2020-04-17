package com.yzc.spring.http.message;

import com.yzc.spring.domain.entity.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 23:27
 */
public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(StandardCharsets.UTF_8);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        //进来的类必须是Person的子类
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
