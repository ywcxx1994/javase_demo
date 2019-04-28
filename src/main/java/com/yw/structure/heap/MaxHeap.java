package com.yw.structure.heap;

import java.util.Random;

/**
 * 借助数组，实现一下最大堆，二叉树的父节点的值永远比子节点大
 * @author 18765
 *
 */
public class MaxHeap<E extends Comparable<E>> {
	
	private Array<E> array;
	
	public MaxHeap(int capacity) {
		this.array = new Array<>(capacity);
	}
	public MaxHeap() {
		this.array = new Array<>();
	}
	
	public int getSize() {
		return array.getSize();
	}
	
	public boolean isEmpty() {
		return array.isEmpty();
	}
	//返回指定索引的父节点的索引
	public int parent(int index) {
		if(index ==0 )
			throw new IllegalArgumentException("根节点没有父节点");
		return (index-1)/2;
	}
	//指定索引的左子节点的索引
	public int leftChild(int index) {
		return index*2 + 1 ;
	}
	
	//指定索引的右子节点的索引
	public int rightChild(int index) {
		return index*2 + 2 ;
	}
	
	public void add(E e) {
		array.addLast(e);
		siftUp(array.getSize()-1);
	}
	//上浮元素
	private void siftUp(int index) {
		//上浮的条件：当这个节点不是根节点，并且比父节点大的时候，就上浮
		while(index >0 && array.get(index).compareTo(array.get(parent(index))) > 0) {
			//当前元素和父亲元素交换位置
			array.swap(index, parent(index));
			//下次循环的当前元素从父亲元素开始
			index = parent(index);
		}
	}
	//查看堆中最大元素
	public E findMax() {
		if(this.isEmpty()) {
			throw new RuntimeException("findMax is fail when heap is empty@!");
		}
		return array.get(0);
	}
	//取出堆中最大的元素(取出并删除)
	public E extract() {
		E max = this.findMax();
		//交换位置，最大的跑到堆中最后一个元素
		array.swap(0, getSize()-1);
		//将最后一个删除
		array.removeLast();
		//这时候堆的第一个元素不符合堆的性质，故下沉找到合适的位置
		siftDown(0);
		return max;
	}
	private void siftDown(int index) {
		
		//如果没有左孩子，循环肯定结束
		while(leftChild(index) < array.getSize()) {
			//比较左右两个孩子，拿出最大的和当前index位置元素比较
			//假设左孩子是当前位置左右孩子中大的一个
			int max = leftChild(index);
			//max+1 < array.getSize()表示存在右孩子节点，
			if(max+1 < array.getSize() && array.get(max+1).compareTo(array.get(max))>0) {
				max = max+1;
			}
			//经过以上操作，max位置就是两个孩子节点中大的哪一个。
			if(array.get(index).compareTo(array.get(max))>=0) 
				break;
			array.swap(index, max);
			//下一轮循环从max位置开始
			index = max;
			
		}
	}
	public static void main(String[] args) {
		int n = 100000;
		MaxHeap<Integer> mh = new MaxHeap<>();
		Random random  = new Random();
		for(int i=0;i<n;i++) {
			mh.add(random.nextInt(Integer.MAX_VALUE));
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = mh.extract();
		}
		for (int i = 1; i < n; i++) {
			if(arr[i-1] < arr[i]) {
				throw new RuntimeException("Error");
			}
			
		}
		System.out.println("good");
	}
}
