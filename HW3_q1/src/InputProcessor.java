import java.util.Scanner;

public class InputProcessor {
    Scanner scanner ;
    Manager manager = new Manager();

    void runCustomer(){
        scanner = new Scanner(System.in);
        System.out.println("Enter your Username and Password :");
        String Username = scanner.next();
        String Password = scanner.next();
        manager.customerLogin(Username , Password);
        while (true){
            manager.updateFile();
            System.out.println("Please enter your command :");
            String customerCommand = scanner.next() ;
            if (customerCommand.equals("ls")){
                customerCommand =scanner.next() ;
                if (customerCommand.equals("-r"))
                    manager.getAllGoods();
                else if (customerCommand.equals("-i"))
                    manager.getAvailableGoods();
                else if (customerCommand.equals("-n"))
                    manager.getUnavailableGoods();
            }
            else if (customerCommand.equals("order")){
                String goodID = scanner.next();
                if (goodID.equals("-d")) {
                    manager.deleteOrder(Integer.parseInt(scanner.next()));
                }
                else {
                    String goodInventory = scanner.next();
                    goodInventory = scanner.next();
                    manager.newOrder(Integer.parseInt(goodID), Integer.parseInt(goodInventory));
                    System.out.println("salam");
                }
                }
            else if (customerCommand.equals("logout"))
                this.runCustomer();
        }

    }
    void runSeller(){
        scanner = new Scanner(System.in);
        while (true){
            manager.updateFile();
            String sellerCommand = scanner.next();
            if (sellerCommand.equals("ls")){
                String next = scanner.next();
                if (next.equals("-r"))
                    manager.getAllGoods();
                else if (next.equals("-i"))
                    manager.getAvailableGoods();
                else if (next.equals("-n"))
                    manager.getUnavailableGoods();
                else if (next.equals("-o"))
                    manager.getUncheckedOrders();
                else if (next.equals("-ho"))
                    manager.getCheckedOrders();
            }
            else if (sellerCommand.equals("checkout")){
                int orderID = scanner.nextInt();
                manager.checkOrder(orderID);
            }
            else if (sellerCommand.equals("add")){
                scanner.next();
                String goodName = scanner.next();
                scanner.next();
                int inventory = scanner.nextInt();
                scanner.next();
                int sellPrice = scanner.nextInt();
                scanner.next();
                int buyPrice = scanner.nextInt();
                manager.addGood(goodName , inventory ,sellPrice , buyPrice);
            }
            else if (sellerCommand.equals("remove")){
                scanner.next();
                int goodID = scanner.nextInt();
                manager.removeGood(goodID);
            }
            else if (sellerCommand.equals("calc")){
                String temp = scanner.next();
                if (temp.equals("-p")){
                    if (scanner.hasNext()){
                        scanner.next();
                        int goodID = scanner.nextInt();
                        manager.CalculateSpeceficGoodBenefit(goodID);
                    }
                    else
                        manager.calculateTotalBenefit();
                }
                else if (temp.equals("-s")){
                    if (scanner.hasNext()){
                        scanner.next();
                        int goodID = scanner.nextInt();
                        manager.getSoldItem(goodID);
                    }
                    else
                        manager.getTotalSoldItems();
                }
            }
            else if (sellerCommand.equals("edit")){
                int goodID = scanner.nextInt();
                String temp = scanner.next();
                if (temp.equals("-n")){
                    String newGoodName = scanner.next();
                    manager.editName(goodID , newGoodName);
                    if (scanner.hasNext()){
                        scanner.next();
                        int newCount = scanner.nextInt();
                        manager.editInventory(goodID , newCount);
                    }
                }
                else if (temp.equals("-sp")){
                    int newSellPrice = scanner.nextInt();
                    scanner.next();
                    int newBuyPrice = scanner.nextInt();
                    scanner.next();
                    int newcount= scanner.nextInt();
                    manager.editSellPrice(goodID , newSellPrice);
                    manager.editBuyPrice(goodID , newBuyPrice);
                    manager.editInventory(goodID , newcount);
                }
            }
        }
    }

}
