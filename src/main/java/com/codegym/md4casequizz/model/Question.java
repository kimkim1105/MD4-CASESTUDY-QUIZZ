package com.codegym.md4casequizz.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String content;
    @ManyToOne
    @JoinColumn(name = "level_id")
    @NotNull
    private Level level;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

    public Question() {
    }

    public Question(Long id, String content, Level level, Category category) {
        this.id = id;
        this.content = content;
        this.level = level;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

