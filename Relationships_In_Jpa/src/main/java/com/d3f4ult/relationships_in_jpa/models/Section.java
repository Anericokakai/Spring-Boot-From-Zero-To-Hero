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
@Entity
@Builder
public class Section {
    @Id
    @GeneratedValue
    private Integer id;
    private String  name;
    private int SectionOrder;

    /*Many sections can belong to one course/

     */
    @ManyToOne
    @JoinColumn(name = "course_id")
    private  Courses courses;

   @OneToMany(mappedBy = "section")
    List<Lecture> lectures;
}
