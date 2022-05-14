package com.sofkau.todo.todoapp.dto;

import com.sofkau.todo.todoapp.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class NoteDto {

    private Long id;
    private String message;
    private boolean done;
    private Long categoryId;
    private List<TagDto> tags = new ArrayList<>();
}
