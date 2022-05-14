package com.sofkau.todo.todoapp.dto;

import com.sofkau.todo.todoapp.entity.Category;
import com.sofkau.todo.todoapp.entity.Note;
import com.sofkau.todo.todoapp.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public Tag fromTagDtoToEntity(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setTag(tagDto.getTag());
        tag.setNoteId(tagDto.getNoteId());
        return tag;
    }

    public TagDto fromEntityToTagDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setId(tag.getId());
        tagDto.setTag(tag.getTag());
        tagDto.setNoteId(tag.getNoteId());
        return tagDto;
    }

    public Note fromNoteDtoToEntity(NoteDto noteDto) {
        Note note = new Note();
        note.setCategoryId(noteDto.getCategoryId());
        note.setDone(noteDto.isDone());
        note.setMessage(noteDto.getMessage());
        note.setId(noteDto.getId());
        List<Tag> tags = new ArrayList<>();
        noteDto.getTags().forEach
                (taskDto -> tags.add(this.fromTagDtoToEntity(taskDto)));
        note.setTags(tags);
        return note;
    }

    public NoteDto fromEntityToNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setCategoryId(note.getCategoryId());
        noteDto.setDone(note.isDone());
        noteDto.setMessage(note.getMessage());
        noteDto.setId(note.getId());
        List<TagDto> tagDto = new ArrayList<>();
        note.getTags().forEach(task -> tagDto.add(this.fromEntityToTagDto(task)));
        noteDto.setTags(tagDto);

        return noteDto;
    }

    public Category fromCategoryDtoToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        List<Note> notes = new ArrayList<>();

        List<Tag> tag = new ArrayList<>();
        List<Tag> tagDto = new ArrayList<>();
        if (categoryDto.getNotes().size() > 0) {
            categoryDto.getNotes().forEach(noteDto -> notes.add(this.fromNoteDtoToEntity(
                    noteDto
            )));
            category.setNotes(notes);
        }
        return category;
    }

    public CategoryDto fromEntityToCategoryDto(Category category) {

        List<NoteDto> notes = new ArrayList<>();
        category.getNotes().forEach(note -> notes.add(this.fromEntityToNoteDto(note)));
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNotes(notes);
        return categoryDto;
    }


}