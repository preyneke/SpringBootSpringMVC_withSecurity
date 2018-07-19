package com.thymeleaf.demo.Controller;

import com.thymeleaf.demo.Model.Product;
import com.thymeleaf.demo.Repositories.ProductRepository;
import com.thymeleaf.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/market/products", method = RequestMethod.GET)
    public String retrieveAll(Model model) {

        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);


        return "market/products";
    }

    @RequestMapping(value = "market/products/product", method = RequestMethod.GET)
    public String getProductById(@RequestParam(value = "id", required = false) int productId, Model model) {
        model.addAttribute("product", productService.findById(productId));

        return "market/products/product";

    }
}
