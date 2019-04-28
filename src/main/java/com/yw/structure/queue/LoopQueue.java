package com.yw.structure.queue;

import com.yw.structure.queue.Queue;
/**
 * 循环队列的实现
 * @author 18765
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
	//数据
	private E[] data;
	//队列的队首索引
	private int front;
	//队尾+1处的索引
	private int tail;
	//队列的大小
	private int size;
	public LoopQueue() {
		//队列中留出一位，便于实现循环。故要在用户期待的容量+1构成数据
		this.data = (E[])new Object[10+1];
		this.front=0;
		this.tail=0;
		this.size=0;
	}
	public LoopQueue(int capacity) {
		//队列中留出一位，便于实现循环。故要在用户期待的容量+1构成数据
		this.data = (E[])new Object[capacity+1];
		this.front=0;
		this.tail=0;
		this.size=0;
	}
	/**
	 * 如果队首和队尾+1相等，则队列为null
	 */
	@Override
	public boolean isEmpty() {
		return this.front == tail;
	}

	@Override
	public int getCapacity() {
		return data.length-1;
	}

	@Override
	public void enqueue(E e) {
		//入队的时候，tail表示这个元素该在位置的索引，front表示位于队首位置元素的索引，当tail+1==front时，表示队列满了。需要扩容
		if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        //假如front在倒数第一个位置上，那么重新回到索引为0的位置
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
	}

	@Override
	public E getFront() {
		if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
	}
	private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }
	 @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
