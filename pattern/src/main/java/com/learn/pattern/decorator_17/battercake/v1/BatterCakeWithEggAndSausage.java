package com.learn.pattern.decorator_17.battercake.v1;

public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {
	@Override
	protected String getMsg() {
		return super.getMsg() + "+1根香肠";
	}

	@Override
	//加一个香肠加2块钱
	public int getPrice() {
		return super.getPrice() + 2;
	}
}
