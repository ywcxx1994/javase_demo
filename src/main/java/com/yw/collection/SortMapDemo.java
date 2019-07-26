/**
 * @Company JBINFO
 * @Title: SortMapDemo.java
 * @Package com.yw.collection
 * @author Yan Wei
 * @date 2018年7月25日 上午10:09:28
 * @version V1.0
 */
package com.yw.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName: SortMapDemo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yan Wei
 */
public class SortMapDemo {
    public static void main(String[] args) {
        Map<String, String> inMap = new HashMap<>();
        inMap.put("3", "333");
        inMap.put("1", "111");
        inMap.put("2", "222");
        inMap.forEach((k, v) -> System.out.println(k + "\t" + v));

        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("d", 2);
        map1.put("c", 1);
        map1.put("b", 1);
        map1.put("a", 4);
        map1.forEach((k, v) -> System.out.println(k + "\t" + v));
        System.out.println("+++++++++++++++");
        SortedMap<String, Integer> smap = new TreeMap<>();
        smap.put("q", 1);
        smap.put("d", 2);
        smap.put("f", 3);
        smap.put("g", 4);
        smap.put("v", 5);
        smap.forEach((k, v) -> System.out.println(k + "\t" + v));
        SortedMap<TreeMapDemo, Integer> sortedMap = new TreeMap<>();
        TreeMapDemo treeMapDemo1 = new TreeMapDemo("a",12);
        TreeMapDemo treeMapDemo2 = new TreeMapDemo("a",6);
        TreeMapDemo treeMapDemo3 = new TreeMapDemo("a",18);
        sortedMap.put(treeMapDemo1,12);
        sortedMap.put(treeMapDemo2,12);
        sortedMap.put(treeMapDemo3,12);
        sortedMap.forEach((k, v) -> System.out.println(k.toString() + "\t" + v));
    }
    static class TreeMapDemo implements Comparable<TreeMapDemo>{
        public String name;
        public int age;

        public TreeMapDemo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(TreeMapDemo o) {
            return o.age-this.age;
        }

        @Override
        public String toString() {
            return "TreeMapDemo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
