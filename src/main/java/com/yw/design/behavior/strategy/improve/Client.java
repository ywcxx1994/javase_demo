/**
* @Company JBINFO   
* @Title: Client.java 
* @Package com.yw.design.behavior.strategy.improve 
* @author Yan Wei   
* @date 2018年3月26日 上午11:58:02 
* @version V1.0   
*/ 
package com.yw.design.behavior.strategy.improve;

import com.yw.design.behavior.strategy.Customer;

/** 
* @ClassName: Client 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
public class Client {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(500D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(2600D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
    }
    
}