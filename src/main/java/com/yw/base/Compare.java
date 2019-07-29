package com.yw.base;

import java.util.*;

/**
 * @author:YanWei
 * @date: 2019/7/29 10:47
 * @desc: Comparable和Comparator的使用
 * comparable:对象本身可比较，无需第三方，比如，学生的年龄
 * comparator：本身不可比较，或者要参与比较的对象不可修改，则使用comparator。
 * 一般使用comparable作为默认的排序，新的需求可以使用comparator改变排序方式。
 *
 */
public class Compare {
    public static void main(String[] args) {
        Student c = new Student("c",11);
        Student a = new Student("a",12);
        Student b = new Student("e",15);
        Student e = new Student("k",15);
        List<Student> students = Arrays.asList(a, b, c,e);
        Collections.sort(students, Comparator.comparing(o -> o.lover));
        students.forEach(student -> System.out.println(student));

    }
}
class Student implements Comparable<Student>{

    public Student(String lover, int age) {
        this.lover = lover;
        this.age = age;
    }

    String lover;

    int age;

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lover='" + lover + '\'' +
                ", age=" + age +
                '}';
    }
}