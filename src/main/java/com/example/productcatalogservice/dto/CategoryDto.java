package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto  {
    private Long id;
    private String name;
    private String description;

}
