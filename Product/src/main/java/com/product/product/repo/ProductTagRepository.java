package com.product.product.repo;

import com.product.product.model.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Integer> {
}
