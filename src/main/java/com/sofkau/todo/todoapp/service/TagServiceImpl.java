package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.dto.TagDto;
import com.sofkau.todo.todoapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private Mapper mapper;

    public TagDto createTag(TagDto tagDto) {
        return mapper.fromEntityToTagDto(tagRepository.save(mapper.fromTagDtoToEntity(tagDto)));
    }
}