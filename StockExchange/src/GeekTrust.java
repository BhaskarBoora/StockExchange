import controllers.StockExchange;
import model.Order;
import model.Time;
import utils.OrderType;

import java.lang.*;
import java.io.*;

public class GeekTrust {
    static class Tokenizer{
        String words[];
        int index;

        Tokenizer(String line){
            this.words = line.split("[ #:]");
            index = 0;
        }

        String nextString(){
            while(words[index].equals("") || words[index] == null)
                index++;

            return words[index++];
        }
    }


    public static void main(String[] args) throws java.lang.Exception{

         String path = args[0];
         BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        StockExchange exchange = new StockExchange();
        while(line != null){
           Tokenizer tk = new Tokenizer(line);


            int orderID = Integer.parseInt(tk.nextString());

            int hour = Integer.parseInt(tk.nextString());
            int minutes = Integer.parseInt(tk.nextString());

            String ticker = tk.nextString();
            String orderType = tk.nextString();

            double price = Double.parseDouble(tk.nextString());

            int quantity = Integer.parseInt(tk.nextString());

            Order order = new Order(orderID,new Time(hour,minutes) ,ticker, OrderType.valueOf(orderType), price, quantity );
            exchange.executeOrder(order);
            line = reader.readLine();
        }

    }
}
