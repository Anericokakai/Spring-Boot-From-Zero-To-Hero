package com.d3f4ult.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "clients_sequence")
    @SequenceGenerator(name = "clients_sequence",sequenceName = "clients_sequence",allocationSize = 1)
    private Integer id;
    private String  firstName;
    private String  lastname;
    private String email;
    private int age;


}
