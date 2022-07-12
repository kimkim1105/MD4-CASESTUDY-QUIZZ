package com.codegym.md4casequizz.service.product;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Product;
import com.codegym.md4casequizz.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);
    Boolean existsByNameProduct(String nameProduct);
    Page<Product> findAllByNameProductContaining(String nameProduct, Pageable pageable);
}
