package com.yw.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");
        ketSetDemo(map);
        entrySetDemo(map);
        //遍历所有的values
        map.values().forEach(System.out::println);
        map.forEach((k, v) -> System.out.println(k + "/t" + v));

    }

    /**
     * 测试遍历map的entrySet方法
     *
     * @param map
     */
    private static void entrySetDemo(Map<String, String> map) {
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> mapset = it.next();
            System.out.println(mapset.getKey() + "--" + mapset.getValue());
        }
    }

    /**
     * keySet()方法测试
     *
     * @param map
     */
    private static void ketSetDemo(Map<String, String> map) {
        Set<String> set = map.keySet();
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

}
