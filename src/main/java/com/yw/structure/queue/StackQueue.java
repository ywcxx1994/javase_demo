package com.yw.structure.queue;

import java.util.Stack;
/**
 * 两个栈实现队列
 * @author 18765
 *
 */
public class StackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int e) {
    	stack1.push(e);
    }
    
    public Integer pop() {
    	if(stack2.empty()) {
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
    
    
    public static void main(String[] args) {
    	StackQueue sq = new StackQueue();
		for(int i=0;i<10;i++) {
			sq.push(i);
		}
		for(int i=0;i<10;i++) {
			System.out.println(sq.pop());
		}
	}
}