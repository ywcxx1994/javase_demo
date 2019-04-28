package com.yw.design.behavior.strategy;

public class Client {
	 public static void main(String[] args) {
	        Customer customer = new Customer();
	        customer.buy(500D);
	        System.out.println("客户需要付钱：" + customer.calLastAmount());
	        customer.buy(1200D);
	        System.out.println("客户需要付钱：" + customer.calLastAmount());
	        customer.buy(1200D);
	        System.out.println("客户需要付钱：" + customer.calLastAmount());
	        customer.buy(500D);
	        System.out.println("客户需要付钱：" + customer.calLastAmount());
	    }
	 
}
