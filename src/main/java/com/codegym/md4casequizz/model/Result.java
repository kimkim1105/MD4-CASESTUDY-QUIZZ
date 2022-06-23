package com.codegym.md4casequizz.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_id")
    @NotNull
    private Test test;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User testUser;
    @NotBlank
    private Integer mark;

    public Result(Long id, Test test, User testUser, Integer mark) {
        this.id = id;
        this.test = test;
        this.testUser = testUser;
        this.mark = mark;
    }

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getTestUser() {
        return testUser;
    }

    public void setTestUser(User testUser) {
        this.testUser = testUser;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
