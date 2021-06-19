
import java.util.* ;

public class hybrid {
    public static void main(String[] arg) {
        Scanner shahab = new Scanner(System.in);
        int n = shahab.nextInt();
        int k = shahab.nextInt();
        int[] donbale = new int[n];
        int i , j ,temp = 0;
        for (i = 0; i < n; i++) {
            donbale[i] = shahab.nextInt();
        }
        for (i=0 ; i < n ; i++){
            if (donbale[i] % k > 1)
                System.out.println("NO");
            else if (donbale[i] %k == 1)
                temp = temp +1 ;

        }
        if (temp > 1)
            System.out.println("NO");
    }

}
