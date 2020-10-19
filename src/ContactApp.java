import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ContactApp {


    public static void main(String[] args) throws IOException {

        Input input = new Input();

        String directory = "data";
        String filename = "contacts.txt";

        Path filePath = FileIO.createDirectoryAndFile(directory, filename);
        System.out.println("filePath = " + filePath);
        System.out.println();

        ContactList list = new ContactList();
        List<Contact> importedList = FileIO.importContactFile(filePath);

        for(Contact contact: importedList) {
            list.addContact(contact);
        }

        int userChoice;

        do{
            printMenu();
             userChoice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");
            System.out.println("userChoice = " + userChoice);
            if(userChoice == 1){
                list.printContactMap();
            } else if (userChoice == 2){
                String newContactName = input.getString("Who would you like to add?");
                String newContactNumber = input.getString("What is their phone number?");
                System.out.println("newContactNumber = " + newContactNumber);
                System.out.println("newContactName = " + newContactName);
                Contact newContact = new Contact(newContactName, newContactNumber);
                list.addContact(newContact);

            } else if (userChoice == 3){
                // TODO Add search functionality

            } else if (userChoice == 4){
                // Get a contact name to delete
                String contactToDelete = input.getString("Who would you like to remove?");

                // Translate that name into its corresponding contact object
                Contact contactObjectToDelete = list.getContactFromName(contactToDelete);

                // Remove the contact object from our contactList HashMap
                list.delContact(contactObjectToDelete);

            }

        }while(userChoice < 5);

    }

    public static void printMenu(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
    }
}

