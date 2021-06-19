import java.lang.annotation.Retention;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m , N ;
        Scanner scanner= new Scanner(System.in);
        N = scanner.nextInt();
        m = scanner.nextInt();
        int i  ;
        int ways = 0 ;
        while (m > 0){
            for(i = m ; i > 0 ; i--){
                if(Return(N , i))
                    ways += 1 ;
                else{
                    Return(N , m - 1);
                    m = m - 1 ;
            }
            }
        }
        System.out.println(ways);
    }
    public static boolean Return(int N , int m){
        int i ;
        int temp;
        for (i = m ; i > 0 ; i--){
            temp = N - i ;
            if (temp < 0)
                Return(N , m -1) ;
            else if(temp > 0)
                Return(N-m , m) ;
        }
        return true ;
    }
}
