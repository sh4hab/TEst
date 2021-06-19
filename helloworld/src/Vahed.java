import java.util.*;

public class Vahed {
    public static void main(String[] arg){
        Scanner shahab = new Scanner(System.in);
        int n =shahab.nextInt();
        int[] line = new int[n] ;
        int i , j = 0 ;
        int temp = 0 ;
        for (i = 0 ; i < n ; i++) {
            line[i] = shahab.nextInt();
        }
        for (i=0 ; i< n; i++){
            if(line[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            else{
                for(j = i+1 ;j< n; j++){
                    if (line[i] > line[j]){
                        temp=temp+ 1;
                    }
                }
            }
        }
        /*for (i =0 ;i< n ;i++){
            for(j = i+1 ;j < n ; j++){
                if(line[i] > line[j]){
                    temp = temp + 1;
                }
            }
        }*/
        System.out.println(temp);
    }
}
