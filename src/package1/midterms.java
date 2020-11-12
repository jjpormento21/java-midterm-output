package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class midterms {

    static ArrayList<String> name = new ArrayList<>();// Collects string
    static ArrayList<Integer> age = new ArrayList<>();// Collects age
    static Scanner sc = new Scanner(System.in);//Scanner input

    public static void listEmpty() {//Displays Empty list message
        System.out.print("------------------------\n");
        System.out.print("VIEW ITEMS:\n");
        System.out.print("------------------------\n");
        System.out.print("This list is empty.\n"
                + "Add some items to get started\n");
        System.out.print("------------------------\n");
    }//ListEmpty()

    public static void waitLine() { // Pauses the console
        System.out.print("Press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }//waitLine()

    public static void addItem() { // Adds Items
        int entryLimit;
        System.out.print("How many entries would you like to add?\n"
                + ">> ");
        entryLimit = sc.nextInt();//Tells how much is the entry limit for the for loop
        for (int i = 0; i < entryLimit; i++) {
            System.out.print("Enter name:\n"
                    + ">> ");
            String entry = sc.next();
            entry += sc.nextLine();//Ensures that the entire sentence is captured
            name.add(entry);
            System.out.print("Enter age:\n"
                    + ">> ");
            int entryAge = sc.nextInt();
            age.add(entryAge);
        }
        System.out.print("------------------------\n");
        System.out.println("Entries have been added successfully.");
        System.out.print("------------------------\n");
    }//addItem

    public static void deleteItem() { // Deletes Items
        int arraySize1 = name.size();//Checks if array size is empty or not
        
        //Delete Menu
        System.out.print("Delete Items\n"
                + "-----------------------\n"
                + "What would you like to delete?\n"
                + "1. Delete an Item\n"
                + "2. Delete all items\n"
                + "3. Go back\n"
                + ">> ");
        int op = sc.nextInt();
        
        //Delete options
        switch (op) {
            case 1: //Delete a single item
                if (arraySize1 == 0) {
                    listEmpty();
                } else {
                    viewItems();
                    System.out.print("Select an item to delete (This cannot be undone!)\n"
                            + ">> ");
                    int del = sc.nextInt();//variable to store index number
                    name.remove(del);
                    age.remove(del);
                    System.out.print("------------------------\n");
                    System.out.println("Delete success!");
                    System.out.print("------------------------\n");
                }
                waitLine();
                deleteItem();
                break;

            case 2: //Delete all Items
                if (arraySize1 == 0) {
                    listEmpty();
                } else {
                    System.out.print("------------------------\n");
                    System.out.print("Are you sure you want to delete ALL items? "
                            + "(This cannot be undone!)\n"
                            + "|1. Yes | 2. Back |\n"
                            + ">> ");
                    int clr = sc.nextInt();
                    //Delete all items submenu
                    switch (clr) {
                        case 1://Yes
                            name.clear();
                            age.clear();
                            System.out.print("------------------------\n");
                            System.out.println("Delete success!");
                            System.out.print("------------------------\n");
                            break;

                        case 2://Back
                            deleteItem();
                            break;                            
                    }//end of sub-submenu
                }//end of delete all items option
                waitLine();
                deleteItem();
                break;
            case 3: //back
                main(null);
                break;
        }//end of delete menu
    }//deleteItem()

    public static void viewItems() { // Views items
        int arraySize1 = name.size();//Checks if array size is empty or not
        if (arraySize1 == 0) {
            listEmpty();
        } else {
            System.out.print("------------------------\n");
            System.out.print("VIEW ITEMS:\n");
            System.out.print("------------------------\n");
            for (int i = 0; i < name.size(); i++) {
                System.out.println(i + ". " + name.get(i) + " is " + age.get(i));
            }
            System.out.print("------------------------\n");
        }
    }//viewItems()

    public static void updateItems() { // Updates array contents
        int arraySize1 = name.size();//Checks if array size is empty or not
        if (arraySize1 == 0) {
            listEmpty();
        } else {
            System.out.print("------------------------\n");
            System.out.print("Update Items\n");
            System.out.print("------------------------\n");
            viewItems();
            int indexPos;//index position
            String input;//change values input
            System.out.print("Choose an item to change:\n"
                    + ">> ");
            indexPos = sc.nextInt();
            System.out.print("Enter new name: \n"
                    + ">> ");
            input = sc.next();
            input += sc.nextLine();

            name.set(indexPos, input);
            //      index position, user input
            System.out.print("Enter new age: \n"
                    + ">> ");
            int input1 = sc.nextInt();
            age.set(indexPos, input1);
            System.out.print("------------------------\n");
            System.out.print("Update successful!\n");
            System.out.print("------------------------\n");
        }

    }//updateItems

    public static void main(String[] args) { // Main menu
        System.out.print("------------------------\n");
        System.out.println("Simple Database MENU");
        System.out.print("------------------------\n");
        System.out.print("1. Add an entry\n"
                + "2. Delete an entry\n"
                + "3. View entries\n"
                + "4. Update Entries\n"
                + "0. Exit\n"
                + ">> ");
        int op = sc.nextInt();
        switch (op) {
            case 1: //Add Item
                addItem();
                waitLine();
                main(null);
                break;
            case 2: //Delete Item
                deleteItem();
                break;
            case 3: //View Items
                viewItems();
                waitLine();
                main(null);
                break;
            case 4: //Update Entries
                updateItems();
                waitLine();
                main(null);
                break;
            default: //exit
                System.out.print("------------------------\n");
                System.out.print("--PROGRAM FINISHED--\n");
                System.out.print("------------------------\n");
        }
    }//main
}