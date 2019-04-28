package com.yw.design.create.factory;

import com.yw.design.create.factory.abstFactory.AbstFactory;
import com.yw.design.create.factory.abstFactory.AbstPhoneFactory;

public class Test {
	public static void main(String[] args) {
		//simple factory test
		//System.out.println(ProductFactory.getProduct(""));
		AbstFactory factory = new AbstPhoneFactory();
		System.out.println(factory.getProduct());
	}
}
