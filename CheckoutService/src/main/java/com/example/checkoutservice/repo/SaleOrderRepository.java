package com.example.checkoutservice.repo;

import com.example.checkoutservice.model.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder,Integer> {
}
