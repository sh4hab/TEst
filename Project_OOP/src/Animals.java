import java.util.ArrayList;

public class Animals {
    public int x , y ;
    public int price;
    public int health;
    public int sell_price;
    public int volume ;
    private int level ;
    public String production ;
    public String fule ;
    public String target ;
    // defender animals
    public Animals(int x, int y, int price, int level, String target) {
        this.x = x;
        this.y = y;
        this.price = price;
        this.level = level;
        this.target = target;
    }

    // wild animals
    public Animals(int x , int y , int sell_price, int volume, int level, String target) {
        this.x = x ;
        this.y = y ;
        this.sell_price = sell_price;
        this.volume = volume;
        this.level = level;
        this.production = production;
        this.fule = fule;
        this.target = target;
    }

    // domestic
    public Animals(int x , int y ,int price, int health, int sell_price, int volume, int level, String production, String fule) {
        this.price = price;
        this.health = health;
        this.sell_price = sell_price;
        this.volume = volume;
        this.level = level;
        this.production = production;
        this.fule = fule;
    }

}
