package com.yw.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射，调用内部类的属性
 * @author 18765
 *
 */
public class OutClass {

	private class InnerClass{
		
		public InnerClass() {
		}

		public String name="innner class1111";
	}
	
	public static void main(String[] args) throws Exception{
		Class clazz = OutClass.class;
		Object newInstance = clazz.newInstance();
		Class[] declaredClasses = clazz.getDeclaredClasses();
		for (Class class1 : declaredClasses) {
			int modifiers = class1.getModifiers();
			if("private".equals(Modifier.toString(modifiers))) {
				Field field = class1.getField("name");
				Constructor constructor = class1.getConstructor(clazz);
				constructor.setAccessible(true);
				Object newInstance2 = constructor.newInstance(newInstance);
				System.out.println(field.get(newInstance2));
			}
		}

	}
}
