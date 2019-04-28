package com.yw.structure.chain;

public class LinkedList<E> {
	// 内部类
	private class Node {
		// 属性设置成public提供给外部类（linkedlist）访问
		public E e;
		public Node next;

		// 三个构造函数
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	private int size;
	//虚拟头节点，真是存在的节点，但是不存元素。存在的位置就是索引为0的元素之前的位置
	private Node dummyHead;

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public LinkedList() {
		dummyHead = new Node(null,null);
		size = 0;
	}


	/**
	 * 在指定位置添加元素,关键是找到指定索引位置的前一个元素
	 * @param index
	 * @param e
	 */
	public void add(int index,E e) {
		if(index<0 || index>size) {
			throw new IllegalArgumentException("索引位置不正确！");
		}
		//找到指定索引位置的前一个元素A，建立关系。
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
//			Node node = new Node(e);
		//插入节点的next变成了原来A节点的next
//			node.next = prev.next;
		//A节点的next变为了现在的node
//			prev.next = node;
		prev.next = new Node(e,prev.next);
		size++;
	}
	public void addFirst(E e) {
//		Node node = new Node(e);
//		node.next = head;
//		head = node;
		
		this.add(0, e);
	}
	
	public void addLast(E e) {
		this.add(size, e);
	}
	
	public E get(int index) {
		if(index<0 || index>size) {
			throw new IllegalArgumentException("索引位置不正确！");
		}
		//索引为0的位置上的元素
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	public E getFirst() {
		return this.get(0);
	}
	public E getLast() {
		return this.get(size-1);
	}
	
	public void set(int index,E e) {
		if(index<0 || index>size) {
			throw new IllegalArgumentException("索引位置不正确！");
		}
		//索引为0的位置上的元素
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	
	public boolean constains(E e) {
		Node cur = dummyHead.next;
		while(cur!=null) {
			if(cur.e.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	
	public E remove(int index) {
		if(index<0 || index>size) {
			throw new IllegalArgumentException("索引位置不正确！");
		}
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
		//待删除的节点
		Node cur = prev.next;
		prev.next = cur.next;
		cur.next = null;
		size--; 
		return cur.e;
	}
	public E removeFirst(){
		return this.remove(0);
	}
	
	public E removeLast(){
		return this.remove(size-1);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node cur = dummyHead.next;cur!=null;cur = cur.next) {
			sb.append(cur+"->");
		}
		sb.append("NULL");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i=0;i<5;i++) {
			ll.addFirst(i);
			System.out.println(ll);
		}
		ll.add(3, 38);
		System.out.println(ll);
		System.out.println(ll.getLast());
	}
}
