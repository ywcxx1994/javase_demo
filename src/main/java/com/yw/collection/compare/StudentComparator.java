package com.yw.collection.compare;

import com.yw.structure.array.Main;

import java.util.Comparator;

/**
 * @author:YanWei
 * @date: 2019/6/20 18:50
 * @desc: 学生比较器
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.lover.compareTo(o1.lover);
    }

    public static void main(String[] args) {
        Student s1 = new Student(178,"a");
        Student s2 = new Student(183,"b");
        StudentComparator sc = new StudentComparator();
        System.out.println( sc.compare(s1,s2));
    }
}
