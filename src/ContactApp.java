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

//        list.printContactMap();

        // TODO make a main loop that is able to control the UX
//        printMenu();
//        int userChoice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");
//        System.out.println("userChoice = " + userChoice);
        int userChoice;

        do{
            printMenu();
             userChoice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");
            System.out.println("userChoice = " + userChoice);
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

