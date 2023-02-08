package shop.model;

import java.util.ArrayList;

public class User {
    
    private int id;
    private String email;
    private String username;
    private String password;
    private ShoppingCart pendingOrder;
    private ArrayList<ShoppingCart> pastOrders;


    public User(String email, String name, String password) {
        this.email = email;
        this.username = name;
        this.password = password;
    }

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void openShoppingCart() {
        this.pendingOrder =new ShoppingCart(this);
    }

    public ShoppingCart getPendingOrder() {
        return pendingOrder;
    }
    
    public ArrayList<ShoppingCart> getPastOrders() {
        return pastOrders;
    } 
    
}
