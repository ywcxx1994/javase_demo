package com.yw.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存溢出
 * Created by 18765 on 2019/9/23 21:32
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe.hashCode());
        while (true){
            unsafe.allocateMemory(_1M);
        }
    }
}
