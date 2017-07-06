package com.sucre.lambda.tutorial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Describe:java8中日期转的方法
 * User:qiaolei3
 * Date:2017-07-06
 * Time:10:54
 */
public class DateTest {
    public static void main(String[] args) {
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("1===:"+localDateTime.format(dtf));
        System.out.println("2===:"+dtf.format(localDateTime));
        String now = "2017-07-06 10:59:06";
        localDateTime = LocalDateTime.parse(now,dtf);
        System.out.println("3===:"+dtf.format(localDateTime));
    }
}
