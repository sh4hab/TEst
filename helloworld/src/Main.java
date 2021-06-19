import java.util.*;
public class Main {
    int x = 10 ;
    public static void  main(String[] arg){
        Scanner shahab=new Scanner(System.in);
        int n = shahab.nextInt();
        int k = shahab.nextInt();
        int t = shahab.nextInt();
        int temp = t/k ;
        int i = 0 ;
        int [] line = new int[n];
        //System.out.println(temp);
        for (i=0;i<n;i++){
            if(i < temp){
                line[i] = k ;
            }
            else if(i == temp){
                line [i] = t % k ;
            }
            else{
                line[i] = 0 ;
            }
        }
        for (i = 0 ; i < n ; i++){
            System.out.print(line[i]+" ");
        }
    }
}
