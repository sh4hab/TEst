import javax.xml.transform.Source;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name please :");
        Manager manager = new Manager() ;
        manager.playerName = scanner.nextLine();
        InputProcessor inputProcessor = new InputProcessor(manager);
        inputProcessor.run();
    }
}
