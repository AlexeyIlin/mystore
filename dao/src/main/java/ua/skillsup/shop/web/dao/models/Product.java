package ua.skillsup.shop.web.dao.models;

import javax.persistence.*;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private double size;

    @Column(name = "BALANCE")
    private int balance;

    public Product(Long id, String productName, double price, String category, String gender, String color, double size, int balance) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getGender() {
        return gender;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }




}
