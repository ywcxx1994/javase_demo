/**
 * @Company JBINFO
 * @Title: Client.java
 * @Package com.yw.design.pattern.proxy
 * @author Yan Wei
 * @date 2017年12月23日 上午10:47:36
 * @version V1.0
 */
package com.yw.design.structure.proxy;

import java.lang.reflect.Proxy;


/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Client {

    public void eat() {
        //目标类
        Person person = new Woman();
        //辅助类
        Assistant assistant = new Assistant();
        //准备水
        BeforAssistant basis = new BeforAssistant();
        EatIncovationHandle eat = new EatIncovationHandle(person, assistant, basis);
        Person proxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), eat);
        proxy.eat();
    }

}
