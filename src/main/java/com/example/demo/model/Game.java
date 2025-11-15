package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String fileUrl;

    // שדה קטגוריה חדש
    @Column(nullable = true)
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public Game() {}

    // קונסטרוקטור מלא עם קטגוריה
    public Game(String title, String description, String fileUrl, String category, User owner) {
        this.title = title;
        this.description = description;
        this.fileUrl = fileUrl;
        this.category = category;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
