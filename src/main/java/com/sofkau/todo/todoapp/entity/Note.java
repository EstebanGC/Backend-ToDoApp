package com.sofkau.todo.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Note")
@Table(name= "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private boolean done;

    private Long categoryId;

    @OneToMany(mappedBy = "noteId",
            fetch = FetchType.EAGER)
    private List<Tag> tags = new ArrayList<>();
}
