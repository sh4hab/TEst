import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner.* ;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int n = scanner.nextInt();
        int i ,j= 0 ;
        ArrayList<Integer> adjacency[] = new ArrayList[n];
        for (i = 0 ; i < n ; i++)
            adjacency[i] = new ArrayList<>();
        for (i = 0; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();
            Rock rock1 = new Rock(x , y , r);
            Rock.rock_info.add(rock1);
        }
        for (i=0 ; i < n ; i++){
            for (j =0; j < n ; j++){
                if(i == j)
                    continue;
                else {
                    if (rock[i].adj(rock[i], rock[j])) {
                        adjacency[i].add(j) ;
                    }
                }
            }
        }

    }

}
