package shop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCart {

    // VARIABLES
    private double total;
    private ArrayList<Product> items;
    private ArrayList<Product> orginalItems;
    private int quanity;
    private boolean checkedout;
    private User user;

    private static ArrayList<ShoppingCart> pastOrders;

    // CONSTRUCTORS
    public ShoppingCart(User customer){
        this.checkedout=false;
        this.user=customer;
        this.items= new ArrayList<Product>();
        this.orginalItems = new ArrayList<Product>();
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

    public void sortItems() {
        Collections.sort(getItems(), new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void printItems() {
        sortItems();
        for (int i = 0; i < getItems().size(); i++) {
            System.out.println("#" + (i + 1) + ": " + getItems().get(i).toString());
        }
    }
    public ArrayList<Product> getItems() {
        return items;
    }
    

    public ArrayList<Product> getOrginalItems() {
        return orginalItems;
    }

    public void setOrginalItems(ArrayList<Product> orginalItems) {
        this.orginalItems = orginalItems;
    }

    public void addItem(int index, int quanity) {
        //System.out.println(Product.IventoryList());
        Product item = new Product(Product.IventoryList().get(index-1));

        if(this.orginalItems.contains(Product.IventoryList().get(index-1))){
            updateQuantity(this.orginalItems.indexOf(Product.IventoryList().get(index - 1))+1, quanity);}
        else if ( Product.IventoryList().get(index - 1).getQuantity() > quanity) {
            item.setQuantity(quanity);
            this.items.add(item);
            this.orginalItems.add(item.getOriginal());
            System.out.println("Added: " + quanity + " " + item.getName() + " to Shopping Cart.");}
        else {
            System.out.println("Sorry we only have  " + Product.IventoryList().get(index - 1).getQuantity() + " in stock.");
        }
        setTotal();
        setQuantity();
    }

    public void updateItem(int index, int quanity) {
        Product item = new Product(this.items.get(index - 1));
        if (this.items.get(index-1).getOriginal().getQuantity() > quanity) {
            item.setQuantity(quanity);
            this.items.set(index-1, item);
            System.out.println("Replacing: " + quanity + " " + item.getName() + " to Shopping Cart.");
        } else {
            System.out.println("Sorry we only have  " + Product.IventoryList().get(index - 1).getQuantity() + " in stock.");
        }
        setTotal();
        setQuantity();
    }

    public void updateQuantity(int index, int quanity) {
          Product item = new Product(this.items.get(index - 1));
        if (this.items.get(index - 1).getOriginal().getQuantity() >= (quanity + this.items.get(index - 1).getQuantity())) {
           this.items.get(index - 1).setQuantity(quanity+ this.items.get(index - 1).getQuantity());
            System.out.println("Adding: " + quanity + " " + item.getName() + " to Shopping Cart.");
        } else {
            System.out.println(
                    "Sorry we only have  " + Product.IventoryList().get(index - 1).getQuantity() + " in stock.");
        }
        setTotal();
        setQuantity();
    }

    public void deleteProduct(int index) {
        index = index - 1;
        getItems().remove(index);
        System.out.println("Done. Updated list:\n");
        getItems();
    }
    public void checkout() {

        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("That should be: " + this.items.get(i));
            for (int j = 0; j < Product.IventoryList().size(); j++) {
                if(this.items.get(i).getName()==Product.IventoryList().get(j).getName()){
                    this.items.get(i).updateInventory(j+1,this.items.get(i).getQuantity());
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

    public void printCart(){
        for (int i = 0; i < getItems().size(); i++) {
            
        }
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
