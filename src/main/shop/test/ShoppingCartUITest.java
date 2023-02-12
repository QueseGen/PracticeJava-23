package shop.test;

import shop.model.Product;
import shop.model.User;

public class ShoppingCartUITest {

    public static void main(String[] args) {
        System.out.println("\n1. Create inventory/database[COMPLETE]");
        Product seeinventory = new Product();

        System.out.println("\n2. Create user[COMPLETE]");
        User admin = new User("Admin", "test123");

        System.out.println("\n3. Add products to inventory[COMPLETE]");
        new Product("Nike slides", 34.99, 8, "red/white");
        new Product("Crocs", 34.99, 8, "white");
        new Product("Steppers", 34.99, 10, "black");
        new Product("Air Force Ones", 120.99, 16, "white");
        new Product("Nike shoes", 60.99, 16, "blue/white");
        new Product("Benzzy Airs", 34.99, 8, "black/white");

        System.out.println("\n4. Display inventory[COMPLETE]");
        seeinventory.getInventory();
        System.out.println("\n5. Open Shopping cart[COMPLETE]");
        admin.openShoppingCart();

        System.out.println("\n6. Add to shopping cart[COMPLETE]");
        admin.getPendingOrder().addItem(3, 2);
        admin.getPendingOrder().addItem(4, 5);

        System.out.println("\n7. Show Current shopping Cart[COMPLETE]");
        admin.getPendingOrder().printItems();

        
        System.out.println("\n8. Update/Delete quantity in Shopping cart[COMPLETE]");
        admin.getPendingOrder().updateCart(2, 2);
        admin.getPendingOrder().printItems();

        System.out.println("\n9. add duplicates in Shopping cart[COMPLETE]");
        admin.getPendingOrder().addItem(2, 4);
        // admin.getPendingOrder().printItems();
        seeinventory.getInventory();
        admin.getPendingOrder().addItem(3, 3);
        admin.getPendingOrder().printItems();
        admin.getPendingOrder().addItem(4, 8);
        admin.getPendingOrder().printItems();
        
        System.out.println("\n10. remove item from  in Shopping cart");
        admin.getPendingOrder().addItem(3, 0);

        admin.getPendingOrder().printItems();

        System.out.println("\n10.5 Added the removed crocs back to cart, Success!");
        admin.getPendingOrder().addItem(3, 5);
                                                                    //If not in list admin will get a log of product and sold out
        System.out.println("\n11. Max of QTY of Benzzy Airs so when checkout they are sold out(Not showing in inventory)");
        admin.getPendingOrder().addItem(2, 4);

        admin.getPendingOrder().checkout();
        seeinventory.getInventory();
        admin.getPendingOrder().printItems();
    }
}
