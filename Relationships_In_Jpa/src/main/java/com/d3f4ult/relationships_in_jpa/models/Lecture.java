package com.d3f4ult.relationships_in_jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Lecture {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private  Section section;

/*
/    One to one Mapping
//    */
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private  Resource resource;
}
