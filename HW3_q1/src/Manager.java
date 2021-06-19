import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Manager {
    static int CustomerID ;
    static int SellerID ;
    Order order ;
    ArrayList<Goods> goods = new ArrayList<>() ;
    ArrayList<Customer> customers = new ArrayList<>() ;
    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>() ;
    ArrayList<Order> checkedOrders = new ArrayList<>() ;
    Date date = new Date() ;

    File goods_file = new File("C:\\Users\\Shahab\\IdeaProjects\\HW3_q1\\src\\goods.txt");
    File customers_file = new File("C:\\Users\\Shahab\\IdeaProjects\\HW3_q1\\src\\customers.txt");
    File orders_file = new File("C:\\Users\\Shahab\\IdeaProjects\\HW3_q1\\src\\orders.txt");
    Random random = new Random() ;
    FileWriter fileWriter   ;
    Scanner scanner ;
    void addGood(String goodName ,int inventory ,int sellPrice , int byePrice){
        for (Goods good : goods) {
            if (good.name.equals(goodName)) {
                System.out.println("Sorry !The good already exists! ");
                return;
            }
        }
        goods.add(new Goods(goodName , inventory , sellPrice , byePrice));
        System.out.println("add was successful -> good_id = " +goods.get(goods.size()-1).goodID);
    }
    void removeGood(int goodID){
        ArrayList<Goods> removedGoods = new ArrayList<>();
        for (Goods good : goods) {
            if(good.goodID == goodID)
                removedGoods.add(good);
        }
        if (removedGoods.isEmpty())
            System.out.println("The Good was Not Found !");
        else {
            for (Goods removedGood : removedGoods) {
                goods.remove(removedGood);
            }
            System.out.println("The good was successfully removed !");
        }
    }
    void getUncheckedOrders(){
        System.out.printf("Order ID \t Customer ID \t Date \t Time \t Good Id \t Inventory \t \n");
        for (Order order1 : orders) {
            System.out.println(order1.orderID + "\t" + order1.customerID + "\t" + order1.date +"\t" + order1.time+ "\t" + order1.goodID +"\t" + order1.inventory);
        }
    }
    void getCheckedOrders(){
        System.out.printf("Order ID \t Customer ID \t Date \t Time \t Good Id \t Inventory \t \n");
        for (Order checkedOrder : checkedOrders) {
            System.out.println(checkedOrder.orderID + "\t" + checkedOrder.customerID + "\t" + checkedOrder.date + "\t" + checkedOrder.time + "\t" + checkedOrder.goodID + "\t" + checkedOrder.inventory);
        }
    }

    void checkOrder(int orderId){
        for (Order order1 : orders) {
            if (order1.orderID == orderId){
                checkedOrders.add(order1);
            }
        }
        for (Order checkedOrder : checkedOrders) {
            orders.remove(checkedOrder) ;
        }
    }
    void editName(int goodID ,String newName){
        for (Goods good : goods) {
            if(good.goodID == goodID){
                good.name = newName ;
            }
        }
    }
    void editInventory(int goodID ,int newInventory){
        for (Goods good : goods) {
            if(good.goodID == goodID)
                good.inventory = newInventory ;
        }
    }
    void editSellPrice(int goodID , int newSellPrice){
        for (Goods good : goods) {
            if(good.goodID == goodID)
                good.inventory = newSellPrice ;
        }
    }
    void editBuyPrice(int goodID , int newBuyPrice){
        for (Goods good : goods) {
            if(good.goodID == goodID)
                good.inventory = newBuyPrice ;
        }
    }
    void calculateTotalBenefit(){
        int totalBenefit = 0 ;
        for (Order checkedOrder : checkedOrders) {
            for (Goods good : goods) {
                if (checkedOrder.goodID == good.goodID){
                    totalBenefit += (good.sellPrice - good.buyPrice)*checkedOrder.inventory ;
                }
            }
        }
        System.out.println(totalBenefit + "IRR");
    }
    void CalculateSpeceficGoodBenefit(int goodID){
        int totalBenefit = 0 ;
        int Benefit = 0 ;
        for (Goods good : goods) {
            if (good.goodID == goodID)
                Benefit  = good.sellPrice - good.buyPrice ;
        }
        for (Order checkedOrder : checkedOrders) {
            if (checkedOrder.goodID == goodID)
                totalBenefit += checkedOrder.inventory*Benefit ;
        }
        System.out.println(totalBenefit + "IRR");
    }
    void getTotalSoldItems(){
        int soldItems ;
        soldItems = orders.size();
        int total_sell = 0;
        int total_benefit = 0;
        for (Order order1 : orders) {
            for (Goods good : goods) {
                if (order1.goodID == good.goodID){
                    total_sell += good.sellPrice ;
                    total_benefit += (good.sellPrice -good.buyPrice)*order1.inventory;
                }
            }
        }


    }
    void getSoldItem(int goodID){
        int items = 0;
        int total_sell = 0;
        int total_benefit = 0;
        for (Order order1 : orders) {
            if (order1.goodID == goodID){
                for (Goods good : goods) {
                    if (good.goodID == goodID){
                        items += order1.inventory ;
                        total_sell += good.sellPrice ;
                        total_benefit += (good.sellPrice - good.buyPrice)*order1.inventory ;
                    }
                }
            }
        }

    }
    void customerLogin(String Username , String Password){
        try {
            scanner = new Scanner(customers_file);
            while (scanner.hasNext()) {
                if (scanner.next().equals(Username) && scanner.next().equals(Password)) {
                    System.out.println("Welcome " + Username + ".CustomerID : " + scanner.next());
                    return;
                }
            }
                    customers.add(new Customer(Username, Password));
                    System.out.println("Your account has been successfully created ! CustomerID :" + customers.get(customers.size() - 1).ID);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void getAllGoods(){
        System.out.println("  name \t inventory \t price");
        try {
            scanner = new Scanner(goods_file);
            while (scanner.hasNext()){
                String goodName = scanner.next();
                String goodID = scanner.next();
                int inventory = Integer.parseInt(scanner.next());
                int buyPrice = Integer.parseInt(scanner.next());
                int sellPrice = Integer.parseInt(scanner.next()) ;
                System.out.println(goodName + "\t" + sellPrice + "\t" + inventory);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void getAvailableGoods() {
        System.out.println("  name \t inventory \t price");
        try {
            scanner = new Scanner(goods_file);
            while (scanner.hasNext()){
                String goodName = scanner.next();
                String goodID = scanner.next();
                int inventory = Integer.parseInt(scanner.next());
                int buyPrice = Integer.parseInt(scanner.next());
                int sellPrice = Integer.parseInt(scanner.next()) ;
                if (inventory > 0)
                    System.out.println(goodName + "\t" + sellPrice + "\t" + inventory);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    void getUnavailableGoods(){
        System.out.println("  name \t inventory \t price");
        try {
            scanner = new Scanner(goods_file);
            while (scanner.hasNext()){
                String goodName = scanner.next();
                String goodID = scanner.next();
                int inventory = Integer.parseInt(scanner.next());
                int buyPrice = Integer.parseInt(scanner.next());
                int sellPrice = Integer.parseInt(scanner.next()) ;
                if (inventory == 0)
                    System.out.println(goodName + "\t" + sellPrice + "\t" + inventory);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void newOrder(int goodID , int inventory) {
        for (Goods good : goods) {
            if (good.goodID == goodID) {
                if (good.inventory >= inventory) {
                    orders.add(new Order(CustomerID, date.getDate(), date.getTime(), goodID, inventory));
                    System.out.printf("Your order id is = %d", orders.get(orders.size() - 1).orderID);
                    return;
                }
                else {
                    System.out.println("ERROR: order not successful");
                    return;
                }
            }
            return;
        }
        System.out.println("ERROR: order not successful");
    }
    void deleteOrder(int orderID){
        ArrayList<Order> deletedOrder = new ArrayList<>() ;
        for (Order order1 : orders) {
            if(order1.orderID == orderID)
                deletedOrder.add(order1);
            else
                continue;
        }
        if (deletedOrder.isEmpty())
            System.out.printf("Error deleting order %d!" , orderID);
        else {
            for (Order order1 : deletedOrder) {
                orders.remove(order1);
            }
            System.out.printf("order %d was deleted successfully!" , orderID);
        }

    }
    void updateFile(){

        try {
            fileWriter = new FileWriter(customers_file);
            for (Customer customer : customers) {
                fileWriter.append(customer.Username).append("\t").append(customer.Password).append("\t").append(String.valueOf(customer.ID)).append("\n");
            }
            fileWriter = new FileWriter(orders_file);
            for (Order order1 : orders) {
                fileWriter.append(String.valueOf(order1.orderID)).append("\t").append(String.valueOf(order1.customerID)).append("\t").append(String.valueOf(order1.goodID)).append("\t").append(String.valueOf(order1.date)).append("\t").append(String.valueOf(order1.time)).append("\n");
            }
            fileWriter = new FileWriter(goods_file);
            for (Goods good : goods) {
                fileWriter.append(good.name).append("\t").append(String.valueOf(good.goodID)).append("\t").append(String.valueOf(good.inventory)).append("\t").append(String.valueOf(good.buyPrice)).append("\t").append(String.valueOf(good.sellPrice)).append("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
