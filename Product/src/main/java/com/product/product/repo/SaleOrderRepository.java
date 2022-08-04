package com.product.product.repo;

import com.product.product.model.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder,Integer> {
}
