/**
 * @Company JBINFO
 * @Title: Test.java
 * @Package cn.jbinfo.oasis.system.plugin.aop
 * @author Yan Wei
 * @date 2018年4月18日 下午3:12:36
 * @version V1.0
 */
package com.yw;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yan Wei
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Test.countMap();
    }

    /**
     * @param a
     * @param b
     * @Description: 获取方法参数列表的注解
     * @author Yan Wei
     * @date 2018年4月19日 上午11:39:01
     */
    public static void test(@Deprecated String a, @Deprecated Integer b) {
        Method[] me = Test.class.getMethods();
        for (int i = 0; i < me.length; i++) {
            if (me[i].getName().equals("test")) {
                Annotation[][] annos = me[i].getParameterAnnotations();
                for (int j = 0; j < annos.length; j++) {
                    System.out.println(annos[j]);
                }
            }

        }
        System.out.println(a + "\t" + b);
    }

    /**
     * Description: 利用map的key不能重复，统计出现的数量
     *
     * @author Yan Wei
     * @date 2018年4月18日 下午4:26:13
     */
    private static void countMap() {
        List<String> asList = Arrays.asList("aa", "bb", "c", "aa", "bb");
        Map<String, Integer> map = new HashMap<>();
        asList.forEach(item -> {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        });
        map.forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });
    }

    /**
     * Description: 二维数组求和
     *
     * @author Yan Wei
     * @date 2018年4月18日 下午4:14:44
     */
    private static void arrTwo() {
        int[][] arr = {{5, 7, 9}, {12, 14, 16, 18}, {23, 25, 36, 47}, {22, 54, 65, 15}, {22, 34}};
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                a += arr[i][j];
            }
        }
        System.out.println(a);
    }
}
