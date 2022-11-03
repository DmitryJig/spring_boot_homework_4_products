package com.jd.products.products.services;

import com.jd.products.products.model.Product;
import com.jd.products.products.repositories.ProductsInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsInMemoryRepository productsInMemoryRepository;

    public Optional<Product> findById(Long id){
        return productsInMemoryRepository.findById(id);
    }

    public List<Product> findAll(){
        return productsInMemoryRepository.findAll();
    }

    public Product saveOrUpdate(Product p){
        return productsInMemoryRepository.saveOrUpdate(p);
    }

    public void deleteById(Long id){
        productsInMemoryRepository.deleteById(id);
    }
}
