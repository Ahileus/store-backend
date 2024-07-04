package com.ivanrudik.store.repository;

import com.ivanrudik.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
