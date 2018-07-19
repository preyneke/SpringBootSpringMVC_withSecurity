package com.thymeleaf.demo.Service;

import com.thymeleaf.demo.Model.Product;
import com.thymeleaf.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findById(int id){

        List<Product> products = productRepository.findAll();

        return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }
}
