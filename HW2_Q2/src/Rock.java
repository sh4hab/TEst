import java.util.ArrayList;
import java.util.Iterator;

class Rock {
    double x ;
    double y ;
    double r ;
    static ArrayList<Rock> rock_info=new ArrayList<>();
    static ArrayList<Integer> neighbor

    public Rock(double X, double Y,double R) {
        this.x = X;
        this.y = Y;
        this.r = R;
    }
    public boolean neighbor(int x){
        int n = rock_info.size() ;
        int i , j ;
        for(i =0 ; i< n; i++){
            if(Math.sqrt(Math.pow(Math.abs(rock_info.get(x).x - rock_info.get(i).x) , 2) +
                    Math.pow(Math.abs(rock_info.get(x). y - rock_info.get(i). y) , 2)) >
                    rock_info.get(x).r + rock_info.get(i).r)
                return false ;
            else
                return true ;
        }
        return true;

    }
    void bfs(){
        int i = 0 ;
        int n =rock_info.size();
        ArrayList<Integer> visited[] = new ArrayList[n];
        for(i =0 ; i < n ; i++)
            visited[i] = new ArrayList<>();
        while (i != rock_info.size()){
            if (neighbor(i)){
                visited[i].add() ;
            }
            i++ ;
        }
    }

}
