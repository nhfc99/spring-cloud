package com.nhfc99.eureka_product.service;

import com.nhfc99.eureka_product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    static ArrayList<Product> arrayList = new ArrayList<>();

    static {
        Product product1 = new Product(2, "xx", 1, 1);
        Product product2 = new Product(2, "xx", 1, 1);
        Product product3 = new Product(2, "xx", 1, 1);
        Product product4 = new Product(2, "xx", 1, 1);
        Product product5 = new Product(2, "xx", 1, 1);
        Product product6 = new Product(2, "xx", 1, 1);
        Product product7 = new Product(2, "xx", 1, 1);

        arrayList.add(product1);
        arrayList.add(product2);
        arrayList.add(product3);
        arrayList.add(product4);
        arrayList.add(product5);
        arrayList.add(product6);
        arrayList.add(product7);
    }

    /**
     * 获取商品列表
     * @return
     */
    public List<Product> listProduct() {
        return ProductService.arrayList;
    }
}
