import java.util.Random;

public class Order {
    int customerID ;
    int orderID ;
    int date ;
    long time ;
    int goodID ;
    int inventory ;
    Random random = new Random() ;
    public Order(int customerID,  int date,long time, int goodID, int inventory) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.date = date;
        this.time = time;
        this.goodID = goodID;
        this.inventory = inventory;

        this.orderID = random.nextInt(1000000) ;
    }
}
