package com.yw.structure.stack;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>();
		for(int i=0;i<10;i++) {
			stack.push(i);
			System.out.println(stack);
		}
		for(int i=0;i<10;i++) {
			stack.pop();
			System.out.println(stack);
		}
//		stack.pop();
//		System.out.println(stack);
	}
}
