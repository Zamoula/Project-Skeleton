package com.project.jamel.controllers;

import com.project.jamel.services.Crud;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class Controller<T, ID> {
    protected abstract Crud<T, ID> getService();

    @PostMapping
    public T create(@RequestBody T entity) {
        return getService().save(entity);
    }

    @GetMapping("/{id}")
    public Optional<T> findById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @GetMapping
    public List<T> findAll() {
        return getService().findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> updateCourse(@PathVariable ID id, @RequestBody T entityDetails) {
        T updated = getService().update(id, entityDetails);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        getService().deleteById(id);
    }
}
