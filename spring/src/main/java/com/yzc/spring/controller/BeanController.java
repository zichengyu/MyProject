package com.yzc.spring.controller;

import io.swagger.annotations.Api;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 21:53
 */
@RestController
@Api(tags = "Bean信息查询")
public class BeanController {

	private final ApplicationContext applicationContext;

	public BeanController(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@GetMapping("/person/{name}")
	public String getPerson(
			@RequestParam String name
	) {
		return applicationContext.getBean(name).toString();
	}
}
