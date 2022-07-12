package com.codegym.md4casequizz.service.product;

import com.codegym.md4casequizz.model.Product;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.repository.IProductRepository;
import com.codegym.md4casequizz.security.userprincal.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    UserDetailService userDetailService;
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
         User user =userDetailService.getCurrentUser();
         product.setUser(user);
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void remove(Long id) {
    productRepository.deleteById(id);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Boolean existsByNameProduct(String nameProduct) {
        return productRepository.existsByNameProduct(nameProduct);
    }

    public Page<Product> findAllByNameProductContaining(String nameProduct, Pageable pageable) {
        return productRepository.findAllByNameProductContaining(nameProduct, pageable);
    }
}
