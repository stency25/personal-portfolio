package com.stency.personal_portfolio.entity;

import jakarta.persistence.*;

@Entity
@Table (name ="skills")
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    //constructor

    public SkillEntity(Long id, String name, SkillCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    //getter and setters

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

    public SkillCategory getCategory() {
        return category;
    }

    public void setCategory(SkillCategory category) {
        this.category = category;
    }
}
