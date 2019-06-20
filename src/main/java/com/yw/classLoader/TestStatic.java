/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package com.yw.classLoader
 * @author Yan Wei
 * @date 2018年4月6日 上午12:51:26
 * @version V1.0
 */
package com.yw.classLoader;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class TestStatic {
    //	static {
//		System.out.println("static 1");
//	}
    private static int count1; // step 2
    private static int count2 = 2; // step 3
    private static TestStatic tester = new TestStatic(); // step 1

    public TestStatic() { // step 4
        count1++;
        count2++;
        System.out.println("" + count1 + "\t" + count2);
    }

    static {
        System.out.println("static2 running" + count1);
    }

    public static TestStatic getTester() { // step 5
        System.out.println(count1 + "\t" + count2);
        return tester;
    }

    public static void main(String[] args) {
        System.out.println(TestStatic.getTester());
    }
}
