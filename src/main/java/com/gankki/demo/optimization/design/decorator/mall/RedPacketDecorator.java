package com.gankki.demo.optimization.design.decorator.mall;

import java.math.BigDecimal;

/**
 * 计算使用红包后的金额
 * @author admin
 *
 */
public class RedPacketDecorator extends BaseCountDecorator{

	public RedPacketDecorator(IBaseCount count) {
		super(count);
	}
	
	@Override
	public BigDecimal countPayMoney(OrderDetail orderDetail) {
		super.countPayMoney(orderDetail);
		return countCouponPayMoney(orderDetail);
	}
	
	private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
		
		BigDecimal redPacket = orderDetail.getMerchandise().getSupportPromotions().get(PromotionType.REDPACKED).getUserRedPacket().getRedPacket();
		System.out.println("红包优惠金额：" + redPacket);
		
		orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(redPacket));
		return orderDetail.getPayMoney();
	}
}
