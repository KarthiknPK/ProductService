package com.example.productcatalogservice.service;

import com.example.productcatalogservice.model.Product;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyProductService implements IProductService {
    private RestTemplate restTemplate;

    public DummyProductService(RestTemplateBuilder builder){
        this.restTemplate=builder.build();
    }
    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
