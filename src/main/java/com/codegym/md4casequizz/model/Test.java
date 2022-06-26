package com.codegym.md4casequizz.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
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
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @ManyToMany
    @JoinTable(name = "test_ques",
            joinColumns = @JoinColumn(name = "test_id"),inverseJoinColumns = @JoinColumn(name = "ques_id"))
    Set<Question> questions = new HashSet<>();

    public Test(Long id, String name, User user, Set<Question> questions) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.questions = questions;
    }

    public Test(String name, Level level, User user, Date date, Set<Question> questions) {
        this.name = name;
        this.level = level;
        this.user = user;
        this.date = date;
        this.questions = questions;
    }

    public Test() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
