package com.yw.java8;

import java.util.Optional;

/**
 * @author: yanwin
 * @Date: 2020/4/9
 */
public class OptionDemo {
    public void create(){
        //只能接受一个非空对象，否则NPE
        Optional<Integer> integer = Optional.of(1);
        //可以接受一个空或者不空对象
        Optional<Integer> integer2 = Optional.ofNullable(1);
    }
    public void isPresent(){
        //只能接受一个非空对象，否则NPE
        Optional<Integer> integer = Optional.ofNullable(null);
        //相当于非空判断。
        System.out.println(integer.isPresent());
    }
    public static void main(String[] args) {
        //只能接受一个非空对象，否则NPE
        Optional<Integer> integer = Optional.ofNullable(1);
        System.out.println(integer.orElse(100) == 1);
    }
}
