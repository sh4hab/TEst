import java.util.Random;

public class Customer {
    String Username ;
    String Password ;
    int ID ;
    Random random  = new Random() ;
    public Customer(String username, String password) {
        Username = username;
        Password = password;
        this.ID = random.nextInt(100000);
    }
}
