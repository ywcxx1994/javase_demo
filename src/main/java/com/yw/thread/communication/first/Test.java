package com.yw.thread.communication.first;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		//公共资源（煤）
		Resource r = new Resource();
		//输入线程的任务（大卡车）
		Input i = new Input(r);
		//输出线程的任务（大卡车）
		Output o = new Output(r);
		//开启线程，执行线程任务
		Thread input= new Thread(i);
		Thread output= new Thread(o);
		input.start();
		output.start();
	}
}
