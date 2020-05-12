package com.yw.java8.stream;

import java.util.stream.IntStream;

/**
 * Created by 18765 on 2020/4/19 17:32
 */
public class StreamDemo {
    public static void main(String[] args) {
        intDemo();
    }

    private static void intDemo() {
        //开区间，不包含5的0-5的数组遍历
        IntStream.range(0,5).forEach(System.out::println);
        //闭区间，[0,5]
        IntStream.rangeClosed(0,5).forEach(System.out::println);
        //求平均数
        int [] ints={1,5,9,2,5,63,4,8};
        System.out.println(IntStream.of(ints).average().getAsDouble());
    }
}
