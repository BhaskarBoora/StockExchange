package service;

import model.Order;
import utils.OrderType;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    public int compare(Order order1, Order order2) {
        if (order1.getPrice() == order2.getPrice()) {
            int time1 = order1.getTime().getTimeId();
            int time2 = order2.getTime().getTimeId();
            return Integer.compare(time1, time2);
        }


        if (order1.getOrderType() == OrderType.buy) {
            return Double.compare(order2.getPrice(), order1.getPrice());
        }
        return Double.compare(order1.getPrice(), order2.getPrice());


    }
}

