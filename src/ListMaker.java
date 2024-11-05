import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = SafeInput.getRegExString(console, "Enter your choice: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(console);
                    break;
                case "D":
                    deleteItem(console);
                    break;
                case "I":
                    insertItem(console);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(console, "Do you want to quit the program?: ")) {
                        System.out.println("Quitting program.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Adding item");
        System.out.println("D - Deleting item");
        System.out.println("I - Inserting item");
        System.out.println("P - Printing list");
        System.out.println("Q - Quit program");
    }

    private static void addItem(Scanner console) {
        String item = SafeInput.getNonZeroLenString(console, "Item to add?");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner console) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        printList();
        int itemNumber = SafeInput.getRangedInt(console, "Number of items to delete? ", 1, list.size()) - 1;
        String removedItem = list.remove(itemNumber);
        System.out.println("Item '" + removedItem + "' deleted.");
    }

    private static void insertItem(Scanner console) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding item at the beginning.");
        }
        int position = SafeInput.getRangedInt(console, "Position to insert at?", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(console, "Enter item to insert: ");
        list.add(position, item);
        System.out.println("Item inserted at position " + (position + 1) + ".");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("[The list is currently empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }
}

