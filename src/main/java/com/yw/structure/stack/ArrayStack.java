package com.yw.structure.stack;

import com.yw.structure.array.Array;
/**
 * 
 * @author 18765
 *基于数组，实现栈的数据结构
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
	
	Array<E> array;
	
	//指定容量的栈
	public ArrayStack(int capacity) {
		this.array = new Array<E>(capacity);
	}
	//默认十个数量级
	public ArrayStack() {
		this.array = new Array<E>(10);
	}
	
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("Stack: ");
		for (int i = 0; i <= array.getSize()-1; i++) {
			sb.append(array.get(i));
			if(i != array.getSize()-1) {
				sb.append(", ");
			}
		}
		sb.append("] Top");
		return sb.toString();
	}
}
