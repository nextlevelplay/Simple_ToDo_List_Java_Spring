package com.petproject.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todo")
@Table(name = "todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private UserEntity userEntity;

    @Column(name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;

}
