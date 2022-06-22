package com.example.demo.dto;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.AAAACategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)// bu avtomatik null bo'lgan qiymatlarni tashlab ketadi
//agar faqat biror obyektnigina null qiymaytalarini olmaslik kerak bo'lsa u holda shu obyektdan oldin
//  qo'yiladi bu anotatasiya
public class CategoryDto extends BaseEntity {


private String title;
private String  description;
private Long parentId;
private Long Id;
private String icon;
  public static  CategoryDto fromCategory(AAAACategory category )
  {
      CategoryDto dto= new CategoryDto();
       dto.setId(category.getId());
       dto.setTitle(category.getTitle());
       if (category.getParent()!= null){
       dto.setParentId(category.getParent().getId()); }
       dto.setIcon(category.getIconCode());
       return dto;
  }





}
