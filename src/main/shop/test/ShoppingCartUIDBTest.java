package shop.test;

import java.util.Scanner;

import shop.model.Admin;
import shop.model.Product;
import shop.model.User;
import shop.model.Warehouse;


public class ShoppingCartUIDBTest {
    static boolean sessionEnded=false;

    public static void main(String[] args) {
        // Create Test data
        Warehouse seeinventory = new Warehouse();
        clearscreen();

        Admin admin= new Admin("Bruce", "Bruce");
        
        admin.Ops("add", new Product("Nike slides", 34.99f, 8, "Slides are sleek and simple — a great footwear option for simple errands, lounging with friends, hitting the beach or doing absolutely nothing. Nike slides are made with durable materials for \ttraction and support so your feet feel effortlessly secure, wherever your chill day takes you."));
        admin.Ops("add", new Product("Crocs", 34.99f, 8, "Crocs, Inc., is a Colorado maker of unique clogs that became extremely popular in the early 2000s with both men and women. The inexpensive shoes rely on a proprietary closed-cell resin material called Croslite to produce a lightweight, slip-resistant, odor-resistant, non-marking sole."));
        admin.Ops("add", new Product("Steppers", 34.99f, 10, "Since being founded in 1825, Clarks has been a mainstay of high-quality shoe manufacturing. With 197 years of experience under their belt, you can rest assured that these shoes will last for a very long time.\t Many people say that they've owned a pair of Clarks shoes for 20+ years!"));
        admin.Ops("add", new Product("Air Force Ones", 120.99f, 16, "From musicians to artists to streetwear icons, the Air Force 1 has always been more than a sneaker. Everywhere it’s gone, it’s changed the game. But the past 40 years are behind us, so let’s set the stage for the next 40. Because Force has always been strongest when we do it together."));
        admin.Ops("add", new Product("Air Jordan", 60.99f, 16, "The highly anticipated movie, Air, is set to make its grand premiere on April 5,\t gracing over 3,000 movie theatre screens across the United States. The excitement doesn't end there, as it will soon be available for streaming in over 240 countries, providing a truly global experience for fans everywhere."));
        admin.Ops("add", new Product("Benzzy Airs", 34.99f, 8, "black/white"));
       
        User testUser= new User(); //User testUser= new User("Elon", "Musky", false);
       
        System.out.printf("\n--------------Welcome to PopShop--------------\nPlease Login. \n\n\tUsername: ");
        Scanner scannerTest = new Scanner(System.in);
        
        testUser.setUsername(scannerTest.nextLine()); 
        System.out.printf("\tPassword: ");
        testUser.setPassword(scannerTest.nextLine());
            
        System.out.printf("\n\nGreetings %s, looking to shop today?", testUser.getUsername());
        Product selected=null;
        testUser.openShoppingCart();
         String input= scannerTest.nextLine();
        do {
            switch (input) {
                case "Yes", "Y", "y", "yes", "til I drop", "FlY", "EAGLES":
                    clearscreen();
                    System.out.println("Great! Let's see whats in stock and you can make a selection:");
                    seeinventory.getInventory();
                    input=scannerTest.nextLine();
                    
                    if (!IsInt(input, Warehouse.IventoryList().size())){ 
                        System.out.print("Enter a Product # for more options: ");
                        input = scannerTest.nextLine(); } 
                    
                    selected= seeinventory.IventoryList().get(Integer.parseInt(input)-1);

                   //When ready to shop admin.openShoppingCart();
                   clearscreen();
                    System.out.printf("\nNice! you chose %s\t Details:\n\n", selected.getProductname());
                    System.out.printf("Product #%d %15s |\tSelling at $%.2f per pair | %2s %d in stock.\n\n \t\tDescription:\n\t%s", (Integer.parseInt( input)), selected.getProductname(),
                            selected.getProductprice(), "Currently", selected.getProductQuantity(), selected.getProductdescription());
                    System.out.println("\n\n\tWhat would you like to do:\n#1: Add to Cart \n#2: Go back to Menu \n#3: View Shopping Cart");
                    input = scannerTest.nextLine();
                    break;

                case "No", "N", "n", "nope","not yet", "no", "Exit", "exit", "nathan":
                clearscreen();
                sessionEnded=true;
                    break;
                case "Add to Cart", "1":
                        clearscreen();
                        if (selected==null){  input="Y";} else{
                            System.out.print("Add how many: ");
                            input=scannerTest.nextLine();
                            if (IsInt(input)){
                                testUser.getPendingOrder().addItem(seeinventory.IventoryList().indexOf(selected)+1, 
                                        Integer.parseInt(input)
                                        );
                                        System.out.println(
                                                "\nWhats next?\n#1: Add to Cart \n#2: Go back to Menu \n#3: View Shopping Cart \n#4: Checkout");
                                        input = scannerTest.nextLine();
                                    } else{ System.out.println("Please try again");
                                        input="1";}
                        }
                    break;

                case "Menu", "2":
                        clearscreen();
                        input = "Y";
                        break;

                case "Shopping Cart", "3":
                        clearscreen();
                        testUser.getPendingOrder().printItems();
                        System.out.println("\nNice!\n #1: Remove from cart \n #2: Update Item  \n #3: Keep Shopping \n #4: Checkout");
                        input=scannerTest.nextLine();

                        switch(input){
                            case "1":
                                System.out.println("Remove, Which #?");
                                input=scannerTest.nextLine();
                                if (IsInt(input)) {
                                    selected = seeinventory.IventoryList().get(Integer.parseInt(input)+1);
                                    testUser.getPendingOrder().addItem(Integer.parseInt(input),0);
                                    System.out.println( "\nWhats next?\n#1: Go back to Menu\n#2: Add Item back to Cart  \n#3: View Shopping Cart \n#4: Checkout");
                                    input = scannerTest.nextLine();
                                } else {
                                    System.out.println("Please try again");
                                    input = "3";
                                }
                                break;
                            case "2":
                                System.out.println("Update, Which #?");
                                input = scannerTest.nextLine();
                                if (IsInt(input)) {
                                    selected = seeinventory.IventoryList().get(Integer.parseInt(input));
                                    System.out.println("How many: ");
                                    String many=scannerTest.nextLine();
                                    if(IsInt(many)){
                                        testUser.getPendingOrder().updateCart(Integer.parseInt(input), Integer.parseInt(many));
                                    System.out.println( "\nWhats next?\n#1: Go back to Menu\n#2: Add more of item to Cart  \n#3: View Shopping Cart \n#4: Checkout");
                                    input = scannerTest.nextLine();}

                                } else {
                                    System.out.println("Please try again");
                                    input = "3";
                                }
                                break;
                            case "3":
                                input="2";
                                break;
                            case "4":
                                sessionEnded=true;
                                testUser.getPendingOrder().checkout();
                                break;
                            default:
                                clearscreen();
                                System.out.println(
                                        "I don't understand..please answer Yes, Menu, No, Exit or Shopping Cart:");
                                input = scannerTest.nextLine();
                                break;};
                        break;

                case "4":
                    clearscreen();
                    sessionEnded = true;
                    testUser.getPendingOrder().checkout();
                    break;

                default:
                    clearscreen();
                    System.out.println("I don't understand..please answer Yes, Menu, No, Exit or Shopping Cart:");
                    input = scannerTest.nextLine();                   
                     break;
            }
        } while (!sessionEnded);
        System.out.printf("Thanks for shopping %s, Hasta Luego!" ,testUser.getUsername());
       scannerTest.close();
    }

    private static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static boolean IsInt(String input) {
        try {
            int pass=Integer.parseInt(input);
            if (pass>=0) 
            {return true;}
            return false;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception random){
            return false;
        }
    }

    private static boolean IsInt(String input, int size) {
        try {
            int pass = Integer.parseInt(input);
            if (pass >= 1 && (pass - 1) < size) {
                return true;
            }
            return false;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception random) {
            return false;
        }
    }
}

}
