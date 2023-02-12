package shop.test;

import java.util.Scanner;

import shop.model.*;
import shop.model.User;


public class Admin extends User{

    public Admin(String name, String password) {
        super(name, password);
        //TODO Auto-generated constructor stub
    }
    public static void Ops( String operation,int index, int quantity){
        switch (operation) {
            case "read":
                Product.getInventory();
                break;
            case "add":
                Product.IventoryList().add(new Product("Testing", quantity));
                break;
            case "alt":
                Product.getInventory();
                // get product index
                index = index - 1;
                Product.getInventory(index);
                Product.IventoryList().get(index).setProductQuantity(3);
                break;
            case "del":
                Product.getInventory();
                // get product index
                index = index - 1;
                Product.getInventory(index);
                Product.IventoryList().remove(index);
                break;

        }
    }


}
public class InventoryAdminTest {

    public static void main(String[] args) {
        // Not sure if relevant but Collection

        //Create
        new Product("Nike slides", 34.99, 8, "red/white");
        new Product("Crocs", 34.99, 8, "white");
        new Product("Steppers", 34.99, 10, "black");
        new Product("Air Force Ones", 120.99, 16, "white");
        new Product("Nike shoes", 60.99, 16, "blue/white");
        new Product("Benzzy Airs", 34.99, 8, "black/white");
       // Product.getInventory();
        //Read
        //Admin.Ops("read",0,0);

    }

}
