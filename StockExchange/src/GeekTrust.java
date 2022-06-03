import controllers.StockExchange;
import model.Order;
import model.Time;
import utils.OrderType;

import java.lang.*;
import java.io.*;

public class GeekTrust {



    public static void main(String[] args) throws java.lang.Exception{

         String path = args[0];
         BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        StockExchange exchange = new StockExchange();
        while(line != null){
            String words[] = line.split("[ #:]");

            int orderID = Integer.parseInt(words[1]);

            int hour = Integer.parseInt(words[2]);
            int minutes = Integer.parseInt(words[3]);

            String ticker = words[4];
            String orderType = words[5];

            double price = Double.parseDouble(words[6]);
            int quantity = Integer.parseInt(words[7]);

            Order order = new Order(orderID,new Time(hour,minutes) ,ticker, OrderType.valueOf(orderType), price, quantity );
            exchange.executeOrder(order);
            line = reader.readLine();
        }

    }
}
