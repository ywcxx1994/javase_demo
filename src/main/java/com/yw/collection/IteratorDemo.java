package com.yw.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.yw.reflect.Student;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("asdf");
        c.add(23);
        c.add(new Student());
        //当for循环执行完，it对象不被回收
		/*Iterator it = c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
        //当for循环执行完，it对象被回收，不浪费空间。
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
