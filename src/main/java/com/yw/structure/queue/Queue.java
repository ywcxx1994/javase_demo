package com.yw.structure.queue;

public interface Queue<E> {
	
	boolean isEmpty();
	
	int getCapacity();
	//像队列中添加元素
	void enqueue(E e);
	//从队列中获取元素
	E dequeue();
	//获取队首的元素
	E getFront();
}
