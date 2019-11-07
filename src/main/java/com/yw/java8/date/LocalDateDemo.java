package com.yw.java8.date;

import java.time.LocalDate;

/**
 * Created by 18765 on 2019/11/6 9:02
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
    }
}
