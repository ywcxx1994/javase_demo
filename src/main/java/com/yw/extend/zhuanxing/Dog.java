package com.yw.extend.zhuanxing;
/**
 * 向上转型：
 * 	Animal animal = new Dog();//把狗转成了动物，多态的典型应用
 * 向下转型
 * 	Animal animal = new Dog();
 * 	Dog d = (Dog)animal;//将一个动物强制转换成了狗
 * @author yan
 *
 */
public class Dog extends Animal{
	public static void main(String[] args) {
		Animal animal = new Dog();
		//Dog dog = (Dog)animal;
		animal.eat();
		/*if(animal instanceof Dog) {
			
		}*/
		
	}

	@Override
	protected void eat() {
		System.out.println("dog eat");
	}
}
