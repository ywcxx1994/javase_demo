/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package com.yw.innerClass
 * @author Yan Wei
 * @date 2017年12月27日 下午5:26:49
 * @version V1.0
 */
package com.yw.innerClass;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class Test {
    public static void main(String[] args) {
        //匿名内部类
        NameLost nl = new NameLost() {
            @Override
            public void show() {
                System.out.println("hahah");
            }
        };
        nl.show();
    }
}
