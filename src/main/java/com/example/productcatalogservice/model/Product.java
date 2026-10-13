package com.example.productcatalogservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private Double price;
    private String Description;
    private String imageUrl;
    private Category category;

}
