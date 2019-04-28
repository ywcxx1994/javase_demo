package com.yw.design.create.builder;
/**
 * 建造者模式，客户端不管人是怎么建出来的，只是调用，director负责核心的造人方法，
 * 而具体人是什么样只要实现接口就行。将职责分布的很清楚。
 * @author 18765
 *
 */
public class Cilent {
	public static void main(String[] args) {
		DirectBuilderHuman bdh = new DirectBuilderHuman();
		Human human = bdh.directBuild(new SuperHumanBuilder());
		System.out.println(human.getBody());
	}
}
