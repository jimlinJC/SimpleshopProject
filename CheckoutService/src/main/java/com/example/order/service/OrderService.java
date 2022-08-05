package com.example.order.service;


import com.example.order.model.LineItem;
import com.example.order.model.Product;
import com.example.order.model.SaleOrder;
import com.example.order.repo.ProductRepository;
import com.example.order.repo.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class OrderService {


    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private ProductRepository productRepository;



    public int checkout(Integer orderid) {
        Optional<SaleOrder> temporaryorder = saleOrderRepository.findById(orderid);
        if (temporaryorder.isPresent()) {
            SaleOrder saleOrder = temporaryorder.get();
            if (saleOrder.getState().equals("purchased"))
                return -1;
            List<LineItem> items = saleOrder.getLineItems();
            for (LineItem item : items) {
                Optional<Product> oproduct = productRepository.findById(item.getSku());
                if (oproduct.isPresent()) {
                    Product product = oproduct.get();
                    int quantity = product.getQuantity();
                    if (quantity >= item.getQuantity()) {
                        product.setQuantity(quantity - item.getQuantity());
                        productRepository.save(product);
                    } else {
                        throw new RuntimeException("inventory not enough");
                    }
                }
            }
            saleOrder.setCheckoutDate(LocalDateTime.now());
            saleOrder.setState("purchased");
            saleOrderRepository.save(saleOrder);
            return 1;
        } else {
            return 0;
        }
    }
}
