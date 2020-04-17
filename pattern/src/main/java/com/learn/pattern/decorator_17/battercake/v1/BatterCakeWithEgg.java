package com.learn.pattern.decorator_17.battercake.v1;

public class BatterCakeWithEgg extends BatterCake {
	@Override
	protected String getMsg() {
		return super.getMsg() + "+1个鸡蛋";
	}

	@Override
	//加一个鸡蛋加1块钱
	public int getPrice() {
		return super.getPrice() + 1;
	}
}
