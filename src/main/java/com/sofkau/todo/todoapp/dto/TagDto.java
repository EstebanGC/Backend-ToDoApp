package com.sofkau.todo.todoapp.dto;

import lombok.Data;

@Data
public class TagDto {

    private Long id;
    private String tag;
    private Long noteId;

}
