package com.learn.pattern.strategy_18.promotion;

/**
 * 无优惠
 */
public class EmptyStrategy implements PromotionStrategy {
	public void doPromotion() {
		System.out.println("无促销活动");
	}
}
