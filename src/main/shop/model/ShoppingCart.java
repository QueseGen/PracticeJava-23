package shop.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCart {

    // VARIABLES
    private double SubTotal;
    private double Total;
    private final double SaleTax= .10;
    private ArrayList<Product> items;
    private ArrayList<Product> orginalItems;
    private int quanity;
    private boolean checkedout;
    private User user;
    private String shoppingCartName;

    private static ArrayList<ShoppingCart> pastOrders;

    // CONSTRUCTORS
    public ShoppingCart(User customer){
        this.checkedout=false;
        this.user=customer;
        this.items= new ArrayList<Product>();
        this.orginalItems = new ArrayList<Product>();
        pastOrders= new ArrayList<ShoppingCart>();
    }

    public double getSubTotal() {
         this.SubTotal = 0;
        for (Product item : this.items) {
            this.SubTotal = (item.getProductQuantity() * item.getProductprice()) + this.SubTotal;
        }
        return Math.round(this.SubTotal*100)/100;
    }

    
    public double getTaxes() {
        return this.SaleTax;
    }

    public double getTotal(){
        double taxes=getSubTotal()*getTaxes();
        return getSubTotal()+taxes;
    }

    

    public int getQuanity() {
        int subtotalq = 0;
        for (Product item : this.items) {
            subtotalq = item.getProductQuantity() + subtotalq;
        }
        return subtotalq;
    }

    public void setQuantity() {
        this.quanity = getQuanity();
    }

    public ArrayList<Product> sortItems(ArrayList<Product> items) {
        Collections.sort(items, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getProductname().compareTo(o2.getProductname());
            }
        });
        return items;
    }

    public void printItems() {
        System.out.println("\n-----------"+getShoppingCartName()+"-----------");
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

 

    // Inventory / Product.IventoryList().get(index - 1)
    public void addItem(int index, int quanity) {
        //First get item fro iventory to compare
        Product item = new Product(Product.IventoryList().get(index-1));
        System.out.println("Selection from Inventory : "+ item.getProductname());

        //IsinChart
        if(this.orginalItems.contains(item.getOriginal())){
            System.out.println("Is "+ item.getProductname()+" currently in shopping cart? "+ this.orginalItems
                    .contains(item.getOriginal()));    
            //QuantityisZero
            if(quanity==0){
                System.out.println("Is " + item.getProductname() + " currently in shopping cart but user wants 0? " + (this.orginalItems
                        .contains(item.getOriginal()) && quanity==0));
            
                updateItem(this.getOrginalItems().indexOf(item.getOriginal()), quanity);
            } 
            else{ //UpdateQuantity
               updateItem(this.getOrginalItems().indexOf(item.getOriginal()), quanity);
            }}
        
        //IsNew
        else if ( item.getProductQuantity() > quanity) {
            System.out.println("Is " + item.getProductname() + " currently in shopping cart? " + this.orginalItems
                    .contains(Product.IventoryList().get(index - 1))); 

            item.setProductQuantity(quanity); //item.getQuantity+quantity
            this.items.add(item);
            //Add to reference to object/item and reference/ list
            this.orginalItems.add(item.getOriginal());
            System.out.println("Added: " + quanity + " " + item.getProductname() + " to Shopping Cart.");}
        else {
            System.out.println("Sorry we only hav  " + Product.IventoryList().get(index - 1).getProductQuantity() + " in stock.");
        }
        getSubTotal();
        setQuantity();
    }
    
    public User getUser() {
        return user;
    }

    public String getShoppingCartName() {
        this.shoppingCartName=getUser().getUsername()+"'s ShoppingCart";
        return this.shoppingCartName;
    }

    // Shopping Cart / Product(this.items.get(index)
    public void updateCart(int index, int quanity) {
        Product item = new Product(this.items.get(index - 1), this.items.get(index - 1).getOriginal());
        System.out.println("Selection from Cart : " + item.getProductname());
        if (item.getOriginal().getProductQuantity() > quanity) {    
            item.setProductQuantity(quanity);
            this.items.set(index-1, item);
            System.out.println("Replacing: " + quanity + " " + item.getProductname() + " to Shopping Cart. Inventory: |"
                    + item.getOriginal().getProductQuantity());
        } else {
            System.out.println("Sorry we only have  " + item.getOriginal().getProductQuantity()
                    + " in stock and you currently have " + item.getProductQuantity() + " in cart.");
        }
        getSubTotal();
        setQuantity();
    }

    // Shopping Cart / Product(this.items.get(index)
    public void updateItem(int index, int quanity) {
        System.out.println("Index: " + index+" should be: " + this.getItems().get(index).getProductname());
        Product item = new Product(this.getItems().get(index), this.getItems().get(index).getOriginal());
        
        if (quanity == 0) {
            this.getOrginalItems().remove(item.getOriginal());
            System.out.println("Removing: " + item.getProductname() + " from Shopping Cart.");
            this.items.remove(index);
        } else if (item.getOriginal().getProductQuantity() > (quanity+item.getProductQuantity())) {
            item.setProductQuantity(quanity + item.getProductQuantity());
            this.items.set(index, item);
            System.out.println("Adding: " + quanity + " " + item.getProductname() + " to Shopping Cart. Inventory: |"+ item.getOriginal().getProductQuantity());
        } else if(item.getOriginal().getProductQuantity() == (quanity + item.getProductQuantity())){
            item.setProductQuantity(quanity + item.getProductQuantity());
            this.items.set(index, item);  
            System.out.println("Adding: " + quanity + " " + item.getProductname() + " to Shopping Cart. Inventory: |"
                    + item.getOriginal().getProductQuantity());
        }else {
            System.out.println("Sorry we only have  " + item.getOriginal().getProductQuantity() + " in stock and you currently have "+item.getProductQuantity()+" in cart.");
        }
        getSubTotal();
        setQuantity();
    }
    //Shopping Cart / Product(this.items.get(index)
    // Inventory / Product.IventoryList().get(index - 1)

    public void updateQuantity(int index, int quanity) {
          Product item = Product.IventoryList().get(index);
        System.out.println(index+" : "+item.getProductname());
         if (item.getProductQuantity() > (quanity + item.getProductQuantity())) {
           item.setProductQuantity(quanity+ item.getProductQuantity());
            System.out.println("Adding: " + quanity + " " + item.getProductname() + " to Shopping Cart.");
        } else if (item.getOriginal()
                .getProductQuantity() == (quanity + item.getProductQuantity())) {
            item.setProductQuantity(quanity + item.getProductQuantity());
            System.out.println("Adding: " + quanity + " " + item.getProductname() + " to Shopping Cart.");
        }else {
            System.out.println(
                    "Sorry we only have  " + item.getOriginal().getProductQuantity() + " in stock.");
        }
        getSubTotal();
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
                if(this.items.get(i).getProductname()==Product.IventoryList().get(j).getProductname()&& this.items.get(i)
                        .getProductQuantity() == Product.IventoryList().get(j).getProductQuantity()){
                            Product.IventoryList().remove(getOrginalItems().get(i));
                }else if(this.items.get(i).getProductname()==Product.IventoryList().get(j).getProductname()){
                    this.items.get(i).updateInventory(j+1,this.items.get(i).getProductQuantity());
                    Product.IventoryList().set(j, this.items.get(i));
                }
            }}
      //Getting nullexception
        this.checkedout=true;
        getPastOrders().add(this);
        System.out.println("\n"+this.user.getUsername()+", we have successfully placed your order! \n");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.printf("#%d %15s |\t$%.2f %2s %d Total: $%.2f\n",(i+1), items.get(i).getProductname(),items
                    .get(i).getProductprice()," x QTY:", items.get(i).getProductQuantity(),items.get(i).getProductQuantity()*items.get(i).getProductprice());}
        
         System.out.println("\n-------------------------------------------------------");
         System.out.printf("%46s $%.2f\n","Subtotal:",getSubTotal());
         System.out.printf("%46s $%.2f\n", "Sales Tax:",getSubTotal()*getTaxes());
         System.out.printf("%46s $%.2f\n","Total:", getTotal());
         System.out.println("Sale Tax is currently: "+ getTaxes());
         
        items.clear();
        //System.out.println(this.getItems().isEmpty());
    }
    
    public void printPastOrders(){
        for (ShoppingCart order : getPastOrders()) {
            System.out.println(order.toString());
        }
    }
    public void sortCart() {
        Collections.sort(this.items, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return o1.getProductname().compareTo(o2.getProductname());
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
        return getShoppingCartName()+" [total=" + Total + ", items=" + items + ", quanity=" + quanity + ", checked-out=" + checkedout
                + ", user=" + user + "]";
    }

}
