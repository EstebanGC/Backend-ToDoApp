package com.sofkau.todo.todoapp.repository;

import com.sofkau.todo.todoapp.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}