package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController
{
    private final CategoryService service;


    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity FindAlBYParent(@RequestParam(required =false) Long parentId)
    {

        return ResponseEntity.ok(service.findAll(parentId));

    }

    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable Long id)
    {

        return ResponseEntity.ok(service.findone(id));
    }
    @PostMapping("{id}")
    @PreAuthorize("hasanyAuthority('ADMINISTRATOR','MODERATOR')")
    // BU ANOTATASIYA FAQATGINA ADMINGINA bu methoddan foydalana oladi degani
    public ResponseEntity add(@RequestBody CategoryDto form)
    {
        return ResponseEntity.ok(service.add(form));
    }
    @PutMapping("{id}")
    @PreAuthorize("hasanyAuthority('ADMINISTRATOR','MODERATOR')")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CategoryDto form)
    {
        return ResponseEntity.ok(service.update(id,form));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity delete(Long id)
    {
        return ResponseEntity.ok(service.delete(id));

    }










}



