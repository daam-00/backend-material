package com.example.doublecloutch.dto;

import com.example.doublecloutch.entity.Material;
import com.example.doublecloutch.entity.User;

import java.util.Date;

public class ReceiptDTO {
    private Long id;
    private User user;
    private Material material;
    private String description;
    private double unitPrice;
    private int quantity;
    private double totalPrice;
    private String receiptNumber;
    private String paymentType;
    private Date date;
    private double amount;
    private Date dueDate;
    private Double amount2;
    private Date dueDate2;
    private String paymentType2;
    private Double amount3;
    private Date dueDate3;
    private String paymentType3;
    private Double amount4;
    private Date dueDate4;
    private String paymentType4;
    private Double amount5;
    private Date dueDate5;
    private String paymentType5;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount2() {
        return amount2;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public Date getDueDate2() {
        return dueDate2;
    }

    public void setDueDate2(Date dueDate2) {
        this.dueDate2 = dueDate2;
    }

    public String getPaymentType2() {
        return paymentType2;
    }

    public void setPaymentType2(String paymentType2) {
        this.paymentType2 = paymentType2;
    }

    public Double getAmount3() {
        return amount3;
    }

    public void setAmount3(Double amount3) {
        this.amount3 = amount3;
    }

    public Date getDueDate3() {
        return dueDate3;
    }

    public void setDueDate3(Date dueDate3) {
        this.dueDate3 = dueDate3;
    }

    public String getPaymentType3() {
        return paymentType3;
    }

    public void setPaymentType3(String paymentType3) {
        this.paymentType3 = paymentType3;
    }

    public Double getAmount4() {
        return amount4;
    }

    public void setAmount4(Double amount4) {
        this.amount4 = amount4;
    }

    public Date getDueDate4() {
        return dueDate4;
    }

    public void setDueDate4(Date dueDate4) {
        this.dueDate4 = dueDate4;
    }

    public String getPaymentType4() {
        return paymentType4;
    }

    public void setPaymentType4(String paymentType4) {
        this.paymentType4 = paymentType4;
    }

    public Double getAmount5() {
        return amount5;
    }

    public void setAmount5(Double amount5) {
        this.amount5 = amount5;
    }

    public Date getDueDate5() {
        return dueDate5;
    }

    public void setDueDate5(Date dueDate5) {
        this.dueDate5 = dueDate5;
    }

    public String getPaymentType5() {
        return paymentType5;
    }

    public void setPaymentType5(String paymentType5) {
        this.paymentType5 = paymentType5;
    }
}
