package com.learn.pattern.strategy_18.pay.payport;

public class AliPay extends Payment {

	public String getName() {
		return "支付宝";
	}

	protected double queryBalance(String uid) {
		return 900;
	}

}
