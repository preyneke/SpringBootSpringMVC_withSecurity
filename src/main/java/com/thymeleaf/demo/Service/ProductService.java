package com.thymeleaf.demo.Service;

import com.thymeleaf.demo.Model.Product;
import org.springframework.stereotype.Service;


public interface ProductService {

     Product findById(int id);


}
