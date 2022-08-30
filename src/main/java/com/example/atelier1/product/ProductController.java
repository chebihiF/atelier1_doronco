package com.example.atelier1.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductsPage(
            Model model,
            @RequestParam(name="size", defaultValue = "5") int size,
            @RequestParam(name="page", defaultValue = "0") int page){
        try {
            Page<Product> products = productService.getProducts(PageRequest.of(page,size));
            model.addAttribute("products", products);
            model.addAttribute("pages",new int[products.getTotalPages()]);
            model.addAttribute("current_page",page);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }

        return "products";
    }
}
