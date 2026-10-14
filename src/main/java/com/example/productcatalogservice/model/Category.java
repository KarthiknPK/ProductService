package com.example.productcatalogservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseEntity{

    private String name;
    private String Description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
