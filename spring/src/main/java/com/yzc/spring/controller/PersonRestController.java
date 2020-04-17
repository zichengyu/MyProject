package com.yzc.spring.controller;

import com.yzc.spring.domain.entity.Person;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 21:53
 */
@RestController
@Api(tags = "用户和管理")
public class PersonRestController {

	@GetMapping("/person/{id}")
	public Person getPerson(
			@PathVariable("id") int id,
			@RequestParam(required = false) String name
	) {
		Person person = new Person();
		person.setAge(id);
		person.setName(name);
		return person;
	}
}
