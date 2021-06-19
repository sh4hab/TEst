import java.util.Random;

public class Goods {
    int goodID ;
    String name ;
    int inventory ;
    int buyPrice ;
    int sellPrice ;
    Random random = new Random() ;
    public Goods(String name, int inventory, int sellPrice, int buyPrice) {
        this.name = name;
        this.inventory = inventory;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;

        this.goodID = random.nextInt() ;
    }
}
