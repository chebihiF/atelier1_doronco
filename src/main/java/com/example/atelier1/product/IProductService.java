package com.example.atelier1.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    public Product saveProduct(Product product) throws Exception;
    public Product updateProduct(Product product) throws Exception;
    public Product removeProduct(String ref) throws Exception;
    public Page<Product> getProducts(Pageable pageable) throws Exception;
    public Product getProduct(String ref) throws Exception;
    public Product sellProduct(String ref, int qte) throws Exception;
    public Product buyProduct(String ref, int qte) throws Exception;
    public Page<Product> getProductsByCategory(Category category,Pageable pageable) throws Exception;
}
