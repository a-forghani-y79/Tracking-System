package com.moon.trackingsystem.models;


import com.moon.trackingsystem.models.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int supporter;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project sectionProject;

    public Section(String name, String description, int supporter) {
        this.name = name;
        this.description = description;
        this.supporter = supporter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSupporter() {
        return supporter;
    }

    public void setSupporter(int supporter) {
        this.supporter = supporter;
    }

    public Project getSectionProject() {
        return sectionProject;
    }

    public void setSectionProject(Project sectionProject) {
        this.sectionProject = sectionProject;
    }
}
