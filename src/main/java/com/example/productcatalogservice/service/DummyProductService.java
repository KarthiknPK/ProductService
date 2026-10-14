package com.example.productcatalogservice.service;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyProductService implements IProductService {
    private static final String PRODUCT_URL = "https://fakestoreapi.com/products/{id}";

    private final RestTemplate restTemplate;

    public DummyProductService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProduct response = restTemplate.getForObject(
                PRODUCT_URL, FakeStoreProduct.class, id);
        if (response == null) {
            throw new IllegalStateException("Product service returned an empty response for id " + id);
        }

        Product product = new Product();
        product.setName(response.name());
        product.setPrice(response.price());
        product.setDescription(response.description());
        product.setImageUrl(response.imageUrl());

        Category category = new Category();
        category.setName(response.category());
        product.setCategory(category);
        return product;
    }

    private record FakeStoreProduct(
            @JsonProperty("title") String name,
            Double price,
            String description,
            @JsonProperty("image") String imageUrl,
            String category) {
    }
}
