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

    public ArrayList<Product> sortItems(ArrayList<Product> items) {
        Collections.sort(items, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getName().compareTo(o2.getName());
            }
        });
        return items;
    }

    public void printItems() {
        System.out.println("-----------Shopping Cart-----------");
        if (getItems().size()==0){ 
            System.out.println("\t\t\t\t\tCart Empty.");} else{
        for (int i = 0; i < getItems().size(); i++) {
            System.out.println("#" + (i + 1) + ": " + getItems().get(i).toString());
        }
    }}
    public ArrayList<Product> getItems() {
        return sortItems(items);
    }
    

    public ArrayList<Product> getOrginalItems() {
        return sortItems(orginalItems);
    }

    public void setOrginalItems(ArrayList<Product> orginalItems) {
        this.orginalItems = orginalItems;
    }
/*
 * 0 Read Inventory 
 * 1 Read Shopping Cart
 * 2 Add to Shopping cart
 * 3 Update  item in shopping cart
 * 4 Delete item in shopping cart
 */
/*
 * 0 Read Inventory
 *  Add to inventory
 * Update inventory
 * Delete from Inventory
 */
    public void CRUDitem(int index, int quanity, int operation){
        switch(operation){
        case quanity>1: 
            break;
        case :
            break;
        case 2:
            break;
        case 3:
            break;
        }

    }

    // Inventory / Product.IventoryList().get(index - 1)
    public void addItem(int index, int quanity) {
        //First get item fro iventory to compare
        Product item = new Product(Product.IventoryList().get(index-1));
        System.out.println("Selection from Inventory : "+ item.getName());

        //IsinChart
        if(this.orginalItems.contains(item.getOriginal())){
            System.out.println("Is "+ item.getName()+" currently in shopping cart? "+ this.orginalItems
                    .contains(item.getOriginal()));    
            //QuantityisZero
            if(quanity==0){
                System.out.println("Is " + item.getName() + " currently in shopping cart but user wants 0? " + (this.orginalItems
                        .contains(item.getOriginal()) && quanity==0));
            
                updateItem(this.getOrginalItems().indexOf(item.getOriginal()), quanity);
            } 
            else{ //UpdateQuantity
               updateItem(this.getOrginalItems().indexOf(item.getOriginal()), quanity);
            }}
        
        //IsNew
        else if ( item.getQuantity() > quanity) {
            System.out.println("Is " + item.getName() + " currently in shopping cart? " + this.orginalItems
                    .contains(Product.IventoryList().get(index - 1))); 

            item.setQuantity(quanity); //item.getQuantity+quantity
            this.items.add(item);
            //Add to reference to object/item and reference/ list
            this.orginalItems.add(item.getOriginal());
            System.out.println("Added: " + quanity + " " + item.getName() + " to Shopping Cart.");}
        else {
            System.out.println("Sorry we only hav  " + Product.IventoryList().get(index - 1).getQuantity() + " in stock.");
        }
        setTotal();
        setQuantity();
    }
    
    // Shopping Cart / Product(this.items.get(index)
    public void updateCart(int index, int quanity) {
        Product item = new Product(this.items.get(index - 1), this.items.get(index - 1).getOriginal());
        System.out.println("Selection from Cart : " + item.getName());
        if (item.getOriginal().getQuantity() > quanity) {    
            item.setQuantity(quanity);
            this.items.set(index-1, item);
            System.out.println("Replacing: " + quanity + " " + item.getName() + " to Shopping Cart. Inventory: |"
                    + item.getOriginal().getQuantity());
        } else {
            System.out.println("Sorry we only have  " + item.getOriginal().getQuantity()
                    + " in stock and you currently have " + item.getQuantity() + " in cart.");
        }
        setTotal();
        setQuantity();
    }

    // Shopping Cart / Product(this.items.get(index)
    public void updateItem(int index, int quanity) {
        System.out.println("Index: " + index+" should be: " + this.getItems().get(index).getName());
        Product item = new Product(this.getItems().get(index), this.getItems().get(index).getOriginal());
        
        if (quanity == 0) {
            this.getOrginalItems().remove(item.getOriginal());
            System.out.println("Removing: " + item.getName() + " from Shopping Cart.");
            this.items.remove(index);
        } else if (item.getOriginal().getQuantity() > (quanity+item.getQuantity())) {
            item.setQuantity(quanity + item.getQuantity());
            this.items.set(index, item);
            System.out.println("Adding: " + quanity + " " + item.getName() + " to Shopping Cart. Inventory: |"+ item.getOriginal().getQuantity());
        } else if(item.getOriginal().getQuantity() == (quanity + item.getQuantity())){
            item.setQuantity(quanity + item.getQuantity());
            this.items.set(index, item);  
            System.out.println("Adding: " + quanity + " " + item.getName() + " to Shopping Cart. Inventory: |"
                    + item.getOriginal().getQuantity());
        }else {
            System.out.println("Sorry we only have  " + item.getOriginal().getQuantity() + " in stock and you currently have "+item.getQuantity()+" in cart.");
        }
        setTotal();
        setQuantity();
    }
    //Shopping Cart / Product(this.items.get(index)
    // Inventory / Product.IventoryList().get(index - 1)

    public void updateQuantity(int index, int quanity) {
          Product item = Product.IventoryList().get(index);
        System.out.println(index+" : "+item.getName());
         if (item.getQuantity() > (quanity + item.getQuantity())) {
           item.setQuantity(quanity+ item.getQuantity());
            System.out.println("Adding: " + quanity + " " + item.getName() + " to Shopping Cart.");
        } else if (item.getOriginal()
                .getQuantity() == (quanity + item.getQuantity())) {
            item.setQuantity(quanity + item.getQuantity());
            System.out.println("Adding: " + quanity + " " + item.getName() + " to Shopping Cart.");
        }else {
            System.out.println(
                    "Sorry we only have  " + item.getOriginal().getQuantity() + " in stock.");
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
                if(this.items.get(i).getName()==Product.IventoryList().get(j).getName()&& this.items.get(i)
                        .getQuantity() == Product.IventoryList().get(j).getQuantity()){
                            Product.IventoryList().remove(getOrginalItems().get(i));
                }else if(this.items.get(i).getName()==Product.IventoryList().get(j).getName()){
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
    
    public static void sortCart() {
        Collections.sort(this.items, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getName().compareTo(o2.getName());
            }
        });
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
