package service;
import java.util.*;

import model.Order;
import model.Transaction;
import utils.OrderType;

public class BusinessService {

    Map<String, PriorityQueue<Order>> buyOrders;
    Map<String, PriorityQueue<Order>> sellOrders;

    public BusinessService(){
        buyOrders = new HashMap<>();
        sellOrders = new HashMap<>();
    }
    public List<Transaction> newOrder(Order order){

        String stock = order.getStock();

        //InsertOrder
        if (order.getOrderType() == OrderType.buy) {


            buyOrders.putIfAbsent(stock, new PriorityQueue<>(new OrderComparator()));
            buyOrders.get(stock).offer(order);
        }
        else{
                sellOrders.putIfAbsent(stock, new PriorityQueue<>(new OrderComparator()));
                sellOrders.get(stock).offer(order);


            }




        //make decision
        return makeDecision(order.getStock());




    }

    public List<Transaction> makeDecision(String stock){

        List<Transaction> tp = new ArrayList<>();

        if (!buyOrders.containsKey(stock) || !sellOrders.containsKey(stock))
            return tp;

        PriorityQueue<Order> buyQueue = buyOrders.get(stock);
        PriorityQueue<Order> sellQueue = sellOrders.get(stock);

        Order peakBuyOrder = buyQueue.peek();
        Order peakSellOrder = sellQueue.peek();

        if(peakBuyOrder.getPrice() < peakSellOrder.getPrice())
            return tp;

        buyQueue.poll();
        sellQueue.poll();

        if(buyQueue.isEmpty())
            buyOrders.remove(stock);

        if(sellQueue.isEmpty())
            sellOrders.remove(stock);
        int quant = Math.min(peakBuyOrder.getQuantity(), peakSellOrder.getQuantity());
        Transaction tn = new Transaction(peakBuyOrder.getOrderId(),peakSellOrder.getPrice(),quant , peakSellOrder.getOrderId() );

        tp.add(tn);

        if(peakBuyOrder.getQuantity()> quant){
             peakBuyOrder.setQuantity(peakBuyOrder.getQuantity() - quant);
             tp.addAll(newOrder(peakBuyOrder));
        }
        if(peakSellOrder.getQuantity()> quant){
            peakSellOrder.setQuantity(peakSellOrder.getQuantity() - quant);

            tp.addAll(newOrder(peakSellOrder));
        }

        return tp;
    }


}



