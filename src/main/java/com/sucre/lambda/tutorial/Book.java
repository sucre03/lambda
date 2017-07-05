package com.sucre.lambda.tutorial;

/**
 * Describe:图书
 * User:qiaolei3
 * Date:2017-07-04
 * Time:16:33
 */
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Book getInstance(){
        return new Book();
    }
}
