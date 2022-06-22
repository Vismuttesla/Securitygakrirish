package com.example.demo.service.Impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.AAAACategory;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryRepository repository;
    private  final EntityManager entityManager;

    public CategoryServiceImpl(CategoryRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }


    @Override
    public List<CategoryDto> findAll(Long parentId)
    {
        return repository.findAllByParent_idAndDeletedFalse(parentId).stream().
                map(CategoryDto::fromCategory).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findone(Long id)
    {
        return CategoryDto.fromCategory(repository.getOne(id));
    }


    @Override
    public  CategoryDto add(CategoryDto form)
    {

        return CategoryDto.fromCategory(repository.save(fillCategory(new AAAACategory(),form)));
    }

    @Override
    public CategoryDto update(Long id, CategoryDto form)
    {
        return CategoryDto.fromCategory(repository.save(fillCategory(repository.getOne(id),form)));
    }

    @Override
    public CategoryDto delete(Long id)
    {
        return CategoryDto.fromCategory(repository.trash(id));
    }
    private AAAACategory fillCategory(AAAACategory category, CategoryDto form)
    {
        category.setTitle(form.getTitle());
        category.setDescription(form.getDescription());
        category.setIconCode(form.getIcon());
        if(form.getParentId()!=null)
        {  category.setParent(entityManager.getReference(AAAACategory.class,form.getParentId()));
        }
        return category;



    }


}
