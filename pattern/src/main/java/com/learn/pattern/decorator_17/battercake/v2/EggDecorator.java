package com.learn.pattern.decorator_17.battercake.v2;

/**
 *
 */
public class EggDecorator extends BatterCakeDecorator {
	public EggDecorator(BatterCake battercake) {
		super(battercake);
	}

	protected void doSomething() {

	}

	@Override
	protected String getMsg() {
		return super.getMsg() + "+1个鸡蛋";
	}

	@Override
	protected int getPrice() {
		return super.getPrice() + 1;
	}
}
