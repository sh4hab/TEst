
import java.util.* ;

public class quizz1 {
    public static void main(String[] arg) {
        Scanner shahab = new Scanner(System.in);
        int n = shahab.nextInt();
        int k = shahab.nextInt();
        long[] donbale = new long[n];
        int i =0 ;int j = 0 ;int temp = 0;
        long [] a = new long[n];
        for (i = 0; i < n; i++) {
            donbale[i] = shahab.nextLong();
        }
        for (i=0 ; i < n ; i++){
            if (donbale[i] % k > 1) {
                System.out.println("NO");
                return;
            }
            else if (donbale[i] %k == 1) {
                temp = temp + 1;
            }
        }
        if (temp > 1) {
            System.out.println("NO");
            return;
        }
        while (true){
            temp = 0 ;
            for (i=0 ; i < n ; i++){
                if(donbale[i] % k == 1){
                    donbale[i] = donbale[i] - 1 ;
                }
                a[i] = donbale[i] / k ;
            }
            for (i=0;i<n;i++){
                if (a[i] == 1) {
                    temp = temp + 1 ;
                }
                else if(a[i] % k > 1){
                    System.out.println("NO");
                    return;
                }
            }
            if(temp > 1){
                System.out.println("NO");
                return;
            }
            else{
                System.out.println("YES");
                return;
            }
        }

    }


}
