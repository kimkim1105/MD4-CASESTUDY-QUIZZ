package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Product;
import com.codegym.md4casequizz.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> pageProduct(@PageableDefault(sort = "nameProduct",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Product> productPage=productService.findAll(pageable);
        if (productPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        if (product.getNameProduct()==null){
            return new ResponseEntity<>(new ResponMessage("no_nameProduct"),HttpStatus.OK);
        }
        if (product.getAvatarProduct()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatarProduct"),HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponMessage("create Product success!!!"),HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchByNameProductContaining(@RequestParam ("nameProduct") String search,@PageableDefault(sort = "nameProduct",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Product> productPage=productService.findAllByNameProductContaining(search,pageable);
        if (productPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(productOptional.get().getId());
        return new ResponseEntity<>(new ResponMessage("delete success"), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detailProduct(@PathVariable Long id){
        Optional<Product> product=productService.findById(id);
        if (!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product){
        Optional<Product> productOptional=productService.findById(id);
        if (!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (productService.existsByNameProduct(product.getNameProduct())){
            return new ResponseEntity<>(new ResponMessage("product name is existed"),HttpStatus.OK);
        }

        productOptional.get().setNameProduct(product.getNameProduct());
        productOptional.get().setAvatarProduct(product.getAvatarProduct());
        productOptional.get().setDescription(product.getDescription());
        productService.save(productOptional.get());
        return new ResponseEntity<>(new ResponMessage("update success"),HttpStatus.OK);
    }
}
