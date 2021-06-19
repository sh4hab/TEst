import java.util.Scanner;
import java.util.Scanner.* ;

public class question1 {
    public static void main(String[] args){
        Scanner shahab = new Scanner(System.in);
        String UserName = shahab.nextLine();
        String Password = shahab.nextLine();
        int invalid_username = 0  ;
        int invalid_password = 0 ;
        // UserName Specification
        if (UserName.length() > 30 || UserName.length()< 6)
            invalid_username = 1 ;
        if (!UserName.matches("(.*^[A-Za-z].*)")) {
            invalid_username = 1;
            //System.out.println("First of the Word");
        }
        if (!UserName.contains("_")) {
            invalid_username = 1;
            //System.out.println("UnderLine");
        }
        if(!UserName.matches("(.*[^A-Z][^a-z][^1-9][^_].*)")) {
            invalid_username = 1;
            //System.out.println("Not Char or Num");
        }

        // PassWord Specification

        if (Password.length() > 20 || Password.length() < 8)
            invalid_password = 1 ;

        if(!Password.matches("(.*\\d.*)")) {
            invalid_password = 1;
           // System.out.println("no digits");
        }
        if(!Password.matches("(.*[A-Z].*)")) {
            invalid_password = 1;
            //System.out.println("No large Chars");
        }
        if(!Password.matches("(.*[a-z].*)")) {
            invalid_password = 1;
           // System.out.println("No small Chars");
        }
        if(Password.contains("\\s")) {
            invalid_password = 1;
           // System.out.println("Spaces");
        }
        if(!Password.matches("(.*[!@#$%&*()-+=^].*)")) {
            invalid_password = 1;
           // System.out.println("Special Chars");
        }
        if(invalid_password == 1 || invalid_username == 1)
            System.out.println("Inappropriate username or password");
        else
            System.out.println("Account created successfully");

    }
}
