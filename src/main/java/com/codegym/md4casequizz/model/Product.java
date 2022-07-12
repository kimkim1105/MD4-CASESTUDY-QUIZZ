package com.codegym.md4casequizz.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameProduct;
    private String description;
    private String avatarProduct;

    @ManyToOne
    Category category;
    @ManyToOne
    User user;


    public Product() {
    }

    public Product(Long id, String nameProduct, String description, String avatarProduct, Category category, User user) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.avatarProduct = avatarProduct;
        this.category = category;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product(Long id, String nameProduct, String description, String avatarProduct, Category category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.avatarProduct = avatarProduct;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarProduct() {
        return avatarProduct;
    }

    public void setAvatarProduct(String avatarProduct) {
        this.avatarProduct = avatarProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
