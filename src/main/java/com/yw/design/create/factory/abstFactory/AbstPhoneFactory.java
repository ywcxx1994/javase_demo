package com.yw.design.create.factory.abstFactory;

import com.yw.design.create.factory.PhoneProduct;
import com.yw.design.create.factory.Product;

public class AbstPhoneFactory implements AbstFactory {

    @Override
    public Product getProduct() {
        return new PhoneProduct();
    }

}