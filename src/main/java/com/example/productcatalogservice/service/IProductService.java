package com.example.productcatalogservice.service;

import com.example.productcatalogservice.model.Product;

public interface IProductService {
    Product getProductById(Long id);
}
