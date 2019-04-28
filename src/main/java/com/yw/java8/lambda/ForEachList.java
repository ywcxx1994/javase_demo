package com.yw.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class ForEachList {
	public static void main(String[] args) {
		System.out.println("111");
		List<String> strings = Arrays.asList("aaa","bbb","ccc");
		//第一种
		strings.forEach(item->{System.out.println(item);});
		//第二种,println方法当做参数传给遍历的每一个元素
		strings.forEach(System.out::println);
	}
}
