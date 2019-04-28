package com.yw.design.create.factory.easy;

import com.yw.design.create.factory.ComputerProduct;
import com.yw.design.create.factory.PhoneProduct;
import com.yw.design.create.factory.Product;
import com.yw.extend.FuckException;
/**
 * 
* @ClassName: ProductFactory 
* @Description: 简单工厂，违背了开闭原则，对修改关系
* @author Yan Wei
 */
public class ProductFactory {
	public static Product getProduct(String flag) {
		if(flag ==null) {
			throw new FuckException("are you creazy");
		}
		if(flag.equals("1")) {
			return new PhoneProduct();
		}else {
			return new ComputerProduct();
		}
	}
}