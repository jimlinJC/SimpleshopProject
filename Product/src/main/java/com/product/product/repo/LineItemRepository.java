package com.product.product.repo;

import com.product.product.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
}
