import java.util.Scanner;

public class InputProcessor {
    private Manager manager = new Manager();
    private Scanner scanner = new Scanner(System.in);

    InputProcessor(Manager manager) {
        this.manager = manager;
    }

    void run() {
        int step = 0;
        manager.initial();
        while (manager.MAX_ZOMBIES - manager.zombieCounter > 0) {
            System.out.println("Enter Your Command :");
            String command = scanner.nextLine();
            manager.putZombie();
            if (command.contains("put bomb ")) {
                if (command.contains("rare")) {
                    manager.putBombType(Integer.parseInt(command.substring(9, 4 + command.indexOf("m"))) - 1,
                            Integer.parseInt(command.substring(11, command.indexOf("r") - 1)) - 1, "rare");
                    step++;
                } else if (command.contains("common")) {
                    manager.putBombType(Integer.parseInt(command.substring(9, 4 + command.indexOf("m"))) - 1,
                            Integer.parseInt(command.substring(11, command.indexOf("c") - 1)) - 1, "common");
                    step++;
                } else if (command.contains("super")) {
                    manager.putBombType(Integer.parseInt(command.substring(9, 4 + command.indexOf("m"))) - 1,
                            Integer.parseInt(command.substring(11, command.indexOf("s") - 1)) - 1, "super");
                    step++;
                } else {
                    manager.putBomb(Integer.parseInt(command.substring(9, 4 + command.indexOf("m"))) - 1,
                            Integer.parseInt(command.substring(11, command.length())) - 1);
                    step++;
                }
            } else if (command.equals("request coins")) {
                manager.getCoins();
            } else if (command.contains("check zombie ")) {
                manager.zombieHealth(Integer.parseInt(command.substring(13, 14)) - 1,
                        Integer.parseInt(command.substring(15, command.length())) - 1);
                step++;
            } else if (command.equals("exit")) {
                System.out.println("Exiting the Game ...");
                return;
            } else {
                System.out.println("Invalid Command ! Please Try again .");
            }
            manager.calculations();
            System.out.println("Step " + step + " you have " + manager.playerCoins + " coins");
            System.out.println("Remaining zombies :" + (manager.MAX_ZOMBIES - manager.zombieCounter));
        }
        System.out.println("Congrajulations !!!!");
    }
}
