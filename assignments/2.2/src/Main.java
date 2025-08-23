import java.util.ArrayList;
import java.util.HashMap;

//------------Task 1-------------
class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    // Add methods here
    public void addItem(String item){
        groceryList.add(item);
    }
    public void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" has been removed");
    }
    public void displayList(){
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println(groceryList.get(i));
        }
    }
    boolean checkItem(String item){
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager myGroceryListManager = new GroceryListManager();
        myGroceryListManager.addItem("Apples");
        myGroceryListManager.addItem("Milk");
        myGroceryListManager.addItem("Bread");

        myGroceryListManager.displayList();
        if(myGroceryListManager.checkItem("Milk")){System.out.println("Milk is in the list");}
        else System.out.println("Milk is not in the list");

        myGroceryListManager.removeItem("Milk");
        myGroceryListManager.displayList();
    }

}
//------------Task 2-------------
class GroceryListManager2 {
    HashMap<String, Double> groceryList = new HashMap<>();

    // Add methods here
    public void addItem(String item, double cost){
        groceryList.put(item,cost);
    }
    public void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" has been removed");
    }
    public void displayList(){
        for (String i : groceryList.keySet()) {
            System.out.println(i);
        }
    }

    public double calculateTotalCost(){
        double total_value = 0;
        for (double i : groceryList.values()) {
            total_value += i;
        }
        return (total_value);
    }

    public static void main(String[] args) {
        GroceryListManager2 myGroceryListManager = new GroceryListManager2();
        myGroceryListManager.addItem("Apples",100);
        myGroceryListManager.addItem("Milk",20);
        myGroceryListManager.addItem("Bread",30);

        myGroceryListManager.displayList();

        myGroceryListManager.removeItem("Milk");
        myGroceryListManager.displayList();
        System.out.println("total value is "+ myGroceryListManager.calculateTotalCost());
    }

}
//------------Task 3-------------
class GroceryListManager3 {
    HashMap<String, Item> groceryList = new HashMap<>();

    // Add methods here
    public void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" has been removed");
    }
    public void displayList(){
        for (String i : groceryList.keySet()) {
            System.out.println(i);
        }
    }

    public void addItem(String item, double cost, String category) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            groceryList.put(item, new Item(item, cost, category));
        }
    }

    private static class Item {
        String name;
        double cost;
        String category;

        Item(String name, double cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (Item item : groceryList.values()) {
            if (item.category.equals(category)) {
                System.out.println("- " + item.name);
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager3 myGroceryListManager = new GroceryListManager3();
        myGroceryListManager.addItem("Apples",100,"Fruits");
        myGroceryListManager.addItem("Milk",20,"Dairy");
        myGroceryListManager.addItem("Bread",30,"Bakery");

        myGroceryListManager.displayByCategory("Bakery");
    }
}
//------------Task 4-------------
class GroceryListManager4 {
    HashMap<String, Item> groceryList = new HashMap<>();

    // Add methods here
    public void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" has been removed");
    }
    public void displayList(){
        for (String i : groceryList.keySet()) {
            System.out.println(i);
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            groceryList.put(item, new Item(item, cost, category,quantity));
        }
    }

    private static class Item {
        String name;
        double cost;
        String category;
        int quantity;

        Item(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (Item item : groceryList.values()) {
            if (item.category.equals(category)) {
                System.out.println("- " + item.name);
            }
        }
    }
    public void updateQuantity(String item, int newQuantity) {
        if(groceryList.containsKey(item)){
            groceryList.get(item).quantity = newQuantity;
        }
        else {
            System.out.println(item + " not found in the list.");
        }
    }
    public void displayAvailableItems(){
        for (Item item : groceryList.values()) {
            if (item.quantity > 0) {
                System.out.println("- " + item.name);
            }
        }
    }
    public static void main(String[] args) {
        GroceryListManager4 myGroceryListManager = new GroceryListManager4();
        myGroceryListManager.addItem("Apples",100,"Fruits",1);
        myGroceryListManager.addItem("Milk",20,"Dairy",2);
        myGroceryListManager.addItem("Bread",30,"Bakery",3);

        myGroceryListManager.displayByCategory("Bakery");
        myGroceryListManager.updateQuantity("Bread",0);
        myGroceryListManager.displayAvailableItems();
    }
}
//------------Task 5-------------
class GroceryListManager5 {
    HashMap<String, Item> groceryList = new HashMap<>();

    // Add methods here
    public void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" has been removed");
    }
    public void displayList(){
        for (String i : groceryList.keySet()) {
            System.out.println(i);
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (groceryList.containsKey(item)) {
            System.out.println(item + " already exists.");
        } else {
            groceryList.put(item, new Item(item, cost, category,quantity));
        }
    }

    private static class Item {
        String name;
        double cost;
        String category;
        int quantity;

        Item(String name, double cost, String category, int quantity) {
            this.name = name;
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (Item item : groceryList.values()) {
            if (item.category.equals(category)) {
                System.out.println("- " + item.name);
            }
        }
    }
    public void updateQuantity(String item, int newQuantity) {
        if(groceryList.containsKey(item)){
            groceryList.get(item).quantity = newQuantity;
        }
        else {
            System.out.println(item + " not found in the list.");
        }
    }
    public void displayAvailableItems(){
        for (Item item : groceryList.values()) {
            if (item.quantity > 0) {
                System.out.println("- " + item.name);
            }
        }
    }
    public double calculateTotalCost(){
        double total_value = 0;
        for (Item item : groceryList.values()) {
            total_value += item.cost * item.quantity;
        }
        return (total_value);
    }

    public static void main(String[] args) {
        GroceryListManager5 myGroceryListManager = new GroceryListManager5();
        myGroceryListManager.addItem("Apples",100,"Fruits",1);
        myGroceryListManager.addItem("Milk",20,"Dairy",2);
        myGroceryListManager.addItem("Bread",30,"Bakery",3);

        myGroceryListManager.displayByCategory("Bakery");
        myGroceryListManager.updateQuantity("Bread",0);
        myGroceryListManager.displayAvailableItems();
        System.out.println("Total cost: " + myGroceryListManager.calculateTotalCost());
    }
}