import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

class Manager {
    int playerCoins ;
    int zombieCounter ;
    private String[][] map = new String[MAX_ROW ][MAX_COLUMN] ;

    String playerName ;

    private ArrayList<Zombies> zombies = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();

    private Random random = new Random();

    private final static int MAX_ROW  = 5;
    private final static int MAX_COLUMN = 30;
    final static int MAX_ZOMBIES = 20 ;

    Manager() {

    }
    void initial(){
        int i , j;
        playerCoins = 500 ;
        for (i = 0 ; i < MAX_ROW ; i++){
            for (j = 0 ; j < MAX_COLUMN ; j++){
                map[i][j] = " ";
            }
        }
        System.out.println("      " + playerName + "'s Farm !!!");
        for (i = 0 ; i < MAX_ROW  ; i++)
            for (j = 0 ; j < MAX_COLUMN + 4 ; j++) {
                if(j == 0)
                    System.out.print(String.valueOf(i + 1));
                else if (j == 1)
                    System.out.print(":");
                else if(j == MAX_COLUMN + 2)
                    System.out.print(":");
                else if(j == MAX_COLUMN + 3)
                    System.out.print(String.valueOf(i + 1) + "\n");
                else
                    System.out.print(map[i][j - 2]);
            }

    }
    public void putZombie(){
        if (zombieCounter < MAX_ZOMBIES + 1) {
            if (random.nextInt(10) < 8) {
                zombies.add(new Zombies(random.nextInt(MAX_ROW)  , MAX_COLUMN - 1));
                //System.out.println("The zombie row is :" + zombies.get(0).row + "And the zombie col is " + zombies.get(0).col);
                map[zombies.get(zombies.size()- 1).row ][MAX_COLUMN - 1] = "<";
                zombieCounter++;
            }
        }


    }
    void putBomb(int row , int col){
        bombs.add(new Bomb(row , col)) ;
        map[row][col] = "c";
        playerCoins = playerCoins - 25 ;
    }

    void putBombType(int row , int col , String type){
        bombs.add(new Bomb(type , row , col)) ;
        if(type.equals("common"))
            map[row][col] = "c";
        else if(type.equals("super"))
            map[row][col] = "s";
        else
            map[row][col] = "r";
        playerCoins = playerCoins - bombs.get(bombs.size() - 1).price ;
    }

    void getCoins(){
        if(random.nextInt(10) < 6)
            playerCoins += 50 ;
    }
    void zombieHealth(int row , int col){
        for(Zombies zombie : zombies){
            if(zombie.row == row & zombie.col  == col)
                System.out.println("The Zombie Health is :" + zombie.health);
        }
    }

    void calculations(){
        ArrayList<Zombies> newZombie = new ArrayList<>() ;
        int i , j ;
        for (Bomb bomb: bombs){
            for (Zombies zombie : zombies){
                zombie.col = zombie.col - 1 ;
                if(zombie.row == bomb.row && zombie.col == bomb.col)
                    zombie.tackdamage(bomb.damage);
                if(zombie.health < 0){
                    newZombie.add(zombie);
                    playerCoins += 15 ;
                    zombieCounter = zombieCounter -1;
                    map[zombie.row][zombie.col] = " " ;
                }
                if (zombie.col == 0){
                    System.out.println("Game Over !");
                    return ;
                }

            }

        }
        for (Zombies zombies1 : newZombie) {
            zombies.remove(zombies1) ;
        }
        for (i = 0 ; i < MAX_ROW ; i++) {
            for (j = 0; j < MAX_COLUMN; j++) {
                if (map[i][j] == "<") {
                    map[i][j - 1] = "<";
                    map[i][j] = " ";
                }
            }
        }
        System.out.println("      " + playerName + "'s Farm !!!");
        for (i = 0 ; i < MAX_ROW  ; i++)
            for (j = 0 ; j < MAX_COLUMN + 4 ; j++) {
                if(j == 0)
                    System.out.print(String.valueOf(i + 1));
                else if (j == 1)
                    System.out.print(":");
                else if(j == MAX_COLUMN + 2)
                    System.out.print(":");
                else if(j == MAX_COLUMN + 3)
                    System.out.print(String.valueOf(i + 1) + "\n");
                else
                    System.out.print(map[i][j - 2]);
            }
    }



}
