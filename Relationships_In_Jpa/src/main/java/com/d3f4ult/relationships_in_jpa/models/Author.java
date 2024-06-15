package com.d3f4ult.relationships_in_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
    private String  firstName;
    private String  lastname;
    private String email;
    private int age;
    /**
     * This is the Inverse relationShip
     * we use the mappedBy
     *
     * @Params  mappedBy="" the name of the other list joint  in our case
     * */
    @ManyToMany(mappedBy = "authors")
    List<Courses> courses;
}
