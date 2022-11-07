package com.jd.products.products.repositories;

import com.jd.products.products.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductsInMemoryRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Tomato", 120.0),
                new Product(2L, "Potato", 50.0),
                new Product(3L, "Tea", 200.0)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }


    public Product saveOrUpdate(Product p){
        if (p.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(p.getId())) {
                    products.set(i, p);
                    return p;
                }
            }
        }
        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        p.setId(newId);
        products.add(p);
        return p;
    }

    public void deleteById(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }
}
