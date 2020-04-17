package com.learn.pattern.strategy_18.promotion;

/**
 * 优惠活动
 */
public class PromotionActivity {
	private PromotionStrategy promotionStrategy;

	public PromotionActivity(PromotionStrategy promotionStrategy) {
		this.promotionStrategy = promotionStrategy;
	}

	public void execute() {
		promotionStrategy.doPromotion();
	}

}
