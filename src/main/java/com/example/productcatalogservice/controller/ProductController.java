package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.dto.CategoryDto;
import com.example.productcatalogservice.dto.ProductDto;
import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {


    private IProductService productService;


    public ProductController (IProductService productService) {
        this.productService=productService;
    }

    List<Product> getProducts(){
        return List.of();
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id){
        Product product=productService.getProductById(id);

        return new ResponseEntity<>(from(product), HttpStatus.OK);
    }
    private ProductDto from(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());

        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setName(product.getCategory().getName());
        categoryDto.setId(product.getCategory().getId());
        categoryDto.setDescription(product.getCategory().getDescription());
        productDto.setCategory(categoryDto);
        return productDto;
    }

}
