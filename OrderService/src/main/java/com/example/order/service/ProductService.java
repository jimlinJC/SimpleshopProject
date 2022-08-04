package com.example.order.service;


import com.example.order.model.Product;
import com.example.order.repo.ProductRepository;
import com.example.order.repo.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTagRepository productTagRepository;



    public Product addProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }


}
