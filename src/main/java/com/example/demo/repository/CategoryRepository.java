package com.example.demo.repository;

import com.example.demo.entity.AAAACategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends BaseRepository<AAAACategory>
{
    List<AAAACategory> findAllByParent_idAndDeletedFalse(Long parentId);


}
