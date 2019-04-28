package com.yw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
	public static void printMethod(Object obj) {
		Class clazz = obj.getClass();
		System.out.println("类的名称是" + clazz.getName());
		// 获取该类的public方法，包含继承的
		Method[] method = clazz.getMethods();
		for (int i = 0; i < method.length; i++) {
			// 得到返回值类型对应的类类型
			Class returnType = method[i].getReturnType();
			System.out.print(returnType.getName() + " " + method[i].getName() + "(");
			// 得到参数类型
			Class[] paramType = method[i].getParameterTypes();
			for (Class class1 : paramType) {
				System.out.print(class1.getSimpleName() + ",");
			}
			System.out.println(")");

		}
	}
	public static void printFiled(Object obj) {
		Class clazz = obj.getClass();
		System.out.println("类的名称是" + clazz.getName());
		// 获取该类的public方法，包含继承的
		Field[] field = clazz.getDeclaredFields();
		for (Field field2 : field) {
			//System.out.print(field2.getModifiers()+"\t");
			//System.out.print(field2.getGenericType()+"\t");
			System.out.print(field2.getType().getName()+"\t");
			System.out.println(field2.getName());
		}
	}
	public static void printConstruct(Object obj) {
		Class clazz = obj.getClass();
		System.out.println("类的名称是" + clazz.getName());
		// 获取该类的public方法，包含继承的
		Constructor[]  c = clazz.getConstructors();
		for (Constructor constructor : c) {
			System.out.print(constructor.getName()+"(");
			Class[] cc = constructor.getParameterTypes();
			for (Class class1 : cc) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
