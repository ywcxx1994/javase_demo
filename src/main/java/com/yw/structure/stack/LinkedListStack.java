package com.yw.structure.stack;

import com.yw.structure.chain.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> ll;

    public LinkedListStack() {
        this.ll = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public int getSize() {
        return ll.getSize();
    }

    @Override
    public E peek() {
        return ll.getFirst();
    }

    @Override
    public void push(E e) {
        ll.addFirst(e);
    }

    @Override
    public E pop() {
        return ll.removeFirst();
    }

}
