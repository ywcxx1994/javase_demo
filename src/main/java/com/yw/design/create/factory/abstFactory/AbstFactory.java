package com.yw.design.create.factory.abstFactory;

import com.yw.design.create.factory.Product;

/**
 * @author Yan Wei
 * @ClassName: AbstFactory
 * @Description:工厂模式： 提供一个的抽象产品，让子类实现具体的实现。
 * 提供一个抽象工厂，生产这个产品，让子类具体工厂，来决定怎样生产。
 * 总的来说，是提供一个抽象工厂，一个抽象产品，客户端是实现具体的。
 */
public interface AbstFactory {
    Product getProduct();
}