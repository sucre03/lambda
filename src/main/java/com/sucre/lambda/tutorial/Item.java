package com.sucre.lambda.tutorial;

import java.math.BigDecimal;

/**
 * Describe:用于lambda的实体
 * User:qiaolei3
 * Date:2017-07-05
 * Time:14:32
 */
public class Item {
    private String name;
    private int qty;
    private BigDecimal price;

    private Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public static Item getInstance(String name, int qty, BigDecimal price){
        return new Item(name, qty, price);
    }
}
