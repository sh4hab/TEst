public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        Manager manager = new Manager();
        manager.updateFile();
        inputProcessor.runCustomer();

    }
}
