package com.yw.design.create.factory.abstFactory;

import com.yw.design.create.factory.ComputerProduct;
import com.yw.design.create.factory.Product;

public class AbstComputerFactory implements AbstFactory{

	@Override
	public Product getProduct() {
		return new ComputerProduct();
	}

}