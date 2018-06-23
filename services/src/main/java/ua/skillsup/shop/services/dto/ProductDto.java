package ua.skillsup.shop.services.dto;

/**
 * Created by Aleksey on 13.05.2018.
 */
public class ProductDto {

    private String productName;
    private double price;
    private String category;
    private String gender;
    private String color;
    private double size;
    private int balance;

    public ProductDto(String productName, double price, String category, String gender, String color, double size, int balance) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.balance = balance;
    }

    public ProductDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", category=" + category +
                ", gender=" + gender +
                ", color=" + color +
                ", size=" + size +
                ", balance=" + balance +
                '}';
    }

}
