package shop.test;

import java.util.Scanner;

import shop.model.Product;
import shop.model.User;

public class ShoppingCartUITest {
    static boolean sessionEnded=false;

    public static void main(String[] args) {
        User testUser= new User(); //User testUser= new User("Elon", "Musky", false);
        System.out.printf("\n--------------Welcome to PopShop--------------\nPlease Login. \n\n\tUsername: ");
        Scanner scannerTest = new Scanner(System.in);
        
        testUser.setUsername(scannerTest.nextLine()); 
        System.out.printf("\tPassword: ");
        testUser.setPassword(scannerTest.nextLine());
            
        System.out.printf("\n\nGreetings %s, looking to shop today?", testUser.getUsername());
    
        do {
            switch (scannerTest.nextLine()) {
                case "Yes", "Y", "y", "yes", "til I drop", "FlY", "EAGLES":
                    break;

                case "No", "N", "n", "nope","not yet", "no", "nathan":
                sessionEnded=true;
                    break;

                default:
                    System.out.println("I don't understand..please answer Yes or No:");
                    break;
            }
        } while (!sessionEnded);
       scannerTest.close();
    }
}
