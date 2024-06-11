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
//    !GENERATE VALUE  FOR EITHER SEQUNCE OR TABLE
//    @GeneratedValue(strategy= GenerationType.TABLE,generator = "client_id_gen")
//    ! SEQUENCE GENERATOR
//  @SequenceGenerator(name = "clients_sequence",sequenceName = "clients_sequence",allocationSize = 1)

//    ! TABLE GENERATOR
//  @TableGenerator(name = "client_id_gen"
//          ,pkColumnName = "id_name",
//          table = "id_generator",
//          valueColumnName = "id_values")
    @GeneratedValue
    private Integer id;
    private String  firstName;
    private String  lastname;
    private String email;
    private int age;


}
