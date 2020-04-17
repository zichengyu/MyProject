package com.yzc.spring.extern;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        ImportSelector importSelector = new ServerImportSelector(); // 直接引用ImportSelector，避免重复实现
        String[] selectedClassNames = importSelector.selectImports(annotationMetadata);
        //创建Bean定义
        Stream.of(selectedClassNames)
                // 转换为BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为BeanDefinition对象
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        // 注册BeanDefinition到BeanDefinitionRegistry中
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, beanDefinitionRegistry)
                );
    }
}
