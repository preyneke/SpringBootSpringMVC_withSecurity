package com.thymeleaf.demo.Repositories;

import com.thymeleaf.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
