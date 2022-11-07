package com.jd.products.products.controllers;

import com.jd.products.products.model.Product;
import com.jd.products.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String addProductPage(){
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product newProduct){
        productService.saveOrUpdate(newProduct);
        return "redirect:/products";
    }
}
