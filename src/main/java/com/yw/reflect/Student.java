package com.yw.reflect;

import java.lang.annotation.Annotation;

@Test(value = "fuck", name = "hello")
public class Student {
    private String sing() {
        System.out.println("sing invoking");
        return "im sing";
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        //	String s="sfd";
        //	ClassUtil.printConstruct(s);
        Class clazz = s1.getClass();
        clazz.isAnnotation();
        Test t = (Test) clazz.getAnnotation(Test.class);
        System.out.println(t.value() + t.name());
        System.out.println(clazz.getAnnotations().length);

    }
}
