package com.nhfc99.eureka_product.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    public Product(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private int price;
    /**
     * 库存
     */
    private int store;
}
