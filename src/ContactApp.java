import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ContactApp {


    public static void main(String[] args) throws IOException {

        Input input = new Input();

        String directory = "data";
        String filename = "contacts.txt";

        Path filePath = FileIO.createDirectoryAndFile(directory, filename);

        ContactList list = new ContactList();
        List<Contact> importedList = FileIO.importContactFile(filePath);

        for(Contact contact: importedList) {
            list.addContact(contact);
        }

        int userChoice;

        System.out.println("---------- Contacts Manager ----------");
        System.out.println();

        do{
            printMenu();
            userChoice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");

            if(userChoice == 1){
                list.printContactMap();
            } else if (userChoice == 2){
                String newContactName = input.getString("Who would you like to add?");
                String newContactNumber = input.getString("What is their phone number?");
                Contact newContact = new Contact(newContactName, newContactNumber);
                list.addContact(newContact);
                System.out.printf("%s added to contacts.%n", newContactName);
                System.out.println("---------------------------------");
                System.out.println();


            } else if (userChoice == 3){
                String contactToFind = input.getString("Who are you looking for?");
                Contact contactToPrint = list.getContactFromName(contactToFind);
                contactToPrint.printContact();


            } else if (userChoice == 4){
                String contactToDelete = input.getString("Who would you like to remove?");
                Contact contactObjectToDelete = list.getContactFromName(contactToDelete);
                list.delContact(contactObjectToDelete);
                System.out.printf("%s removed from contacts.%n", contactObjectToDelete.getName());
                System.out.println("---------------------------------");
                System.out.println();

            }

        }while(userChoice < 5);

        FileIO.writeContactsToFile(filePath, list);
        System.out.println("Contacts saved to disk.");

    }

    public static void printMenu(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
    }
}

