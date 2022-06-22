package com.example.demo.repository.Impl;

import com.example.demo.entity.BaseEntity;
import com.example.demo.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static antlr.build.ANTLR.root;

public class BaseRepositoryImpl<T extends BaseEntity>
extends SimpleJpaRepository<T,Long> implements BaseRepository<T>
{

   private Specification <T> notDeleted;
    public BaseRepositoryImpl(JpaEntityInformation<T, ?>
                                      entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

       notDeleted = (Specification<T>)(root,query,cb)->cb.equal(root.get("deleted"),false);
    }
       @Override
    public T trash(Long id)
       {
   T entity=getOne(id);
   entity.setDeleted(true);
        return save(entity);
    }

    @Override
    public List<T> findAllNotDeleted() {
        return findAll(notDeleted);
    }

    @Override
    public Page<T> findAllNotDeleted(Pageable pageable)
    {
        return findAll(notDeleted,pageable);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {

    }
}
