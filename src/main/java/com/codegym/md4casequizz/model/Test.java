package com.codegym.md4casequizz.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "level_id")
    @NotNull
    private Level level;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User createUser;
    @ManyToMany
    @JoinTable(name = "test_ques",
            joinColumns = @JoinColumn(name = "test_id"),inverseJoinColumns = @JoinColumn(name = "ques_id"))
    Set<Question> questions = new HashSet<>();

    public Test(Long id, String name, User createUser, Set<Question> questions) {
        this.id = id;
        this.name = name;
        this.createUser = createUser;
        this.questions = questions;
    }

    public Test() {
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
