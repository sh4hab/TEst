public class Bomb {
    private String[] types = {"common" , "rare" , "super"} ;
    private String type ;
    int price ;
    int damage ;
    int row ;
    int col ;

    public Bomb(int row, int col) {
        this.row = row;
        this.col = col;
        type = types[0] ;
        price = 25 ;

    }

    public Bomb(String type , int row , int col) {
        this.type = type;
        this.row = row;
        this.col = col;
        if(type == types[0]) {
            price = 25;
            damage = 25;
        }
        else if(type == types[1]){
            price = 75 ;
            damage = 75 ;
        }
        else if(type == types[2]){
            price = 150 ;
            damage = 150 ;
        }
        else
            System.out.println("Invalid Bomb Type !");


    }
}
