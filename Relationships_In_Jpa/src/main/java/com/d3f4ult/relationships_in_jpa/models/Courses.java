package com.d3f4ult.relationships_in_jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Courses {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private  String description;
    /**
     * This is the owner Entity
     * we define the joint table on the owners side
     * @joinColumns= the column name that stores the owners primary key
     * @inverseJoinColumn
     * */
    @ManyToMany
    @JoinTable(name = "author_courses",
            joinColumns={@JoinColumn(name = "course_id")
    }
    ,inverseJoinColumns = {
            @JoinColumn(name = "authors_id")
    })

    List<Author> authors;

    /*
    * one to many mappings*/
    @OneToMany(mappedBy = "courses")
    List<Section> sections;
}
