package ua.skillsup.shop.web.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Aleksey on 14.04.2018.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Column(name = "ORDERID")
    private Long orderid;

    @Column(name = "USERID")
    private Long userid;

    @Column(name = "PRODUCTID")
    private Long productid;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "AMOUNT")
    private int amount;

    public Order(Long orderid) {
    }

    public Order(Long orderid, Long userid, Long productid, double price, int amount) {
        this.orderid = orderid;
        this.userid = userid;
        this.productid = productid;
        this.price = price;
        this.amount = amount;
    }

    public Long getOrderid() {
        return orderid;
    }

    public Long getUserid() {
        return userid;
    }

    public Long getProductid() {
        return productid;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
