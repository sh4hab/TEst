import java.util.ArrayList;

public class Capacitor {
    public int capacity ;
    public int level ;
    public String good ;
    public int NumOfGoodsIn ;
    ArrayList<Object> goods= new ArrayList<>() ;

    public Capacitor(int capacity, int level, String good, int numOfGoodsIn) {
        this.capacity = capacity;
        this.level = level;
        this.good = good;
        NumOfGoodsIn = numOfGoodsIn;
    }

    public void AddToCap(String input){}
}
