package com.petproject.todolist.domain;

import lombok.Data;

import javax.persistence.*;

@Data
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

}
