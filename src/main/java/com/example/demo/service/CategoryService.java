package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;
//lllllll
public interface CategoryService {

    List<CategoryDto> findAll(@Nullable Long parentId);
    CategoryDto findone (Long id);
    CategoryDto add(CategoryDto form);
    CategoryDto update (Long Id,CategoryDto form);
    CategoryDto delete (Long id);

}