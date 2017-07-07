package com.sucre.lambda.tutorial;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

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
                fruits.stream().collect(groupingBy(Function.identity(), counting()));
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
                .collect(groupingBy(Item::getName,counting()));
        System.out.println(counting);
        Map<String,Integer> sum = items.stream()
                .collect(groupingBy(Item::getName,summingInt(Item::getQty)));
        System.out.println("1======:"+sum);
        Map<BigDecimal,List<Item>> groupByPriceMap = items.stream().collect(groupingBy(Item::getPrice));
        System.out.println("2======:"+groupByPriceMap);
        Map<BigDecimal,Set<String>> res = items.stream().collect(groupingBy(Item::getPrice,mapping(Item::getName,toSet())));
        System.out.println("3======:"+res);
        Map<BigDecimal,String> res1 = items.stream().collect(groupingBy(Item::getPrice,mapping(Item::getName, joining(";"))));
        System.out.println(res1+"===");
        Optional<String> max = items.stream().max(Comparator.comparing(Item::getPrice)).map(Item::getName);
        System.out.println("max price fruit is:"+max.orElse(""));
        //在List上使用partitioningBy，满足条件的生成一个List，不满足条件的生成另一个List
        Map<Boolean,List<Item>> pm = items.stream().collect(partitioningBy(t->t.getQty()==10));
        pm.entrySet().stream().forEach(t->
            System.out.println(t.getKey()+":"+t.getValue()));
    }


}
