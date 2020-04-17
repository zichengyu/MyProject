package com.yzc.spring.controller;

import com.yzc.spring.service.base.CalculatingService;
import com.yzc.spring.service.impl.LambdaCalculatingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 21:53
 */
@RestController
@Api(tags = "计算器")
public class CalculateController {

    private final ApplicationContext applicationContext;

    public CalculateController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/calculate")
    public Integer calculate(@RequestParam String values) {
        List<Integer> param = Arrays.stream(values.split(",")).map(Integer::parseInt).collect(Collectors.toList());

		CalculatingService calculatingService = applicationContext.getBean(CalculatingService.class);
        return calculatingService.sum(param.get(0), param.get(1));
    }
}
