package com.learn.pattern.decorator_17.battercake.v2;

/**
 *
 */
public abstract class BatterCakeDecorator extends BatterCake {

	//静态代理，委派
	private BatterCake battercake;

	public BatterCakeDecorator(BatterCake battercake) {
		this.battercake = battercake;
	}

	protected abstract void doSomething();

	@Override
	protected String getMsg() {
		return this.battercake.getMsg();
	}

	@Override
	protected int getPrice() {
		return this.battercake.getPrice();
	}
}
