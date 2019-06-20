package com.yw.structure.queue;

import com.yw.structure.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front(队首) [");
        for (int i = 0; i <= array.getSize() - 1; i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail(队尾)");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            //每enqueue三次，则dequeue一次
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
