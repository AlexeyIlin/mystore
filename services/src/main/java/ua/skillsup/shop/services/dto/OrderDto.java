package ua.skillsup.shop.services.dto;

public class OrderDto {

    private String firstName;
    private String productName;
    private double price;
    private int amount;

    public OrderDto() {
    }

    public OrderDto(String firstName, String productName, double price, int amount) {
        this.firstName = firstName;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
