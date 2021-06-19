public class Main2 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        InputProcessor inputProcessor = new InputProcessor();
        manager.updateFile();
        inputProcessor.runSeller();
    }
}
