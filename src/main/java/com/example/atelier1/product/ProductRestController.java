package com.example.atelier1.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    private final IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getProductsPage(
            @RequestParam(name="size", defaultValue = "5") int size,
            @RequestParam(name="page", defaultValue = "0") int page){
        Page<Product> products = null ;
        try {
            products = productService.getProducts(PageRequest.of(page,size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        Product prod = null ;
        try {
            prod = productService.saveProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return prod ;
    }

}
