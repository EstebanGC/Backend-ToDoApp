package com.sofkau.todo.todoapp.controller;

import com.sofkau.todo.todoapp.dto.CategoryDto;
import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.dto.TagDto;
import com.sofkau.todo.todoapp.entity.Category;
import com.sofkau.todo.todoapp.service.CategoryService;
import com.sofkau.todo.todoapp.service.NoteService;
import com.sofkau.todo.todoapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class Controller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private TagService tagService;

    @GetMapping("get/all/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping("save/category")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @PostMapping("save/note")
    public NoteDto saveNote(@RequestBody NoteDto note) {
        return noteService.createNote(note);
    }

    @PostMapping("save/tag")
    public TagDto saveTag (@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @PutMapping("update/note")
    public NoteDto updateNote(@RequestBody NoteDto noteDto) {
        return noteService.updateNote(noteDto);
    }

    @DeleteMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}