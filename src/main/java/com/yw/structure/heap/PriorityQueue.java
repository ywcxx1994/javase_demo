package com.yw.structure.heap;

import com.yw.structure.queue.Queue;
/**
 * 
 * @author 18765
 *
 * @param <E>
 * 利用最大堆，实现一个优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
	private MaxHeap<E> maxHeap;
	
	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public int getCapacity() {
		return maxHeap.getSize();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extract();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}
	
	public int getSize() {
		return maxHeap.getSize();
	}
}
