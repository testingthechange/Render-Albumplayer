package com.maven.album;

import java.time.LocalDate;

public class Project {
    private Long id;
    private String title;
    private LocalDate startDate;
    private String magicLink;

    public Project(Long id, String title, LocalDate startDate) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.magicLink = null; // none until generated
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public LocalDate getStartDate() { return startDate; }
    public String getMagicLink() { return magicLink; }

    public void setMagicLink(String magicLink) {
        this.magicLink = magicLink;
    }
}
