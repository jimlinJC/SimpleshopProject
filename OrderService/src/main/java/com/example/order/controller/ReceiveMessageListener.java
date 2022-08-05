package com.example.order.controller;


import com.example.order.model.Product;
import com.example.order.service.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessageListener {

    @Autowired
    ProductService productService;

    /**
     * 監聽Queue中是否有資料，若有資料則進行消費。
     * @param product
     */
//    @RabbitListener(queues={"tpu.queue"})
//    public Product receive(Product product) {
//        try {
//            Product newProduct = productService.addProduct(product);
//            return newProduct;
//        } catch (Exception e) {
//            Product newProduct = new Product();
//            newProduct.setName("null");
//            return newProduct;
//        }
//    }

}