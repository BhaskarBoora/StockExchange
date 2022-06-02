package model;

import utils.OrderType;

public class Order {
    private int orderID;
    private Time time;
    private String stock;
    private OrderType orderType;
    private double price;
    private int quantity;

    public int getOrderId(){
        return orderID;
    }
    public void setOrderId(int orderId){
        this.orderID = orderId;
    }

    public Time getTime(){
        return time;
    }
    public void setTime(Time time){
        this.time = time;
    }

    public OrderType getOrderType(){
        return orderType;
    }
    public void setOrderType(OrderType orderType){
        this.orderType = orderType;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String getStock(){
        return stock;
    }
    public void setStock(String stock){
        this.stock = stock;
    }

    public Order(int orderId, Time time, String stock, OrderType orderType, double price, int quantity)
    {
        this.orderID = orderId;
        this.time = time;
        this.stock = stock;
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
    }

}
