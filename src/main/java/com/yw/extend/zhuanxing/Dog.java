package com.yw.extend.zhuanxing;

import java.util.Arrays;
import java.util.List;

/**
 * 向上转型：
 * Animal animal = new Dog();//把狗转成了动物，多态的典型应用
 * 向下转型
 * Animal animal = new Dog();
 * Dog d = (Dog)animal;//将一个动物强制转换成了狗
 *
 * @author yan
 */
public class Dog extends Animal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Dog();
        animal.eat();

        List<Animal> animals = Arrays.asList(animal);
        List<Dog> dogs = Arrays.asList(dog);
//        Dog.testFenXin(dogs);
        Dog.testFenXin2(dogs);

    }

    @Override
    protected void eat() {
        System.out.println("dog eat");
    }

    public static void testFenXin(List<Animal> demo){

    }
    public static void testFenXin2(List<? extends Animal> demo){

    }
}
