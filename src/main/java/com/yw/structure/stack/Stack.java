package com.yw.structure.stack;
/**
 * 栈内存的公共接口
 * @author 18765
 *
 * @param <E>
 */
public interface Stack<E> {
	boolean isEmpty();
	int getSize();
	//栈顶的元素
	E peek();
	//添加元素
	void push(E e);
	//弹出元素
	E pop();
	
}
