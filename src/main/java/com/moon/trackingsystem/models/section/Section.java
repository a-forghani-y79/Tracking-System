package com.moon.trackingsystem.models.section;


import com.moon.trackingsystem.models.project.Project;
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
 /*   @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project sectionProject;*/


}
