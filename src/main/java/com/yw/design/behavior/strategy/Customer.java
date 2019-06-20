package com.yw.design.behavior.strategy;

import com.yw.design.behavior.strategy.improve.CalPriceFactoryImprove;

public class Customer {
    // 购买单价
    private Double amount = 0d;
    //总共花的钱
    private Double totalAmount = 0d;
    //每个客户都有一个计算价格的策略，初始都是普通计算，即原价
    private CalPrice calPrice;

    public void buy(Double amount) {
        this.amount = amount;
        this.totalAmount += amount;
        //只有一种策略，累计减价
        //calPrice = CalPriceImproveFactory.getInstance().createCalPrice(this);
        //同时支持两种策略
        calPrice = CalPriceFactoryImprove.getInstance().createCalPrice(this);

    }

    //计算客户最终要付的钱
    public Double calLastAmount() {
        return calPrice.calPrice(amount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


}
