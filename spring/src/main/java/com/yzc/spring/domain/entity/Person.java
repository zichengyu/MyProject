package com.yzc.spring.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Creator      : yuzicheng
 * Created Date : 2018/8/24
 * Comment      : 21:48
 */
@Getter
@Setter
@ToString
public class Person implements Serializable {
	public int age;
	public String name;
}
