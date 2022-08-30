package com.example.atelier1.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) throws Exception {
        if(product.getQuantity()<=0) throw new Exception("quantity must be > 0");
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    @Override
    public Product removeProduct(String ref) throws Exception {
        Product product = getProduct(ref);
        productRepository.deleteById(ref);
        return product;
    }

    @Override
    public Page<Product> getProducts(Pageable pageable) throws Exception {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProduct(String ref) throws Exception {
        Optional<Product> productOptional = productRepository.findById(ref);
        if(productOptional.isPresent())
            return productOptional.get();
        else
            throw new RuntimeException("product not found");
    }

    @Override
    public Product sellProduct(String ref, int qte) throws Exception {
        Product product = getProduct(ref);
        product.setQuantity(product.getQuantity() - qte);
        return updateProduct(product);
    }

    @Override
    public Product buyProduct(String ref, int qte) throws Exception {
        Product product = getProduct(ref);
        product.setQuantity(product.getQuantity() + qte);
        return updateProduct(product);
    }

    @Override
    public Page<Product> getProductsByCategory(Category category, Pageable pageable) throws Exception {
        return productRepository.findProductByCategory(category, pageable);
    }
}
