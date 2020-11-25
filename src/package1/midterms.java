package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class midterms {

    static ArrayList<String> names = new ArrayList<>();// Collects string
    static ArrayList<Integer> ages = new ArrayList<>();// Collects ages
    static Scanner sc = new Scanner(System.in);//Scanner new_name

    public static void empty_list_msg() {//Displays Empty list message
        System.out.print("------------------------\n");
        System.out.print("|----CURRENT ITEMS:----|\n");
        System.out.print("------------------------\n");
        System.out.print("This list is empty.\n"
                + "Add some items to get started\n");
        System.out.print("------------------------\n");
    }//empty_list_msg()

    public static void pauseConsole() { // Pauses the console
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
        entryLimit = sc.nextInt();//Tells how much is the nameEntry limit for the for loop
        for (int i = 0; i < entryLimit; i++) {
            System.out.print("Enter name:\n"
                    + ">> ");
            String nameEntry = sc.next();
            nameEntry += sc.nextLine();//Ensures that the entire sentence is captured
            names.add(nameEntry);
            System.out.print("Enter age:\n"
                    + ">> ");
            int ageEntry = sc.nextInt();
            ages.add(ageEntry);
        }
        System.out.print("------------------------\n");
        System.out.println("Entries have been added successfully.");
        System.out.print("------------------------\n");
    }//addItem

    public static void deleteItem() { // Deletes Items
        int arraySize = names.size();//Checks if array size is empty or not

        //Delete Menu
        System.out.println();
        System.out.print("-----------------------\n"
                + "|----DELETE  ITEMS----|\n"
                + "-----------------------\n"
                + "What would you like to delete?\n"
                + "1. Delete an Item\n"
                + "2. Delete all items\n"
                + "3. Go back\n"
                + ">> ");
        int option = sc.nextInt();

        //Delete options
        switch (option) {
            case 1: //Delete a single item
                if (arraySize == 0) {
                    empty_list_msg();
                } else {
                    viewItems();
                    System.out.print("Select an item to delete (This cannot be undone!)\n"
                            + ">> ");
                    int indexNumber = sc.nextInt();//variable to store index number
                    
                    //loop only runs is user selects non-existent item
                    while (indexNumber > arraySize - 1) {
                        System.out.print("Item does not exist. Please try again.\n"
                                + ">> ");
                        indexNumber = sc.nextInt();
                    }
                    names.remove(indexNumber);
                    ages.remove(indexNumber);
                    System.out.print("------------------------\n");
                    System.out.println("Delete success!");
                    System.out.print("------------------------\n");
                }
                pauseConsole();
                deleteItem();
                break;

            case 2: //Delete all Items
                if (arraySize == 0) {
                    empty_list_msg();
                } else {
                    System.out.print("------------------------\n");
                    System.out.print("Are you sure you want to delete ALL items? "
                            + "(This cannot be undone!)\n"
                            + "|1. Yes | 2. Back |\n"
                            + ">> ");
                    int clrOption = sc.nextInt();
                    //Delete all items submenu
                    switch (clrOption) {
                        case 1://Yes
                            names.clear();
                            ages.clear();
                            System.out.print("------------------------\n");
                            System.out.println("Delete success!");
                            System.out.print("------------------------\n");
                            break;

                        case 2://Back
                            deleteItem();
                            break;
                    }//end of sub-submenu
                }//end of delete all items option
                pauseConsole();
                deleteItem();
                break;
            case 3: //back
                main(null);
                break;
        }//end of delete menu
    }//deleteItem()

    public static void viewItems() { // Views items
        int arraySize = names.size();//Checks if array size is empty or not
        if (arraySize == 0) {
            empty_list_msg();
        } else {
            System.out.print("------------------------\n");
            System.out.print("|----CURRENT ITEMS:----|\n");
            System.out.print("------------------------\n");
            for (int i = 0; i < names.size(); i++) {
                System.out.println(i + ". " + names.get(i) + " is " + ages.get(i));
            }
            System.out.print("------------------------\n");
        }
    }//viewItems()

    public static void updateItems() { // Updates array contents
        int arraySize = names.size();//Checks if array size is empty or not
        if (arraySize == 0) {
            empty_list_msg();
        } else {
            System.out.print("------------------------\n");
            System.out.print("|-----UPDATE ITEMS-----|\n");
            System.out.print("------------------------\n");
            viewItems();
            int indexPosition;//index position
            String new_name;//change values new_name
            System.out.print("Choose an item to change:\n"
                    + ">> ");
            indexPosition = sc.nextInt();
            
            //loop only runs is user selects non-existent item
            while (indexPosition > arraySize - 1) {
                System.out.print("Item does not exist. Please try again.\n"
                        + ">> ");
                indexPosition = sc.nextInt();
            }

            System.out.print("Enter new name: \n"
                    + ">> ");
            new_name = sc.next();
            new_name += sc.nextLine();

            names.set(indexPosition, new_name);
            //      index position, user input value
            System.out.print("Enter new age: \n"
                    + ">> ");
            int new_age = sc.nextInt();
            ages.set(indexPosition, new_age);
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
                pauseConsole();
                main(null);
                break;
            case 2: //Delete Item
                deleteItem();
                break;
            case 3: //View Items
                viewItems();
                pauseConsole();
                main(null);
                break;
            case 4: //Update Entries
                updateItems();
                pauseConsole();
                main(null);
                break;
            default: //exit
                System.out.print("------------------------\n");
                System.out.print("|---PROGRAM FINISHED---|\n");
                System.out.print("------------------------\n");
        }
    }//main
}
