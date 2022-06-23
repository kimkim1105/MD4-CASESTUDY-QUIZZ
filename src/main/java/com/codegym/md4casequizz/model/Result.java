package com.codegym.md4casequizz.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

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

    public Result(Test test, Date createAt, User testUser, Integer mark) {
        this.test = test;
        this.createAt = createAt;
        this.testUser = testUser;
        this.mark = mark;
    }

    public Result() {
    }

    public Date getDate() {
        return createAt;
    }

    public void setDate(Date createAt) {
        this.createAt = createAt;
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
