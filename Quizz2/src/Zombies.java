import java.util.Random;

public class Zombies {
    final static int MAX_HEALTH = 120 ;
    int health ;
    int row , col ;

    public Zombies(int row, int col) {
        this.row = row;
        this.col = col;
        Random rand = new Random();
        health = rand.nextInt(MAX_HEALTH) + 1;
    }
    public void tackdamage(int damage){
        health = health - damage ;
    }

}
