package com.learn.pattern.decorator_17.battercake.v2;

public class BaseBatterCake extends BatterCake {
	protected String getMsg() {
		return "煎饼";
	}

	public int getPrice() {
		return 5;
	}
}
