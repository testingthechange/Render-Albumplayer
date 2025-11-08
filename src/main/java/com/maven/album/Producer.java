package com.maven.album;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private Long id;
    private String name;
    private String email;
    private List<Project> projects = new ArrayList<>();

    public Producer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Project> getProjects() { return projects; }

    public void addProject(Project project) {
        projects.add(project);
    }
}
