package com.example.demo.project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name="project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private long id;
    private String name;
    private String description;
    private LocalDate date;
    private Integer rating;

    public Project() {
    }

    public Project(String name, String description, Integer rating,LocalDate date) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }

    public Project(long id, String name, String description, Integer rating,LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                '}';
    }
}
