package com.yzc.spring.service.impl;

import com.yzc.spring.service.base.CalculatingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Profile("local")
@Service
public class LambdaCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0, Integer::sum);
        System.out.printf("lambda表达式求和为 %d", sum);
        return sum;
    }
}
