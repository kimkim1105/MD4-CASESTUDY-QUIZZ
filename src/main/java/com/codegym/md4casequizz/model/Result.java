package com.codegym.md4casequizz.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
//    @NotBlank
    private User user;
    private Integer mark;

    @ManyToMany
    @JoinTable(name = "result_answer",
            joinColumns = @JoinColumn(name = "result_id"),inverseJoinColumns = @JoinColumn(name = "answer_id"))
    List<Answer> answers = new ArrayList<>();

    public Result(Long id, Test test, User user, Integer mark) {
        this.id = id;
        this.test = test;
        this.user = user;
        this.mark = mark;
    }

    public Result(Test test, Date date, User user, Integer mark) {
        this.test = test;
        this.date = date;
        this.user = user;
        this.mark = mark;
    }

    public Result() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
