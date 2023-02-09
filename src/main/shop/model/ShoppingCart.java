package shop.model;

import java.util.ArrayList;

public class ShoppingCart {

    // VARIABLES
    private double total;
    private ArrayList<Product> items;
    private int quanity;
    private boolean checkedout;
    private User user;

    private static ArrayList<ShoppingCart> pastOrders;

    // CONSTRUCTORS
    public ShoppingCart(User customer){
        this.checkedout=false;
        this.user=customer;
        this.items= new ArrayList<Product>();
        pastOrders= new ArrayList<ShoppingCart>();
    }

    public double getTotal() {
        double totally = 0;
        for (Product item : this.items) {
            totally = (item.getQuantity() * item.getPrice()) + totally;
        }
        return totally;
    }

    public void setTotal() {
        this.total = getTotal();
    }

    public int getQuanity() {
        int totalq = 0;
        for (Product item : this.items) {
            totalq = item.getQuantity() + totalq;
        }
        return totalq;
    }

    public void setQuantity() {
        this.quanity = getQuanity();
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public static ArrayList<Product> getInventory(){
        return Product.IventoryList();
    }

    public void addItem(int index, int quanity) {
        Product item = new Product(getInventory().get(index-1));
        if (getInventory().get(index - 1).getQuantity() > quanity) {
            item.setQuantity(quanity);
            this.items.add(item);
            System.out.println("Added: " + quanity + " " + item.getName() + " to Shopping Cart.");
        } else {
            System.out.println("Sorry we only have  " + getInventory().get(index - 1).getQuantity() + " in stock.");
        }
        setTotal();
        setQuantity();
    }

    public void checkout() {

        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("That should be: " + this.items.get(i));
            for (int j = 0; j < Product.IventoryList().size(); j++) {
                if(this.items.get(i).getName()==Product.IventoryList().get(j).getName()){
                    this.items.get(i).updateQuantity(j+1,this.items.get(i).getQuantity());
                    Product.IventoryList().set(j, this.items.get(i));
                }
            }}
      //Getting nullexception
        this.checkedout=true;
        getPastOrders().add(this);
        System.out.println("We have successfully placed your order! ");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println( "#"+ (i+1)+"  " + items.get(i).getName() + " | " + items.get(i).getColor() + "   $" + items
                    .get(i).getPrice() + " x QTY: " + items.get(i).getQuantity() +"|  Total: "+ (items.get(i)
                            .getQuantity()*items.get(i).getPrice()) );
        } System.out.println("\n Total: $"+ getTotal());

        for (ShoppingCart order : getPastOrders()) {
            System.out.println(order.toString());
        }
    
        items.clear();
        System.out.println(this.getItems().isEmpty());

    }

    public static ArrayList<ShoppingCart> getPastOrders() {
        return pastOrders;
    }

    @Override
    public String toString() {
        return "ShoppingCart [total=" + total + ", items=" + items + ", quanity=" + quanity + ", checked-out=" + checkedout
                + ", user=" + user + "]";
    }

}
