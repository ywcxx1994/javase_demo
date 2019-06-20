package com.yw.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodDemo {
    @Test(name = "222")
    public Student demo(@Test(name = "aaa") String name, @Test(name = "bbb") Integer age) throws RuntimeException {
        return new Student();
    }

    public static void main(String[] args) throws Exception {
        Method method = MethodDemo.class.getMethod("demo", String.class, Integer.class);
        System.out.println(method.getAnnotation(Test.class).value());
        System.out.println(Modifier.toString(method.getModifiers()));
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotations : parameterAnnotations) {
            System.out.println(annotations.length);
        }
//		System.out.println(method.getExceptionTypes());
    }
}
