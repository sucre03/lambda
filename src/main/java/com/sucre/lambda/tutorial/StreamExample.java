package com.sucre.lambda.tutorial;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Describe:stream的调试
 * User:qiaolei3
 * Date:2017-06-30
 * Time:14:03
 */
public class StreamExample {
    public static void main(String[] args) {
        Book b1 = Book.getInstance();
        b1.setName("java");
        Book b2 = Book.getInstance();
        b2.setName("scala");
        Book b3 = Book.getInstance();
        b3.setName("python");
        Book b4 = Book.getInstance();
        b4.setName("go");
        Book b5 = Book.getInstance();
        b5.setName("c++");
        Book b6 = Book.getInstance();
        b6.setName("c#");
        Book b7 = Book.getInstance();
        b7.setName("docker");

        List<Book> lists = Arrays.asList(b1,b2,b3,b4,b5,b6,b7);

        //lists.stream().min(Comparator.comparing(Book::getName));
        Optional<Book> optional = Optional.of(b1);
        System.out.println(optional.orElse(b2).getName());
        List<String> fruits = Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String,Long> result =
                fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        //LinkedHashMap的顺序默认为插入顺序
        Map<String,Long> finalMap = Maps.newLinkedHashMap();
        result.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .forEachOrdered(t->finalMap.put(t.getKey(),t.getValue()));
        System.out.println(finalMap);
        //group by and count
        List<Item> items = Arrays.asList(
                Item.getInstance("apple", 10, new BigDecimal("9.99")),
                Item.getInstance("banana", 20, new BigDecimal("19.99")),
                Item.getInstance("orange", 10, new BigDecimal("29.99")),
                Item.getInstance("watermelon", 10, new BigDecimal("29.99")),
                Item.getInstance("papaya", 20, new BigDecimal("9.99")),
                Item.getInstance("apple", 10, new BigDecimal("9.99")),
                Item.getInstance("banana", 10, new BigDecimal("19.99")),
                Item.getInstance("apple", 10, new BigDecimal("9.99"))
        );
        Map<String,Long> counting = items.stream()
                .collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
        System.out.println(counting);
        Map<String,Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));
        System.out.println(sum);
    }


}
