package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
Boolean existsByNameProduct(String nameProduct);
Page<Product> findAllByNameProductContaining(String nameProduct, Pageable pageable);
}
