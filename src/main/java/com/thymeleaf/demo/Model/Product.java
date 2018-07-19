package com.thymeleaf.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;
    @NotEmpty
    @Column(name = "name")
    private String name;
    @Column(name = "manufacturer")
    @NotEmpty(message = "*Please enter valid manufacturer")
    private String manufacturer;
    @Column(name = "category")
    @NotEmpty(message = "*Please enter valid catagory")
    private String category;
    @NotEmpty(message = "*Please enter valid description")
    @Column(name = "description")
    private String description;
    @Column(name = "unit_price")
    @Min(value = 1)
    @Digits(integer = 8, fraction = 2, message = "*Please enter valid amount")
    private BigDecimal unitPrice;
    @Column(name = "unit_stock")
    @NotEmpty(message = "*Can not be blank")
    @Min(value = 1, message = "Must have one or more items in stock.")
    private int unitStock;

    public Product(){

    }

    public Product(@NotEmpty String name, @NotEmpty(message = "*Please enter valid manufacturer") String manufacturer, @NotEmpty(message = "*Please enter valid catagory") String catagory, @NotEmpty(message = "*Please enter valid description") String description, @Min(value = 1) @Digits(integer = 8, fraction = 2, message = "*Please enter valid amount") BigDecimal unitPrice, @NotEmpty(message = "*Can not be blank") @Min(value = 1, message = "Must have one or more items in stock.") int unitsInStock) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = catagory;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitStock = unitsInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitStock() {
        return unitStock;
    }

    public void setUnitStock(int unitsInStock) {
        this.unitStock = unitsInStock;
    }
}
