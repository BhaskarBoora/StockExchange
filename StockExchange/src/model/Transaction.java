package model;

public class Transaction {
    int buyOrderID;
    double  sellPrice;
    int quantity;
    int sellOrderID;

    public int getBuyOrderID(){
        return this.buyOrderID;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public double getSellPrice(){
        return this.sellPrice;
    }
    public int getSellOrderID(){
        return this.sellOrderID;
    }

    public Transaction(int buyOrderId, double sellPrice, int quantity, int sellOrderId)
    {
        this.buyOrderID = buyOrderId;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.sellOrderID = sellOrderId;
    }

    public String outputString(){

        return String.format("#%d %.2f %d #%d", this.buyOrderID, this.sellPrice, this.quantity, this.sellOrderID);

    }
}
