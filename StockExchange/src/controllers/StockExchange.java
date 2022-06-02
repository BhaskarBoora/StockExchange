package controllers;

import model.Order;
import model.Transaction;
import service.BusinessService;

import java.util.List;

public class StockExchange {
    BusinessService businessService;

    public StockExchange(){
        businessService = new BusinessService();
    }
    public void executeOrder(Order order){

        List<Transaction> transactions = businessService.newOrder(order);
        for (Transaction transaction : transactions) {
            System.out.println(transaction.outputString());
        }
    }
}
